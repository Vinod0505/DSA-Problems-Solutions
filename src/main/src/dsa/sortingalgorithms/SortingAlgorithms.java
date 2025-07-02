package dsa.sortingalgorithms;

public class SortingAlgorithms {

    /**
     * Bubble Sort Algorithm
     * ---------------------
     * Time Complexity: O(n^2)
     * Description: Repeatedly compares adjacent elements and swaps them if they are in the wrong order.
     * After each outer loop, the largest unsorted element "bubbles up" to its correct position.
     *
     * @param arr Input array to be sorted
     * @return Sorted array in ascending order
     */
    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // Last i elements are already sorted
            for (int j = 0; j < arr.length - i - 1; j++) {
                // Swap if current element is greater than next
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * Selection Sort Algorithm
     * ------------------------
     * Time Complexity: O(n^2)
     * Description: Finds the minimum element in the unsorted part of the array and places it at the beginning.
     *
     * @param arr Input array to be sorted
     * @return Sorted array in ascending order
     */
    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;

            // Find the index of the minimum element in the remaining unsorted array
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the element at index i
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    /**
     * Insertion Sort Algorithm
     * ------------------------
     * Time Complexity: O(n^2)
     * Description: Builds the sorted array one element at a time by inserting each new element into its correct position.
     *
     * @param arr Input array to be sorted
     * @return Sorted array in ascending order
     */
    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];         // Element to be inserted
            int j = i - 1;

            // Move elements of arr[0...i-1] that are greater than key one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];  // Shift element to right
                j--;
            }

            arr[j + 1] = key;         // Insert key in the correct position
        }
        return arr;
    }


    public static void printArray(String sortType, int[] arr) {
        System.out.println(sortType + ":");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 1, 6, 8};

        int[] bubbleSorted = bubbleSort(arr.clone());
        int[] selectionSorted = selectionSort(arr.clone());
        int[] insertionSorted = insertionSort(arr.clone());

        printArray("Bubble Sort", bubbleSorted);
        printArray("Selection Sort", selectionSorted);
        printArray("Insertion Sort", insertionSorted);

    }

}
