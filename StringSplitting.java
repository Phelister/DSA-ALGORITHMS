package com.myProjects.wow;

import java.util.LinkedList;
import java.util.Queue;

public class StringSplitting {

    static boolean validateIP(String ip) {
        if (ip.length() == 0) return false;

        String[] words = ip.split(".");

        if (ip.length() != 4) return false;
        for (int i = 0; i <= words.length - 1; i++) {
            //  if
            Queue<Integer> myqu = new LinkedList();
            //myqu.add((567),(768));
            //boolean visited[][] = new boolean[m][n];
        }
        // }
        return true;
    }
}
