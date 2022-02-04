package Sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SelectionSort {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter No. of Elements");
        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];
        System.out.println("Enter " + n + " Elements");
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(br.readLine());

        int min;
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            min = i;
            for (int j = i + 1; j < n; j++)
                if (a[j] < a[min])
                    min = j;

            // Swap the found minimum element with the first element
            if (a[min] < a[i]) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }

        System.out.println("After Sorting Array is Elements Are:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + "\t");
        }
    }
}
