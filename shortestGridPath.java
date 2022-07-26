package com.myProjects.wow;

import java.util.*;
import java.util.LinkedList;

public class shortestGridPath {
    public int ShortestGridPath (int[][]grid,int sr, int sc, int tr, int tc){

        if (grid[sr][sc]==0 || grid[tr][tc]==0) return -1;
        int depth=0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> myqu = new LinkedList<>();
        Set<int[]> visited = new HashSet<>();

        //direction array.
        int [][] direction = {{sr-1, sc}, {sr+1, sc}, {sr, sc-1}, {sr, sc+1}};
        myqu.add(new int[]{sr,sc,depth+1});
        visited.add(new int[]{sr,sc});

        while(!myqu.isEmpty()){
            int[] wow = myqu.poll();
            if (wow[0]==tr && wow[1]==tc){
                return wow[2];
            }
            for (int [] dir : direction) {
                int nr = wow[0] + dir[0];
                int nc = wow[1] + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1 && !visited.contains(new int[]{nr, nc})) {
                    myqu.add(new int[]{nr, nc, depth + 1});
                    visited.add(new int[]{nr, nc});
                }
            }

            }
        return -1;
    }


    public int CellCountPath (int[][]grid) {

        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> myqu = new LinkedList();
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        //Set<int[]> visited = new HashSet<>();
        //direction array.
        for (int i = 0; i < m; i++) {
                        for (int j = 0; j < n; j++) {

                            if (grid[i][j] == 1 && !visited[i][j]) {
                                myqu.add(new int[]{i, j});
                    visited[i][j] = true;
                                int temp=0;
                    while (!myqu.isEmpty()) {
                        int[] current = myqu.poll();
                        int cr = current[0];

                        int cc = current[1];
                        if(cr==0||cr==m-1||cc==0||cc==n-1){
                            temp++;
                        }
                        int[][] directions = {{cr + 1, cc}, {cr - 1, cc}, {cr, cc + 1}, {cr, cc - 1}};
                        for (int[] dir : directions) {
                            int nr = dir[0];
                            int nc = dir[1];

                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1 && !visited[nr][nc]) {

                                myqu.add(new int[]{nr, nc});
                                visited[nr][nc] = true;

                            }
                        }
                    }
                    if(temp==0){
                        count++;
                    }
                count++;
                }
                //like saying for all the counts increase it as we go along
                //count++;
            }
           // count++;
        }

        return count;
    }

    public int minimaldistance(HashMap<String, Boolean>[] grid, int[] req) {

        if(grid.length==0) return 0;
        int m = grid.length;
        int minimum= grid.length+1;
        int wantedResidence= 6;
        for(int i=0; i< grid.length; i++){
            Queue<HashMap<String, Boolean>> values = new LinkedList();
            Queue<int[]> depth = new LinkedList<>();
            boolean[] visited = new boolean[m];
            int count1 = 0;
            int count2 = 0;
            int count3 = 0;
            values.add(new HashMap<>(i));
            depth.add(new int[]{0,i,i});
            visited[i] =true;
            while(!values.isEmpty()){
                HashMap<String, Boolean> current = values.poll();
                int[] depthValues = depth.poll();
                int depth1= depthValues[0];
                int location = depthValues[1];
                int perfectResidence = depthValues[2];
                if (current.containsKey(req[0]) && current.get(req[0])==true){
                    count1++;
                }
                if (current.containsKey(req[1]) && current.get(req[1])==true){
                    count2++;
                }
                if (current.containsKey(req[3]) && current.get(req[3])==true){
                    count3++;
                }
                if (count1>0 && count2>0 && count3> 0){
                    if(depth1 < minimum){
                        minimum=depth1;
                        wantedResidence=perfectResidence;
                    }
                    break;
                }
                int[] dir ={location+1,location-1};
                for(int dr: dir){
                    int nc =dr;
                    if (nc>0 && nc <m && !visited[nc]){
                        values.add(new HashMap<>(nc));
                        depth.add(new int[]{depth1+1,location+1,perfectResidence});
                        visited[nc]=true;
                    }
                }

            }

        }
        return wantedResidence;
    }




    public static void main (String [] args){
       shortestGridPath SGP = new shortestGridPath();
       int [][] numbers = {{1,1,0,0,0}, {1,1,0,0,0}, {0,0,1,0,0}, {0,0,0,1,1}};
       int y =numbers[0].length;
       System.out.println(SGP.CellCountPath(numbers));
       List<Integer> result = new ArrayList<>();
       Object [] arr = result.toArray();
       Queue<Map<String,Integer>> values = new LinkedList<>();
       Map<String,Integer> uzi = new HashMap<>();
       uzi.put("wow",1);
       uzi.put("view", 4);
       uzi.put("op", 5);


       values.add(new HashMap<>(){{put("view",1);}});
       values.add(new HashMap<>(){{putAll(uzi);}});
       //values.add(new HashMap<>(){{put("zed",2);}});

       Map<String,Integer> wow = values.poll();

       int count=0;
       if(wow.containsKey("view") && wow.get("view")==4){
           count++;
       }
        System.out.println("wow");
       System.out.println(count);
        int vie;
        int zed;
        List<List<String>> resul = new ArrayList<>();
        List<List<Integer>> resu = new ArrayList<>();

             for(Map.Entry<String,Integer> pall: wow.entrySet()){
                List<String> v= new ArrayList<>();
                 List<Integer> ze= new ArrayList<>();
                 v.add(pall.getKey());
                 ze.add(pall.getValue());
                 resul.add(v);
                 resu.add(ze);

             };

        System.out.println(resul);
        System.out.println(resu);
       Queue<List<Integer>> val = new LinkedList<>();
       val.add(new ArrayList<>(Arrays.asList(5)));
       val.add(new ArrayList<>());

       Queue<Node> vali = new LinkedList<>();
       vali.add(new Node(5));

       Queue<Set<Integer>> vuzi = new LinkedList<>();
       vuzi.add(new HashSet<>(Arrays.asList(5)));
        //collections you can initialize with arrays as list.

        Map<String,List<Integer>> va= new HashMap<>();
        va.put("win",new ArrayList<>());
        va.get("win").add(5);

        Map<String, String> doubleBraceMap  = new HashMap<String, String>() {{
            put("key1", "value1");
            put("key2", "value2");
        }};

    }
}
