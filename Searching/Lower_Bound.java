package Searching;

public class Lower_Bound {

    public int lowerBound(int[] arr,int length,int value){

        int low=0;
        int high=length;
        while (low<high){
            int mid=(low+high)/2;
            if(value<=arr[mid])
                high=mid;
            else
                low=mid+1;
        }

        return low;
    }
}
