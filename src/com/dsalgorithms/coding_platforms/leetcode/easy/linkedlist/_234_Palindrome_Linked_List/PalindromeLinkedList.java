package com.dsalgorithms.coding_platforms.leetcode.easy.linkedlist._234_Palindrome_Linked_List;

/**
 * 234. Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/
 *
 * Given the head of a singly linked list, return true if it is a palindrome.

 Example 1:
 1 -> 2 -> 2 -> 1
 Input: head = [1,2,2,1]
 Output: true

 Example 2:
 1 -> 2
 Input: head = [1,2]
 Output: false
 ---------------------------------------------------------------------------------------------------------

 ## Approach 1: (Iterative)
    - Create a new reverse list & compare all nodes of both list
    - Time complexity: O(n), Extra O(n) space required for copy of list (reversed list)

 ## Approach 2: (Iterative - Runner approach)
    - Keep 2 pointers - Current which jumps once & Runner which jumps twice.
    - Keep adding curr into Stack
    - When runner reaches end of list, current reaches middle of list.
    - Then pop from stack & increment current to compare. If not match return false else return true

 ## Approach 3: (Recursive)
    -
 */


class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        head = null;
    }

    public void display(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    /**
     * Approach 1: Create new reverse list & compare
     */
    public Node reverseClone(Node head){
        Node curr = head;
        //Node next = null;
        Node prev = null;

        while(curr != null) {
            Node n = new Node(curr.data);
            n.next = prev;
            prev = n;
            //curr = next;
            curr = curr.next;
        }
        return prev;
    }

    public boolean isPalindrome(Node head) {
        Node curr = head;
        Node revCurr = reverseClone(head);

        while(curr != null && revCurr != null){
            if(curr.data != revCurr.data){
                return false;
            }
            curr = curr.next;
            revCurr = revCurr.next;
        }
        return true;
    }


    /**
     * Approach 3: Recursive
     */
    public boolean isPalindrome_Recursive(Node head){
        int length = getListLength(head);
        Result res = helper(head, length);

        return res.isMatch;
    }

    private Result helper(Node head, int length) {
        //base case
        if(head == null || length == 0){        //even nodes
            return new Result(head, true);
        }else if(length == 1){                  //odd nodes
            return new Result(head.next, true);
        }

        Result result = helper(head.next, length-2);        //Recurse & reduce length by 2 each time

        //If not match, return false
        if(!result.isMatch || result.node == null){
            return result;
        }

        result.isMatch = head.data == result.node.data;     //Check and return if there is Match of data on other side
        result.node = result.node.next;                     //Return next node

        return result;
    }

    private int getListLength(Node head){
        Node curr = head;
        int length = 0;
        while(curr != null){
            length++;
            curr = curr.next;
        }
        return length;
    }

}


//Small utility class for recursive solution, as we need to return 2 values viz. boolean isMatch and next Node
class Result{
    boolean isMatch;
    Node node;

    public Result(Node node, boolean isMatch){
        this.isMatch = isMatch;
        this.node = node;
    }
}

public class PalindromeLinkedList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(2);
        list.head.next.next.next.next = new Node(1);
        list.display(list.head);

//        list.head = list.reverseClone(list.head);
//        System.out.println("\nReverse list: ");
//        list.display(list.head);

        System.out.println(list.isPalindrome(list.head));

        System.out.println(list.isPalindrome_Recursive(list.head));

    }
}
