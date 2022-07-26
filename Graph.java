package com.myProjects.wow;

import java.util.*;
import java.util.LinkedList;

public class Graph {
    int vertex;
    LinkedList list[];

    boolean visited[];

    public Graph(int Vertex) {
        this.vertex = Vertex;
        list = new LinkedList[Vertex];
        visited = new boolean[vertex];

        for (int i = 0; i < Vertex; i++) {
            list[i] = new LinkedList<>();

        }
    }

    public void addEdge(int source, int destination) {
        //do both for undirected graph
        list[source].add(destination);
       list[destination].add(source);
    }

    public void printGraph() {
        for (int i = 0; i < vertex; i++) {
            if (list[i].size() > 0) {
                System.out.print(i + " ---> ");
                for (int j = 0; j < list[i].size(); j++) {
                    System.out.print(list[i].get(j) + " ");
                }
                System.out.println();
            }
        }
    }




    public LinkedList<Integer> DFSSearch(int source) {
        //visited[vertex]=false;
        LinkedList<Integer> myList1 = new LinkedList<>();
        Set<Integer> myset = new HashSet<Integer>();
        Stack<Integer> myStack = new Stack<Integer>();
        myStack.push(source);
        visited[source] = true;
        while (!myStack.isEmpty()) {
            int current = myStack.pop();
            myList1.add(current);
            //System.out.print(current);
            List<Integer> neighbourList = list[current];

            for (int neighbour : neighbourList) {
                if (!visited[neighbour]) {
                    myStack.push(neighbour);
                    visited[neighbour] = true;
                }
            }
        }

        return myList1;
    }

    public List<Integer> DFSSearchRecursively(int source) {
        LinkedList<Integer> myList1 = new LinkedList<>();
        Set<Integer> Visited = new HashSet<>();
        return DFSSearchRecursively1(source, Visited, myList1);
        //return myList1;
    }

        public List<Integer> DFSSearchRecursively1(int current,Set<Integer> Visited, List<Integer> myList1){
        if (Visited.contains(current)) return myList1;
        Visited.add(current);
        myList1.add(current);
        List<Integer> neighbourList = list[current];
            for (int neighbour : neighbourList) {
                DFSSearchRecursively1(neighbour,Visited,myList1);
            }
           return myList1;
        }

    public boolean DFSHasPath(int source, int target) {
        Set<Integer> Visited = new HashSet<>();
        if (DFSHasPath1(source,target, Visited)==true) return true;
        return false;
    }

    public boolean DFSHasPath1(int current,int target, Set<Integer> Visited) {

        if (current == target) return true;
        if (!Visited.contains(current)) {
            Visited.add(current);
            List<Integer> neighbourList = list[current];
            for (int neighbour : neighbourList) {
                if (DFSHasPath1(neighbour, target, Visited)==true){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean DFSHasPath2(int[][] edges,int n,  int source, int target) {

        Graph graph = new Graph(n);
        for (int i=0; i< edges.length; i++) {
            graph.addEdge((edges[i][0]),(edges[i][1]));
        }
        Set<Integer> Visited = new HashSet<>();
        if (DFSHasPath3(source,target, Visited,graph)==true) return true;
        return false;
    }

    public boolean DFSHasPath3(int current,int target, Set<Integer> Visited, Graph graph) {

        if (current == target) return true;
        if (!Visited.contains(current)) {
            Visited.add(current);
            //List<Integer>[] graph;
            List<Integer> neighbourList = list[current];
            for (int neighbour : neighbourList) {
                if (DFSHasPath3(neighbour, target, Visited,graph)==true){
                    return true;
                }
            }
        }
        return false;
    }


    public int myConnectedComponents(Graph graph) {
        Set<Integer> visited = new HashSet<Integer>();
        int count = 0;
        for (int i=0;i< graph.vertex; i++) {
            if (myNewConnectedComponents(i, graph,visited) == true) {
                count++;
            }
        }
        return count;
    }

    public boolean myNewConnectedComponents(int current,Graph graph, Set<Integer> visited) {
        if (visited.contains(current)) return false;
        visited.add(current);
        List<Integer> neighbourlist = graph.list[current];
        for (int neighbour : neighbourlist) {
            myNewConnectedComponents(neighbour,graph, visited);
        }
        return true;
        }

    public int LargestComponents(Graph graph) {
        Set<Integer> visited = new HashSet<Integer>();
        int count = 0;
        int longest=(0);
        for (int i=0;i< graph.vertex; i++) {

            int size= LargestComponentsHelper(i, graph,visited);
            if(size>longest) longest=size;
            }
        return longest;
    }

    public int LargestComponentsHelper(int current,Graph graph, Set<Integer> visited) {
        if (visited.contains(current)) return 0;
        visited.add(current);
        int size = 1;
        List<Integer> neighbourlist = graph.list[current];
        for (int neighbour : neighbourlist) {
            size = size+LargestComponentsHelper(neighbour,graph, visited);
        }
        return size;
    }


    public int shortestDistance(int[][] edge, int n, int start, int end) {
        Graph graph2 = new Graph(n);
        for (int i = 0; i < edge.length; i++) {
            graph2.addEdge(edge[i][0], edge[i][1]);
        }
        Set<Integer> visited = new HashSet<Integer>();
        Queue<Integer> myqueue = new LinkedList<>();

        int[] distance = new int[graph2.vertex];
        Arrays.fill(distance,-1);
        myqueue.add(start);// Intialize distance array
        distance[start]=0;
        visited.add(start);
        while(!myqueue.isEmpty()) {
            //int size = myqueue.size();

                int current = myqueue.poll();
                if (current == end) {
                    return distance[current];
                }
                List<Integer> neighbourlist = graph2.list[current];
               for (int neighbour : neighbourlist) {
                  //  if (!visited.contains(neighbour)) {
                   if (distance[neighbour]==-1) {
                       // int infinity= (int) Double.NEGATIVE_INFINITY;
                        distance[neighbour] = distance[current] + 1;
                        myqueue.add(neighbour);
                        visited.add(neighbour);

                    }
                }
            }

        return -1;
    }


    public static void main(String[] args){
        Graph graph2 = new Graph(5);
        Graph graph1 = new Graph(5);
        int [][] edges={{0,1},{1,2},{2,3},{0,4},{3,4}};

        //System.out.print(graph1.DFSHasPath2(edges,5,3,2));
        System.out.println(graph2.shortestDistance(edges,5,0,2));


       graph1.addEdge(0, 1);
       graph1.addEdge(0, 4);
       graph1.addEdge(2, 3);
       graph1.addEdge(1, 3);
       graph1.addEdge(4, 2);
       graph1.addEdge(2, 3);

        //System.out.print(graph1.DFSSearchRecursively(0));
        graph1.printGraph();
       System.out.println(graph1.LargestComponents(graph1));

        //graph1.edgeToAdjacencyList(edges);
        //graph1.DFSHasPath2(edges,0,1);
            //System.out.print(graph1.DFSSearchRecursively(0));
       // System.out.print(graph1.DFSHasPath(0,4));
           // System.out.print(graph1.myConnectedComponents(1));


        }

}




