package com.myProjects.wow;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class newConnectedThings {

    public class Graph {
        int vertex;
        LinkedList list[];

        public Graph(int Vertex) {
            this.vertex = Vertex;
            list = new LinkedList[Vertex];

            for (int i = 0; i < Vertex; i++) {
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
    }

        public boolean DFSHasPath2(int[][] edges, int n, int source, int target) {

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
                List<Integer> neighbourList = graph.list[current];
                for (int neighbour : neighbourList) {
                    if (DFSHasPath3(neighbour, target, Visited,graph)==true){
                        return true;
                    }
                }
            }
            return false;
        }


   // public boolean DFSHasPath2(int[][] edges, int n, int source, int target) {

        //Graph graph = new Graph(n);
       // for (int i=0; i< edges.length; i++) {
       //     graph.addEdge((edges[i][0]),(edges[i][1]));
      //  }
        //Set<Integer> Visited = new HashSet<>();
        //if (DFSHasPath3(source,target, Visited,graph)==true) return true;
        //return false;
   // }

    //public boolean DFSHasPath3(int current,int target, Set<Integer> Visited, Graph graph) {

        //if (current == target) return true;
        //if (!Visited.contains(current)) {
          //  Visited.add(current);
            //List<Integer> neighbourList = graph.list[current];
            //for (int neighbour : neighbourList) {
             //   if (DFSHasPath3(neighbour, target, Visited,graph)==true){
                   // return true;
             //   }
         //   }
      //  }
        //return false;
   // }


        public static void main(String[] args){
            newConnectedThings wow = new newConnectedThings();
            int [][] edges={{0,1},{0,3},{3,4}};
            System.out.print(wow.DFSHasPath2(edges,5,1,3));



        }

    }

