package com.myProjects.wow;

import java.util.*;
public class Program {

    public static void main(String[] arg) {
        List<char[]> edges = new java.util.LinkedList<>();
        edges.add(new char[]{'w', 'x'});
        edges.add(new char[]{'x', 'y'});
        edges.add(new char[]{'z', 'y'});
        edges.add(new char[]{'z', 'v'});
        edges.add(new char[]{'w', 'v'});
        //int distance = shortestPath(edges, 'w', 'z');
        //System.out.println(distance);
    }
    //    private static void PrintGraph(HashMap<Character, List<Character>> graph) {
//        System.out.println("[");
//        for (HashMap<Character, List<Character>> item : graph) {
//            System.out.println(item.[{String.join(',', item.Value)}] ");
//        }
//        System.out.println("]");
//    }


    private static Map<Character, List<Character>> buildGraph(List<char[]> edges) {
        Map<Character, List<Character>> graph = new HashMap<>();
        for (char[] edge : edges) {
            char a = edge[0];
            char b = edge[1];
            if (!graph.containsKey(a)) {
                graph.put(a, new java.util.LinkedList<>());
            }
            if (!graph.containsKey(b)) {
                graph.put(b, new java.util.LinkedList<>());
            }
            List<Character> aa = graph.get(a);
            aa.add(b);
            graph.replace(a, aa);
            List<Character> bb = graph.get(b);
            bb.add(a);
            graph.replace(b, bb);
        }
        return graph;

    }
}
