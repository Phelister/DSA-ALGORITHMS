package com.myProjects.wow;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class ConnectedComponents {

    public int myConnectedComponents(Graph graph, int source) {
        Set<Integer> visited = new HashSet<Integer>();
        int count = 0;
        myNewConnectedComponents(graph, source, visited);
        return count;
    }

    public boolean myNewConnectedComponents(Graph graph, int source, Set<Integer> visited) {
        visited = new HashSet<Integer>();
        if (visited.contains(source)) return false;
        visited.add(source);
        //List<Integer> neighbourlist = list[source];
       // for (int neighbour : neighbourlist) {
        //    myNewConnectedComponents(graph, neighbour, visited);
       // }
        return true;
    }
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(4, 2);
        graph.addEdge(2, 3);


        graph.printGraph();
    }
}

