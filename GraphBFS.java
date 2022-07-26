package com.myProjects.wow;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphBFS {

    int vertex;
    java.util.LinkedList list[];
    boolean visited[];

    public GraphBFS(int vertex) {
        this.vertex = vertex;
        list = new LinkedList[vertex];
        visited = new boolean[vertex];

        for (int i = 0; i < vertex; i++) {
            list[i] = new java.util.LinkedList<>();
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


    public java.util.LinkedList<Integer> BFSSearch(int source) {

        LinkedList<Integer> myList1 = new LinkedList<>();
        Queue<Integer> myqueue = new LinkedList<>();
        myqueue.add(source);
        visited[source] = true;
        while (!myqueue.isEmpty()) {
            int current = myqueue.poll();
           myList1.add(current);
            System.out.print(current +" ");

            List<Integer> neighbourList = list[current];
            for (int neighbour : neighbourList) {
                if (!visited[neighbour]) {
                    myqueue.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
        return myList1;
    }



    public static void main(String[] args){
        GraphBFS graph1 = new GraphBFS(5);
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 4);
        graph1.addEdge(1, 2);
        graph1.addEdge(1, 3);
        graph1.addEdge(4, 2);
        graph1.addEdge(2, 3);


        graph1.printGraph();
       System.out.print(graph1.BFSSearch(0));


    }

}

