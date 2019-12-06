package Searching;

import java.util.ArrayList;

class ListBinarySearch  {

    public int lowerBound(ArrayList<Integer> list, int length, int value){
        int low=0;
        int high=length;
        while (low<high){
            int mid=(low+high)/2;
            if(value<=list.get(mid))
                high=mid;
            else
                low=mid+1;
        }
        return low;
    }

    public int upperBound(ArrayList<Integer> list,int length,int value){
        int low=0;
        int high=length+1;
        while (low<high){
            int mid=(low+high)/2;
            if(value>=list.get(mid))
                low=mid+1;
            else
                high=mid;
        }
        return low;
    }

    public int binarySearch(ArrayList<Integer> list,int length,int value){
        int low=0;
        int high=length;
        while (low<=high){
            int mid=(low+high)/2;
            if(value==list.get(mid))
                return mid;
            else if(value>list.get(mid))
                high=mid-1;
            else
                low=mid+1;
        }
        return low;
    }

    public int lowerBound(ArrayList<Long> list,int length,long value){
        int low=0;
        int high=length;
        while (low<high){
            int mid=(low+high)/2;
            if(value<=list.get(mid))
                high=mid;
            else
                low=mid+1;
        }
        return low;
    }

    public int upperBound(ArrayList<Long> list,int length,long value){
        int low=0;
        int high=length+1;
        while (low<high){
            int mid=(low+high)/2;
            if(value>=list.get(mid))
                low=mid+1;
            else
                high=mid;
        }
        return low;
    }

    public int binarySearch(ArrayList<Long> list,int length,long value){
        int low=0;
        int high=length;
        while (low<=high){
            int mid=(low+high)/2;
            if(value==list.get(mid))
                return mid;
            else if(value>list.get(mid))
                high=mid-1;
            else
                low=mid+1;
        }
        return low;
    }

}