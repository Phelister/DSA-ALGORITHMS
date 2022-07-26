package com.myProjects.wow;

public class naturalNumbers {
    public static int naturalNums(int num){
     if (num==0){
         return num;
     }
     return num +naturalNums(num-1);
    }

    public static void main(String[] args){
      naturalNumbers nat =new naturalNumbers();
      System.out.println(nat.naturalNums(1));
    }
}
