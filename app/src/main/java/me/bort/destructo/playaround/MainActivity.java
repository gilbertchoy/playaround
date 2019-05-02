package me.bort.destructo.playaround;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private int arr[]=new int[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //hashmap
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("test",0);
        map.put("test1",1);
        map.put("test2",2);
        map.put("test3",3);
        map.put("test4",4);

        Log.d("test", "contains key " + map.containsKey("test"));

        map.put("test5", 1);
        Log.d("test", "test5 value: " + map.get("test5"));

        //cycle through hashmap
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            entry.getValue();
            entry.getKey();
        }

        //array
        int[] array = new int[20];

        int x = 0;
        for(int i =0; i<array.length; i++){
            x++;
            array[i] = x;
        }

        //array of strings
        String[] stringArray = new String[]{"fwefsdfsdf","sadfdsfd","fegewafsd","gefsdfa","dsfsdfd"};
        for(int i=0; i<stringArray.length; i++){
            for(int j=0; j<stringArray[i].length(); j++){
                stringArray[i].charAt(j);
            }
        }

        //arraylist
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("fawefwae");
        arrayList.add("fawefwae1");
        arrayList.add("fawefwae2");
        arrayList.add("fawefwae3");
        arrayList.add("fawefwae4");
        arrayList.add("fawefwae5");

        for(int i=0; i<arrayList.size(); i++){
            arrayList.get(i);
            Log.d("print arrray list","listerine:" + arrayList.get(i));
        }




        HashMap<Character,Integer> substring = new HashMap<Character, Integer>();
        substring.clear();

        List<String> countries = Arrays.asList("Germany", "Panama", "Australia", "US");


        //unsorted array
        int a[]=new int[5];
        a[0]=4;
        a[1]=5;
        a[2]=3;
        a[3]=1;
        a[4]=2;

        //bubble sort
        int[] result = bubbleSort(a);
        Log.d("bubble sort","output");
        printValues(result);

        //selection sort
        int[] result1 = selectionSort(a);
        Log.d("selection sort","output");
        printValues(result1);

        //merge sort

        arr[0]=4;
        arr[1]=5;
        arr[2]=6;
        arr[3]=1;
        arr[4]=2;
        mergeSort(arr, 0, arr.length);
        Log.d("merge sort","output");
        printValues(arr);


    }

    public void mergeSort(int a[], int l, int r){

        Log.d("berttest", "lopping");

        int m = (l+r)/2;

        if(m-l > 1){//split left
            mergeSort(a, l, m);
        }
        if(r-m > 1){//split right
            mergeSort(a, (int)m+1, r);
        }

        merge(a, l, m, r);

    }

    public void merge(int a[], int l, int m, int r){
        int Lsize = m-l+1;
        int Rsize = r-m;

        int L[] = new int[Lsize];
        int R[] = new int[Rsize];

        //create left array
        for(int i=0; i<L.length; i++){
            L[i] = a[l+i];
        }
        //create right array
        for(int i=0; i<R.length; i++){
            R[i] = a[m+i];
        }

        int lc = 0;
        int rc = 0;
        int index = l;  //initial index of merged subarray

        while(lc < L.length && rc < R.length){
            if(L[lc] < R[rc]){
                a[index] = L[lc];
                lc++;
            }
            else{
                a[index] = R[rc];
                rc++;
            }
            index++;
            Log.d("berttest", "lopping1");
        }

        while(lc+1 < L.length){
            a[index] = L[lc];
            lc++;
            index++;
        }
        while(rc+1 < R.length){
            a[index] = R[rc];
            rc++;
            index++;
        }
    }

    public void printValues(int a[]){
        for(int i=0; i<a.length; i++){
            Log.d("print values", "" + a[i]);
        }
    }

    public int[] selectionSort(int a[]){ // find smallest value and swap with first element, find second smallest value swap with 2nd element, etc
        Integer smallestIndex = null; //using Integer instead of int so I can set value to null
        for(int i=0; i<a.length; i++){
            smallestIndex = null;
            for(int j=i; j<a.length; j++){
                if(smallestIndex == null){
                    smallestIndex = j;
                }
                if(a[j] < a[smallestIndex]){
                    smallestIndex = j;
                }
            }
            //swap next smallest value with next index
            int temp = a[i];
            a[i] = a[smallestIndex];
            a[smallestIndex] = temp;
        }
        return a;
    }

    public int[] bubbleSort(int a[]){
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a.length - 1; j++){
                if(a[j] > a[j+1]){ //swap
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        return a;
    }


}
