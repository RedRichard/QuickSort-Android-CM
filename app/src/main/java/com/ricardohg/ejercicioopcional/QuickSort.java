package com.ricardohg.ejercicioopcional;

import java.util.ArrayList;

public class QuickSort {
    public static void sortArrayList(ArrayList<Integer> arrayList){
        //ArrayList<Integer> sortedArray = arrayList;
        quickSort(arrayList, 0, arrayList.size()-1);
        //return sortedArray;
    }

    public static void quickSort(ArrayList<Integer> arrayList, int start, int end){
        int partition = partition(arrayList, start, end);

        if((partition-1)>start){
            quickSort(arrayList, start, partition - 1);
        }
        if((partition+1)<end){
            quickSort(arrayList, partition + 1, end);
        }
    }

    public static int partition(ArrayList<Integer> arrayList, int start, int end){
        Integer pivot = arrayList.get(end);

        for(int i = start; i < end; i++){
            if(arrayList.get(i).compareTo(pivot)<=0){
                int temp = arrayList.get(start);
                arrayList.set(start, arrayList.get(i));
                arrayList.set(i, temp);
                start++;
            }
        }

        int temp = arrayList.get(start);
        arrayList.set(start, pivot);
        arrayList.set(end, temp);

        return start;
    }
}
