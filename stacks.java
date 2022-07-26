package com.myProjects.wow;

import java.util.Stack;

public class stacks {

    public static void main (String[] args) {
        {
            Stack<Integer> stak = new Stack<>();
            stak.push(1);
            stak.push(2);
            stak.push(3);
            System.out.println(stak);
            //top most
            System.out.println(stak.isEmpty());
            System.out.println(stak.peek());
            System.out.println(stak.size());
            System.out.println(stak.pop());
            System.out.println(stak.size());

            System.out.println(stak);

        }
    }
}
