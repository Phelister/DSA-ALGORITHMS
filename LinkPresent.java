package com.myProjects.wow;

public class LinkPresent {

    public boolean LinkPresent1(Node1 head, int target) {
        Boolean isPresent = false;
        if (head == null) {
            return isPresent;
        } else {
            Node1 current = head;
            while (current != null) {
                if (current.data == target) {
                    isPresent = true;
                }
                current = current.next;
            }
        }
        return isPresent;
    }


    public boolean LinkPresent2(Node1 head, int target) {

        if (head == null) {
            return false;
        } else {
            Node1 current = head;
            while (current != null) {
                if (current.data == target) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    public boolean LinkPresent3(Node1 head, int target) {

        if (head == null) return false;
        if (head.data == target) return true;
        return LinkPresent3(head.next, target);
    }

    public static void main(String[] args) {
        //LinkedList list =new LinkedList();
        Node1 a = new Node1(1);
        Node1 b = new Node1(2);
        Node1 c = new Node1(3);
        Node1 d = new Node1(4);
        Node1 e = new Node1(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        LinkPresent list = new LinkPresent();
        System.out.println(list.LinkPresent3(a, 10));

    }
}
