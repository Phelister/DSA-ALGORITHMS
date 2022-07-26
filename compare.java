package com.myProjects.wow;

import java.util.*;

public class compare implements Comparator<compare>{
   int a;

    public compare(int a){
       this.a=a;
    }

    public compare() {
    }

    @Override
    public int compare(compare o1, compare o2) {

        if(Math.abs(o1.a)<Math.abs(o2.a)){
            return -1;
        }
        if(Math.abs(o1.a)>Math.abs(o2.a)){
            return 1;
        }
        if(o1.a>o2.a){
            return 1;
        }
        if(o1.a<o2.a){
            return -1;
        }
        return 0;
    }

    public static void main(String[] args){
        int[] arr1 ={2,-7,-2,-2,0};
        compare[] arr13 = new compare[5];
        int k=0;
        for(int i=0; i<arr1.length; i++){
            arr13[k]= new compare(arr1[k]);
            k++;
        }
        Arrays.sort(arr13,new compare());

    }

}
