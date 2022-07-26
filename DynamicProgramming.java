package com.myProjects.wow;

import java.util.*;

public class DynamicProgramming {
    //fibonnaci series
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int x = fib(n - 1);
        int y = fib(n - 2);
        return x + y;
    }

    //frog jump
    public int frogJump(int[] arr) {
        int index = arr.length - 1;
        return frogJumpHelper(arr, index);
    }

    public int frogJumpHelper(int[] arr, int index) {
        if (index == 0) return 0;
        int left = Math.abs(arr[index] - arr[index - 1]) + frogJumpHelper(arr, index - 1);
        int right = Integer.MAX_VALUE;
        if (index > 1) {
            right = Math.abs(arr[index] - arr[index - 2]) + frogJumpHelper(arr, index - 2);
        }
        return Math.min(left, right);
    }

    public int frogJumpTabulation(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int left = Math.abs(arr[i] - arr[i - 1]) + dp[i - 1];
            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = Math.abs(arr[i] - arr[i - 2]) + dp[i - 2];
            }
            dp[i] = Math.min(left, right);
        }
        return dp[n - 1];
    }

    //house robber tabulation
    public int houseRobber(int[] arr) {
        int n = arr.length;
        int dp[] = new int[n + 1];
        dp[1] = arr[0];
        dp[0] = 0;
        int negative = 0;
        for (int i = 2; i < n + 1; i++) {
            int take = arr[i - 1] + dp[i - 2];
            //if(i>1){
            //  take+=dp[i-2];
            //  }
            int notTake = 0 + dp[i - 1];
            dp[i] = Math.max(take, notTake);
        }
        return dp[n];
    }

    public int[] swapA(int[] arr) {
        return swapArray(arr, 0);

    }

    public int[] swapB(int[] arr) {
        int i = 0;
        int n = arr.length;
        while (i < arr.length - 1 - i) {
            swap(arr[i], arr[n - 1 - i]);

            //int temp= arr[i];
            //arr[i]=arr[arr.length-1-i];
            //arr[arr.length-1-i]=temp;
            // System.out.println("//////////");
            //System.out.println(arr[i]);
            //System.out.println(arr[arr.length-1-i]);
            i++;
        }
        return arr;
    }

    public int[] swapArray(int[] arr, int i) {
        if (i >= arr.length - i - 1) {
            return arr;
        }
        int temp = arr[i];
        arr[i] = arr[arr.length - 1 - i];
        arr[arr.length - 1 - i] = temp;
        //swap(arr[i],arr[arr.length-1-i]);
        return swapArray(arr, i + 1);

    }

    public void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println(a);
        System.out.println(b);
    }

    public boolean IsPalindrome(String s, int i) {
        if (i >= s.length() - 1 - i) {
            return true;
        }
        if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
            return false;
        }
        return IsPalindrome(s, i + 1);
    }

    public int subsequencesWithSum(int[] arr, int target) {
        int index = 0;
        int sum = 0;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        return myList(arr, index, sum, target, result, temp);
        //return result;
    }

    public int myList(int[] arr, int index, int sum, int target, List<List<Integer>> result, List<Integer> temp) {
        if (index >= arr.length) {
            if (sum == target) {
                //result.add(new ArrayList<>(temp));
                return 1;
            }
            return 0;
        }
        temp.add(arr[index]);
        //sum+=arr[index];
        int x = myList(arr, index + 1, sum += arr[index], target, result, temp);

        temp.remove(temp.size() - 1);
        //sum-=arr[index];
        int y = myList(arr, index + 1, sum -= arr[index], target, result, temp);

        return x + y;
    }

    public List<List<Integer>> combinationSum1(int[] arr, int target) {
        if (arr.length == 0 || arr == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combinationSum1Helper1(arr, 0, target, result, temp);
        return result;
    }

    public void combinationSum1Helper(int[] arr, int index, int target, List<List<Integer>> result, List<Integer> temp) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (index >= arr.length) {
            return;
        }
        if (arr[index] > target) {
            return;
        }
        //temp.remove(temp.size()-1);


        // if(arr[index]<=target) {
        temp.add(arr[index]);
        combinationSum1Helper(arr, index, target - arr[index], result, temp);
        temp.remove(temp.size() - 1);
        // }
        combinationSum1Helper(arr, index + 1, target, result, temp);
    }

    public void combinationSum1Helper1(int[] arr, int index, int target, List<List<Integer>> result, List<Integer> temp) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0 || index > arr.length) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {

            temp.add(arr[index]);
            combinationSum1Helper(arr, index + 1, target - arr[index], result, temp);
            //temp.remove(temp.size()-1);

        }

    }

    public List<Integer> howSum(int[] arr, int target) {
        List<Integer> result = new ArrayList<>();
        if (target == 0) return new ArrayList<>();
        if (target < 0) return null;
        for (int num : arr) {
            int remainder = target - num;
            result = howSum(arr, remainder);
            if (result != null) {
                result.add(num);
            }
        }
        return result;
    }

    public List<List<Integer>> Combination(int[] arr, int target) {
        if (arr.length == 0 || arr == null) {
            return null;
        }
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        combinationSumII(arr, 0, temp, result, target);
        return result;
    }

    public void combinationSumII(int[] arr, int index, List<Integer> temp, List<List<Integer>> result, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (index >= arr.length) {
            return;
        }
        if (arr[index] <= target) {
            temp.add(arr[index]);
            combinationSumII(arr, index + 1, temp, result, target - arr[index]);
            temp.remove(temp.size() - 1);
        }
        combinationSumII(arr, index + 1, temp, result, target);


    }

    public List<List<Integer>> combinationSumII(int[] arr, int target) {
        if (arr.length == 0 || arr == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int start = 0;
        Arrays.sort(arr);
        combinationSumIIhelper(arr, target, start, temp, result);
        return result;
    }

    public void combinationSumIIhelper(int[] arr, int target, int index, List<Integer> temp, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }
            //if(arr[i]>target){
            // break;
            // }
            temp.add(arr[i]);
            combinationSumIIhelper(arr, target - arr[i], index + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    public List<Integer> subsetSum(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        subSetSumHelper(arr, 0, 0, result);
        return result;
    }

    public void subSetSumHelper(int[] arr, int index, int sum, List<Integer> result) {
        if (index >= arr.length) {
            result.add(sum);
            return;
        }
        subSetSumHelper(arr, index + 1, sum, result);
        subSetSumHelper(arr, index + 1, sum + arr[index], result);
    }

    public String messageDecrypter(String word) {
        // your code goes here
        //convert letter to ascii value
        if (word.length() == 0 || word == null) {
            return null;
        }

        int m = word.length();
        int[] arr = new int[m];
        int j = 0;
        //converting to ascii code.
        while (j < m) {
            char current = word.charAt(j);
            arr[j] = (int) current;
            j++;
        }
        System.out.println(Arrays.toString(arr));

        //second to last letter add value of the previous letter
        for (int i = 0; i < m; i++) {
            if (i == 0) {
                arr[i] += 1;
            } else {
                arr[i] += arr[i - 1];
            }
        }
        System.out.println(Arrays.toString(arr));
        //subtract 26 from every letter till its in the range of lowercase a to Z
        for (int i = 0; i < m; i++) {

            while (arr[i] > 122) {
                arr[i] -= 26;
            }
        }
        System.out.println(Arrays.toString(arr));
        //convert back to letters
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            char c = (char) arr[i];
            sb.append(c);
        }
        System.out.print(sb.toString());
        return sb.toString();
    }

    public List<List<Integer>> repeat(int[] arr) {

        if (arr.length == 0 || arr == null) {
            return null;
        }
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        repeatingSubsets(arr, result, temp, 0);
        return result;
    }

    public void repeatingSubsets(int[] arr, List<List<Integer>> result, List<Integer> temp, int index) {
        result.add(new ArrayList<>(temp));
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }
            temp.add(arr[i]);
            repeatingSubsets(arr, result, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public void repeatingSubsetsSet(int[] arr, List<List<Integer>> result, List<Integer> temp, int index) {

        result.add(new ArrayList<>(temp));
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }
            temp.add(arr[i]);
            repeatingSubsets(arr, result, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
        return;
    }

    public List<List<Integer>> printAllPermutations(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        printAllPermutationshelper(arr, result, visited, temp, 0);
        return result;
    }

    public void printAllPermutationshelper(int[] arr, List<List<Integer>> result, Set<Integer> visited, List<Integer> temp, int index) {
        //if(temp.size()==arr.length){
        if (visited.size() == arr.length && index >= arr.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            //if(visited.contains(arr[i])) {
            if (visited.contains(arr[i])) {
                continue;
            }
            temp.add(arr[i]);
            visited.add(arr[i]);
            printAllPermutationshelper(arr, result, visited, temp, index + 1);
            //printAllPermutationshelper(arr,result,visited,temp);
            visited.remove(temp.get(temp.size() - 1));
            temp.remove(temp.size() - 1);
        }

        return;
    }

    public List<List<Integer>> printPermutations(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            temp.add(arr[i]);
        }
        printPermutationsHelper(temp, result, 0);
        return result;
    }

    public void printPermutationsHelper(List<Integer> temp, List<List<Integer>> result, int index) {
        if (index == temp.size()) {
            result.add(new ArrayList<>(temp));
        }

        for (int i = index; i < temp.size(); i++) {
            //if(index==i){
            //continue;
            //}

            int list = temp.get(i);
            temp.set(i, temp.get(index));
            temp.set(index, list);
            printPermutationsHelper(temp, result, index + 1);
            list = temp.get(i);
            temp.set(i, temp.get(index));
            temp.set(index, list);

        }
    }

    public List<List<String>> nQueens(int n) {
        //nqueen n*n chess board fill
        //to carry final answer with all number of ways to fill
        List<List<String>> result = new ArrayList<>();
        String[][] board = new String[n][n];
        //time n2 space n2
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ".";
            }
        }
        int row = 0;
        nQueensHelper(row, result, board);
        return result;
    }

    public void nQueensHelper(int row, List<List<String>> result, String[][] board) {
        //SPACE auxilliary would be 0(n)
        //time n*n;
        if (row == board.length) {
            result.add(new ArrayList<>(convertToListString(board)));
            return;
        }
        for (int column = 0; column < board.length; column++) {
            if (possiblePlacement(board, row, column)) {
                board[row][column] = "Q";
                nQueensHelper(row + 1, result, board);
                board[row][column] = ".";
            }
        }
    }

    public boolean possiblePlacement(String[][] board, int row, int column) {
        int cr = row;
        int cc = column;
        //check column
        while (cr >= 0) {

            if (board[cr][cc] == "Q") {
                return false;
            }
            cr--;
        }
        //check diagnol up
        cr = row;
        while (cc >= 0 && cr >= 0) {

            if (board[cr][cc] == "Q") {
                return false;
            }
            cc--;
            cr--;
        }

        cr = row;
        cc = column;

        while (cc <= board.length - 1 && cr >= 0) {

            if (board[cr][cc] == "Q") {
                return false;
            }
            cc++;
            cr--;
        }
        return true;
    }

    public List<String> convertToListString(String[][] board) {
        List<String> temp = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            sb.append("{ ");
            for (int j = 0; j < board.length; j++) {
                sb.append(board[i][j] + " ");
            }
            sb.append(" }");
            if (i < board.length - 1) {
                sb.append(",");
            }
        }

        //sb.deleteCharAt(sb.length()-1);
        temp.add(sb.toString());
        return temp;
    }

    public List<List<Integer>> sudokuSolver(int[][] sudoku) {
        //try out all possible ways to get an answer.
        if (sudoku == null || sudoku.length == 0 || sudoku[0].length == 0 || sudoku == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        int row = 0;
        int column = 0;
        int length = sudoku.length;
        sudokuSolverHelper(sudoku, row, column, length, ans);
        /*sudokusolver(sudoku);
        for(int i = 0; i< sudoku.length; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j<sudoku[0].length; j++){
                temp.add(sudoku[i][j]);
            }
            ans.add(temp);
        }
*/
        return ans;
    }

    public boolean sudokuSolverHelper(int[][] sudoku, int row, int column, int length, List<List<Integer>> ans) {
        if (row == length) {

            //Arrays.deepToString(y);
            for (int i = 0; i < sudoku.length; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j<sudoku[0].length; j++) {
                    temp.add(sudoku[i][j]);
                }
                ans.add(temp);
            }
            return true;
        }
        if (sudoku[row][column] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (valid(sudoku, column, row, i)) {
                    sudoku[row][column] = i;
                    if (column != length - 1) {
                        if (sudokuSolverHelper(sudoku, row, column + 1, length, ans)) {
                            return true;
                        }
                    } else if (column == length - 1) {
                        if (sudokuSolverHelper(sudoku, row + 1, 0, length, ans)) {
                            return true;
                        }
                    }
                    sudoku[row][column] = 0;
                }
            }
            return false;
        } else {
            if (column!= length - 1) {
                if(sudokuSolverHelper(sudoku, row, column + 1, length, ans)){
                    return true;
                }
            } else{
                if(sudokuSolverHelper(sudoku, row + 1, 0, length, ans)){
                    return true;
                }
            }
        }
        return false;
     }

     public boolean valid(int[][]sudoku,int column,int row,int value){
        for(int i=0;i<9;i++){
          if(sudoku[row][i]==value)  {
              return false;
          }
          if(sudoku[i][column]==value)  {
                return false;
            }
          ///help with movement either columnwise or row wise;
          int nr=(3*(row/3))+i/3;
          int nc= (3*(column/3))+i%3;
          if(sudoku[nr][nc]==value){
              return false;
          }
        }
        return true;
     }
     public boolean sudokusolver(int[][] sudoku){
        for(int i=0; i<sudoku.length;i++){
            for(int j =0; j<sudoku[0].length; j++){
                if(sudoku[i][j]==0){
                    for(int k=1;k<=9;k++){
                        if(valid(sudoku,i,j,k)){
                            sudoku[i][j]=k;
                            if(sudokusolver(sudoku)==true){
                                return true;
                            }
                            sudoku[i][j]=0;
                        }

                    }
                    return false;

                }
            }

        }
        return true;
    }
    //undirected graph
    public Map<Integer, List<Integer>> edgesToGraphConverter(int[] []edges){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            int source = edges[i][0];
            int destination = edges[i][1];
            if(!graph.containsKey(source)){
                graph.put(source,new ArrayList<>());
            }
            if(!graph.containsKey(destination)){
                graph.put(destination,new ArrayList<>());
            }
            graph.get(source).add(destination);
            graph.get(destination).add(source);
        }
        //System.out.println(graph);
        return graph;
    }

    public boolean MColouring(int[][] edges, int m, int N){
        //N is the number of vertices;
        if(edges==null || edges.length==0 || edges[0].length!=2){
            return false;
        }
        Map<Integer, List<Integer>> graph =edgesToGraphConverter(edges);
        Map<Integer, Integer> colours = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for(Map.Entry<Integer,List<Integer>> entry:graph.entrySet()){
            int key= entry.getKey();
            if(!visited.contains(key)){
                if (MColouringHelper(colours,visited,key,graph,m)==false){
                    return false;
                }
            }

        }
        return true;
    }

    public boolean MColouringHelper(Map<Integer, Integer> colours,Set<Integer> visited,int source,Map<Integer, List<Integer>> graph,int m) {
        if (colours.size() == graph.size()) {
            return true;
        }

        if (!colours.containsKey(source)) {
            for (int i = 1; i <=m; i++) {
                if (safeToUse(i, graph,source,colours)) {
                    colours.put(source, i);

                    visited.add(source);
                    List<Integer> neighbourlist = graph.get(source);
                    for (int neighbour : neighbourlist) {

                            if (MColouringHelper(colours, visited, neighbour, graph, m) == true) {
                                return true;
                            }
                            colours.remove(neighbour);

                    }

                }
            }
            return false;
        }
        return false;
    }
    public boolean safeToUse(int colour, Map<Integer, List<Integer>> graph, int source,Map<Integer, Integer> colours){
        List<Integer> neighbour = graph.get(source);
        for (int neigh: neighbour){
            if(colours.containsKey(neigh) && colours.get(neigh)==colour){
                return false;
            }
        }
        return true;
    }
    public int indexEqualsValueSearch(int[] arr) {

        if(arr==null || arr.length==0){
            return -1;
        }
        int left =0;
        int right =arr.length-1;
        while(left<=right){

            int mid = (left +right)/2;
            if(arr[mid]==mid &&(mid==0 || arr[mid-1]-(mid-1)<0)){
            //if(arr[mid]==mid){
                return mid;
            }
            else if(mid>arr[mid]){
                left= mid +1;
            }
            else{
                right= mid-1;
            }
        }

        return -1;
    }
    public int summation (int a,int b){
        int d= a+b;
        int v= (d>1) ? d : -1;
        return v+5;
    }
    public List<String> ratInAMaze(int[][] arr){
        if(arr==null || arr.length==0 || arr[0].length==0){
            return null;
        }
        int m= 0;
        int n=0;
        StringBuilder sb  = new StringBuilder();
        List<String> result= new ArrayList<>();
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        ratInAMazeHelper(arr,0,0,visited,sb,result);
        return result;
    }
    public int ratInAMazeHelper(int[][] arr, int m, int n, boolean[][] visited, StringBuilder sb, List<String> result){


        if(m<0||m>=arr.length || n<0 || n>=arr[0].length || visited[m][n]==true || arr[m][n]==0 ){
            return 0;
       }

        if(m==arr.length-1 && n==arr[0].length-1){
           StringBuilder sr = new StringBuilder(sb);
           result.add(sb.toString());
           return 1;
        }
        visited[m][n]=true;
        System.out.println(m +","+n);
        int down = 0 + ratInAMazeHelper(arr, m + 1, n, visited,sb.append("d"),result);
        sb.deleteCharAt(sb.length()-1);
        int left = 0 + ratInAMazeHelper(arr, m, n - 1, visited,sb.append("l"),result);
        sb.deleteCharAt(sb.length()-1);
        int right = 0 + ratInAMazeHelper(arr, m, n + 1, visited,sb.append("r"),result);
        sb.deleteCharAt(sb.length()-1);
        int up = 0 + ratInAMazeHelper(arr, m - 1, n, visited,sb.append("u"), result);
        sb.deleteCharAt(sb.length()-1);
        visited[m][n] = false;
        return up+left+right+down;
    }

    public int getMaxValue(int input){
        int cur=0;
        int distance=-1;

        if (cur< 5){
            cur +=5;
        }
        else if(cur>5){
            cur-=5;
        }
        if(cur==5){
            distance +=20;
        }
        return distance;
    }
    public static void main(String[] args){
        DynamicProgramming dp = new DynamicProgramming();
        System.out.println(dp.fib(7));
        int[] arr ={10,20,50,40};
        System.out.println(dp.frogJump(arr));
        System.out.println(dp.frogJumpTabulation(arr));
        System.out.println(dp.houseRobber(arr));
        System.out.println(".....");
        System.out.println(Arrays.toString(dp.swapB(arr)));
        System.out.println(dp.IsPalindrome("TRVYT",0));
        int y= (int)1e6;
        int mod= (int)((10^9)+7);
        int[] arr1 ={1,2,2,2,5};
        int[] arr2 ={1,2,2,4};
        //System.out.println(dp.subsequencesWithSum(arr1,5));
        //System.out.println(dp.combinationSum1(arr1,7));
        System.out.println(dp.howSum(arr1,7));
       System.out.println(dp.Combination(arr2,4));
        System.out.println(dp.combinationSumII(arr2,4));
        System.out.println(dp.subsetSum(arr2));
        System.out.println(dp.messageDecrypter("crime"));
        int[] arr3 ={1,2,3};
        System.out.println(dp.repeat(arr3));
        System.out.println("");
        Set<List<Integer>> set = new HashSet<>();
        set.add(new ArrayList<>(Arrays.asList(2,4)));
        set.add(new ArrayList<>(Arrays.asList(2,4)));
        set.add(new ArrayList<>(Arrays.asList(4,2)));
        System.out.println(set);



        System.out.println(dp.printPermutations(arr3));
        //printPermutations(int[] arr)


        System.out.println((int)'c'-'a');
        String ywe = null;
        System.out.println(dp.nQueens(4));
        Set<Integer> visited =new HashSet<>();
        visited.add(5);
        System.out.print(visited);
        visited.remove(5);
        System.out.print(visited);
        Map<Integer,Integer> result = new HashMap<>();
        result.put(1,1);
        System.out.println(result);
        result.remove(1);
        System.out.println(result);
        int[][] sudoku = {{5,3,0,6,7,8,9,0,2},{6,7,2,1,9,5,3,4,8},{0,9,8,3,4,2,5,6,7},{8,5,9,7,6,1,4,2,3},{4,2,6,8,5,3,7,9,1},{7,1,3,9,0,4,8,0,6},{9,6,0,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},{3,4,5,2,8,6,1,7,9}};
       // int[][] sudoku1 ={};
        System.out.println(dp.sudokuSolver(sudoku));
        int[][] edges={{1,2},{2,3},{3,4},{4,1},{1,3}};
        System.out.print(dp.MColouring(edges,3,4));
        System.out.print(dp.MColouring(edges,3,4));
        int[] av = {0,1,2,3,4};
        System.out.println(dp.indexEqualsValueSearch(av));
        System.out.println(dp.summation(-5,-6));
        int [][] arr5 ={{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};

        System.out.println(dp.ratInAMaze(arr5));
        int[] wow = new int[]{2,4};



        //String A= "A";
        //String B= "B";
        //System.out.println(A.compareTo(B));
        //System.out.println(dp.getMaxValue(5));







    }
}
