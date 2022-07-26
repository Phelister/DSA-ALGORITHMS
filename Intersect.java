package com.myProjects.wow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Intersect {
 // solution 1
    public int[] intersecting(int [] nums1, int [] nums2){
    int[] longest =nums1.length > nums2.length ? nums1:nums2;
    int[] shortest =nums1.length > nums2.length ? nums2:nums1;
    List<Integer> result =new ArrayList<>() ;
    for (int a:shortest){
        for(int i=0; i<longest.length; i++){
            if (longest[i]==a){
                result.add(longest[i]);
                //set to -1
                longest[i]=-1;
                break;
            }
        }
    }
    // for converting array list to a straight forward array
    int []r =new int[result.size()];
    for(int i=0; i< result.size(); i++){
        r[i]=result.get(i);
    }
    return r;
}
    public static void main(String[] args) {
        //initialize the class
        Intersect adding = new Intersect();
        //objectize the method outside the main class
        int[] result= adding.intersecting(new int[]{9,9,9}, new int[]{9,6,9});
        //System.out.print("{");
        for(int r:result){
            System.out.print(r +"");
        }
        System.out.println();

    }
    //solution 2
    public int[] intersecting2(int [] nums1, int [] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 =0;
        int index2 =0;
        List<Integer> result =new ArrayList<>() ;

        while(index1<nums1.length && index2<nums2.length){
            int val1=nums1[index1];
            int val2=nums2[index2];
            if(val1==val2){
                result.add(val1);
                index1++;
                index2++;
            } else if (val1<val2){
                index1++;
            } else{
                index2++;
            }
        }
        // for converting array list to a straight forward array
        int []r =new int[result.size()];
        for(int i=0; i< result.size(); i++){
            r[i]=result.get(i);
        }
        return r;
    }




}
