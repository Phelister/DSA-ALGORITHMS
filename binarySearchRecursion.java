package com.myProjects.wow;

public class binarySearchRecursion {

    static int[] wow;
    int[]X;


    public static int Recursive(int[] wow, int X){
        int left = 0;
        int right = wow.length-1;

        for (int i = 0; i < wow.length; i++) {

            if (left>right){
                RecursiveSearch(wow,left,right,X);
            }
            else
                return -1;
        }
        return RecursiveSearch(wow,left,right,X);
    }

    public static int RecursiveSearch(int[] wow, int left, int right, int X){

        int mid =(left+right)/2;

        if(left==right){
            if(wow[left]==X){
                return left;
            }
            return -1;
        }
        {
            if (wow[mid] == X) {
                return mid;
            }
        }
        {
                if (wow[mid] < X) {
                    return RecursiveSearch(wow, mid + 1, right, X);
                }
        }
        {
                    return RecursiveSearch(wow,left,mid-1,X);
        }

            }

    public static void main(String[] args)
    {
        binarySearchRecursion Search = new binarySearchRecursion();
        wow = new int[]{1, 2, 5, 7, 8, 11};
        System.out.println(Recursive(wow,7));
    }
    }

