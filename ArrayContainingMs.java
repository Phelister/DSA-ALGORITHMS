package com.myProjects.wow;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ArrayContainingMs {

    public int sumOfDigits(long n){
        int sum = 0;
        while(n>0){
            sum += n%10;
            n/=10;
        }
        return sum;
    }

    public int maximumSum(int[] arr, int n){
        Map<Integer, Integer> myMap = new HashMap<>();
        int temp=0;
        int A=0;
        int B=0;
        int answer=-1;
        for (int i=0; i<n; i++) {
            temp = sumOfDigits(arr[i]);
            if (!myMap.containsKey(temp)) {
                myMap.put(temp, arr[i]);
            }else{
            if ((arr[i] + myMap.get(temp) > answer)) {
                    A = arr[i];
                    B = myMap.get(temp);
                    answer = A + B;
                }
            myMap.put(temp, Math.max(arr[i], myMap.get(temp)));
           // Set mySet = new

            }
        }
            return answer;
    }

    public static void main (String[] args){
        ArrayContainingMs myArray= new ArrayContainingMs();
        int arr[] ={51,60,71,53};
        //int arr[] ={51,60,8,34};
        //int arr[] ={53,33};
        System.out.print (myArray.maximumSum(arr,4));
    }
}
