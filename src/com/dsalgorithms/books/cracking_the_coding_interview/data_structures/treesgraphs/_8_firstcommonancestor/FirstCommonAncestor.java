package com.dsalgorithms.books.cracking_the_coding_interview.data_structures.treesgraphs._8_firstcommonancestor;

import java.util.Arrays;
import java.util.LinkedList;

/**
 Problem 8: First Common Ancestor (Lowest Common Ancestor)
 Design an algorithm and write code to find the "First Common Ancestor" of two nodes in Binary tree.

 Avoid storing additional nodes in a data structure.

 NOTE: This is not necessarily BST
 -----------------------------------------------------------------------------------------------------------------------
### Note:
 LCA for BST : Making use of BST property
 http://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
 1. If both n1 and n2 are smaller than root, then LCA lies in left
 2. If both n1 and n2 are greater than root, then LCA lies in right
 3. Else LCA is the node itself

 Time Complexity: O(h), h = height of tree

### If Tree is not BST: http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/

 Approach 1: Recursion (1 Traversal of Tree)
 1) Traverse the tree starting from root. If any of the given nodes (n1 and n2) matches with root, then root is LCA.
 2) If root doesn't match with any of the nodes, we recur for left and right subtrees.
 The node which has n1 present in its one subtree and the n2 present in other subtree is the LCA.
 3) If both nodes lie in left subtree, then left subtree has LCA, otherwise LCA lies in right subtree.

Approach 2: Iterative (2 Traversal for Tree & extra sotrage for Path)
 1) Find path from root to n1 and store it in LinkedList<Node>.
 2) Find path from root to n2 and store it in another LinkedList<Node>.
 3) Traverse both paths till the values in list are same. Return the common node just before the mismatch.
 */
class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
    }

    @Override
    public String toString(){
        return Integer.toString(data);
    }
}

class Tree{
    Node root;

    public void displayInorder(Node n){
        if(n != null){
            displayInorder(n.left);
            System.out.print(n.data + " ");
            displayInorder(n.right);
        }
    }

    /******************************************************************
     * By Recursion
     ******************************************************************/
    public Node findLCA(Node node, int n1, int n2){
        if(node == null) {    //base condition
            return null;
        }

        // If either n1 or n2 matches with root's key, report the presence by returning root
        // (Note that if a key is ancestor of other, then the ancestor key becomes LCA
        if(node.data == n1 || node.data == n2){   //check condition
            return node;
        }

        //Recurse to left and right subtrees
        Node leftLCA = findLCA(node.left, n1, n2);
        Node rightLCA = findLCA(node.right, n1, n2);

        //Below comment to show understanding.
        if(leftLCA != null && leftLCA.data != n1 && leftLCA.data != n2){       //optional: return lca right away
            System.out.println("\nleftLCA: " + leftLCA.data);                  //LCA of both n1 & n2 found in Left subtree
            return leftLCA;
        }
        if(rightLCA != null && rightLCA.data != n1 && rightLCA.data != n2){    //optional: return lca right away
            System.out.println("\nrightLCA: " + rightLCA.data);                //LCA of both n1 & n2 found in Right subtree
            return rightLCA;
        }

        // If both of the above calls return Non-NULL, then one node is present in one subtree and other is present in other.
        // So LCA is their parent
        if(leftLCA != null && rightLCA != null){
            System.out.println("\nNode present in different subtrees: " + node.data);
            return node;
        }else if(node.data == n1 || node.data == n2){     //what if one of nodes is root itself
            System.out.println("\nOne of node is root: " + node.data);
            return node;
        }else {
            //If both nodes are in a left subtree of right subtree. Return one which is not null
            return (leftLCA != null) ? leftLCA : rightLCA;
        }
    }

    /**
     * Utility to check if both the Nodes present in Tree or not. Don't find LCA is node not present
     */
    public boolean isNodePresent(Node node, int value) {
        if(node == null){               //base condition
            return false;
        }

        if(node.data == value){         //check condition: if value match, return true
            return true;
        }

        boolean found = isNodePresent(node.left, value);        //recurse left and then right
        if(!found){                                             //not found in left, then check in right
            found = isNodePresent(node.right, value);
        }
        return found;
    }

    /************************************************************
     * Iterative
     ************************************************************/
    public Node findLCA_1(Node root, int node1, int node2){

        LinkedList<Node> pathToNode1 = new LinkedList<>();
        LinkedList<Node> pathToNode2 = new LinkedList<>();

        boolean pathToNode1Exists = findPath(root, pathToNode1, node1);
        boolean pathToNode2Exists = findPath(root, pathToNode2, node2);

        if(pathToNode1Exists){
            System.out.println("\nPath to "+node1);
            System.out.println(Arrays.toString(pathToNode1.toArray()));
        }
        if(pathToNode2Exists){
            System.out.println("\nPath to "+node2);
            System.out.println(Arrays.toString(pathToNode2.toArray()));
        }

        //Find last common node before mismatch
        Node lca = null;
        for(int i=0; i < pathToNode1.size() && i < pathToNode2.size(); i++){
            lca = pathToNode1.get(i);   //set current as lca
            if(pathToNode1.get(i).data != pathToNode2.get(i).data){         //mismatch
                lca = pathToNode1.get(i-1);    //update lca                             //then get its previous, which was matching
                break;
            }
        }

        return lca;
    }

    //IMP: Logic the get path...nice recursive logic. Very useful!
    private boolean findPath(Node node, LinkedList<Node> path, int val){
        if(node == null){       //base condition
            return false;
        }

        path.add(node);         // Store this node. The node will be removed if not in path from root to n.
        if(node.data == val){   //check node present
            return true;
        }

        if(node.left != null && findPath(node.left, path, val)){     //Recurse left and then right
            return true;
        }
        if(node.right != null && findPath(node.right, path, val)){
            return true;
        }

        path.removeLast();          //IMP: If not in path, remove last added node from path and return false
        return false;
    }

}

public class FirstCommonAncestor {

    public static void main(String[] args) {
        Tree tree = new Tree();
        /**
                    1
                /       \
               2         3
             /  \       / \
            4    5     6   7
           / \
         8    9

         */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right = new Node(9);

        System.out.println("Tree is: ");
        tree.displayInorder(tree.root);

        //To handle case, when p or q not present, first check if they are present.
        int p = 1;
        int q = 8;

        //By Recursion
        boolean nodesPresent = tree.isNodePresent(tree.root, p) && tree.isNodePresent(tree.root, q);
        if(nodesPresent){
            Node lca = tree.findLCA(tree.root, p, q);
            System.out.println("\nLCA Recursion = " + lca);
        }else{
            System.out.println("\nError: Nodes not present");
        }

        System.out.println("----------------------");
        //Iterative
        Node lca = tree.findLCA_1(tree.root, p, q);
        System.out.println("\nLCA Iterative = " + lca);
    }

}
