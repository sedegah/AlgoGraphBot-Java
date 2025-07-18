import java.util.*;

public class AlgoSelector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Algorithm Selector!");
        System.out.println("Do you want to use a SEARCHING or SORTING algorithm?");
        String choice = scanner.nextLine().trim().toLowerCase();

        System.out.println("Enter the number of elements in your array:");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        if (choice.equals("searching")) {
            System.out.println("Select a searching algorithm:");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            int algoChoice = scanner.nextInt();
            System.out.println("Enter the value to search for:");
            int target = scanner.nextInt();

            if (algoChoice == 1) {
                System.out.println("\nDefinition: Linear Search checks each element sequentially.");
                int index = Searching.linearSearch(array, target);
                System.out.println("Result: Element " + target + (index == -1 ? " not found." : " found at index " + index));
            } else if (algoChoice == 2) {
                Arrays.sort(array); // Ensure sorted for binary search
                System.out.println("\nDefinition: Binary Search splits the array and searches efficiently.");
                int index = Searching.binarySearch(array, target);
                System.out.println("Result: Element " + target + (index == -1 ? " not found." : " found at index " + index));
            }
        } else if (choice.equals("sorting")) {
            System.out.println("Select a sorting algorithm:");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Selection Sort");
            System.out.println("3. Insertion Sort");
            System.out.println("4. Merge Sort");
            System.out.println("5. Quick Sort");
            int algoChoice = scanner.nextInt();

            System.out.println("\nOriginal Array: " + Arrays.toString(array));
            switch (algoChoice) {
                case 1 -> {
                    System.out.println("Definition: Bubble Sort repeatedly swaps adjacent elements to 'bubble' the largest to the end.");
                    Sorting.bubbleSort(array);
                }
                case 2 -> {
                    System.out.println("Definition: Selection Sort finds the minimum and swaps it with the front repeatedly.");
                    Sorting.selectionSort(array);
                }
                case 3 -> {
                    System.out.println("Definition: Insertion Sort builds a sorted portion by inserting elements in order.");
                    Sorting.insertionSort(array);
                }
                case 4 -> {
                    System.out.println("Definition: Merge Sort divides the array recursively and merges sorted halves.");
                    Sorting.mergeSort(array, 0, array.length - 1);
                }
                case 5 -> {
                    System.out.println("Definition: Quick Sort partitions the array and sorts parts recursively.");
                    Sorting.quickSort(array, 0, array.length - 1);
                }
                default -> System.out.println("Invalid option.");
            }
            System.out.println("Sorted Array: " + Arrays.toString(array));
        } else {
            System.out.println("Invalid choice. Please enter either 'searching' or 'sorting'.");
        }

        scanner.close();
    }
}
