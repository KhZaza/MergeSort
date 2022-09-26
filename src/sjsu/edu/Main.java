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

        // n : the length of the array
        int n = high-low+1;

        //temporary array
        int[] tempArray = new int[n];

        //left is the first index
        int left = low;
        //right is the last index
        int right = middle+1;
        //temporary index
        int tempIndex = 0;

        //while loop to loop until the right and left index are done
        while(left <= middle && right <= high){
            // if the first index is less than the last index to copy it to the temparray otherwise copy the last index
            if (a[left] <= a[right])
                tempArray[tempIndex++] = a[left++];
            else
            tempArray[tempIndex++] = a[right++];

        }

        //while there is something left on the left side to copy it to the temp array
        while(left <= middle) {
            tempArray[tempIndex++] =a[left++];

        }
        //while there is something left on the right side to copy it to the temp array
        while (right <= high){
            tempArray[tempIndex++]= a[right++];
        }

        //for loop to copy the temp array into the original array
        for(int k =0; k<n; k++)
            a[low+k] = tempArray[k];

        // Delete the temp array, to free up space.
        tempArray = null;


    }

    //merge sort
    public static void mergeSort(int[] a, int low, int high){

        //if there is still more than one index in the array
        if (low< high){

            //middle is hte mid index in the array,
            int mid = (low+ high) / 2 ;


            //recursion to the left side
            mergeSort(a, low, mid);
            //recursion to the right side
            mergeSort(a, mid+1, high);
            //merge the index back
            merge(a, low, mid, high);
        }


    }



}
