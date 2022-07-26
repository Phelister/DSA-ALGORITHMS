package com.myProjects.wow;

import java.util.Collections;

public class ABinary {

    public boolean hasSum(Node root, int sum){
        BSTIterator l = new BSTIterator(root,false);
        BSTIterator r = new BSTIterator(root,true);
        int i=l.next();
        int j=r.next();
        while(i<j){
            if(i+j==sum){
                return true;
            }
            else if(i+j< sum){
                i= l.next();
            }
            else{
                j=r.next();
            }
        }
        return false;
    }
    public static void main(String[] args){
        ABinary bb = new ABinary();
        Node a= new Node(7);
        Node b = new Node(3);
        Node c = new Node(10);
        a.left=b;
        a.right=c;
        Node d = new Node(2);
        Node e = new Node(6);
        b.left=d;
        b.right=e;

        Node f = new Node(9);
        Node g = new Node(11);
        c.left=f;
        c.right=g;
        Node h = new Node(5);
        e.left=h;
        Node i = new Node(1);
        d.left=i;
        Node j = new Node(4);
        h.left=j;
        Node k = new Node(8);
        f.left=k;
        System.out.print(bb.hasSum(a,22));
        int mod = (int)1e9 +7;
       //Collections.sort( arr, Collections.reverseOrder());
        int v=1;





    }
}
