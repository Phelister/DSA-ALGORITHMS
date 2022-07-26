package com.myProjects.wow;

public class ArrayStructures<arraySize> {
    private int[] theArray =new int[15];
    private int arraySize =10;

    private int i=0;
    private int j=0;


    public void generateRandomValues()
    {
        System.out.println("-----------");
        for( int i=0; i<arraySize;i++){
           theArray[i]=(int)(Math.random()*10)+10;
            System.out.print("|" + i + "|");
            System.out.println(theArray[i]+"|");
            System.out.println("-----------");
        }
    }

    //get index location
    public int getValueAtIndex(int i){
        if(i< arraySize) return theArray[i];
        return 0;
    }

    //object contains

    public boolean doesContainValue(int SearchValue)
    {
        boolean isContained=false;
        for( int i=0; i<arraySize;i++){
           if(theArray[i]==SearchValue)
               isContained=true;
        }
        return isContained;
    }

    //object deletion
    public void deleteObjectInArray(int index)
    {
        for( int i=index; i<(arraySize-1);i++){
            theArray[i]=theArray[i+1];
        }
        arraySize --;
    }


    //insert values
    public void InsertValue(int value)
    {
        if(arraySize<50){
            theArray[arraySize]=value;
            arraySize++;
        }
    }

    //linear search

    public String LinearSearch(int value){
        boolean isPresent= false;
        String indexesWithValues=" ";
        for( int i=0; i<arraySize;i++) {
            if (theArray[i] == value) {
                isPresent = true;
                System.out.print("The value was found at index: ");
                System.out.print(i + "  ");
                indexesWithValues = i + " ";
            }
        }
        if (!isPresent) {
                indexesWithValues = "No such value was found in the array";
            System.out.println(indexesWithValues);
        }
    return indexesWithValues;
    }

// sorting algorithm
 public void bubbleSort(){

        for (int i=(arraySize-1); i>1; i--){
            for (int j=0; j<arraySize; j++)
                if(theArray[j]>theArray[j+1]) {
                    swap(j, j + 1);
                }

        }
     printHorzArray(i,j);

 }
 //swapping two values
 public void swap(int indexOne, int indexTwo) {
        int temp= theArray[indexOne];
        theArray[indexOne]=theArray[indexTwo];
        theArray[indexTwo]=theArray[indexOne];

 }
 //print horizontal array

    public void printHorzArray(int i, int j) {

        for (int n = 0; n < 51; n++)
            System.out.print("-");
        System.out.println();
        for (int n = 0; n < arraySize; n++) {
            System.out.print("| " + n + "  ");
        }
        System.out.println("|");

        for (int n = 0; n < 51; n++) System.out.print("-");

        System.out.println();
        for (int n = 0; n < arraySize; n++) {

            System.out.print("| " + theArray[n] + " ");
        }
        System.out.println("|");

        for (int n = 0; n < 51; n++) System.out.print("-");

        System.out.println();
    }

//main method
    public static void main(String[] args)
    {
        ArrayStructures newArray = new ArrayStructures();
        int[] wow = new int[]{9, 3, 11, 12, 4, 1, 2};
       newArray.generateRandomValues();
       // System.out.println(newArray.getValueAtIndex(5));
        //System.out.println(newArray.doesContainValue(13));
       // newArray.deleteObjectInArray(7);
       // newArray.generateRandomValues();
        //newArray.InsertValue(14);
        //newArray.generateRandomValues();
        //newArray.LinearSearch(17);
        newArray.bubbleSort();

    }
}
