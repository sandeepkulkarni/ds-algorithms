package com.dsalgorithms.books.cracking_the_coding_interview.data_structures.treesgraphs._5_validatebst;

/**
 Problem 4.5 Validate BST: Implement a function to check if a binary tree is a Binary Search Tree (BST)
 -----------------------------------------------------------------------------------------------------
 Approach:
 1. Start from root and pass (Node, MIN, MAX) as we recurse below to left and right subtree
 2. Check BST condition: left <= root < right
 3. For Left subtree: (n.left, MIN, root)
 4. For Right subtree: (n.right, root, MAX)
 5. Return false if any of these fail

 */

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
    }
}

class Tree{
    Node root;

    public void displayInorder(Node root){
        if(root != null){
            displayInorder(root.left);
            System.out.print(root.data + " ");
            displayInorder(root.right);
        }
    }


    public boolean isBST(Node root){

        if(root == null)
            return true;

        return isBstHelper(root, null, null);
    }

    //BST rule: left <= current < right
    private boolean isBstHelper(Node n, Integer min, Integer max){
        //base condition
        if(n == null) {
            return true;
        }

        //check BST condition
        if((min != null && n.data <= min) || (max != null && n.data > max)){
            return false;
        }

        boolean isLeftBST = isBstHelper(n.left, min, n.data); //left subtree: max value is root, all left nodes should be <= root
        if(!isLeftBST) {            //if error: return immediately
            return false;
        }

        boolean isRightBST = isBstHelper(n.right, n.data, max); //for right subtree: min value is root, all right nodes should be > root
        if(!isRightBST) {            //if error: return immediately
            return false;
        }

        return true;    //All good!
    }


}

public class ValidateBST {

    public static void main(String[] args) {
        Tree bst = new Tree();

        /**
                20
             /    \
            10      30
              \
               25

         */
        bst.root = new Node(20);
        bst.root.left = new Node(10);
        bst.root.right = new Node(30);
        bst.root.left.right = new Node(25);

        System.out.println("Tree is: ");
        bst.displayInorder(bst.root);

        boolean result = bst.isBST(bst.root);
        System.out.println("\nIs BST: "+ result);

    }
}
