package MostAskedQue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static int KthLargest(int[] arr, int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
       /* What is the difference between peek(), poll() and remove() method of the Queue interface?
        Both poll() and remove() method is used to remove head object of the Queue.
        The main difference lies when the Queue is empty().
         If Queue is empty then poll() method will return null .
         While in similar case , remove() method will throw NoSuchElementException .
         peek() method retrieves but does not remove the head of the Queue.
         If queue is empty then peek() method also returns null.
        */
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.poll();
    }

    //Method 2
    public static int KthLargest_By_Sorting(int[] arr, int k){
        Arrays.sort(arr);
        return arr[arr.length-k];
    }
    public static void main(String[] args) {
       // LeetCode:  215. Kth Largest Element in an Array
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(KthLargest(nums,k));
        System.out.println(KthLargest_By_Sorting(nums,k));

    }

}
