package com.myProjects.wow;

import java.util.*;
import java.util.LinkedList;

public class MinimumSpanningTree{
    //1----Prims        2-----Kruskal
    private Map<Integer, List<Node5>> minimumTree(int[][] edges){

        Map<Integer, List<Node5>> graph =graph5(edges);
        //to be output in the end
        Map<Integer, List<Node5>> map= new HashMap<>();
        PriorityQueue<Node5> pq = new PriorityQueue();
        //you need to choose a starting point node or vertex;
        int cost=0;
        int n= graph.size();
        //i can use arrays.sort to pick the smallest element from the edges list;
        //we will assume selected but always use greedy to select;
        pq.add(new Node5(1,2));

        //edges in a spanning tree are usually -1 vertices
        for(int i=0;i<n-1; i++){

            Node5 current = pq.poll();
            int currVertex=current.data;
            int currWeight = current.weight;

            List<Node5> neighbourList= graph.get(currVertex);
            for(Node5 neighbour : neighbourList){

                if(!map.containsKey(neighbour.data)) {
                    if(neighbour.weight == currWeight){
                        cost+=neighbour.weight;
                        if(!map.containsKey(currVertex)){
                            map.put(currVertex,new ArrayList<>());
                        }
                        if(!map.containsKey(neighbour.data)){
                            map.put(neighbour.data,new ArrayList<>());
                        }
                        map.get(currVertex).add(neighbour);
                        map.get(neighbour.data).add(new Node5(currVertex,currWeight));
                        for(Node5 neigh:graph.get(neighbour.data)){
                            if(map.containsKey(neigh.data)){
                                continue;
                            }
                            pq.add(new Node5(neighbour.data,neigh.weight));
                        }

                    }
                    else if(neighbour.weight != currWeight){

                        pq.add(new Node5(currVertex, neighbour.weight));

                    }

                }
            }
        }
    return map;
    }

    public Map<Integer, List<Node5>> graph5(int[][] edges){
        Map<Integer, List<Node5>> g = new HashMap<>();

        if(edges==null || edges.length==0 || edges[0].length==0){
            return new HashMap<>();
        }
        for(int i=0; i<edges.length;i++){
            int source= edges[i][0];
            int destination= edges[i][1];
            int weight= edges[i][2];
            if(!g.containsKey(source)){
                g.put(source, new ArrayList<>());
            }
            if(!g.containsKey(destination)){
                g.put(source, new ArrayList<>());
            }
            g.get(source).add(new Node5(destination,weight));
            g.get(destination).add(new Node5(source,weight));
        }

        return g;
    }


    //kruskal algorithm
    public int findParent(int source, Map<Integer,Integer> arr){
        if(arr.get(source)==source){
            return source;
        }
        return arr.put(source,findParent(arr.get(source),arr));
    }
    public void union(int a, int b, Map<Integer, Integer> rank, Map<Integer,Integer> arr){
        //if null in the map there might be a null pointer exception so populate the values before hand.
        int y = findParent(a,arr);
        int x= findParent(b,arr);
        //cause path compression has been performed they are the same.
        if(y!=x){
            if(rank.get(a)<rank.get(b)){
                arr.put(a,b);
            }
            else if(rank.get(b)<rank.get(a)){
                arr.put(b,a);
            }
            else{
                arr.put(b,a);
                rank.put(a,rank.get(a)+1);
            }

        }
    }
    public Map<Integer, List<Node5>> KruskalsMinimumSpanningTree(int[][] edges){
        //have source,destination,weight.
        //sort in ascending order
        Arrays.sort(edges,(a,b)->a[2]-b[2]);
        Map<Integer,Integer> parent = new HashMap<>();
        Map<Integer,Integer> rank = new HashMap<>();
        for(int i=0; i<edges.length;i++){
            int source= edges[i][0];
            int destination=edges[i][1];
            if(!parent.containsKey(edges[i][0]) && rank.containsKey(edges[i][0])){
                parent.put(source,source);
                rank.put(source,0);
            }
            if(!parent.containsKey(edges[i][1]) && rank.containsKey(edges[i][1])){
                parent.put(destination,destination);
                rank.put(destination,0);
            }
        }
        Map<Integer,List<Node5>> map = new HashMap<>();
        for(int[] edge : edges){
            int source = edge[0];
            int destination= edge[1];
            int weight=edge[2];
            int par1=findParent(source,parent);
            int par2=findParent(destination,parent);
            if(par1!=par2){
                union(par1,par2,rank,parent);
                if(!map.containsKey(source)){
                    map.put(source,new ArrayList<>());
                }
                if(!map.containsKey(destination)){
                    map.put(destination,new ArrayList<>());
                }
                map.get(source).add(new Node5(destination, weight));
                map.get(destination).add(new Node5(source,weight));
            }
        }
        return map;

    }

    public int calculate(String s) {
        if(s==null || s.length()==0){
            return 0;
        }

        int result =0;
        int sign =1;

        int i=0;
        int n= s.length();

        Stack<Integer> stack = new Stack<>();

        while(i<=n-1){

            char current = s.charAt(i);

           // if(Character.isWhitespace(current) || current==','){
              //  continue;
            //}

            if(current=='('){

                stack.add(result);
                stack.add(sign);
                result=0;
                sign=1;
            }

            if(current==')'){

                result+=(stack.pop()*stack.pop());
            }


            if(current=='-'){

                sign=-1;
            }

            if(current=='+'){

                sign=1;
            }

            if(Character.isDigit(current)){
                //System.out.println(result);
                int num=0;
                StringBuilder sb= new StringBuilder();
                //"1+1"

                while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9' ){
                    //System.out.println(sb.toString());
                    sb.append(s.charAt(i));
                   // if(i!=sb.length()-1){
                        i++;
                   // }

                }


                System.out.println(sb.toString());
                num=Integer.valueOf(sb.toString());

                result+=(num*sign);
                i--;

            }
            i++;
        }


        return result;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums==null || nums.length==0){
            return false;
        }
        //bruteforce n2
        int m= nums.length;
        for(int i=0;i<m;i++){
            for(int j=i+1; j<m; j++){
                long y=Math.abs((long)nums[i]-(long)nums[j]);
                System.out.println(y);
                long x=Math.abs(i-j);
                if(y<=t && x<=k){
                    return true;
                }
            }
        }
        return false;
    }
    public int[]  mergeSort(int[]arr){
        if(arr==null || arr.length<=1){
            return arr;
        }
        int m= arr.length;
        int mid=arr.length/2;
        int[] left= new int[mid];
        int[] right= new int[m-mid];
        for(int i=0;i<mid;i++){
            left[i]=arr[i];
        }
        for(int i=0;i<m-mid;i++){
            right[i]=arr[mid+i];
        }
       // int[] result= new int[arr.length];
        left=mergeSort(left);
        right=mergeSort(right);
        return merge(left,right);
    }
    public int[] merge (int[] left, int[] right){
        int[] result = new int[left.length+right.length];
        int l=0;
        int r=0;
        int k=0;
        int m=left.length;
        int n=right.length;
        while(l<m || r<n){
            if(l<m && r<n){
                if(left[l]<right[r]){
                    result[k++]=left[l++];

                }
                else if(left[l]>=right[r]){
                    result[k++]=right[r++];
                }
            }
            else if(l<m){
                result[k++]=left[l++];
            }
            else{
                result[k++]=right[r++];
            }
        }
        return result;
    }

    public int[] quickSort(int[] arr){
        //pick pivot and anything to the left should be smaller and right bigger
        if(arr==null || arr.length==0){
            return arr;
        }

        int m= arr.length;
        quickSortHelper(0,m-1,arr);
        return arr;
    }

    public void quickSortHelper(int start, int end, int[] arr){
        if(start>=end){
            return;
        }
        int y= partitionHelper(start,end,arr);
        System.out.print("*****");
        System.out.println(y);
        quickSortHelper(start,y-1,arr);
        quickSortHelper(y+1, end,arr);
    }

    public int partitionHelper(int start, int end, int[] arr){
        int lb=start;
        int pivot= arr[start];

        while(start<end){

            while(start<arr.length && pivot>=arr[start]){
                start++;
            }
            while(end>=0 && pivot<arr[end]){
                end--;
            }

            if(start<end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }

        }

        int temp= arr[lb];
        arr[lb]=arr[end];
        arr[end]= temp;
        System.out.print(Arrays.toString(arr));
        System.out.print(end);

        return end;
    }
    public int[] selectionSort(int[] nums){
        if(nums==null || nums.length==0){
            return nums;
        }
        for(int i=0; i<nums.length; i++){
            int minimum=i;
            for(int j=i+1; j<nums.length; j++){
                if(nums[j]<nums[minimum]){
                    minimum=j;
                }
            }
            swap(i,minimum,nums);
        }
        return nums;
    }
    public void swap(int i, int j, int []arr){
        int temp= arr[i];
        arr[i]=arr[j];
        arr[j]= temp;
    }

    public int[] insertionSort(int[] nums){

        if(nums==null || nums.length==0){
            return nums;
        }

        for(int i=1; i<nums.length;i++){
            int k=i;
            for(int j=i-1;j>=0;j--){

                if(nums[j]>nums[k]){
                    swap(k,j,nums);
                    k--;
                }
            }
        }
        return nums;
    }


    public int bridgesInaGraph(Map<Integer,List<Integer>> graph){
        if(graph==null|| graph.size()==0){
            return 0;
        }
        Map<Integer, Integer> startTime = new HashMap<>();
        Map<Integer,Integer>  endTime = new HashMap<>();
        int[] arr= new int[1];
        arr[0]=1;
        int[] count={0};
        for (int wow : graph.keySet()){
            if(!startTime.containsKey(wow)){
                DFSBridge(graph,wow,startTime,endTime,arr,count);

            }

        }

        return count[0];
    }
    public void DFSBridge(Map<Integer,List<Integer>> graph,int source,Map<Integer,Integer> startTime, Map<Integer,Integer> endTime,int[] arr,int[] count){
       if(graph.get(source)==null || startTime.containsKey(source)){
            return;
        }
        startTime.put(source,arr[0]);

        //System.out.print(startTime.toString());
       // System.out.print(count);
        endTime.put(source,arr[0]++);
        //System.out.println(endTime);
       // count2++;
       // System.out.print(endTime.toString());
        for(int neighbour: graph.get(source)){
            if(!startTime.containsKey(neighbour)) {
                DFSBridge(graph, neighbour, startTime, endTime, arr, count);
                //int nu=Integer.MAX_VALUE;

                for (int na : graph.get(neighbour)) {
                    if (na == source) {
                        continue;
                    }
                    //for neighbours who wont have been visited when we go back
                    if (!startTime.containsKey(na)) {
                        continue;
                    }
                    int curr = endTime.get(neighbour);
                    int nu = endTime.get(na);
                    endTime.put(neighbour, Math.min(curr, nu));
                }

                if (endTime.get(neighbour) > endTime.get(source)) {
                    //System.out.println(neighbour);
                    //System.out.println(neighbour);
                    count[0]++;
                }
            }
        }
    }
    public List<Integer> topo (Map<Integer, List<Integer>> graph, int source){
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        topoSort(source,graph,result,visited);
        StringBuilder sb = new StringBuilder();
        //Integer.valueOf(y);
        return result;
    }
    public void topoSort(int source,Map<Integer, List<Integer>> graph, List<Integer> result, Set<Integer> visited){
       if( graph.get(source)==null ||visited.contains(source)){
           // result.add(5);
            return;
        }
       //get.get source not


        visited.add(source);
        System.out.println(visited);
        List<Integer> neighbour= graph.get(source);
            for (int neigh : graph.get(source)){
                    topoSort(neigh, graph, result, visited);
            }
            result.add(source);
        }


    public static void main(String[] args){
        MinimumSpanningTree mt= new MinimumSpanningTree();
        Queue<Integer> queue = new LinkedList<>();
        String s= "1+1";
       System.out.println(mt.calculate(s));


       PriorityQueue<paire> pq = new PriorityQueue<>(new paire());
       PriorityQueue<paire> peq = new PriorityQueue<>((x,y)-> x.weight-y.weight);
        pq.add(new paire(5,16));
        pq.add(new paire(6,5));
        pq.add(new paire(3,31));
        System.out.println(pq.poll().weight);
        System.out.println(pq.poll().weight);
        System.out.println(pq.poll().weight);
        List<String> y = new ArrayList<>();
        int[] arr={5,4,3,2};
        int[] arrb = {6,7,5,1};
        boolean contains=false;
        Set<Integer> canHave = new HashSet<>();
        for(int i=0; i<arr.length;i++){
            canHave.add(arr[i]);
        }
        for(int i=0;i<arrb.length;i++){
            if(canHave.contains(arrb[i])){
                contains=!contains;
            }
        }
        System.out.println(contains);
        int[] nums= {-2147483648,2147483647};
        //System.out.println(nums[0]-nums[1]);
        int k=1;
        int t=1;
        System.out.println(mt.containsNearbyAlmostDuplicate(nums,k,t));

        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        Map<Character, Character> map = new HashMap<>();
        map.put('3','8');
        map.put('4','5');
        map.put('2','1');
        //Has
        Map<Integer, Integer> map1= new LinkedHashMap<>();
        //LinkedResult
        map1.put(15,8);
        map1.put(2,1);
        map1.put(5,8);
        map1.put(4,5);

        StringBuilder sb = new StringBuilder();
        for(int key: map1.keySet()){
            System.out.print(key);
        }
        for(Map.Entry<Integer,Integer> entry : map1.entrySet()){
            int key= entry.getKey();
            int value=entry.getValue();
            if(key==4) {
                entry.setValue(4);
            }
        }

        System.out.println(map1.toString());
       int[]  num ={173,154,205,4,5};
      // System.out.println(Arrays.toString(mt.mergeSort(num)));
       //System.out.println(Arrays.toString(mt.quickSort(num)));
       System.out.print(Arrays.toString(mt.insertionSort(num)));

       System.out.print(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        List<paire> result = new LinkedList<>();
         char sy = '1';
         String syr= null;
         //String []  sr =sy.split(" ");
         int v = Integer.valueOf(sy);
        //int  w= Integer.valueOf(sy);
        System.out.println(v);
        //System.out.println(w);

        //System.out.println((int)Math.pow(2,3));
        //StringBuffer sb5= new StringBuffer();
        //System.out.println(Integer.valueOf(1));
        Stack<Integer> stack = new Stack<>();
        stack.add(5);
        stack.add(3);
        System.out.println(stack.peek());
        int a=5;
        int data =(a==5)?a : -1;
        int sum=8;
        if(sum==Math.max(5,2)){
            System.out.print(true);
        }
        else{
            System.out.println(false);
        }
        int[] a5 = new int[1];
        a5[0]=1;
        a5[0]++;
        System.out.println(a5[0]);
        Map<Integer, List<Integer>> g= new HashMap<>();
        g.put(1,new ArrayList<>());
        g.put(2,new ArrayList<>());
        g.put(3,new ArrayList<>());
        g.put(4,new ArrayList<>());
        g.put(5,new ArrayList<>());
        g.put(6,new ArrayList<>());
        g.put(7,new ArrayList<>());
        g.put(8,new ArrayList<>());
        g.put(9,new ArrayList<>());
        g.put(11,new ArrayList<>());
        g.get(1).add(2);
        g.get(1).add(4);
        g.get(2).add(1);
        g.get(2).add(3);
        g.get(3).add(2);
        g.get(3).add(4);        g.get(4).add(1);
        g.get(4).add(3);
        g.get(4).add(5);
       g.get(5).add(4);
       g.get(5).add(11);
     g.get(11).add(5);
      g.get(6).add(11);
        g.get(11).add(6);
        g.get(6).add(9);
        g.get(6).add(7);
        g.get(7).add(6);
        g.get(7).add(8);
        g.get(8).add(7);
        g.get(8).add(9);
        g.get(9).add(6);
        g.get(9).add(8);



       System.out.println(g);
        System.out.println(mt.bridgesInaGraph(g));
        System.out.println();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        //graph.put(1, graph.getOrDefault(1,new ArrayList<>().add(4)))
        graph.put(1,new ArrayList<>());
        //graph.put(2,new ArrayList<>());
        graph.put(3,new ArrayList<>());
        graph.put(4,new ArrayList<>());
        graph.get(1).add(4);
       // graph.get(1).add(2);
        graph.get(4).add(3);
        System.out.println(graph);
        System.out.println(graph.get(3));
        int source=1;
        System.out.println(mt.topo(graph,source));
        System.out.println(mt.topo(graph,source));
        int x= (int)1e9;
        System.out.println(x);

       // bridgesInaGraph(Map<Integer,List<Integer>> gra
        //int y=(int)-1e9;
        int[][] dp = new int[7][7];

        Map<Integer,Integer> vx = new HashMap<>();
        vx.put(1, vx.getOrDefault(1,0)+1);
        vx.put(1, vx.getOrDefault(1,0)+1);
        vx.put(1, vx.getOrDefault(1,0)+1);
        System.out.println(vx.get(1));
        Queue<HashMap<Integer,Integer>>  queue1 = new LinkedList<>();
        int x1=5;
        HashMap<Integer, Integer> val = new HashMap<>();
        int x2=7;
        queue1.add(new HashMap<>(){{putAll(val);}});
        int[] arr1 ={2,-7,-2,-2,0};
        List<Integer> list1 = new ArrayList(Arrays.asList(5,6,7,8));

        Collections.sort(list1, Collections.reverseOrder());

        for(int i=0; i< arr1.length;i++){
            System.out.print(" ");
            System.out.print(arr1[i]);
        }







       // String


    }
}
