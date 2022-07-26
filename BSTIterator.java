package com.myProjects.wow;

import java.util.Stack;

public class BSTIterator {

    Stack<Node> stack;
    boolean isReverse;
    public BSTIterator(Node root,boolean isReverse){
        stack= new Stack<>();
        this.isReverse=isReverse;
        pushAll(root);
    }

    public void pushAll(Node root){
        Node current = root;
        if(isReverse){
            while(current!=null){
                stack.add(current);
                current=current.right;

            }
        }
        else{
            while(current!=null){
                stack.add(current);
                current=current.left;
            }
        }
    }

    public int next(){
        Node  current  = stack.pop();
        if(isReverse==true){
           pushAll(current.left);
        }
        else{
            pushAll(current.right);
        }
        return current.Value;
    }

    public boolean hasNext(){
        return !stack.isEmpty();
    }



}
