package com.myProjects.wow;

public class binarySearch2 {

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        if (nums.length == 0) {
            return -1;
        }
        while(left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;

            } else if (nums[mid] < target) {
                left = mid + 1;

            }
        }
        return -1;
    }

        public static void main (String[]args){
                binarySearch2 wow = new binarySearch2();
                System.out.println(wow.binarySearch(new int[]{1,2,3,4,6,7,8}, 4));
            }

    }


