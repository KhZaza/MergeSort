package sjsu.edu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Merge Sort");

        //open the file as a scanner
        Scanner scanner = new Scanner(new File("src/sjsu/edu/MyList-3.txt"));

        //Create an array to store the integers
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        //while loop to add the integers to the array
        while(scanner.hasNextInt()){
            arr2.add(scanner.nextInt());
        }



        //size of the array
        int size = arr2.size();

        int[] intArray = new int[size];
        for (int i = 0; i < size; i++)
            intArray[i] = arr2.get(i);



        //print the unsorted array
        System.out.println("Unsorted: " + Arrays.toString(intArray));


        //mergeSort
        mergeSort(intArray, 0, size-1);

        //print the sorted array
        System.out.println("Sorted: " + Arrays.toString(intArray));





    }




    public static void merge (int[] a, int low, int middle, int high) {
        int n = high-low+1;
        int[] tempArray = new int[n];

        int left = low;
        int right = middle+1;
        int tempIndex = 0;

        while(left <= middle && right <= high){
            if (a[left] <= a[right])
                tempArray[tempIndex++] = a[left++];
            else
            tempArray[tempIndex++] = a[right++];

        }

        while(left <= middle) {
            tempArray[tempIndex++] =a[left++];

        }
        while (right <= high){
            tempArray[tempIndex++]= a[right++];
        }

        for(int k =0; k<n; k++)
            a[low+k] = tempArray[k];


        tempArray = null;


    }


    public static void mergeSort(int a[], int low, int high){
        if (low< high){


            int mid = (low+ high) / 2 ;


            mergeSort(a, low, mid);
            mergeSort(a, mid+1, high);
            merge(a, low, mid, high);
        }


    }



}
