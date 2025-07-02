package dsa.sortingalgorithms;

public class QuickSort {


    //Quick sort moves smaller element to left of a pivot
    //recursively divides array in 2 partitions

    //Time Complexity : Best  and Average case O(n log(n)) , worst case: O(n^2)

    private static void quickSort(int[] arr, int start, int end) {

        if(end<=start) return;
        int pivot = partition(arr,start,end);
        quickSort(arr,start,pivot-1);
        quickSort(arr,pivot+1, end);
    }

    private static int partition(int[] arr, int start, int end) {

        int pivot = arr[end];
        int i = start-1;

        for(int j = start;j<=end-1;j++){

            if (arr[j]< pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] =temp;
            }
        }

        i++;
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] =temp;
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {5,4,1,3,2,6,9,8};

        quickSort(arr,0,arr.length-1);

        for(int a : arr){
            System.out.print(a+" ");
        }
    }
}
