package com.myProjects.wow;

import java.util.ArrayList;
import java.util.List;

public class workingWithLists {
    public static void main (String[] args){
        List<String> color = new ArrayList<>();
        color.add(0, "wow");
        color.add(1, "break");
        color.add(2, "break2");
        color.add(3, "break2");
        color.add(4, "break3");
        System.out.println(color);
        System.out.println(color.size());
        System.out.println(color.contains("yellow"));
        System.out.println(color.contains("wow"));
        for (String colo:color)
            System.out.println(colo);

        List<String> cozzy =List.of(
        "wow",
        "try",
        "wertw"
        );
        System.out.println(cozzy);
    }
}
