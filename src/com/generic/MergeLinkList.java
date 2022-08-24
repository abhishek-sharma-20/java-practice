package com.generic;

import java.util.Random;

public class MergeLinkList {
    public static void main(String[] args) {
        Node[] nodes = createLinkedListArray(4);
        Node result = mergeKSortedLinkedList(nodes);
        LinkList.printLinkedList(result);
    }

    static Node[] createLinkedListArray(int n){
        Node[] res = new Node[n];
        Random random = new Random();
        for(int i =0;i<n;i++)
            res[i]= LinkList.createSortedLinkedList(random.nextInt(20));
        return res;
    }

    static Node merge2LinkedList(Node head1, Node head2){
        Node result = new Node();
        Node res = result;
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                res.val = head1.val;
                head1=head1.next;
            }
            else{
                res.val = head2.val;
                head2=head2.next;
            }
            if(head1!=null || head2!= null)
            {
                res.next = new Node();
                res=res.next;
            }
        }

        while(head1 != null){
            res.val = head1.val;
            head1=head1.next;
            if(head1!=null)
            {
                res.next = new Node();
                res=res.next;
            }
        }

        while(head2 != null){
            res.val = head2.val;
            head2=head2.next;
            if(head2!=null)
            {
                res.next = new Node();
                res=res.next;
            }
        }

        return result;

    }

    static Node mergeKSortedLinkedList(Node[] nodes){
        for(int i =nodes.length-1;i>0;i--){
            nodes[i-1] = merge2LinkedList(nodes[i-1],nodes[i]);
        }
        return nodes[0];
    }
}
