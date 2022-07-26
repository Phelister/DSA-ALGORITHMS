package com.myProjects.wow;

import java.util.Arrays;

public class twoDarrays {
    public static void main(String[] args){
        char[][] wow = new char[3][3];
        for(int i = 0; i<wow.length; i++)
            for(int j = 0; j<wow.length; j++)
                wow[i][j]='-';

        System.out.println(Arrays.deepToString(wow));
        wow[0][0]='0';
        wow[1][0]='1';
        wow[2][0]='c';
        System.out.println(Arrays.deepToString(wow));


    }
}
