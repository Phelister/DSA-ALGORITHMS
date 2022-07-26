package com.myProjects.wow;

import java.util.*;

public class Atest {

    public static void main (String[] args){

        Map<Integer, List<Integer>> list = new HashMap<>();
        Map<Integer, Map<Integer, List<Integer>> > ll = new HashMap<>();
        list.entrySet();
        list.put(1, new ArrayList<>(Arrays.asList(5,3)));
        if(list.containsKey(1)){
            list.get(1).add(8);
        }
        for(Map.Entry<Integer,List<Integer>> entry:list.entrySet()){
            System.out.println(entry.getValue());
            entry.getValue().get(0);
            entry.getValue().get(entry.getValue().size()-1);

        }
        for(Map.Entry<Integer, Map<Integer, List<Integer>>> vu:ll.entrySet()){
            //System.out.println(entry.getValue());

            for(List<Integer> se : vu.getValue().values()){
                Collections.sort(se);

            }
        }

    }
}
