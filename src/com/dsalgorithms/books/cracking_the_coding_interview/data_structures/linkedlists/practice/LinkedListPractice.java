package com.dsalgorithms.books.cracking_the_coding_interview.data_structures.linkedlists.practice;

import java.util.Set;
import java.util.HashSet;

/**
 * Created by sandeepkulkarni on 16/04/22.
 */
class Node{
    Node next;
    int data;

    public Node(int data){
        this.data = data;
    }
}

class LinkedList{
    Node head;

    public void insertFirst(int d){
        Node n = new Node(d);
        n.next = head;
        head = n;
    }

    public void display(){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    // Remove duplicates - with buffer
    public void removeDuplicatesWithBuffer(){
        Node curr = head;
        Node prev = head;
        Set<Integer> set = new HashSet<>();

        while(curr != null){

            if(set.contains(curr.data)){        //found duplicate
                prev.next = curr.next;
            }else{
                set.add(curr.data);             //not found - so add in set
                prev = curr;                    //set prev to curr
            }
            curr = curr.next;
        }
    }

    //Remove duplicates - without temp buffer
    public void removeDuplicates(){
        Node curr = head;

        while(curr != null){
            Node runner = curr;

            while(runner.next != null){
                if(curr.data == runner.next.data){  //duplicate
                    runner.next = runner.next.next; //goto next next
                }else{
                    runner = runner.next;
                }
            }

            curr = curr.next;
        }
    }


    //Return K-last
    public int returnKthLastElement(int k){
        Node curr = head;
        Node runner = head;

        for(int i=0; i < k; i++){       //move runner k forward
            runner = runner.next;
        }
        while(runner != null){
            curr = curr.next;
            runner = runner.next;
        }
        return curr.data;
    }

    //Reverse list
    public void reverseList() {
        Node curr = head;
        Node next = null;
        Node prev = null;
        while(curr != null){
            next = curr.next;           //store curr.next in next
            curr.next = prev;           //update prev into curr.next
            prev = curr;                //update curr into prev
            curr = next;                //move curr forward by putting next value back
        }
        head = prev;
    }

}

public class LinkedListPractice {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertFirst(50);
        list.insertFirst(40);
        list.insertFirst(30);
        list.insertFirst(20);
        list.insertFirst(20);
        list.insertFirst(10);
        list.insertFirst(5);
        list.insertFirst(1);
        list.display();

        list.reverseList();
        System.out.println("");
        list.display();

        //list.removeDuplicatesWithBuffer();
        //list.removeDuplicates();

//        System.out.println("\nRemove duplicates");
//        list.display();

//        System.out.print("\n K-th last element: " );
//        System.out.println(list.returnKthLastElement(6));

    }
}
