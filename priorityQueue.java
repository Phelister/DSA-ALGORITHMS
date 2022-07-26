package com.myProjects.wow;

import java.util.PriorityQueue;
import java.util.Queue;

public class priorityQueue {
    public static void main(String[] args) {
        Queue<String> quta = new PriorityQueue<>();
        quta.add("Fuzi");
        quta.add("Buzi");
        quta.add("Mjumbe");
        while (!quta.isEmpty()) {
            System.out.println(quta.poll());
        }
    }
}
