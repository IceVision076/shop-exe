package com.vapeshop.filter;

public class Test {
    public static void main(String[] args) {
        int [] array= {10,3,4,1,6};
        //sort array by bubble sort
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-1;j++){
                if(array[j]>array[j+1]){
                    //swap
                    int temp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }

        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }


    }
}
