package com.myProjects.wow;

import java.util.HashSet;
import java.util.Iterator;

public class WorkingWithHashsets {
    public static void main(String[] args) {

        HashSet<Integer> wow = new HashSet<>();
        wow.add(5);
        wow.add(5);
        wow.add(7);
        wow.add(8);
        wow.add(22);
        wow.add(15);
        Iterator<Integer> It = wow.iterator();
        while(It.hasNext()){
            System.out.println(It.next());
        }
        System.out.println(wow.hashCode());

    }
}
