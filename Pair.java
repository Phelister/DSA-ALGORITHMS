package com.myProjects.wow;

import java.util.Comparator;

public class Pair implements Comparator<Integer> {
    int parent;
    int edge;
    public Pair(){
        //this.parent=parent;
        //this.edge=edge;
    }
    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1==o2) {
            return 0;
        }
        else if(o1<o2) {
            return -1;
        }
        else{
            return 1;
        }
    }
}
