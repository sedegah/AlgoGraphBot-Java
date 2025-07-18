package com.algograph;

import java.util.Arrays;

public class AlgoSelector {

    public static String handleTelegramSort(String msg) {
        // Example: /sort quick 4 2 5 1 3
        String[] parts = msg.split("\\s+");
        if (parts.length < 3) return " Usage: /sort <algorithm> <space-separated array>";

        String algo = parts[1].toLowerCase();
        int[] arr = Arrays.stream(Arrays.copyOfRange(parts, 2, parts.length)).mapToInt(Integer::parseInt).toArray();

        StringBuilder steps = new StringBuilder();
        switch (algo) {
            case "bubble" -> {
                steps.append(Sorting.getBubbleSortDefinition()).append("\n\n");
                Sorting.bubbleSort(arr, steps);
            }
            case "selection" -> {
                steps.append(Sorting.getSelectionSortDefinition()).append("\n\n");
                Sorting.selectionSort(arr, steps);
            }
            case "insertion" -> {
                steps.append(Sorting.getInsertionSortDefinition()).append("\n\n");
                Sorting.insertionSort(arr, steps);
            }
            case "merge" -> {
                steps.append(Sorting.getMergeSortDefinition()).append("\n\n");
                Sorting.mergeSort(arr, 0, arr.length - 1, steps);
            }
            case "quick" -> {
                steps.append(Sorting.getQuickSortDefinition()).append("\n\n");
                Sorting.quickSort(arr, 0, arr.length - 1, steps);
            }
            default -> steps.append(" Invalid sorting algorithm.");
        }
        steps.append("\n Sorted: ").append(Arrays.toString(arr));
        return steps.toString();
    }

    public static String handleTelegramSearch(String msg) {
        // Example: /search binary 4 2 5 1 3 5
        String[] parts = msg.split("\\s+");
        if (parts.length < 4) return " Usage: /search <linear|binary> <space-separated array> <target>";

        String algo = parts[1].toLowerCase();
        int[] arr = Arrays.stream(Arrays.copyOfRange(parts, 2, parts.length - 1)).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(parts[parts.length - 1]);

        StringBuilder steps = new StringBuilder();
        int result;

        switch (algo) {
            case "linear" -> {
                steps.append(Searching.getLinearSearchDefinition()).append("\n\n");
                result = Searching.linearSearch(arr, target, steps);
            }
            case "binary" -> {
                Arrays.sort(arr);  // binary search requires sorted
                steps.append(Searching.getBinarySearchDefinition()).append("\n\n");
                result = Searching.binarySearch(arr, target, steps);
            }
            default -> {
                return " Invalid searching algorithm.";
            }
        }

        if (result == -1) {
            steps.append("\n Value not found.");
        } else {
            steps.append("\n Found at index: ").append(result);
        }

        return steps.toString();
    }
}
