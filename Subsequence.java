package com.myProjects.wow;

import java.util.*;

public class Subsequence {
    //longest common subsequence
    public int longestSubsequence(String A, String B) {
        int y= A.length()-1;
        int x= B.length()-1;
        return longestSubsequencehelperOption2(A,B,y,x) ;
    }
    //front to back
    public int longestSubsequencehelper(String A, String B, int i, int j) {
        if(i>=A.length()||j>=B.length()) return 0;
        if(A.charAt(i)==B.charAt(j)) return 1 + longestSubsequencehelper(A, B, i+1, j+1);
        else return Math.max(longestSubsequencehelper(A, B, i+1, j), longestSubsequencehelper(A, B, i, j+1));
    }
    //back to forward
    //String A ="subt";
    //String B ="subt";
    public int longestSubsequencehelperOption2(String A, String B, int i, int j) {
        if(A.length()==0 || B.length()==0) return 0;
        if(i<0||j<0) return 0;
        if(A.charAt(i)==B.charAt(j)) return 1 + longestSubsequencehelperOption2(A, B, i-1, j-1);
        else return Math.max(longestSubsequencehelperOption2(A, B, i-1, j),longestSubsequencehelperOption2(A, B, i, j-1));
    }

    //dynamic programming  bottom up approach
    //time(m*n) space(m*n)
    public int longestSubsequence1(String A, String B) {
        int[][] dp = new int[A.length()][B.length()];
        for (int i = 0; i < dp.length; i++) {
        Arrays.fill(dp[i], 0);
    }
        for(int i=1; i<dp.length;i++){
            for(int j=1; j<dp[i].length; j++){

                if(A.charAt(i)==B.charAt(j)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[A.length()-1] [B.length()-1];
    }

    //climbing staircase
    //time (2 power n space:n) // if we memoize time = n , space = n)
    public int  climbingStairs(int  n){
        if(n==0) return 1;
        if (n<0) return 0;
        return climbingStairs(n-1)+climbingStairs(n-2);
    }

    //tabulation
    public int  climbingStairstab(int  n){
        int[] A = new int [n+1];
        Arrays.fill(A,0);
        for (int i=0; i<A.length; i++){
            if (i<=4){
                A[i]=n;
            }
            else{
                A[i]= A[i-1]+A[i-2];
            }
        }
        return A[n];
    }

    //to calculate using time 0(n) , space 0(1)
    public int  climbingStairstab1(int  n){
        int current=0;
        int prev=3;
        int secprev=2;
        if (n<4) return n;
        else{
            for (int i=4 ; i<=n;i++){
                current=secprev+prev;
                secprev=prev;
                prev=current;
            }
        }
        return current;
    }


     // to review not correct
    public String longestSubsequence2(String A, String B) {
        int[][] dp = new int[A.length()][B.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 0);
        }
        StringBuilder sb= new StringBuilder();
        for(int i=1; i<dp.length;i++){
            for(int j=1; j<dp[i].length; j++){

                if(A.charAt(i)==B.charAt(j)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                    sb.append(B.charAt(j));
                }
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        String y = sb.toString();
        return y;
    }

    //longest increasing subsequence
    public int longestIncreasing(int[] A){
        return longestincreasinghelper( A,0, 0);
    }
    public int longestincreasinghelper(int[] A, int i , int j){
        if(i>=A.length ||j>=A.length) return 0;
        if(A[i]>A[j]) return 1 + longestincreasinghelper(A, i+1,j+1);
        else return Math.max(longestincreasinghelper(A, i ,j+1),longestincreasinghelper(A, i+1 ,j));
    }
    //minimum edit distance
    public int minimumEditMemo(String A, String B){
        int minimum = Integer.MAX_VALUE;
        HashMap<String, Integer> memo = new HashMap<>();
        return minimumeditMemohelper(A, B, A.length()-1, B.length()-1,memo);
    }
    public int minimumeditMemohelper(String A, String B, int i, int j,HashMap<String, Integer> memo){
        if(i<0||j<0) return 0;
        if(A.length()==0) return B.length();
        if(B.length()==0) return A.length();
        String y =String.valueOf(A.charAt(i)) +","+(B.charAt(j));
        if(memo.containsKey(y)){
            return memo.get(y);
        }
        if(A.charAt(i)==B.charAt(j)) {
            memo.put(y, minimumeditMemohelper(A,B,i-1,j-1,memo));
            return memo.get(y);
        }
        else{
            memo.put(y, 1+ min(minimumeditMemohelper(A,B,i-1,j,memo),minimumeditMemohelper(A,B,i,j-1,memo),minimumeditMemohelper(A,B,i-1,j-1,memo)));
            return memo.get(y);
        }
    }
    public int min(int a, int b,int c){
        if(a<b && a<c){
            return a;
        }
        if (b<a && b<c){
            return b;
        }
        else{
            return c;
        }
    }

    //dynamic programming
    public int editdistancetab(String A, String B){
        int[][] dp = new int[A.length()+1][B.length()+1];
        for(int i=0; i<=A.length(); i++){
            for(int j=0; j<=B.length(); j++){

                if (i==0){
                    dp[i][j]=j;
                }

               else if (j==0){
                    dp[i][j]=i;
                }

              else if(A.charAt(i-1)==B.charAt(j-1)){
                  dp[i][j]=dp[i-1][j-1];
             }
                else{
                   dp[i][j]=1 + min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]);
                }
            }
        }
        return dp[A.length()][B.length()];

    }
    //calculate distinct subsequences
    //babbbag //bag
    public int totaldistinctSubsequences(String A, String B){
        return totaldistinctSubsequenceshelper(A,B,A.length()-1, B.length()-1);
    }
    public int totaldistinctSubsequenceshelper(String A,String B,int i, int j){


        //j has been found
        if(j<0) return 1;
        //not all j found

        if(i<0) return 0;
        if(A.charAt(i)==B.charAt(j)){
            return ((totaldistinctSubsequenceshelper(A,B,i-1,j-1))+ (totaldistinctSubsequenceshelper(A,B,i-1,j)));
        }
        else{
            return totaldistinctSubsequenceshelper(A,B,i-1,j);
        }
    }
    public int totalSubsequencetabulation(String A, String B) {
        int m = A.length();
        int n = B.length();

        int[][] dp = new int[m + 1][n + 1];

        for(int i=0 ;i<m;i++){
            Arrays.fill(dp[i],0);
        }

        for(int i=0; i<=m;i++){
            for(int j=0; j<=n; j++){

              if(j==0){
                   dp[i][j]=1;
              }

             else if(i==0){
                  dp[i][j]=0;
              }

             else if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j] + dp[i - 1][j - 1];
                }
             else{
                    dp[i][j] += dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    public int totalSubsequencetab2(String A, String B){
       // int[][] dp = new int[A.length()+1][B.length()+1];
        int[] prev = new int [A.length()+1];
        int[] cur = new int [A.length()+1];
        prev[0]=1;
        cur[0]=1;
        for(int i=1; i<=A.length();i++){
            for(int j=1; j<=B.length(); j++){
               if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    cur[j] = prev[j] + prev[j - 1];
                }
                else{
                    cur[j] = prev[j];
                }
            }
            prev= cur;
        }
        return cur[B.length()];
        //you just require the value of the previous row.
    }
    //1D optimization.
   public int tabulation1D(String A, String B){
        int[] prev = new int [B.length()+1];
        prev[0]=1;
        for(int i=1; i<=A.length();i++){
            for(int j=B.length(); j>=1; j--) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    prev[j] = prev[j] + prev[j - 1];
                }
            }
        }
        return prev[B.length()];

   }

   //print all subsequences in an array

    public List<List<Integer>> allSubsequences(int [] a){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        allSubsequenceshelper(a,0,temp,result);
        return result;
    }
    public void allSubsequenceshelper(int [] arr, int i, List<Integer> temp1,List<List<Integer>> result){
        if(i>=arr.length){
            List<Integer> view = new ArrayList<>(temp1);
            result.add(view);
            return;
        }
        temp1.add(arr[i]);
        allSubsequenceshelper(arr,i+1, temp1,result);
        temp1.remove(temp1.size()-1);
        allSubsequenceshelper(arr,i+1, temp1,result);

    }
    //bruteforce solution
    public List<Integer> longestPalindromicSubsequence(int[] arr) {
        //get all subsequences
        List<List<Integer>> res = allSubsequences(arr);
        List<Integer> pointer = null;

        for (int i = 0; i < res.size(); i++) {

            if (palindromic(res.get(i))) {

                if (pointer == null || res.get(i).size() > pointer.size()) {
                    pointer = res.get(i);
                }
            }
        }
        return pointer;
    }
        public boolean palindromic(List<Integer> current) {
            int left = 0;
            int right = current.size()-1;
            int mid = (left + right) / 2;
            if (current.size() % 2 == 0) {
                int k = mid;
                int j = mid + 1;

                while (k >= 0 && j < current.size()) {
                    if (current.get(k) != current.get(j)) {
                        return false;
                    }
                    k--;
                    j++;
                }

            } else {
                int k = mid - 1;
                int j = mid + 1;
                while (k >= 0 && j < current.size()) {
                    if (current.get(k) != current.get(j)) {
                        return false;
                    }
                    k--;
                    j++;
                }

            }
         return true;
        }

    public String printLongestSubsequence(String A, String B){
        StringBuilder sb = new StringBuilder();
        return printLongestSubsequencehelper(A, B,A.length()-1,B.length()-1,sb);
    }
     public String printLongestSubsequencehelper(String A, String B,int i, int j,StringBuilder sb){
        if(i<0||j<0) return sb.toString();
        if(A.length()==0 ||B.length()==0) return sb.toString();
        if(A.charAt(i)==B.charAt(j)){
            sb.insert(0,A.charAt(i));
            return (printLongestSubsequencehelper(A,  B, i-1,j-1,sb));
        }
        if (printLongestSubsequencehelper(A,  B, i-1,j,sb).length() > printLongestSubsequencehelper(A,  B, i,j-1,sb).length()){
            return printLongestSubsequencehelper(A,  B, i-1,j,sb);
        }
         return printLongestSubsequencehelper(A,  B, i,j-1,sb);
     }
     public String longestPalindromicSubsequence(String A){
        //String y = new StringBuilder(A).reverse().toString();
        //String y= "su";
        StringBuilder sb = new StringBuilder();
        //longestPalindromicSubsequencehelper(A,0,A.length()-1,sb);
        return sb.toString();
     }
     /*
     public String longestPalindromicSubsequencehelper(String A,int start,int end,int j,StringBuilder sb){
        if(i<0 ||j<0) return sb.toString();
        if(A.length()==0||y.length()==0) return sb.toString();
        if(A.charAt(i)==y.charAt(j)){
            sb.insert(0,A.charAt(i));
            return longestPalindromicSubsequencehelper(A,y,i-1,j-1,sb);
        }
       // StringBuilder t= longestPalindromicSubsequencehelper(A,y,i-1,j,sb);
       // StringBuilder s=longestPalindromicSubsequencehelper(A,y,i,j-1,sb);
        if(longestPalindromicSubsequencehelper(A,y,i-1,j,sb).length() > longestPalindromicSubsequencehelper(A,y,i,j-1,sb).length()){
            //return t;
            return longestPalindromicSubsequencehelper(A,y,i-1,j,sb);
        }
        //return s;
         return longestPalindromicSubsequencehelper(A,y,i,j-1,sb);

     }
*/
    public String longestPalindromicSubsequencememo(String A){
        //String y = new StringBuilder(A).reverse().toString();
        String y= "su";
        StringBuilder sb = new StringBuilder();
        Map<String, StringBuilder> memo = new HashMap<>();
        return longestPalindromicSubsequencehelpermemo(A,y,A.length()-1,y.length()-1,sb, memo).toString();
    }
    public StringBuilder longestPalindromicSubsequencehelpermemo(String A,String y,int i,int j,StringBuilder sb, Map<String,StringBuilder> memo){
        String z = String.valueOf(A.charAt(i))+ "," +String.valueOf(y.charAt(j));
        if(memo.containsKey(z)){
            return memo.get(z);
        }
        if(i<0 ||j<0) return sb;
        if(A.charAt(i)== y.charAt(j)){
            sb.insert(0,A.charAt(i));
            return longestPalindromicSubsequencehelpermemo(A,y,i-1,j-1,sb,memo);
        }
        StringBuilder t= longestPalindromicSubsequencehelpermemo(A,y,i-1,j,sb,memo);
        StringBuilder s=longestPalindromicSubsequencehelpermemo(A,y,i,j-1,sb,memo);
        if(t.toString().length() > s.toString().length()){
            memo.put(z,t);
            return memo.get(z);

        }
        else
        {
            memo.put(z, s);
            return memo.get(s);
        }
    }
    public String longestPalindrometab(String y) {
        String z = new StringBuilder().reverse().toString();
        int m = y.length();
        int n = z.length();
        //prev na current (m+n) time(m*n)// memoization also the same;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (y.charAt(i - 1) == z.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            if (y.charAt(i - 1) == z.charAt(j - 1)) {
                sb.insert(0, y.charAt(i-1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        return sb.toString();
    }



    public static void main(String[] args) {
        Subsequence c = new Subsequence();
        String A = "strubt";
        String J = "tburts";
        String B = "subt";
        String E = "stone";
        String D = "longest";
        String F = "bbbag";
        String G = "bag";
        System.out.println(c.longestSubsequence(A, B));
        int[] C = {9, 8, 7, 6, 5, 4};
        System.out.println(c.longestIncreasing(C));
        int f = 2;
        System.out.println(c.climbingStairstab(4));

        System.out.println(c.editdistancetab(A, B));
        System.out.println();
        System.out.println(c.totaldistinctSubsequences(F, G));

        System.out.println(c.tabulation1D(F, G));
        int[] a = {3, 2, 2, 5};
        System.out.println();
        System.out.println(c.allSubsequences(a));
        System.out.println();
        System.out.println(c.longestPalindromicSubsequence(a));
        StringBuilder sb = new StringBuilder();
        sb.insert(0, sb);

        System.out.println(c.printLongestSubsequence(A, J));

        String Y = "su";

        //System.out.println(c.longestPalindromicSubsequencememo(Y));
        System.out.println(c.longestPalindromicSubsequence(Y));
        // System.out.println(c.longestPalindrometab(Y));

    }

}
