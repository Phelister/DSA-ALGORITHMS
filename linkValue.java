package com.myProjects.wow;

public class linkValue {

    public int linkValue(Node1 head, int index) {
        int result = -1;
        if (head == null) return result;
        else {
            Node1 current = head;
            int i = 0;
            while (current != null) {
                if (i == index) {
                    result = current.data;
                } else {
                    current = current.next;
                }
                i++;
            }

        }
        return result;
    }

    public int linkValue1(Node1 head, int index) {
       if (head==null) return -1;
       if(index ==0) return head.data;
       return linkValue1(head.next, index-1);

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
        linkValue list = new linkValue();
        System.out.println(list.linkValue1(a, 6));
    }
}
