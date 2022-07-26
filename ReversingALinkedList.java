package com.myProjects.wow;

public class ReversingALinkedList {
    public Node1 reverseLinkedList(Node1 head)
    {
        Node1 prev =null;
        while(head!=null){
            Node1 next_node = head.next;
            head.next=prev;
            prev=head;
            head =next_node;

        }
        return prev;
    }

    public static void main(String[] args) {
        ReversingALinkedList list =new ReversingALinkedList();
        //System.out.println(list.reverseLinkedList(1,2,3,4,5));
    }
}
