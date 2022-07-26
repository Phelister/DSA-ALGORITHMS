package com.myProjects.wow;
import java.util.*;
public class mymain {

        public static void main(String[] args) {
            int noOfVertices = 7;
            int startVertex=2;  // C is start vertex

            List<Integer>[] adj=new ArrayList[noOfVertices];

            List<Integer> list=new ArrayList<>();
            list.add(1);
            list.add(3);
            adj[0]=list;

            list=new ArrayList<>();
            list.add(3);
            list.add(4);
            adj[1]=list;

            list=new ArrayList<>();
            list.add(0);
            list.add(5);
            adj[2]=list;

            list=new ArrayList<>();
            list.add(5);
            list.add(6);
            adj[3]=list;

            list=new ArrayList<>();
            list.add(6);
            adj[4]=list;

            adj[5]=new ArrayList<>();

            list=new ArrayList<>();
            list.add(5);
            adj[6]=list;

            int[] path = new int[noOfVertices];
            int[] distance = new int[noOfVertices];

            Arrays.fill(distance,-1); // Intialize distance array

            distance[startVertex]=0; // Making distance for start vertex 0
            for (int i=0; i<noOfVertices ;i++) {
                System.out.println(distance[i]);
            }

            path[startVertex]=startVertex; // Updating path for start vertex to itself
            Queue<Integer> q = new java.util.LinkedList();
            //Queue<Integer> q=new LinkedList();
            q.add(startVertex);

            while(!q.isEmpty()){
                int size=q.size();

                while(size-->0){
                    int vertex=q.remove();

                    List<Integer> adjVertices=adj[vertex];

                    for(Integer adjVertex: adjVertices){
                        if(distance[adjVertex]==-1){
                            distance[adjVertex]=distance[vertex]+1;
                            path[adjVertex]=vertex;
                            q.add(adjVertex);
                        }
                    }
                }
            }

            System.out.println("Distance from "+(char)(startVertex+'A')+" :");
            for(int i=0;i<noOfVertices; i++){
                System.out.print("Distance to "+(char)(i+'A')+" is "+distance[i]);
                System.out.println(" from path "+(char)(path[i]+'A'));
            }
        }
    }

