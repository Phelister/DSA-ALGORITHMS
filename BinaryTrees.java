/*package com.myProjects.wow;

import java.util.*;

public class BinaryTrees {

    public Node insert1() {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");
        Node g = new Node("g");
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = g;

        return a;

    }
    public void DFSRecursive(Node n) {
        BinaryTrees bt = new BinaryTrees();
        n = bt.insert1();
        if (n==null) {
            return;
        }
        else;
        System.out.println(n.Value);
        DFSRecursive(n.left);
        DFSRecursive(n.right);
        LinkedList<Integer> fifty = new LinkedList<>();
        Queue<Integer> myList = new LinkedList<>();




    }
    public LinkedList<Integer> DFSIterative(Node root) {
        if (root ==null) return null;

        LinkedList<Integer> fifty = new LinkedList<>();

        BinaryTrees bt = new BinaryTrees();
        root =bt.insert1();
        Stack<Integer> myStack = new Stack<Integer>();
        Queue myqueue = new LinkedList();

        myStack.push(root);
        while(!=myStack.isEmpty()){
            Node t = myStack.pop();
            fifty.add(t.Value);
            if (root.right!=null){
                myStack.push(root.right);
            }
            if (root.left!=null){
                myStack.push(root.left);
            }
        }
        return fifty;

    }

}
*/
