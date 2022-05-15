package com.dsalgorithms.books.cracking_the_coding_interview.data_structures.treesgraphs._2_minimaltree;

/**
 Problem 2: Create Minimal Tree
 Given a sorted (increasing order) array with unique integer elements, write an algorithm to create binary search tree
 with minimal height
 */

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
    }
}

class Tree {
    Node root;        //this is required to traversal etc. as we start from root.

    public Tree() {
        root = null;        //initially the tree is empty, i.e root = null
    }

    public void displayIndorder(Node root){     // LVR
        if(root != null){
            displayIndorder(root.left);
            System.out.print(root.data + " ");
            displayIndorder(root.right);
        }
    }

    public void displayPreorder(Node root){     // VLR
        if(root != null){
            System.out.print(root.data + " ");
            displayPreorder(root.left);
            displayPreorder(root.right);
        }
    }


    /**
     * Approach:
     1. Using binary search approach and Create root with arr[mid]
     2. Pass left subarray and recursively create left subtree
     3. Pass right subarray and recursively create right subtree
     4. Link left and right subtrees to main tree
     */
    public Node createMinimalBST(int arr[], int start, int end){
        //base condition
        if(end < start){
            System.out.println("\nstart: " + start + " end: "+ end);
            return null;
        }

        int mid = (start + end)/2;
        Node n = new Node(arr[mid]);

        if(root == null){       //if root not yet created, create root with arr[mid]
            root = n;
        }

        n.left = createMinimalBST(arr, start, mid - 1);
        n.right = createMinimalBST(arr, mid + 1, end);
        return n;
    }

}


public class CreateMinimalBST {
    public static void main(String[] args) {
        Tree bst = new Tree();
        int[] sortedArray = //{2,4,5,6,8,9,10,12};
        {1,2,3,4,5,6,7,8,9};

        bst.root = bst.createMinimalBST(sortedArray, 0, sortedArray.length-1);

        System.out.println("Inorder:");
        bst.displayIndorder(bst.root);
        System.out.println("\nPreorder");
        bst.displayPreorder(bst.root);
    }
}
