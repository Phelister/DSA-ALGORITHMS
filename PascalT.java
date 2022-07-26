package com.myProjects.wow;

import java.util.List;
import java.util.ArrayList;

public class PascalT {

    public List<List<Integer>> pascalTriangle(int num){

//corner case
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        if (num==0){
            return pascalTriangle;
        }

        List<Integer> firstRow= new ArrayList<>();

        int initializer =1;
        firstRow.add(initializer);
        pascalTriangle.add(firstRow);

        for (int i=1;  i<num; i++){
            List<Integer> previousRow= pascalTriangle.get(i-1);
            List<Integer> currentRow =new ArrayList<>();
            currentRow.add(1);
            System.out.print(" ");
            for(int j=1; j<i; j++){
                currentRow.add(previousRow.get(j) +previousRow.get(j-1));
                System.out.print(" ");
            }
            currentRow.add(1);
            pascalTriangle.add(currentRow);
            System.out.println(" ");
        }
        return  pascalTriangle;
    }

       public static void main(String[] args){
       PascalT wow = new PascalT();

         System.out.println(wow.pascalTriangle(7));
        }
}

