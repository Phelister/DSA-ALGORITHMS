package com.myProjects.wow;

import java.util.*;

public class Recursion {
    Node root;
    public String stringReversal(String S){
        int n = S.length();
        if (S.length() ==0) return "";

        return stringReversal(S.substring(1)) + S.charAt(0);
    }


    public boolean isPalindrome(String S){
        if (S.length() ==0 || S.length()==1){
            return true;
        }
        if (S.charAt(0)==S.charAt(S.length()-1)) {
            return isPalindrome(S.substring(1,S.length()-1));
        }
        return false;
    }
    public int contains1(String str1, String str2){
        int A=5;
        int B=2;
        Contains(str1, str2,A,B);
        return A;
    }
    public int Contains(String str1, String str2, int A, int B){
        if (A==str1.length()||B==str2.length()){
            return 0;
        }
        if (str1.charAt(A)==str2.charAt(B)){
            return 1+ Contains(str1, str2,A+1,B+1);
        }
        else{
            return 0 + Contains(str1, str2,A+1,B+1);
        }
    }
    public List<List<Integer>> pop(int[] arr){
        int pre=0;
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
       int m= arr.length;
        //popHelper(pre,temp, arr,m);
       // return temp;
        for(int i=0; i<m; i+=2){
            temp.add(arr[i]);
            temp.add(arr[i+1]);
            result.add(temp);
            temp = new ArrayList<>();
        }
        return result;
    }

    public void popHelper(int pre,List<Integer>temp,int[] arr,int m){
        if(pre>=m){
            return;
        }
        temp.add(arr[pre++]);
        popHelper(pre,temp,arr,m);
    }

    public List<Integer> wow(Map<Integer, List<Integer>> val,int source){
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        wowhelper(val,result,visited,source);
        return result;
    }
    public void wowhelper(Map<Integer, List<Integer>> val,List<Integer> result,Set<Integer> visited, int source){
        if(visited.contains(source) || val.get(source)==null){
            return;
        }
        visited.add(source);
        List<Integer> neighbour = val.get(source);
        for(int neigh : neighbour){

            wowhelper(val,result,visited,neigh);
            result.add(source);
            result.add(neigh);

        }

    }


    public static void main (String[] args){
        Recursion recursion = new Recursion();
        System.out.println(recursion.stringReversal("FOI"));
        System.out.println(recursion.Contains("FOZIY","BOZI",0,0));
        System.out.println(recursion.contains1("FOZIY","BOZI"));
        System.out.println(recursion.isPalindrome("FOwzwOF"));
        int[] arr = new int[]{5,4,3,7,8,9};
        System.out.println(recursion.pop(arr));

        Map<Integer, List<Integer>> v = new HashMap<>();

        //if(!v.containsKey(5)){
            //v.put(5, new ArrayList<>());
        //}
        //v.get(5).add(2);
        char y = 'Z';
        //char x = 'a';
        int position = y-'a';


        System.out.println(position);
        System.out.println(position);
        System.out.println(position);
        int num = 16;
        int bit=(num >> 4) ;
        System.out.println(bit);

        v.put(5,new ArrayList<>(Arrays.asList(2,5,9)));
        v.put(2,Arrays.asList(8,4,9));
        System.out.println(v.get(5));
        System.out.println(recursion.wow(v,5));
        System.out.println(" ");
        int [] arr1 = {3,4,5};
        System.out.println(Arrays.toString(arr1));
       // for(Map.Entry<Integer, List<Integer>> entry : v.entrySet()){
          //  System.out.println(entry.getValue() +"   "+ entry.getKey());
       // }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(11);
        temp.add(12);
        result.add(new ArrayList<>(temp));
        System.out.println(result);
        int max=0;
        max = max | 1<<2;
        System.out.print(max);
        Map<Integer, Integer> zy = new HashMap<>();
        zy.put(5, zy.getOrDefault(5, 0)+1);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(3);
        pq.add(5);
        pq.add(2);
        pq.add(4);
        System.out.print(pq.poll());


    }
}
