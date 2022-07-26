package com.myProjects.wow;

import java.util.*;
import java.util.LinkedList;


public class Memoization {
    // the best
    public long fibonnaciSeries2(long n,Map<Long,Long> dict){

        if (n<=2) return 1;
        if (dict.containsKey(n)) {
            return dict.get(n);
        }
        if (dict==null){
            dict =new HashMap<>();
        }
        dict.put(n,fibonnaciSeries2(n-1,dict) + fibonnaciSeries2(n-2, dict));
        return dict.get(n);
    }


    public long gridTraveller(int m,int n, Map<String,Long> newMemo){
        String key = Integer.toString(m)+","+ Integer.toString(n);
        if (m==1 && n==1) return 1;
        if (m==0 || n==0) return 0;
        if (newMemo.containsKey(key)) {
            return newMemo.get(key);
        }

        newMemo.put(key, gridTraveller(m-1,n,newMemo) + gridTraveller(m,n-1,newMemo));
        return newMemo.get(key);
    }

    public long gridTraveller1(int m,int n) {
        Map<String, Long> newMemo = new HashMap<>();
        return gridTraveller2(m, n, newMemo);

    }

    public long gridTraveller2(int m,int n,Map<String, Long> newMemo){
        String key = Integer.toString(m)+","+ Integer.toString(n);
        if (m==1 && n==1) return 1;
        if (m==0 || n==0) return 0;
        if (newMemo.containsKey(key)) {
            return newMemo.get(key);
        }
        newMemo.put(key, gridTraveller(m-1,n,newMemo) + gridTraveller(m,n-1,newMemo));
        return newMemo.get(key);
    }

    //normal brute force of can sum
    public boolean canSum (int targetSum, int[] values){
        if (targetSum==0) return true;
        if (targetSum<0) return false;
        for (int num : values){
            int remainder=targetSum-num;
            if (canSum(remainder,values)==true){
                return true;
            }
        }
        return false;
    }
    public boolean canSum1 (int targetSum, int[] values, Map<Integer, Boolean> myMemoz){

        if (targetSum==0) return true;
        if (targetSum<0) return false;
        if (myMemoz.containsKey(targetSum)) {
            myMemoz.get(targetSum);
        }
        for (int num : values){
            int remainder=targetSum-num;
            if (canSum(remainder,values)==true){
                myMemoz.put(targetSum,true);
                //return true;
                return myMemoz.get(targetSum);
            }
        }
        myMemoz.put(targetSum,false);
       return myMemoz.get(targetSum);
       // return false;
    }

    public List<Integer> howSum(int targetSum, int[] values){
        List<Integer> myList = new ArrayList<>();
        if(targetSum==0) return myList;
        if (targetSum<0) return null;
        for (int num : values){
            int remainder=targetSum-num;
            myList = howSum(remainder,values);

            if(myList!=null){
                myList.add(num);
                return myList;
            }

        }
        return null;
    }
    public List<List<Integer>> howSum4(int targetSum, int[] values){
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int start=0;
        howSum5(targetSum,values,temp,result,start);
        return result;
    }
    public boolean howSum5(int targetSum, int[] values,List<Integer> temp, List<List<Integer>> result, int start){
        if(targetSum==0) {

                //result.add(new ArrayList<Integer>(temp));
                //result = new ArrayLis99oooooooooooooooooooooooooop\\\\\\\\\\\\\\\t<>(temp);
                result.add(new ArrayList<>(temp));

           return true;
        }
        if (targetSum<0 || start> values.length) {
            return false;
        }
        //for (int i=start; i<values.length; i++){
            temp.add(values[start]);
            int remainder=targetSum-values[start];
            howSum5(remainder,values,temp, result,start++);
            temp.remove(temp.size()-1);
       // }
        return true;
    }

    public List<Integer> howSum1(int targetSum, int[] values,Map<Integer,List> newMemo){
        List<Integer> myList = new ArrayList<>();
        if (newMemo.containsKey(targetSum)) {
            newMemo.get(targetSum);
        }
        if (targetSum==0) return myList;
        if (targetSum<0) return null;
        for (int num : values){
            int remainder=targetSum-num;
            myList = howSum1(remainder,values,newMemo);
            if(myList!=null){
                myList.add(num);
                newMemo.put(targetSum,myList);
                return newMemo.get(targetSum);
            }
        }
        newMemo.put(targetSum, null);
        return newMemo.get(targetSum);
    }


    public List<Integer> bestSum(int targetSum, int[] values){
        //List<Integer> myList = new ArrayList<>();
        if (targetSum==0) return new ArrayList<>();
        if (targetSum<0) return null;
        List<Integer> shortestPath= null;
        for (int num : values){
            int remainder=targetSum-num;
            List<Integer> myList = bestSum(remainder,values);
            if(myList!=null){
                myList.add(num);
               if (shortestPath==null || myList.size()<shortestPath.size()) {
                   shortestPath =myList;
               }
            }
        }
        return shortestPath;
    }

    public List<Integer> bestSum1(int targetSum, int[] values,Map<Integer,List> memoObject){
        List<Integer> myList = new ArrayList<>();
        if (targetSum==0) return myList;
        if (targetSum<0) return null;
        if (memoObject.containsKey(targetSum)){
           return memoObject.get(targetSum);
        }
        List<Integer> shortestPath= null;
        for (int num : values){
            int remainder=targetSum-num;
            myList = bestSum1(remainder,values,memoObject);
            if(myList!=null){
                List<Integer> tempCombination = new ArrayList<>(myList);
                tempCombination.add(num);
                //myList.add(num);
                if (shortestPath==null || tempCombination.size() < shortestPath.size()) {
                    shortestPath =tempCombination;
                    //shortestPath =myList;
                }
            }
        }
        memoObject.put(targetSum,shortestPath);
        return memoObject.get(targetSum);
    }

    public boolean canConstruct(String target, String[] wordlength){
        if (target == "") return true;
        for(String word : wordlength){
            if (target.indexOf(word)==0){
                String newString = target.substring(word.length());
                if (canConstruct(newString,wordlength) ==true){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean canConstruct1(String target, String[] wordlength,Map<String,Boolean> memo){
        if (target == "") return true;
        if (memo.containsKey(target)){
            return memo.get(target);
        }
        for(String word : wordlength){
            if (target.indexOf(word)==0){
                String newString = target.substring(word.length());
                if (canConstruct1(newString,wordlength,memo) ==true){
                   memo.put(target, true);
                    return memo.get(target);
                }
            }
        }
        memo.put(target, false);
        return memo.get(target);
    }

    public int countConstruct(String target, String[] wordlength){
        int size =0;
        if (target == "") return 1;
        for (String word : wordlength){
          if(target.indexOf(word)==0){
              String slice = target.substring(word.length());
              size+=countConstruct(slice, wordlength);
          }
        }
        return size;
    }
    public int CountConstruct1(String target, String[] wordlist, Map<String, Integer> memo){
        if (target== "") return 1;
        if (memo.containsKey(target)){
            return memo.get(target);
        }
        int size=0;
        for (String word : wordlist){
            if (target.indexOf(word)==0){
                String slice = target.substring(word.length());
                int value= CountConstruct1(slice, wordlist,memo);
             size+=value;
            }
        }
        memo.put(target,size);
        return memo.get(target);
    }

    public ArrayList<ArrayList<String>> allConstruct(String target, String[] wordList) {

       ArrayList<ArrayList<String>> myList = new ArrayList<>();
      if (target == "")  return new ArrayList<>(Arrays.asList(new ArrayList<>()));
        ArrayList<ArrayList<String>> suffixWays = null;
        ArrayList<ArrayList<String>> targetWays = null;
        for (String word : wordList) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                suffixWays = allConstruct(suffix, wordList);
                targetWays = new ArrayList<>();
                //ArrayList<ArrayList<String>> targetWays = new ArrayList<ArrayList<String>>();
                for (int i = 0; i < suffixWays.size(); i++) {
                   // ArrayList<String> tmp = new ArrayList<>(suffixWays.get(i));
                    ArrayList<String> tmp = suffixWays.get(i);
                    tmp.add(0, word);
                    targetWays.add(tmp);
                }
                for (int i = 0; i < targetWays.size(); i++) {
                    //myList.add(new ArrayList<>(targetWays.get(i)));
                    myList.add(targetWays.get(i));
                }
            }

        }
        return myList;
    }

    public List<List<String>> allConstructtest(String target, String[] wordList) {

        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        allConstructtesthelper(target, wordList, result,temp);
        return result;
    }

    public boolean allConstructtesthelper(String target, String[] wordList, List<List<String>> result, List<String> temp) {
                if (target == "") {
                    result.add(new ArrayList<>(temp));
                    return true;
                }

                for (String word : wordList) {
                    if (target.indexOf(word) == 0) {
                        temp.add(word);
                        String suffix = target.substring(word.length());
                        allConstructtesthelper(suffix, wordList,result,temp);
                        temp.remove(temp.size()-1);
                    }

        }
        return false;
    }


    public ArrayList<ArrayList<String>> allConstruct1(String target, String[] wordList,Map<String, ArrayList<ArrayList<String>>> memo) {

        ArrayList<ArrayList<String>> myList = new ArrayList<>();
        if (target == "")  return new ArrayList<>(Arrays.asList(new ArrayList<>()));
        if (memo.containsKey(target)){
            return memo.get(target);
        }
        ArrayList<ArrayList<String>> suffixWays = null;
        ArrayList<ArrayList<String>> targetWays = null;
        for (String word : wordList) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                suffixWays = allConstruct1(suffix, wordList, memo);
                targetWays = new ArrayList<>();
                //ArrayList<ArrayList<String>> targetWays = new ArrayList<ArrayList<String>>();
                for (int i = 0; i < suffixWays.size(); i++) {
                    ArrayList<String> tmp = new ArrayList<>(suffixWays.get(i));
                    tmp.add(0, word);
                    targetWays.add(tmp);
                }
                for (int i = 0; i < targetWays.size(); i++) {
                    myList.add(new ArrayList<>(targetWays.get(i)));
                }
            }

        }
        memo.put(target,myList);
        return memo.get(target);
    }





    public static void main (String[] args){

       Memoization memo = new Memoization();
        Map<Integer, List> dict = new HashMap<>();
        Map<String, ArrayList<ArrayList<String>>> temp = new HashMap<>();
        int[] myarr = new int[]{45,89,2,2,1,2,5,7,25};
        System.out.println(memo.howSum(7,myarr));
        String[] myString = new String[]{"bo", "rd", "ate", "t", "ska"};
        String[] myString1 = new String[]{"ab", "abc", "cd", "def", "abc"};
        String[] myString2 = new String[]{"eeeeeee", "eeeeeeeeee", "eeeeee", "eeee", "ee", "eeeeeeeeeee", "eeeeeee", "e",};
        String[] myString3 = new String[]{"purp", "le", "p", "ur", "le", "purpl"};
        //System.out.println(memo.bestSum1(100,myarr,dict));
       // System.out.println(memo.allConstruct1("purple",myString3, temp));
        //Collections.sort(myarr(a,b))
        System.out.println();
        System.out.println();
        String[] myString5 = new String[]{};
        System.out.println(memo.allConstructtest("purple",myString5));
        System.out.println();
        System.out.println();


        //System.out.println(memo.CountConstruct1("abcdef",myString, dict));

      //System.out.println(memo.CountConstruct1("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",myString2,dict));
        System.out.println("lul ");
      Map<Integer, Boolean> newMemo = new HashMap<>();
        int[] numbers = new int[]{7,4};
        System.out.print(memo.canSum1(15,numbers,newMemo));
        System.out.println("lul ");
        //System.out.print(memo.fibonnaciSeries2(70,dict));
       System.out.println(memo.gridTraveller1(3,3));
        String a ="ladybee";
        System.out.print(a.indexOf('l'));
        //System.out.print(a.charAt());
        Map<Integer, String> val =null;
        Vector<Integer> strp = new Vector<Integer>();
        System.out.print(a.contains("dyb"));
        System.out.println((int)(Math.sqrt(100)*100));
        int[] myarr1 = new int[]{2,2,1,2,5,7,25};
        System.out.println(memo.bestSum(7,myarr1));
        List<Integer> temp1 = new LinkedList<>();
            List<List<Integer>> temp2 = new ArrayList<>();
            temp2.add(new LinkedList<>(temp1));
           boolean flag =true;
           flag=!flag;
           int sum=0;
           sum+=sum;

           System.out.print(flag);
           Set<Integer> visited = new HashSet<>();
           visited.removeAll(visited);


    }

//not so efficient
    public long fibonnaciSeries(long n){
        Map<Long,Long> newMemo =new HashMap<>();
        if (n<=2) return 1;
        if (newMemo.containsKey(n)) {
            return newMemo.get(n);
        }

        newMemo.put(n,fibonnaciSeries(n-1) + fibonnaciSeries(n-2));
        return newMemo.get(n);
    }

}
