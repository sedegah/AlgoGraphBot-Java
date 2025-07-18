package com.algograph;
import java.util.Arrays;

public class Sorting {

    public static void bubbleSort(int[] arr) {
        System.out.println("Definition: Bubble Sort compares adjacent elements and swaps them until sorted.");
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            System.out.println("Pass " + (i + 1));
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("Comparing " + arr[j] + " and " + arr[j + 1]);
                if (arr[j] > arr[j + 1]) {
                    System.out.println(" => Swapping");
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                } else {
                    System.out.println(" => No swap");
                }
            }
            System.out.println("Array now: " + Arrays.toString(arr));
        }
    }

    public static void selectionSort(int[] arr) {
        System.out.println("Definition: Selection Sort selects the smallest element and places it in order.");
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            System.out.println("Swapping " + arr[i] + " and " + arr[minIdx]);
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
            System.out.println("Array after iteration " + (i + 1) + ": " + Arrays.toString(arr));
        }
    }

    public static void insertionSort(int[] arr) {
        System.out.println("Definition: Insertion Sort builds the sorted array one item at a time.");
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            System.out.println("Inserting " + key);
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
                System.out.println("Shifted " + arr[j + 1]);
            }
            arr[j + 1] = key;
            System.out.println("Inserted at position " + (j + 1) + ": " + Arrays.toString(arr));
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left == 0 && right == arr.length - 1) {
            System.out.println("Definition: Merge Sort divides the array and merges sorted halves.");
        }
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] leftArr = new int[mid - left + 1];
        int[] rightArr = new int[right - mid];
        System.arraycopy(arr, left, leftArr, 0, leftArr.length);
        System.arraycopy(arr, mid + 1, rightArr, 0, rightArr.length);
        System.out.println("Merging: " + Arrays.toString(leftArr) + " and " + Arrays.toString(rightArr));

        int i = 0, j = 0, k = left;
        while (i < leftArr.length && j < rightArr.length) {
            arr[k++] = (leftArr[i] <= rightArr[j]) ? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length)
            arr[k++] = leftArr[i++];
        while (j < rightArr.length)
            arr[k++] = rightArr[j++];
        System.out.println("Merged into: " + Arrays.toString(Arrays.copyOfRange(arr, left, right + 1)));
    }

    public static void quickSort(int[] arr, int low, int high) {
        quickSort(arr, low, high, 0);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high, int depth) {
        String indent = " ".repeat(depth * 2);
        if (low == 0 && high == arr.length - 1 && depth == 0) {
            System.out.println("Definition: Quick Sort partitions the array and sorts parts recursively.");
        }

        if (low < high) {
            int pi = partition(arr, low, high, indent);
            System.out.println(indent + "Pivot at index " + pi + ": " + arr[pi]);
            quickSort(arr, low, pi - 1, depth + 1);
            quickSort(arr, pi + 1, high, depth + 1);
        }
    }

    private static int partition(int[] arr, int low, int high, String indent) {
        int pivot = arr[high];
        System.out.println(indent + "Pivot: " + pivot);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            System.out.print(indent + "Comparing " + arr[j] + " with pivot " + pivot);
            if (arr[j] < pivot) {
                i++;
                System.out.println(" => Swapping " + arr[i] + " and " + arr[j]);
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            } else {
                System.out.println(" => No swap");
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        System.out.println(indent + "Final pivot swap: " + Arrays.toString(arr));
        return i + 1;
    }
}
