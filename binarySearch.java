package com.myProjects.wow;

public class binarySearch {

    public int solution(int value) {
        int maximumCount=0;
        int counter=0;
        boolean isStarted = false;
        String binaryRepresentation =Integer.toBinaryString(value);
        System.out.println(binaryRepresentation);
        for (int i=0; i<binaryRepresentation.length(); i++){
            //string.substring(int startIndex, int endIndex)
            String n = binaryRepresentation.substring(i,i+1);
            if (n.equals("1")){
                if(isStarted){
                    if(counter>maximumCount) {
                        maximumCount = counter;
                    }
                }
                counter =0;
                isStarted =true;
            }
            if (n.equals("0")) {
                counter++;
                isStarted = true;
            }

            System.out.println(n);

        }
        return maximumCount;
    }

    public static void main(String[] args)
    {
        binarySearch wow = new binarySearch();
        System.out.println("The Value of the Largest gap is:"+ wow.solution(32));
    }
}
