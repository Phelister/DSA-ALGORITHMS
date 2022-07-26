package com.myProjects.wow;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public  class PlusOnEquation {

    public int[] plusOne(int[] digits) {
        //incase there's a cary over
        boolean CarryOver=false;
        //to save new numbers
        int digit;
        for (int i=digits.length-1; i>=0; i--){
            digit= digits[i] + 1;
            if (digit==10) {
                digit = 0;
                CarryOver = true;
            } else {
                CarryOver =false;
            }
            digits[i]=digit;
            if(!CarryOver){
                return digits;
            }
        }
        if(CarryOver) {
            int[] wow = new int[digits.length +1];
            //set variable 1 to 1
            wow[0]=1;
            return wow;
        }
        return digits;
    }

    public int[] plusOne1(int[] digits) {

            for (int i=digits.length-1; i>=0; i--){
                if (digits[i]<9){
                    digits[i]= digits[i] +1;
                    return digits;
                }
                digits[i]=0;
        }
            int [] newArrayResult = new int[digits.length+1];
            newArrayResult[0]=1;
            return newArrayResult;
    }


    public static void main(String[] args) {
        //initialize the class
        PlusOnEquation adding = new PlusOnEquation();
        int[] wow = new int []{0,9,9};
        List<Integer> myList = new LinkedList<Integer>();
        myList.add(3);
        myList.add(6);
        myList.add(2);
        myList.add(8);

        System .out.println(myList);

        System.out.println(Arrays.toString(adding.plusOne(wow)));

        //objectize the method outside the main class
        //int[] wow= adding.plusOne1(new int[]{9,9,9});
        //System.out.print("{");
        for(int w:wow){
            System.out.print(w +" ");
        }
        System.out.println();

        //this can be called  as
        // System.out.println(new PlusOnEquation().plusOne(new int[]{1,2,3}));
    }
}
