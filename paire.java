package com.myProjects.wow;

import java.util.Comparator;

public class paire implements Comparator<paire> {

    int data;
    int weight;
    public paire(int data,int weight){
        this.data=data;
        this.weight= weight;
    }
   public paire(){}

    @Override
    public int compare(paire a, paire b) {
        if(a.weight<b.weight){
            return -1;
        }
        if(a.weight>b.weight){
            return 1;
        }
        return 0;
    }
}
