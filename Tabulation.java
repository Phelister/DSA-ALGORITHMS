package com.myProjects.wow;

import java.lang.reflect.Array;
import java.util.*;

public class Tabulation {

   public int fib(int n){
       int []arr = new int[n+1];
       Arrays.fill(arr, 0);
       arr[0]=0;
       arr[1]=1;

       for (int i = 1; i < n ; i++) {
           arr[i] += arr[i-1];
           arr[i + 1] += arr[i-1];
           }
        arr[n]+= arr[n-1];

       return arr[n];

    }


    public int gridTraveller(int m, int n){
        int [][] arr = new int[m+1][n+1];
        for(int [] row : arr) {
            Arrays.fill(row, 0);// works for 1d arrays
        }
        arr[1][1]=1;
        for (int i =0 ; i< arr.length ;i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

        int top =0;
        int bottom = arr.length -1;
        int left =0;
        int right = arr[top].length-1;

        while (left<=right && top<=bottom) {

            if (left <= right && top < bottom) {
                for (int i = left; i < right; i++) {
                    arr[top + 1][i] += arr[top][i];
                    arr[top][i + 1] += arr[top][i];
                }
                arr[top + 1][right] += arr[top][right];
                top++;
                left =0;
            }
            if (top == bottom && left <= right) {
                for (int i = left; i < right; i++) {
                    arr[top][i + 1] += arr[top][i];
                }
                break;
            }

        }

        return arr[m][n];
    }

    public int gridTraveller1(int m, int n){
        int [][] arr = new int[m+1][n+1];
        for(int [] row : arr) {
            Arrays.fill(row, 0);// works for 1d arrays
        }
        arr[1][1]=1;
        for (int i =0 ; i< arr.length-1;i++) {
            for (int j = 0; j < arr[0].length-1; j++) {

                    arr[i][j + 1]+= arr[i][j];
                    arr[i+1][j] += arr[i][j];
            }
            arr[i + 1][arr[0].length-1] = arr[i][arr[0].length-1];
        }

        for (int i=0; i<arr.length-1; i++){
        arr[arr.length-1][i+1] += arr[arr.length-1][i];
        }

        
        return arr[m][n];
    }
    public boolean  canSum (int target,int[] numbers) {
        Boolean[] arr = new Boolean[target + 1];
        System.out.println(Arrays.toString(arr));
        Arrays.fill(arr, false);
        System.out.println(Arrays.toString(arr));
        arr[0] = true;
        System.out.println(Arrays.toString(arr));
        //NUMBERS: {7,2,3,4};
        //ARR:{T,F,T,T,T,F,F,T}


        for (int i = 0; i <= arr.length - 1; i++) {
                for (int j = 0; j < numbers.length ; j++) {
                    if (arr[i] == true && i + (numbers[j]) <= arr.length-1) {
                        arr[i + (numbers[j])] = true;
                    }
                }

            }

        return arr[target];
    }



    public List<Integer> howSum(int targetSum, int[] numbers){
       List<Integer> myList = new ArrayList<>();
       List[] arr = new List[targetSum+1];
       Arrays.fill(arr, null);
       arr[0] = new ArrayList(){};
       System.out.println(Arrays.toString(arr));
       for(int i=0; i< arr.length; i++){
           for (int j=0; j< numbers.length; j++){
               if (arr[i]!=null  && i+numbers[j]<= arr.length-1){
                   List<Integer> l = new ArrayList<>(arr[i]);
                   l.add(numbers[j]);
                   arr[i + numbers[j]]=l;
               }
           }
       }
        System.out.println(Arrays.toString(arr));
       return arr[targetSum];
    }
    public List<Integer> bestSum(int targetSum, int[] numbers){
      List[] arr = new List[targetSum+1];
      //List<Integer> shortest = null;
      Arrays.fill(arr, null);
      arr[0] = new ArrayList<>();
      for (int i=0 ; i< arr.length; i++){
          for(int j=0; j<numbers.length; j++){
              if (arr[i]!=null && i+numbers[j] < arr.length){
                  if (arr[i+numbers[j]]==null) {
                      List<Integer> myList = new ArrayList<>(arr[i]);
                      myList.add(numbers[j]);
                      arr[i + numbers[j]] = myList;
                  }
                  if (arr[i+numbers[j]]!=null){
                      List<Integer> myList = new ArrayList<>(arr[i]);
                      myList.add(numbers[j]);
                      if ( myList.size() < arr[i+numbers[j]].size()){
                          arr[i+numbers[j]]=myList;
                      }
                  }
                  }
              }
          }
      return arr[targetSum];
      }

      public boolean canConstruct(String target, String[] wordlist) {
          boolean[] arr = new boolean[target.length() + 1];
          Arrays.fill(arr, false);
          arr[0] = true;
          for (int i = 0; i < arr.length; i++) {
              for (int j = 0; j < wordlist.length; j++) {
                  //String[] myString1 = new String[]{"ab", "abc", "cd", "def", "abc"};

                  //false statement //if (arr[i] == true && target.substring(i, i + wordlist[j].length()) == "wordlist[j]") {
                  if (arr[i] == true && target.startsWith(wordlist[j],i)) {
                      // strarts with word at 0 offset increasingly
                      arr[i + wordlist[j].length()] = true;
                  }
              }
          }
          System.out.println(Arrays.toString(arr));
          return arr[target.length()];
      }
     public int countConstruct(String target, String[] wordlist) {
         List<Integer> arr = new ArrayList<>();
         for (int i = 0; i < target.length() +1; i++) {
             arr.add(i, 0);

         }
         System.out.println(arr);
         //set index 0 to 1 replace everything at zero to one
         arr.set(0, 1);
         System.out.println(arr);
         for (int i = 0; i < arr.size(); i++) {
             for (int j = 0; j < wordlist.length; j++) {
                 if (target.indexOf(wordlist[j])==0) {
                 //if (target.indexOf(wordlist[j]) ==i){
                     int currentposition = i + wordlist[j].length();
                     arr.set(currentposition, arr.get(i) + arr.get(currentposition));
                 }
             }
         }
         System.out.println(arr);
         return arr.get(target.length());
     }

     public List<List<String>> allConstruct (String target, String[]wordBank){

         List[] dp = new List[target.length() + 1];

         for (int i = 1; i < dp.length; i++) {
             dp[i] = new ArrayList();
         }

         dp[0] = new ArrayList<>(Arrays.asList(new ArrayList<>()));
         int size = dp.length;
         for (int i = 0; i < size; i++) {
             for (String word : wordBank) {
                 if (target.indexOf(word)==0){
                     //String suffix = target.substring(word.length());
                     int next =i+word.length();
                     dp[next].addAll(dp[i]);
                     for(int j=0; j<dp[i].size(); j++){
                         dp[next].add(dp[i].get(j));
                     }
                 }
             }
         }
         return dp[target.length()];
         /*p*/


     }


    public static void main (String[] args){
        Tabulation tab = new Tabulation();
       // System.out.println(tab.fib(50));
        //System.out.println(tab.gridTraveller1(3,3));
        int []arr= new int[]{1,3,4,7};
        String[] myString1 = new String[]{"ab", "abc", "cd", "def", "abc"};
        String[] myString3 = new String[]{"purp", "p", "ur", "le", "purpl"};
        System.out.println(tab.bestSum(7,arr));
        System.out.println(tab.countConstruct("purple",myString3));
        System.out.println(tab.countConstruct("abcdef",myString1));

        System.out.println(tab.allConstruct("purple",myString3));
        List<Integer> vuzi = new ArrayList<>();
        String S= null;
        Map<Integer, List<Integer>> list = new HashMap<>();
        list.entrySet();
        list.put(1, new ArrayList<>(Arrays.asList(5,3)));
        if(list.containsKey(1)){
            list.get(1).add(8);
        }
        for(Map.Entry<Integer,List<Integer>> entry:list.entrySet()){
            System.out.println(entry.getValue());
        }

    }
}
