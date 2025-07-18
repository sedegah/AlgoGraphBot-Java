package com.algograph;
public class Searching {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Checking index " + i + ": value = " + arr[i]);
            if (arr[i] == target) {
                System.out.println("Match found at index " + i);
                return i;
            }
        }
        System.out.println("Target not found.");
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println("Checking middle index " + mid + ": value = " + arr[mid]);
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) {
                System.out.println("Searching right half");
                left = mid + 1;
            } else {
                System.out.println("Searching left half");
                right = mid - 1;
            }
        }
        System.out.println("Target not found.");
        return -1;
    }
}
