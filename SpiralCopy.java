package com.myProjects.wow;

import java.util.*;
import java.lang.*;

public class SpiralCopy {

    public List<Integer> spiralCopy (int[][] inputMatrix) {
        List<Integer> inputs = new ArrayList<>();
        int top = 0;
        int bottom = inputMatrix.length - 1;
        int left = 0;
        int right = inputMatrix[0].length - 1;

        while (top <= bottom && left <= right) {


            for (int i = left; i <= right; i++) {
                inputs.add(inputMatrix[top][i]);
            }

            top++;


            for (int i = top; i <= bottom; i++) {
                inputs.add(inputMatrix[i][right]);
            }

            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    inputs.add(inputMatrix[bottom][i]);
                }
                bottom--;
           }


            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    inputs.add(inputMatrix[i][left]);
                }
                left++;
            }

        }
        int[] result = new int[inputs.size()];
        for(int i=0;i<inputs.size(); i++){
            result[i]=inputs.get(i);
        }
        System.out.println(Arrays.toString(result));

            return inputs;

}



        public static void main(String[] args ){
        SpiralCopy spiral = new SpiralCopy();

        int[][] mat ={{1,2,3},{4,5,6},{7,8,9}};
        //int[][] mat ={{1,2,3}};
        StringBuilder sb= new StringBuilder();



        Map<Character, Integer > myMap = new HashMap<>();
           // myMap.getOrDefault();
        System.out.print(spiral.spiralCopy(mat));
    }
}
