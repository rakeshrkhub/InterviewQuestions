package AquimoSports;


public class SmallestSubarray {
    //Method 1 to find Smallest SubArray containing sum of elements greater than target value
    //Time Complexity: O(N^2)
    // Space Complexity: O(N)
    public static void SmallestSubArrya_Method1(int[] arr,int x){
        int minLength=Integer.MAX_VALUE;
//Iterating each element of array and finding which continuous combination has sum>x(target value
        for(int i=0;i< arr.length;i++){
            int sum=0;
            for(int j=i;j< arr.length;j++){
                sum=sum+arr[j];
                if(sum>x){
                    minLength=Math.min(minLength,j-i+1);
                }
            }
        }
        System.out.println(minLength);
    }
    //Method 2: Two Pointer
    //Time Complexity: O(N^2)
    //Space Complexity: O(1)
    public static void SmallestSubArrya_Method2(int[] arr,int x){
        int i=0,j=0;
        int minLength=Integer.MAX_VALUE;
        int n= arr.length;
        int sum=0;
        while(i<=j && j<n){
            //Finding sum>target value
            while (sum<=x && j<n){
                sum=sum+arr[j];
                j++;
            }
            //After Finding sum>x
            //Now we will check it will fulfill the condition after subtracting ith element
            //if yes, will update minLength
            //length=j-i
            while(sum>x && i<j){
                minLength=Math.min(minLength,j-i);
                sum=sum-arr[i];
                i++;
            }
        }
        System.out.println(minLength);
    }
    public static void main(String[] args) {
        int[] arr={1,4,45,6,0,19};
        int x=51;
        SmallestSubArrya_Method1(arr,x);
        SmallestSubArrya_Method2(arr,x);

    }
}
