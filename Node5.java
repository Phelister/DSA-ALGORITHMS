package com.myProjects.wow;

import java.util.Comparator;

public class Node5 implements Comparator<Node5> {
    int data;
    int weight;
    public Node5(int data,int weight){
        this.data=data;
        this.weight= weight;
    }
    @Override
    public int compare(Node5 a,Node5 b){
        if(a.weight<b.weight){
            return -1;
        }
        if(a.weight>b.weight){
            return 1;
        }
        return 0;
    }

}
