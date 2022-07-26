package com.myProjects.wow;

public class Replace {
    public String Replace(String S) {
        String Result1;
        String Result2;
        String Result3;

     Result1 =S.replaceAll("plus","+");
     Result2 =Result1.replaceAll("minus","-");
     Result3="\"" + Result2 + "\"";
     return Result3;
    }

    public static void main(String[] args) {
        Replace result= new Replace();
        String r = result.Replace("plusminusplusminus");
        System.out.println(r);

    }
}