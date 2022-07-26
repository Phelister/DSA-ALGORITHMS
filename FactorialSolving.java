package com.myProjects.wow;

public class FactorialSolving {


    public int FactorialIterate(int n){
        int result =1;
        if(n==0) return 1;
        if (n<0) return -1;
        for (int i = 1; i <= n; i++) {
            result = i * result;
        }
        return result;

    }
    public int FactorialIterate1(int n){
        int result = 1;
        int i=1;
        if (n==0||n==1) return 1;
        else if (n<0) return -1;
        while(i<=n){
            result = result*i;
            i++;
        }
        return result;
    }
    public int FactorialIRecursive(int n){
        int result =1;
        if(n<1) {
            return -1;
        }
        else if (n==0 || n==1){
            return result;
        }
        result=n*FactorialIRecursive(n-1);
        return result;
    }
    public static void main(String[] args){
        FactorialSolving fs = new FactorialSolving();
        System.out.println(fs.FactorialIterate(-50));
    }
}
