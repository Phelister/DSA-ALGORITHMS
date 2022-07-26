package com.myProjects.wow;

import java.util.Arrays;

public class myArray {
    public static void main(String[] args) {
        String[] colors = new String[5];
        colors[0]="purple";
        colors[1]="blue";
        //Don't use the below
        //System.out.println(colors)
        System.out.println(Arrays.toString(colors));
        System.out.println(colors[4]);
        for (int i = 0; i<colors.length; i++)
            System.out.println(colors[i]);
        for (String color:colors)
        {
            System.out.println(color);
        }

    }
}
