package com.myProjects.wow;

import java.util.Arrays;

public class LinkedList {
    Node1 head;

    public void insert(int data){

        Node1 node = new Node1(data);
        node.data =data;

        if(head == null){
            head=node;
        }
        else {//traverse from the start of the list from start to last
            Node1 n = head;
            while (n.next!= null) {
                n = n.next;//traverse to point to the next node
            }
            n.next= node;
        }
    }
//input is void when we are using the insert method
    public static void show(Node1 head){
        Node1 n = head;
        while(n!= null) {
            System.out.print(n.data);
            System.out.print(" ");
            n = n.next;
        }

    }

    public static void show2(Node1 head){
        if (head==null) return;
        System.out.print(head.data);
        System.out.print(" ");
        show2(head.next);
    }




    public static void main(String[] args){
        //LinkedList list =new LinkedList();
        Node1 a =new Node1(1);
        Node1 b =new Node1(2);
        Node1 c =new Node1(3);
        Node1 d =new Node1(4);
        Node1 e =new Node1(4);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next =e;
        show2(b);
        //list.insert(5);
        //list.insert(15);
        //list.insert(25);
        //list.insert(30);
        //list.show();

    }

}

    /*public void boof(String[] args ){
        LinkedList list = new LinkedList();
        list.add(0,5);
        list.add(1,6);
        list.add(2, 57);
        list.add(3, 59);
        list.remove(2);
        list.size();
        Iterator it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        //System.out.println(list.get(2));
        */


