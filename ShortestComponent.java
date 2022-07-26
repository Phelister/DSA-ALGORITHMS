package com.myProjects.wow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestComponent {

    public int ShortestMatrixComponent(int[][] matrix) {
        //using dfs

       int shortest = (int) Double.POSITIVE_INFINITY;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) ;
                int mysize = ShortestMatrixComponentHelper(matrix, i, j);
                if (mysize>0 && mysize < shortest) {
                    shortest = mysize;
                }
            }
        }
        return shortest;
    }

    public int ShortestMatrixComponentHelper(int[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length || matrix[i][j] == 0 || matrix[i][j] == 2) return 0;
        int size = 1;
        matrix[i][j] = 2;
        size += ShortestMatrixComponentHelper(matrix, i - 1, j);
        size += ShortestMatrixComponentHelper(matrix, i + 1, j);
        size += ShortestMatrixComponentHelper(matrix, i, j - 1);
        size += ShortestMatrixComponentHelper(matrix, i, j + 1);
        return size;
    }

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
        ShortestComponent wow = new ShortestComponent();
        int[][] numbers = {{1, 1, 0, 1, 1}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}};
      // int[][] matrix = { {1,1,0,0,0},{1,1,0,0,0}, {0,0,1,0,0},{0,0,0,1,1} };
        System.out.println(Arrays.deepToString(numbers));
        System.out.println(wow.ShortestMatrixComponent(numbers));
        //System.out.println(wow.islands(numbers));
    }

    Queue<Integer> que = new ArrayDeque<>();
    Queue<Integer> quel = new LinkedList<>();

}


