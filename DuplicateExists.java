package com.myProjects.wow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class DuplicateExists {
    public boolean containsDuplicates(int [] nums){
        boolean duplicate= false;
        for (int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length; j++){
                if (nums[i]==nums[j]){
                    duplicate=true;
                }

            }
        }
        return duplicate;
    }

    public boolean containsDuplicates1(int [] nums){
        HashSet<Integer> wow =new HashSet<>();
        for (int i=0; i<nums.length; i++){
                if (wow.contains(nums[i])) return true;
                wow.add(nums[i]);
                }
            return false;
            }

    public boolean containsDuplicates2(int [] nums){
        Arrays.sort(nums);
        for (int i=0; i<nums.length-1; i++){
            if (nums[i]==nums[i+1]) return true;

        }
        return false;
    }




    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        DuplicateExists duplicates = new DuplicateExists();
        int[] nums ={1,4,6,6};
        System.out.println(duplicates.containsDuplicates2(nums));
        long endTime = System.currentTimeMillis();
        System.out.println(startTime +" " +endTime);

    }
}
