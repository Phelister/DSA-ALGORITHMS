package com.myProjects.wow;
import java.util.*;
import java.util.LinkedList;

public class hasPath {
    int vertex;
    LinkedList<Integer> list[];
    Boolean visited[];

    public hasPath(int vertex) {
        this.vertex = vertex;
        list = new LinkedList[vertex];
        visited = new Boolean[vertex];
        for (int i = 0; i < vertex; i++) {
            list[i] = new LinkedList();
        }
    }

    public void addEdge(int source, int destination) {
        list[source].add(destination);
    }

    public boolean DFSHasPath(int source, int destination) {
        Stack myStack = new Stack();
        Set<Integer> myset = new HashSet<>();
        myStack.add(source);
        myset.add(source);
        //visited[source] = true;
        while (!myStack.isEmpty()) {
            int current = (int) myStack.pop();
            if (current == destination) {
                return true;
            }
            List<Integer> neighbourList = list[current];
            if (!myset.contains(neighbourList)) {
                for (int neighbour : neighbourList) {
                    if (!myset.contains(neighbour)) {
                        myStack.add(neighbour);
                        myset.add(neighbour);
                        //visited[neighbour] = true;
                    }
                }

            }

        }
        return false;
    }

        public int connectedComponents (hasPath graph, int source) {
            Stack myStack = new Stack();
            Set<Integer> Visited = new HashSet<>();
            myStack.add(source);
            int count = 0;
            for (int i = 0; i < vertex; i++){
                myStack.add(i);
               // System.out.println (Visited+ "");

                //for (int i = 0; i < vertex; i++) {
                while (!myStack.isEmpty()) {
                    int current = (int) myStack.pop();
                    if (!Visited.contains(current)){
                        count=count+1;
                        Visited.add(current);
                        List<Integer> neighbourList = list[current];
                        // if (!mySet.contains(i)) {
                        // if (!mySet.contains(neighbourList)) {
                        for (int neighbour : neighbourList) {
                            if (!Visited.contains(neighbour)) {
                                myStack.add(neighbour);
                                Visited.add(neighbour);
                            }
                        }
                        System.out.println(Visited);
                    }
                }

            }
            return count;
        }

        public void myhelp(){

        }




        public boolean DFSHasPathRecursive ( int source, int destination){
            if (source == destination) return true;
            visited[source] = true;
            List<Integer> neighbourList = list[source];
            for (int neighbour : neighbourList) {
                if (DFSHasPathRecursive(neighbour, destination) == true) {
                    return true;
                }
            }
            return false;
        }



    public static void main(String[] args)
    {
        hasPath graph = new hasPath(5);
        graph.addEdge(0, 1);
        graph.addEdge(2, 4);
        //graph.addEdge(1, 2);
        //graph.addEdge(4, 2);
        //graph.addEdge(3, 2);

       //System.out.print(graph.DFSHasPath(0,3));
        System.out.print(graph.connectedComponents(graph,0));
    }
}
