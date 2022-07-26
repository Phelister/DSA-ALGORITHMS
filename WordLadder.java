package com.myProjects.wow;

import java.util.*;
import java.util.LinkedList;

public class WordLadder {
    public int Wordladder(String start, String end, List<String> wordlist ){
        //list has a lookup of O(n) so convert to set for 0(1) lookup
        if (start.length()==0 || end.length()==0 || wordlist.size()==0) return 0;
        Set<String> words = new HashSet<>();
        words.addAll(wordlist);
        Queue<WordSearch> values = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        values.add(new WordSearch(start,1));
        visited.add(start);
        while(!values.isEmpty()){
            WordSearch current = values.poll();
            if(current.word==end){
                return current.count;
            }
            for(String valu : words){
                if(isAdjacent(current.word,valu) && !visited.contains(valu)){
                  values.add(new WordSearch(valu,current.count+1));
                  visited.add(valu);
                }
            }
        }
        return 0;
    }

    public boolean isAdjacent(String string1, String string2){
        int count=0;
        for (int i=0; i<string1.length(); i++){
            if(string1.charAt(i)!=string2.charAt(i)){
                count++;
            }
        }
        if (count>1 || count<1){
            return false;
        }
       return true;
    }
    public static void main(String[] args){
        WordLadder wow = new WordLadder();
        String start="hit";
        String end ="cog";
        List<String> words = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        //String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(wow.Wordladder(start, end, words));
       //LinkedList<>[] list;
    }
}
