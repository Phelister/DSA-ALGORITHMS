package com.myProjects.wow;

import java.lang.reflect.Array;
import java.util.*;
import java.util.LinkedList;

public class solutions {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        int firstPointer =0;
        int secondPointer =0;
        int start=0;
        int end =0;
         if(firstList.length ==0 || secondList.length ==0) return new int[][]{};
        List<int[]> results = new ArrayList<>();

        while (firstPointer < firstList.length && secondPointer<secondList.length){

            start=Math.max(firstList[firstPointer][0],secondList[secondPointer][0]);
            end=Math.min(firstList[firstPointer][1],secondList[secondPointer][1]);

            if(start<=end){
                results.add(new int[]{start,end});
            }

            if(firstList[firstPointer][1]<secondList[secondPointer][1]){
                firstPointer++;
            }
            else{
                secondPointer++;
            }
        }

        int[][] values = new int[results.size()][2];
        for(int i=0; i<results.size(); i++){
            values[i]= results.get(i);
        }
        Arrays.sort(values,(a,b)->a[0]-b[0]);//sort in ascending order;
        return results.toArray(new int [results.size()][2]);

    }


    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0 || intervals[0].length ==0 ) return 0;
        int counter =0;
        int[] current = intervals[0];
        //sort the Array
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        System.out.println(Arrays.deepToString(intervals));
        for (int i =1; i< intervals.length; i++){
            //less than and equal to is the issue;
            if (current[1]>intervals[i][0]){
                counter++;
                if (current[1]>intervals [i][1]){
                    current =intervals[i];
                }
            }
            else{
                current =intervals[i];
            }
        }
        return counter;

    }
    public int meetingRoomsII(int [][] data){
        if (data.length==0 || data[0].length ==0){
            return 0;
        }
        //array is not sorted so sorting is very important;// sort by starting character in ascending  order
        //Arrays.sort(data,(a,b)->a[0]-b[0]);
        Arrays.sort(data,(a,b)->Integer.compare(a[0],b[0]));
        System.out.println(Arrays.deepToString(data));
        int meetingRoom=0;

        int[]previous = data[0];
        if (previous.length>0){
            meetingRoom = 1;
        }
        for(int i=1; i<data.length; i++){

           if(previous[1]>data[i][0]){
               meetingRoom++;
               if(previous[1]>data[i][1]){
                   previous=data[i];
               }
           }
           else{
               previous=data[i];
           }
        }
        return meetingRoom;
    }

    public boolean validateIPaddress(String ip){
        if(ip.length()==0) return false;
        String[] values = ip.split("\\.");
        System.out.print(Arrays.toString(values));
        if(values.length!=4) return false;
        for (String value :values){
            if (value.length()==0) return false;
            for(int i=0; i<value.length(); i++) {
            //if (value[i] > '9' || value[i] < 0) {

            //}
           // if(value.length()>1 && ){

            }
        }
       // }
     return true;
    }
    static boolean validateIP(String ip) {

        if(ip.length()==0) return false;
        int i=0;
        int count=0;
        StringBuilder sb = new StringBuilder();
        while(i<ip.length()){
            while(i<ip.length() && ip.charAt(i)!='.'){
                if(Character.isDigit(ip.charAt(i))){
                    sb.append(ip.charAt(i));
                    i++;
                }
                else{
                    return false;
                }
            }
            count++;
            if(sb.length()==0) return false;
            if(sb.length()>2 && ip.charAt(0)=='0'){
                return false;
            }
            Integer myValue = Integer.valueOf(sb.toString());
            if(myValue < 0 || myValue > 255){
                return false;
            }
            sb= new StringBuilder();
            i++;
        }
        if (count!=4) return false;
        return true;
    }


    public Map<String, Integer> wordCountEngine(String document) {
        // your code goes here
        // separate by dot or space

      // if(document.length()==0) return new String[0][0];

        int i=0;
        Map<String, Integer> temp = new HashMap();
        StringBuilder sb = new StringBuilder();

        while (i<document.length()){

            //while(i<document.length() && document.charAt(i)!=' ' && document.charAt(i)!='.' && document.charAt(i)!='!') {
                while(i<document.length() && document.charAt(i)!=' ') {
                    //practice makes perfect Practice
                if(Character.isLetter(document.charAt(i))){
                    if(Character.isUpperCase(document.charAt(i))){
                        sb.append(Character.toLowerCase(document.charAt(i)));
                        i++;
                    }
                    else {
                        sb.append(document.charAt(i));
                        i++;
                    }
                }
                i++;
            }

            System.out.println(sb.toString());
            if(sb.length()>0) {
                if (temp.containsKey(sb.toString())) {
                    temp.put(sb.toString(), temp.get(sb.toString() + 1));
                    i++;
                } else {
                    temp.put(sb.toString(), 1);
                    i++;
                }
                i++;
            }
            else {
                i++;
            }
            sb = new StringBuilder();
        }
    //System.out.println(temp);
    //int count = 0;
    //String[][] result = new String[temp.size()][2];
    //for(Map.Entry<String,Integer> entry : temp.entrySet()){
       // result[count][0] = entry.getKey();
       //result[count][1] = Integer.toString(entry.getValue());
      //  count++;
    //}
    return temp;
}

    public int getNumberOfIslands(int[][] binaryMatrix) {
        // your code goes here
        //if (binaryMatrix.length==0 && binaryMatrix[0].length==0) return 0;
        int er=binaryMatrix.length;
        int ec=binaryMatrix[0].length;
        boolean[][] visited = new boolean[binaryMatrix.length][binaryMatrix[0].length];
        int islands=0;
        for(int i=0; i<er; i++){
            for (int j=0; j<ec; j++){
                //if (binaryMatrix[i][j]==1){
                    if (binaryMatrix[i][j]==1 && !visited[i][j]){
                    markIsland(binaryMatrix,i ,j,visited);
                    islands++;
                }
            }
        }
        System.out.println(Arrays.deepToString(visited));
        return islands;

    }
    public void markIsland(int[][]binaryMatrix,int i ,int j,boolean[][] visited){
        Stack<int[]> values = new Stack<>();
        values.add(new int[]{i,j});
        visited[i][j]=true;
        while(!values.isEmpty()){
            int[] current =values.pop();
            int cr=current[0];
            int cc=current[1];

            //row +1
            if(cr+1< binaryMatrix.length && !visited[cr+1][cc] && binaryMatrix[cr+1][cc]==1){
                values.add(new int[]{cr+1,cc});
                visited[cr+1][cc]=true;
            }

            //row-1
            if(cr-1>=0 && !visited[cr-1][cc] && binaryMatrix[cr-1][cc]==1){
                values.add(new int[]{cr-1,cc});
                visited[cr-1][cc]=true;
            }

            //column +1
            if(cc+1< binaryMatrix[0].length && !visited[cr][cc+1] && binaryMatrix[cr][cc+1]==1){
                values.add(new int[]{cr,cc+1});
                visited[cr][cc+1]=true;
            }

            //column -1
            if(cc-1>=0 && !visited[cr][cc-1] && binaryMatrix[cr][cc-1]==1){
                values.add(new int[]{cr,cc-1});
                visited[cr][cc-1]=true;
            }
        }

    }


    static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
        // your code goes here
        if(grid[sr][sc]==0 || grid [tr][tc]==0) return -1;
        //default arrays are initialized to null;
        if(grid ==null || grid.length==0) return -1;
        //shortest path usually bfs not dfs
        int shortest =0;
        //int[][] neighbourList= new int [][]{{sr+1,sc},{sr,sc-1},{sr-1,sc},{sr,sc+1}};
        Queue<int[]> values = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        values.add(new int[]{sr,sc,shortest});
        visited[sr][sc]=true;

        while(!values.isEmpty()){
            int[] current = values.poll();
            int cr =current[0];
            int cc =current[1];
            if(cr==tr && cc == tc){
                return current[2];
            }
            //add neighbours
            int[][] neighbourList ={{cr+1,cc},{cr-1,cc},{cr,cc+1},{cr,cc-1}};
            for(int[] neighbour: neighbourList){
                //row+1;
                int nr=neighbour[0];
                int nc=neighbour[1];
                if(nr >=0 && nr < grid.length && nc >=0 && nc < grid[0].length && grid[nr][nc]==1 && !visited[nr][nc]){
                    values.add(new int[]{nr,nc,shortest+1});
                    visited[nr][nc]=true;
                }
            }
        }
        return -1;
    }

    public String uniqueInputs(String myValue){
        if( myValue==null ||myValue.length()==0) return "";
        Set<Character> st = new HashSet<>();
        int start=0;
        int end =0;
        int ml=-1;
        int cl=0;
        int substringa=0;

        while(end < myValue.length()){
            char current =myValue.charAt(end);
            if(!st.contains(current)){
                st.add(current);
                end++;
                cl=end-start;
            } //pwwkew; //abc abcbb
            else{
                if(ml<cl){
                    ml=cl;
                    substringa=start;
                }
                while(start<=end && end < myValue.length()){
                    if(myValue.charAt(start)!=current){
                        st.remove(myValue.charAt(start));
                        start++;
                    }
                    start++;
                    end++;
                    break;

                }

            }
        }
        if (cl>ml) {
            ml = cl;
        }
        if (ml==-1){
            ml = myValue.length();
        }
        return myValue.substring(substringa, substringa+ml);

    }

    public List<String[]> timeSchedules(String[][] personA, String[][]  personB,String[] timepersonA, String[] timepersonB,int meetingduration) {

        // combine them first into one array
        List<int[]> combinedA = new ArrayList<>();
        List<String[]> result = new ArrayList<>();
        for (int i = 0; i < personA.length; i++) {
              combinedA.add(new int[]{stringtoInteger(personA[i][0]),stringtoInteger(personA[i][1])});
            }

        for (int i = 0; i < personB.length; i++) {
            combinedA.add(new int[]{stringtoInteger(personB[i][0]),stringtoInteger(personB[i][1])});
        }

        //Sort a list of arrays.
        Collections.sort(combinedA,(a,b)->a[0]-b[0]);
        //List<int[]> finalcombined = new ArrayList();
        List<int[]> finalcombined = new ArrayList();

        int[] prev = combinedA.get(0);

        for (int i=1; i< combinedA.size();i++) {
            int start = Math.min(prev[0],combinedA.get(i)[0]);
            int end = Math.max(prev[1],combinedA.get(i)[1]);
            if(prev[1]>combinedA.get(i)[0]) {
                finalcombined.add(new int[]{start,end});
                prev = new int[]{Math.min(prev[0],combinedA.get(i)[0]),Math.max(prev[1],combinedA.get(i)[1])};
            }
            else {
                finalcombined.add(new int[]{combinedA.get(i)[0],combinedA.get(i)[1]});
                prev=combinedA.get(i);
            }
        }
        List<int[]> finalcombinedAgain = new ArrayList();
        int[] next = finalcombined.get(finalcombined.size()-1);
        for(int i=finalcombined.size()-2 ; i>=0;i--) {
            int start2 = Math.min(next[0],finalcombined.get(i)[0]);
            int end2 = Math.max(next[1],finalcombined.get(i)[1]);
            if(finalcombined.get(i)[1]> next[0]) {
                finalcombinedAgain.add(new int[]{start2,end2});
                next = new int[]{start2,end2};
            }
            else {
                finalcombined.add(new int[]{finalcombined.get(i)[0],finalcombined.get(i)[1]});
                next=combinedA.get(i);
            }

        }



        //Collections.sort(combinedC,(a,b)-> a.get(0) - b.get(0));

        return result;
        }


        public int stringtoInteger(String str) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < str.length()) {
                if (Character.isDigit(str.charAt(i))) {
                    sb.append(str.charAt(i));
                    i++;
                }
                i++;
            }
            int y = Integer.valueOf(sb.toString());
            return y;
        }

        //List<int[]> pB = new ArrayList<>();
        //String[] A = personA.get(0);
        //String[] B =personB.get(0);
        //for lists we use size instead of length
        //while(A< personA.size()){
        //    for(char A : String[] A){
        //}

       // int possiblebegin =Math.max(Integer.value0f(timepersonA[0]));

                //Integer.valueOf()
        //return List<String[]>;
   // }

    public static void main (String[] args) {
        solutions sol = new solutions();
        int[][] firstList = new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] secondList = new int[][]{{1, 2}, {2, 3}, {3, 4}, {-100, -2}, {5, 7}};
        int[][] secondList1 = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        int[][] secondList2 = new int[][]{{2, 3}, {3, 4}, {5, 7}};

        Map<String, Integer> mymap = new HashMap<>();
        mymap.put("s", mymap.getOrDefault("s", 0) + 1);
        mymap.put("v", mymap.getOrDefault("v", 1) + 1);
        mymap.put("W", mymap.getOrDefault("W", 2) + 1);
        Map<String, Integer> green = new HashMap<>();
        for (Map.Entry<String, Integer> entry : mymap.entrySet()) {
            green.put(entry.getKey(), entry.getValue());
        }
        String s = "w";

        //System.out.println(Arrays.toString(newb));
        //System.out.println(Arrays.toString(newb));
        System.out.println("green");
        System.out.println(green);
        StringBuilder sb = new StringBuilder();
        sb.trimToSize();
        char y ='y';
        Scanner sc = new Scanner(System.in);
        //y instanceof
        //sb.re
        //String s =" Wanjiru";
       // s.inse

        //[2, 3], [3, 4], [5, 7]
        //System.out.println(sol.validateIP("255.12.13.8"));
        //System.out.println(sol.wordCountEngine("practice  makes perfect Practice"));
       // int[][] matrix = new int[][]{{1, 1, 0, 1, 0}, {0, 0, 1, 1, 1}, {1, 0, 0, 1, 0}, {0, 1, 1, 0, 0}, {1, 0, 1, 0, 1}};
        //System.out.println(sol.getNumberOfIslands(matrix));
       // int sc = 0;
       // int sr = 0;
       // int depth = 0;
        System.out.println(sol.uniqueInputs("pwwkey"));


        //Queue<int[]> myQue1 = new java.util.LinkedList<>();
       // myQue1.add(new int[]{sr, sc, depth});
       // Queue<List<Integer>> myQue2 = new java.util.LinkedList<>();
       // myQue2.add(new ArrayList<>(Arrays.asList(sr, sc, depth)));
       // Queue<Vector<Integer>> myQue3 = new java.util.LinkedList<>();
       // myQue3.add(new Vector<>(Arrays.asList(sr, sc, depth)));

        //myQue1.add(sr,sc,depth);
        StringBuilder sb1 = new StringBuilder();
        String sb2 = "000000 111111 222222 33333 ";
        sb1.append("wanjiru ");
        sb1.append("pheezyBee ");
        sb1.append("life ");
        sb1.append("fine ");
        System.out.print(sb1);
        String[] newb = sb2.split(" ");
        String[] vuzi = new String[newb.length];
        int[] newArray = new int[newb.length];
        for (int i = 0; i < newb.length; i++) {
            newArray[i] = Integer.valueOf(newb[i]);
            //vuzi[i]=newb[i].trim();
        }
        System.out.println(Arrays.toString(newb));
        System.out.print(Arrays.toString(newArray));
        char b = ' ';
       // boolean y = Character.isWhitespace(b);
        System.out.println(y);
        Scanner st = new Scanner(System.in);
        //StringBuilder sb = new StringBuilder();
        char c = st.next().charAt(0);
        sb.append(c);
        String v = st.next();
        sb.append(v);
        System.out.print(sb);









    }
    }

