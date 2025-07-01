package dsa.searchingalgorithms;

public class SearchingAlgorithm {

    /**
     * This method takes list of items as array and the element to be found in the array as target.
     * It iterates over the array and finds the target element, if found it returns the index position of target
     * else it returns (-1)  */
    //This method we can use even in case of unsorted array, as it iterates whole array
    //Linear Search
    //Time complexity O(n)
    public static int linearSearch(int[] arr,int target){

        for(int i =0;i<arr.length;i++){
            if(arr[i]==target){
                return i; // return the index of the target element
            }
        }
        return -1;
    }

    /**
     * This method is used to find the element in an array where the array should be Sorted array.
     * Doesn't work for Unsorted array
     * This method divides the array into two parts
     * and checks if the mid-element of an array is equal to target element
     * if found it returns the index of mid-element or else if the target element is greater than mid-element
     * it shifts the starting point to mid or else if target is less than mid-element
     * it shifts the end point to mid
     * */
    //Binary Search
    //Time complexity O(log n)
    public static int binarySearch(int[] arr,int target){

        int start = 0;
        int end = arr.length-1;

        while(start<=end){

            int mid = (start+end)/2;

            if(arr[mid]==target){
                return mid;
            }else if(target>arr[mid]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return -1;
    }

    public static void main(String[] args){

        int[] arr = {2,3,4,5,6,7,8,9};

        int target = 7;

        int linearSearch = linearSearch(arr,target);
        int binarySearch =  binarySearch(arr,target);

        System.out.println("LinearSearch : [Element found at index: "+linearSearch+" and the value is ] :"+arr[linearSearch]);
        System.out.println("BinarySearch : [Element found at index: "+binarySearch+" and the value is ] :"+arr[binarySearch]);

    }
}
