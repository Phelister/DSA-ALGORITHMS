package com.myProjects.wow;

import java.util.ArrayList;
import java.util.List;

public class ReturnArrayList {

    public List ReturnMyArray(Node1 head) {
        List<Integer> myArrayList = new ArrayList<>();
        if (head == null) {
            return myArrayList;
        } else {
            Node1 current = head;
            while (current != null) {
                myArrayList.add(current.data);
                current = current.next;
            }
        }
        return myArrayList;
    }

    public List ReturnMyArray1(Node1 head) {
        List<Integer> myArrayList = new ArrayList<>();
        printArray( head, myArrayList);
        return myArrayList;
    }
    public void printArray(Node1 head, List<Integer>myArrayList) {
        if (head == null) return;
        myArrayList.add(head.data);
        printArray(head.next, myArrayList);
    }


    public static void main(String[] args) {

        Node1 a = new Node1(1);
        Node1 b = new Node1(2);
        Node1 c = new Node1(3);
        Node1 d = new Node1(4);
        Node1 e = new Node1(4);
        Node1 f=null;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ReturnArrayList List =new ReturnArrayList();
        System.out.print (List.ReturnMyArray1(a));
    }
}

