package com.generic;
// Implement hashmap get and put for hashmap
import java.util.*;


public class MyMap<K , V> {

    Node[] buckets = new Node[10];
    class Node<K,V>{
        K key;
        V value;
        Node next;

        Node(){}
        Node(K key, V value){
            this.key =key;
            this.value = value;
            this.next = null;
        }
    }
    public MyMap(){
        Arrays.fill(buckets,new Node(0,0));
    }

    public static void main(String[] args) {
//        Problem<Integer,Integer> integerMap = new Problem<>();
//        integerMap.put(1,10);
//        integerMap.put(2,20);
//        System.out.println(integerMap.get(1));
//        integerMap.put(1,30);
//        System.out.println(integerMap.get(1));

        MyMap<String,Integer> stringMap = new MyMap<>();
        stringMap.put("abc",1);
        stringMap.put("bac",2);
        stringMap.put("cba",3);
        stringMap.put("abc",4);
        System.out.println(stringMap.get("abc"));
        System.out.println(stringMap.get("bac"));
        System.out.println(stringMap.get("cba"));


    }
    public void put(K key,V value){
        Node root = buckets[getBucketLocation(key)];
        while (root.next != null){
            if (root.key.equals(key)) {
                root.value = value;
                return;
            }
            root=root.next;
        }
        if(root.key.equals(key))
            root.value = value;
        else
            root.next = new Node(key,value);

    }
    public V get(K key){
        Node root = buckets[getBucketLocation(key)];
        while (root != null){
            if (root.key.equals(key)) {
                return (V) root.value;
            }
            root = root.next;
        }
        return null;
    }

    private int getBucketLocation(K k){
        return k.hashCode() % buckets.length;
    }
}
