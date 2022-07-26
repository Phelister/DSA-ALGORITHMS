package com.myProjects.wow;

import java.util.Arrays;
import java.util.Stack;

public class Islands {

    public int islands(char[][] numbers) {

        int count = 0;
        for (int r = 0; r < numbers.length; r++) {
            for (int c = 0; c < numbers[r].length; c++) {
                if (numbers[r][c] == '1') {
                    count++;
                    DFSCalls(numbers, r, c);
                }

            }
        }
        return count;
    }

    public void DFSCalls(char[][] numbers, int r, int c) {
        if (r < 0 || r >= numbers.length || c < 0 || c >= numbers[r].length || numbers[r][c] == '0' || numbers[r][c] == '2') {
            return;
        } else {
            numbers[r][c] = '2';
            DFSCalls(numbers, r + 1, c);
            DFSCalls(numbers, r - 1, c);
            DFSCalls(numbers, r, c - 1);
            DFSCalls(numbers, r, c + 1);
        }
    }


    public static void main(String[] args) {
        Islands wow = new Islands();
        char[][] numbers = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(Arrays.deepToString(numbers));
        System.out.println(wow.islands(numbers));
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {

                Stack<char[][]> mystack = new Stack<char[][]>();
                mystack.add(new char[i][j]);

            }
        }
    }
}
