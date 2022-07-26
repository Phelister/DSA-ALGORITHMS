package com.myProjects.wow;

public class DecimalToBinary {

    public static String calculate(int decimalNumber,String result){

        if (decimalNumber==0){

           return result;

        }

        else{
            result = decimalNumber % 2 + result;

        }
        return calculate(decimalNumber/2, result);
    }
    public static void main(String[] args)
    {
        DecimalToBinary wow = new DecimalToBinary();

        System.out.println(wow.calculate(10,""));
    }
}
