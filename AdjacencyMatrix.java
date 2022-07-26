package com.myProjects.wow;

import java.util.*;

public class AdjacencyMatrix {
    int [][] adjacencyMatrix;
    AdjacencyMatrix(int nodes) {

        //representing rows and columns and initializing memory space
        this.adjacencyMatrix =new int[nodes][nodes] ;

    }
    public void addEdges(int u, int v) {

        this.adjacencyMatrix[u][v]=1;
        this.adjacencyMatrix[v][u]=1;
    }

    public static void main(String [] args){
        AdjacencyMatrix  g = new AdjacencyMatrix(4);
        g.addEdges(0,1);
        g.addEdges(1,2);
        g.addEdges(2,3);
        g.addEdges(3,0);
      // System.out.print(Arrays.toString(g));
        List<String> vu = new ArrayList<String>();
        Set<String> done = new HashSet<String>();
        String[] wow = new String[]{"ytr","vds", "yte"};
        Queue<String> que = new java.util.LinkedList<String>();
        Stack<String> stack = new Stack<String>();
        //vu.addAll(wow);
       // vu.addAll(stack);
        done.addAll(Set.of("String","tyre", "wert"));
       Objects[] k = new Objects[3];
       Collections.sort(vu,Collections.reverseOrder());
       Collections.sort(stack);

    }
}
