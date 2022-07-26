package com.myProjects.wow;

public class LinkedResult {

    public int LinkedResult1(Node1 head){
        int result=0;
        if(head==null){
            return result;
        }
        else{
            Node1 current =head;
            while (current!=null){
              result += current.data;
              current =current.next;
            }
        }
        return result;
    }

    public int LinkedResult2(Node1 head){
        if(head==null) return 0;
        return head.data + LinkedResult2(head.next);
    }

    public static void main(String[]args){
        Node1 a =new Node1(5);
        Node1 b = new Node1(2);
        Node1 c = new Node1(3);
        Node1 d = new Node1(4);
        Node1 e = new Node1(4);
        Node1 f= null;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        LinkedResult list = new LinkedResult();
        System.out.println(list.LinkedResult2(a));
    }

}
