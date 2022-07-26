package com.myProjects.wow;
import java.util.*;
import java.util.LinkedList;

public class DFSAdjacencyList {


    public static void main(String[] args) {
        //ArrayList<LinkedList<Integer>> l = new ArrayList<>();
        LinkedList<Integer> l[] = new LinkedList[10];
        for (int i = 0; i < 10; i++) {
            l[i] = new LinkedList<>();
            l[0].add(30);
            l[0].add(45);
            l[1].add(67);
            l[0].add(0, 50);
            System.out.println(i + "------>" + l[i]);
            int[] al = {1,2,3,4,6,7};
           // Arrays.sort(al,collections.reverseOrder);
            //for (int le : l[i]) {
            //  System.out.print(le);
            //  System.out.print(" ");
            // }
            PriorityQueue<Node>  values = new PriorityQueue<>();
            //v

        }
        //ArrayList<LinkedList<Integer>> l =new LinkedList<>()
    }
}

