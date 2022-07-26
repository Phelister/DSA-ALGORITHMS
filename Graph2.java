package com.myProjects.wow;

import java.util.*;


public class Graph2 {
    int minimum=Integer.MAX_VALUE;

    public List<List<Integer>> bridgesInGraph(Map<Integer, List<Integer>> g){
        if(g.size()==0 || g==null){
            return null;
        }

        int timer=0;
        Map<Integer, Integer> dfsVisit = new HashMap<>();
        Map<Integer, Integer> lowestTime = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        int parent=-1;
        for(Map.Entry<Integer,List<Integer>> entry: g.entrySet()) {
            int source=entry.getKey();
            if(!dfsVisit.containsKey(source)) {
                bridgesInGraphHelper(source,dfsVisit, lowestTime, result, timer, parent, g);
            }
        }
        return result;
    }

    public void bridgesInGraphHelper(int source,Map<Integer, Integer> dfsVisit,Map<Integer, Integer> lowestTime, List<List<Integer>>result,int timer,int parent, Map<Integer, List<Integer>> g) {
        if (!dfsVisit.containsKey(source) || g.get(source) == null) {
            return;
        }
        dfsVisit.put(source, timer);
        lowestTime.put(source, timer);
        timer++;
        for (int neighbour : g.get(source)) {
            bridgesInGraphHelper(neighbour, dfsVisit, lowestTime, result, timer, source, g);
            for (int child: g.get(source)) {
                if (child == parent) {
                    continue;
                }
               minimum = Math.min(lowestTime.get(source), lowestTime.get(child));
            }
            lowestTime.put(source, minimum);
            if (lowestTime.get(parent) < lowestTime.get(source)) {
                    //no way i dont know of a neighour with less time than you
                    result.add(new ArrayList<>(Arrays.asList(source, neighbour)));
                    System.out.println(source + neighbour);
                }
            }
    }
    public static void main(String[] args){
        Graph2 graph = new Graph2();
        Map<Integer, List<Integer>> g =new HashMap<>();
        g.put(1,new ArrayList<>(Arrays.asList(2)));
        g.put(2,new ArrayList<>(Arrays.asList(3,4)));
        g.put(3,new ArrayList<>(Arrays.asList(2,4)));
        g.put(4,new ArrayList<>(Arrays.asList(2,3)));
        System.out.print(graph.bridgesInGraph(g));
    }
}
