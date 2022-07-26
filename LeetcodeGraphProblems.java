package com.myProjects.wow;

import java.util.*;
import java.util.LinkedList;

public class LeetcodeGraphProblems {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //to check if theres a loop and if
        if(prerequisites==null|| prerequisites.length==0 || prerequisites[0].length==0){
            return false;

        }
        //cycle detection
        //parent cur1
        int m= prerequisites.length;
        Boolean canFinish=false;
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i=0;i<m;i++){
            if(!graph.containsKey(prerequisites[i][1])){
                graph.put(prerequisites[i][1], new ArrayList<>());
            }
            if(!graph.containsKey(prerequisites[i][0])){
                graph.put(prerequisites[i][0], new ArrayList<>());
            }
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }


        Map<Integer,Integer> DFSMonitor = new HashMap<>();
        for(Map.Entry<Integer,List<Integer>> entry : graph.entrySet()){
            int key=entry.getKey();
            if(!DFSMonitor.containsKey(key)){
                if(containsCycle(DFSMonitor,graph,key)){
                    return false;
                }

            }

        }
        return true;
    }

    public boolean containsCycle(Map<Integer,Integer> DFSMonitor,Map<Integer,List<Integer>> graph,int source){
        if(DFSMonitor.containsKey(source) && DFSMonitor.get(source)==1){
            return true;
        }
        if((DFSMonitor.containsKey(source) && DFSMonitor.get(source)==0)|| graph.get(source)==null){
            return false;
        }

        DFSMonitor.put(source,1);
        System.out.println(graph);
        System.out.println(DFSMonitor);

        List<Integer> neighbourList = graph.get(source);
        for(int neighbour : neighbourList){
            if(containsCycle(DFSMonitor,graph,neighbour)){
                return true;
            }

        }
        DFSMonitor.put(source,0);
        return false;
    }
    public List<Integer> topoLogicalSort(Map<Integer, List<Integer>> graph){
        if(graph==null || graph.size()==0){
            return null;
        }
        List<Integer> temp = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for(Map.Entry<Integer,List<Integer>> entry: graph.entrySet())
        {
            int key=entry.getKey();
            if(!visited.contains(key)) {
                topoLogicalSortHelper(key,graph, temp, visited);
            }
        }
        return temp;
    }
    public void topoLogicalSortHelper(int source,Map<Integer,List<Integer>> graph,List<Integer> temp, Set<Integer> visited){
        if(visited.contains(source)|| graph.get(source)==null){
            return;
        }
        visited.add(source);
        List<Integer> neighbourList = graph.get(source);
        for(int neighbour: neighbourList){
            topoLogicalSortHelper(neighbour,graph,temp,visited);
        }
        temp.add(0,source);
        return;
    }


    //khan algorithm test

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //use khans algorithm
        //create a map with the list provided
        if(prerequisites==null|| prerequisites.length==0){
            return new int[]{};
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        int m= prerequisites.length;

        for(int i=0;i<m;i++){
            if(!graph.containsKey(prerequisites[i][0])){
                graph.put(prerequisites[i][0], new ArrayList<>());
            }
            if(!graph.containsKey(prerequisites[i][1])){
                graph.put(prerequisites[i][1], new ArrayList<>());
            }
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        //find in---degrees


        Map<Integer,Integer> map = new HashMap<>();
        for(Map.Entry<Integer,List<Integer>> entry : graph.entrySet()){
            int key= entry.getKey();
            List<Integer> value = entry.getValue();
            if(!map.containsKey(key)){
                map.put(key,0);
            }
            if(value!= null ||value.size()!=0){
                for(int val : value){
                    if(!map.containsKey(val)){
                        map.put(val,0);
                    }
                    map.put(val, map.get(val)+1);
                }
            }
        }

        // to see if any contains zero so that i add them to my list as they dont have parents

        Queue<Integer> queue = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int value= entry.getValue();
            if(value==0){
                queue.add(key);
            }
        }
        System.out.println(queue);

        //iterate through queue as you output array
        int i=0;
        int[] arr = new int[graph.size()];
        while(!queue.isEmpty()){
            int current = queue.poll();
            arr[i++]=current;
            List<Integer> neighbourList = graph.get(current);
            System.out.println(neighbourList);
            if(neighbourList!=null){
                for(int neighbour: neighbourList){
                    map.put(neighbour, map.get(neighbour)-1);
                    if(map.get(neighbour)==0){
                        queue.add(neighbour);
                    }
                }
            }

        }
        return arr;

        //return (i==arr.length)? arr : new int[]{};

    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> result = new ArrayList<>();
        if( n==0){
            return result;
        }
        if(n==1){
            result.add(0);
            return result;
        }

        Map<Integer,List<Integer>> graph = new HashMap<>();

        for(int i=0; i<edges.length; i++){
            if(!graph.containsKey(edges[i][0])){
                graph.put(edges[i][0], new ArrayList<>());
            }
            if(!graph.containsKey(edges[i][1])){
                graph.put(edges[i][1], new ArrayList<>());
            }
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);

        }
        System.out.println(graph);


        for(int i=0; i<n;i++){
            if(!graph.containsKey(i)){
                graph.put(i, new ArrayList<>());
            }
        }

        Map<Integer,Integer> outDegreeMap = new HashMap<>();

        //outdegree of 1 means its the leafnode.

        Queue<Integer> queue = new LinkedList<>();

        for(Map.Entry<Integer, List<Integer>> entry : graph.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue().size();
            outDegreeMap.put(key, value);
            if(outDegreeMap.get(key)==1){
                queue.add(key);
            }
        }
        System.out.println(outDegreeMap);


        while(!queue.isEmpty()){
            System.out.println(queue);

            //find hack for outputing 1 or 2;
            if(outDegreeMap.size()<=2){
                break;
            }
            int size = queue.size();

            for(int i=0;i<size; i++){
                System.out.println("###");
                System.out.println(queue.peek());
                System.out.println("###");
                int current = queue.poll();

                if(graph.get(current)!=null){
                    for(int neighbour: graph.get(current)){
                        List<Integer> myList = new ArrayList<>();

                        Set<Integer> set= new HashSet<>();
                            outDegreeMap.put(neighbour, outDegreeMap.get(neighbour)-1);
                        if(outDegreeMap.get(neighbour)==1){
                            queue.add(neighbour);
                        }
                    }
                }
                outDegreeMap.remove(current);

            }
        }
        for(Map.Entry<Integer,Integer> entry : outDegreeMap.entrySet()){
            result.add(entry.getKey());
        }

        return result;
    }
    public int[] findRedundantConnection(int[][] edges) {

        //loop through form an adjacency list without that edge and see if it has one connected component
        //continue in your loop
        //looping through either bfs and dfs if result is less than nodes then is false;

        int[] arr = new int[2];

        int n= edges.length;

        Map<Integer,Set<Integer>> graph = buildGraph(edges);

        int m= graph.size();
        System.out.println(m);

        for(int i=0 ;i<n;i++){

            int source = edges[i][0];
            int destination=edges[i][1];

            Set<Integer> visited = new HashSet<>();

            graph.get(source).remove(destination);
            graph.get(destination).remove(source);
            System.out.println(graph);
            int y= dfs(graph,source,visited);
            System.out.println(y);
            if(y==m){
                arr[0]=source;
                arr[1]=destination;
            }
            graph.get(source).add(destination);
            graph.get(destination).add(source);

        }
        return arr;
    }
     public int findParent(int[] arr, int val){
        if(val== arr[val]){
            return val;
        }
        return arr[val]=findParent(arr, arr[val]);
     }

    private Map<Integer,Set<Integer>> buildGraph(int[][] edges){
        int n= edges.length;
        Map<Integer,Set<Integer>> graph = new HashMap<>();

        for(int i=0;i<n;i++){
            int source = edges[i][0];
            int destination=edges[i][1];
            if(!graph.containsKey(source)){
                graph.put(source,new HashSet<>());
            }
            if(!graph.containsKey(destination)){
                graph.put(destination,new HashSet<>());
            }
            graph.get(source).add(destination);
            graph.get(destination).add(source);
        }
        System.out.println(graph);
        return graph;
    }

    public int dfs(Map<Integer,Set<Integer>> graph, int source,Set<Integer> visited){
        if(graph.get(source)==null){
            return 1;
        }
        if(visited.contains(source)){
            return 0;
        }
        int size=1;
        visited.add(source);
        Set<Integer> neighbourList= graph.get(source);
        for(int neighbour: neighbourList){
            size+= dfs(graph,neighbour,visited);

        }
        return size;


    }



public static void main(String[] args){
    LeetcodeGraphProblems lt = new LeetcodeGraphProblems();
    int[][] arr={{1,0}};
    Map<Integer,List<Integer>> map= new HashMap<>();
    map.put(1,new ArrayList<>());
    map.put(2,new ArrayList<>());
    map.put(3,new ArrayList<>());
    map.put(4,new ArrayList<>());
    map.put(5,new ArrayList<>());
    map.put(6,new ArrayList<>());
    map.get(1).add(2);
    map.get(2).add(3);
    map.get(3).add(4);
    map.get(3).add(5);
    map.get(6).add(3);
    Map<Integer,Integer> dfs= new HashMap<>();


    System.out.println(lt.containsCycle(dfs,map,0));
    System.out.println(lt.topoLogicalSort(map));
    int num=2;
    System.out.println(Arrays.toString(lt.findOrder(num, arr)));
    int[][] arr2 = {{0,1},{0,2},{0,3},{3,4},{4,5}};
    for(int i=0;i<5;i++){

    }
    //System.out.println(lt.findMinHeightTrees(4, arr2));
    int[][] edges = {{1,2},{1,3},{2,3}};
    System.out.println(Arrays.toString(lt.findRedundantConnection(edges)));
    Map<Integer,Integer> wow= new HashMap<>();
    System.out.println(wow.get(1));
    int [] arry = new int[8];
    arry[1]=1;
    arry[5]=1;
    arry[6]=5;
    arry[7]=6;
    System.out.print(lt.findParent(arry,7));
    System.out.print(Arrays.toString(arry));
    arry[6]++;
    System.out.print(Arrays.toString(arry));

    PriorityQueue<Node2> pq = new PriorityQueue<>();
    pq.add(new Node2(5,4));
    pq.add(new Node2(6,4));
    //Arrays.sort().sort(pq,(a,b),)





}
}
