package com.myProjects.wow;

import java.util.*;
import java.util.LinkedList;

public class mytest {

    public static void main (String[] args){
        int start =5;
        int distance=18;
        Queue<Pair> queue = new PriorityQueue(new Pair());

        //Queue<Pair> que = new PriorityQueue<Pair>(new Pair());


        Queue<Map<Integer,Integer>> myqueu = new LinkedList<>();
        myqueu.add(new HashMap<>(start,distance));
        myqueu.add(new HashMap<>(0,5));
        //Map<Integer,Integer> myMap= new HashMap<>();
       // myMap.put(start, distance);
        //myMap.put(8, 3);
       // myqueu.add(myMap);
        Map<Integer, Integer> keys= myqueu.poll();
        System.out.println(myqueu.poll());
        String y ="pull";
        String w ="push";
        System.out.println(w.compareTo(y));
        Map<Integer, Integer> wow = new HashMap<>();
        //public Map<Integer, Integer> ven(Map<Integer, Integer> wow) {
        //if (wow == null || wow.size() == 0) {
           // return null;
        }
       }

//}
//}
