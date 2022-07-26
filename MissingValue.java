package com.myProjects.wow;

import java.util.HashSet;

public class MissingValue {


    public int Solution(int[]A){
        int i;
        HashSet<Integer> wow = new HashSet<Integer>();
        for( i=1; i<=A.length+1; i++){
            wow.add(i);
        }
        for(int a: A) {
            wow.remove(a);
        }
 return wow.iterator().next();
    }

    public static void main(String[] args){
        //constructor
        MissingValue missing = new MissingValue();
        System.out.println(missing.Solution(new int[]{1,3,4,2,6}));
    }
}

