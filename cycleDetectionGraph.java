package com.myProjects.wow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class cycleDetectionGraph {
    public boolean cycleDFS(Map<Integer, List<Integer>> graph){
        if(graph==null || graph.size()==0){
            return false;
        }
        Map<Integer, Integer> cycle = new HashMap<>();

        for(int key : graph.keySet()){
            if(DFSCycleHelper(key,cycle,graph)){
                return true;
            };
        }
        return false;
    }
    public boolean DFSCycleHelper(int source, Map<Integer,Integer> cycle,Map<Integer, List<Integer>> graph){
        if(graph.get(source)==null){
            return false;
        }
        if(cycle.containsKey(source)){
            if(cycle.get(source)==1){
                return true;
            }
            return false;
        }
        cycle.put(source,1);
        for(int neighbour: graph.get(source)){
            if(DFSCycleHelper(neighbour,cycle,graph)){
                return true;
            }
        }
        cycle.put(source,0);
        return false;
    }
    public static void main (String[] args){
        cycleDetectionGraph cycle = new cycleDetectionGraph();
        Map<Integer, List<Integer>> g= new HashMap<>();
        g.put(1,new ArrayList<>());
        g.put(2,new ArrayList<>());
        g.put(3,new ArrayList<>());
        g.put(4,new ArrayList<>());
        g.get(1).add(3);
        g.get(2).add(1);
        g.get(3).add(4);
        g.get(4).add(2);

        System.out.println(cycle.cycleDFS(g));
        int current = 5;
        int y =(current<Integer.MAX_VALUE)? current:-1;
        System.out.print(y);
    }
}
