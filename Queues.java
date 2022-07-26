package com.myProjects.wow;

import java.util.LinkedList;
import java.util.Queue;

public class Queues {
    public static void main(String[] args) {
        //queues
        //fifo
        //mostly use linked lists or priority queue
        Queue<Person> myqueue = new LinkedList<>();
        myqueue.add(new Person("foi", 3));
        myqueue.add(new Person("fuzu", 4));
        myqueue.add(new Person("vita", 5));
        System.out.println(myqueue.size());
        System.out.println(myqueue.peek());
        System.out.println(myqueue.poll());
        System.out.println(myqueue.size());
        System.out.println(myqueue.isEmpty());
       // static record Person(String name, int age){}
    }
   static record Person(String name, int age){}
}