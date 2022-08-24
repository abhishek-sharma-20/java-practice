package com.generic;

import java.util.Random;

public class LinkList<I extends Number> {

    static Node createLinkedList(int n){
        Node head = new Node();
        Node temp = head;
        Random random = new Random();
        temp.val = random.nextInt(50);
        for(int i =0;i<n-1 ;i++){
            temp.next = new Node();
            temp =temp.next;
            temp.val = random.nextInt(50);
        }
        return head;
    }

    static Node createSortedLinkedList(int n){
        Node head = new Node();
        Node temp = head;
        Random random = new Random();
        int prev = random.nextInt(100);
        temp.val = prev;
        for(int i =1;i<n-1 ;i++){
            prev++;
            temp.next = new Node();
            temp =temp.next;
            temp.val = prev;
        }
        return head;
    }
    static void printLinkedList(Node root){
        while(root !=null){
            System.out.print(root.val+" ");
            root=root.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node root = createLinkedList(10);
        Node head = root;
        Node runner = root;
        Node previous = null;
        printLinkedList(root);

        while(runner.next !=null && runner.next.next !=null){
            runner=runner.next.next;
            previous=head;
            head=head.next;
        }
        previous.next = previous.next.next;
        printLinkedList(root);

        System.out.println(Integer.toBinaryString(100));
    }
}
