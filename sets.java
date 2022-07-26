package com.myProjects.wow;

import java.util.HashSet;
import java.util.Set;

public class sets {
    public static void main(String[] args) {
        Set<balls> balls =new HashSet<>();
        balls.add(new balls("red"));
        balls.add(new balls("purple"));
        balls.add(new balls("green"));
        balls.add(new balls("green"));
        balls.forEach(System.out::println);


    }
    record balls(String colour){}
}
