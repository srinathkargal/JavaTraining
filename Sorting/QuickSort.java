package Sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class QuickSort {

    static void quickSort(int a[], int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is now at right place */
            int pi = partition(a, low, high);

            quickSort(a, low, pi - 1); // Before pi
            quickSort(a, pi + 1, high); // After pi
        }
    }

    static int partition(int a[], int low, int high) {
        // pivot (Element to be placed at right position)
        int pivot = a[high];

        // Index of smaller element; indicates the right position of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller than the pivot
            if (a[j] < pivot) {
                i++; // increment index of smaller element

                // Swap a[i] and a[j]
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        // Swap a[i+1] and a[high]
        int temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;
        return (i + 1);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter No. of Elements");
        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];
        System.out.println("Enter " + n + " Elements");
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(br.readLine());

        quickSort(a, 0, n - 1);

        System.out.println("After Sorting Array is Elements Are:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + "\t");
        }
    }
}