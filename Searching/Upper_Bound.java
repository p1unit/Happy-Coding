package Searching;

public class Upper_Bound {

    public static int upperBound(int[] arr,int length,int value){

        int low=0;
        int high=length+1;

        while (low<high){
            int mid=(low+high)/2;
            if(value>=arr[mid])
                low=mid+1;
            else
                high=mid;
        }

        return low;
    }
}
    