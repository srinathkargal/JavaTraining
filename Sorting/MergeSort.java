package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort {

    static void merge(int a[], int beg, int mid, int end) {
        int i, j, k;
        int n1 = mid - beg + 1;
        int n2 = end - mid;

        /* temporary Arrays */
        int LeftArray[] = new int[n1];
        int RightArray[] = new int[n2];

        /* copy data to temp arrays */
        for (i = 0; i < n1; i++)
            LeftArray[i] = a[beg + i];
        for (j = 0; j < n2; j++)
            RightArray[j] = a[mid + 1 + j];

        i = 0; /* initial index of first sub-array */
        j = 0; /* initial index of second sub-array */
        k = beg; /* initial index of merged sub-array */

        while (i < n1 && j < n2) {
            if (LeftArray[i] <= RightArray[j]) {
                a[k] = LeftArray[i];
                i++;
            } else {
                a[k] = RightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            a[k++] = LeftArray[i++];
        }

        while (j < n2) {
            a[k++] = RightArray[j++];
        }
    }

    static void mergeSort(int a[], int beg, int end) {
        if (beg < end) {
            int mid = (beg + end) / 2;
            mergeSort(a, beg, mid);
            mergeSort(a, mid + 1, end);
            merge(a, beg, mid, end);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter No. of Elements");
        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];
        System.out.println("Enter " + n + " Elements");
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(br.readLine());
        mergeSort(a, 0, n - 1);
        System.out.println("After Sorting Array is Elements Are:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + "\t");
        }
    }
}
