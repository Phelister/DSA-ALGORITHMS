package com.myProjects.wow;

import java.util.HashMap;
import java.util.Map;

public class workingWithMaps {
    public static void main (String[] args){
        Map<Integer, Person> map = new HashMap<>();
            map.put(1,new Person(1,"mariam"));
            map.put(2,new Person(2,"mariak"));
            map.put(3,new Person(3,"kariam"));
        System.out.println(map);
        System.out.println(map.get(1));
        System.out.println(map.containsKey(4));
        System.out.println(map.entrySet());
        System.out.println(map.keySet());
        map.entrySet().forEach(System.out::println);
        map.entrySet().forEach(x -> System.out.println(x.getKey()+"  " +x.getValue()));
    }
    static record Person( int age, String name){}
}
