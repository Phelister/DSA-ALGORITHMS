package com.myProjects.wow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class binaryTree {
    public int parentSearch(Node root,int val){
        if (root==null || root.Value==val||root.left==null ||root.right==null){
            return -1;
        }
        if(root.left.Value==val||root.right.Value==val){
            return root.Value;
        }
        parentSearch(root.left,val);
        parentSearch(root.right,val);
        return -1;
    }
    List<Integer> result = new ArrayList<Integer>();
    public List inorderRecursive(Node root){
    //if(root!=null) {
      //  inorderRecursiveHelper(root);
    //}
    if(root==null){
        return result;
       }
    inorderRecursive(root.left);
    result.add(root.Value);
    inorderRecursive(root.right);
    return result;
    }

   // public Node bTBuilder(int[] arr){

        //if (arr.length==0) return new Node();
        //int i=0;
        //Node root =null;
       // bTbuilderHelper(arr[], i)
    //}
    public Node bTbuilderHelper(int arr[], int i){
      Node root = new Node(arr[i]);
     // root.left=bTbuilderHelper(arr[],(2*i)+1);
     return root;
    }

    //create a balanced tree from a  none sorted array
    public Node balancedTreeBuilder(int[] arr){
        Arrays.sort(arr);
        return helperbalancedTreeBuilder(arr,0, arr.length-1);
    }
    public Node helperbalancedTreeBuilder(int[] arr,int left, int right){
        if(left>right){
            return null;
        }


        int mid =(left+right)/2;
        Node root = new Node (arr[mid]);
        root.left = helperbalancedTreeBuilder(arr,left,mid-1);
        root.right = helperbalancedTreeBuilder(arr,mid+1,right);
        //List<Integer> wow = new ArrayList<Integer>(Arrays.asList(1));
       // List<Integer> vum = new ArrayList<Integer>(Arrays.asList(wow));
        return root;
    }


    //public void inorderRecuriveHelper(Node root){
       // inorderRecursive(root.left);
        //result.add(root.Value);
        //inorderRecursive(root.right);
    //}
    public static void main (String[] args){
        binaryTree bin =new binaryTree();
        Node root =new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
         root.left.left=new Node(4);
         root.left.right=new Node(5);
        System.out.println(bin.parentSearch(root,3));
        System.out.println(bin.inorderRecursive(root));
        Stack<Integer> val = new Stack<>();

    }
}
