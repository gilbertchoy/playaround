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
    private int arr[]; //used for merge sort
    private int ar[]; //used for quick sort
    private int ar1[]; //used for heap sort

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String st = "asdf";

        st.length();



        Car car = new Car();
        car.numDoors = 4;

        Car car1 = new Car();
        car1.numDoors = 5;

        Car.numDoors = 6;

        Log.d("berttest", "num doors:" + car.numDoors);

        Log.d("berrtest", "getSpeed:" + Car.getSpeed());
        Log.d("berrtest", "getSpeed:" + car.getSpeed());


        //hashmap
        Map<String, Integer> map = new HashMap<>();
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
        ArrayList<String> arrayList = new ArrayList<>();
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

        //bubble sort - go through array n times, compare values adjacent values, if left not smaller than right, then swap
        int[] result = bubbleSort(a);
        Log.d("bubble sort","output");
        printValues(result);

        //selection sort - find smallest value and swap with first element, find second smallest value swap with 2nd element, etc
        int[] result1 = selectionSort(a);
        Log.d("selection sort","output");
        printValues(result1);

        /*merge sort - keep dividing array into halves by dividing by 2 until all arrays have 1 element.  Merge smallest
        arrays together based on value, then keep merging larger arrays together until have fully sorted array.
        Big O = nlogn*/
        arr  = new int[9];
        arr[0]=8;
        arr[1]=5;
        arr[2]=6;
        arr[3]=2;
        arr[4]=3;
        arr[5]=9;
        arr[6]=1;
        arr[7]=10;
        arr[8]=4;
        mergeSort(0,arr.length-1);
        Log.d("merge sort","output");
        printValues(arr);

        /*quick sort - make right most element as pivot, put all values smaller than pivot to left,
        put all values larger than value to right.  Repeat left and right halves until sorted. Big O = n^2*/
        ar = new int[8];
        ar[0]=6;
        ar[1]=1;
        ar[2]=2;
        ar[3]=5;
        ar[4]=8;
        ar[5]=9;
        ar[6]=7;
        ar[7]=10;
        quickSort(0,ar.length-1);
        Log.d("quick sort", "output");
        printValues(ar);

        /*heap sort - create heap data structure, cycle through number of elements and take out root node
        while heapifying the rest of the elements */
        ar1 = new int[8];
        ar1[0]=6;
        ar1[1]=11;
        ar1[2]=2;
        ar1[3]=5;
        ar1[4]=8;
        ar1[5]=9;
        ar1[6]=7;
        ar1[7]=10;
        heapSort();
        Log.d("heap sort", "output");
        printValues(ar1);

        /* binary search - in sorted array search of specific value by starting in the middle and keep searching
        lower or upper halves til value is found*/
        int[] ar2 = new int[5];
        ar2[0]=1;
        ar2[1]=2;
        ar2[2]=3;
        ar2[3]=4;
        ar2[4]=5;
        int result2 = binarySearch(ar2, 0, ar2.length, 3);
        Log.d("binary search result:", " index of target element - " + result2);

    }

    public void heapSort(){
        int n = ar1.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(n, i);
        }

        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = ar1[0];
            ar1[0] = ar1[i];
            ar1[i] = temp;

            // call max heapify on the reduced heap
            heapify( i,0);
        }
    }

    public void heapify(int n, int i){
        int largest = i;
        int l = 2*i+1;
        int r = 2*i+2;

        if(l<n && ar1[l]>ar1[largest]){
            largest = l;
        }

        if(r<n && ar1[r]>ar1[largest]){
            largest = r;
        }

        if(largest != i){
            int swap = ar1[i];
            ar1[i] = ar1[largest];
            ar1[largest] = swap;

            heapify(n,largest);
        }

    }

    public void quickSort(int low, int high){
        if(low<high){
            int mid = partition(low, high);
            quickSort(low, mid-1);
            quickSort(mid+1,high);
        }
    }

    public int partition(int low, int high){  //part of quick sort
        int pivot = ar[high];

        int i = low; //current index of smaller array
        for(int j=i; j<high; j++){
            if(ar[j] <= pivot){
                //swap
                int temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
                i++;
            }
        }
        //swap 1st element with pivot position
        int temp = ar[high];
        ar[high] = ar[i];
        ar[i] = temp;
        return i;
    }

    public void mergeSort(int l, int r){
        int m = (l+r)/2;

        if(l<r) {
            mergeSort(l, m);
            mergeSort( m + 1, r);
            merge(l, m, r);
        }
    }

    public void merge(int l, int m, int r){  //part of merge sort
        int Lsize = m-l+1;
        int Rsize = r-m;

        int L[] = new int[Lsize];
        int R[] = new int[Rsize];

        //create left array
        for(int i=0; i<L.length; i++){
            L[i] = arr[l+i];
        }
        //create right array
        for(int i=0; i<R.length; i++){
            R[i] = arr[m+1+i];
        }

        int lc = 0;
        int rc = 0;
        int index = l;  //initial index of merged subarray

        while(lc < L.length && rc < R.length){
            if(L[lc] < R[rc]){
                arr[index] = L[lc];
                lc++;
            }
            else{
                arr[index] = R[rc];
                rc++;
            }
            index++;
        }

        while(lc < L.length){
            arr[index] = L[lc];
            lc++;
            index++;
        }
        while(rc < R.length){
            arr[index] = R[rc];
            rc++;
            index++;
        }
    }

    public void printValues(int a[]){
        for(int i=0; i<a.length; i++){
            Log.d("print values", "" + a[i]);
        }
    }

    public int[] selectionSort(int a[]){
        for(int i=0; i<a.length; i++){
            Integer smallestIndex = null; //using Integer instead of int so I can set value to null
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

    public int binarySearch(int a[], int l, int r, int target){
        if(r >= l){
            int mid = l + (r-l)/2;

            if(a[mid] == target){  //if target is found then return found element
                return mid;
            }

            if(a[mid] < target){  //if target is greater than mid the search upper half
                return binarySearch(a,mid+1, r, target);
            }
            else{  //if target is less than mid the search lower half
                return binarySearch(a,l,mid-1, target);
            }
        }
        //if int not in array then return -1
        return -1;
    }

}
