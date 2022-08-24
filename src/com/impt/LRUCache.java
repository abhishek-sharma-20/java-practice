package com.impt;

import java.util.HashMap;

/*

HashMap for key and Node pointers to store and retrive data at O(1)
Doubly Linked list to maintain order of items
Left and Right Pointers to add and remove values
 */
public class LRUCache {
    int capacity ;
    Node root;
    Node leftMost;
    Node rightMost;
    HashMap<Integer,Node> cacheMap ;

    LRUCache(int capacity){
        this.capacity = capacity;
        this.leftMost = null;
        this.rightMost = null;
        this.root = new Node();
        cacheMap = new HashMap<>();
    }


    class Node{
        int key,value;
        Node next;
        Node prev;
        Node(){}
        Node(int key, int value){
            this.value=value;
            this.key = key;
            this.next = null;
            this.prev = null;
        }
    }

    public void insert(Node node){
        if(this.rightMost == null) {
            rightMost = node;
            leftMost = node;
            return;
        }
        rightMost.next = node;
        node.prev = rightMost;
        node.next = null;
        rightMost = node;

    }

    public void remove(Node node){
        if(this.leftMost == node) {
            this.leftMost = this.leftMost.next;
        }
        else{
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
    }


    public void put(int key, int value){
        if(this.get(key) != -1){
            Node temp = this.cacheMap.get(key);
            temp.value = value;
            this.cacheMap.put(key,temp);
            return;
        }
        Node temp = new Node(key,value);
        this.cacheMap.put(key,temp);
        if(this.cacheMap.size() > this.capacity) {
            this.cacheMap.remove(this.leftMost.key);
            this.remove(this.leftMost);
        }
        this.insert(temp);
    }

    public int get(int key){
        Node temp = this.cacheMap.get(key);
        if(temp != null && temp != rightMost) {
            remove(temp);
            insert(temp);
        }
        return temp != null ? temp.value : -1;
    }

    public void print(){
        System.out.println("--------------------");
        Node temp = this.leftMost;
        while(temp != null){
            System.out.println(temp.key+" "+temp.value);
            temp = temp.next;
        }
        System.out.println("--------------------");
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(4);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        lruCache.put(4,4);
        lruCache.print();
        lruCache.put(2,4);
        lruCache.print();
//        System.out.println(lruCache.get(1));
//        lruCache.print();
//        System.out.println(lruCache.get(3));
//        lruCache.print();
//        lruCache.put(5,5);
//        lruCache.print();
//        System.out.println(lruCache.get(2));
//        lruCache.print();
//        System.out.println(lruCache.get(3));
//        lruCache.print();
    }
}
