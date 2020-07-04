package Graph_and_Tree;

import java.util.Scanner;

public class SegmentTree {

    public static void main(String[] args) {
        SegmentTree s=new SegmentTree();
        s.main1();
    }

    void main1(){

        Scanner in=new Scanner(System.in);

        int n=in.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }

        int segarr[]=new int[4*n];

        build(arr,segarr,0,n-1,0);

        int q=in.nextInt();
        while (q-->0){

            int t=in.nextInt(),l=in.nextInt(),r=in.nextInt();

            if(t==1){
                update(segarr,0,n-1,0,l,r);
            }
            if(t==0){
                System.out.println(query(segarr,0,n-1,l,r,0));
            }
        }

    }

    void build(int arr[],int segarr[],int start,int end,int idx){

        if(start==end){
            segarr[idx]=arr[start];
            return;
        }

        int mid=(start+end)/2;
        build(arr,segarr,start,mid,2*idx+1);
        build(arr,segarr,mid+1,end,2*idx+2);

        segarr[idx]=Math.min(segarr[2*idx+1],segarr[2*idx+2]);
    }

    int query(int segarr[],int start,int end,int l,int r,int idx){


        if(l<=start && end<=r)
            return segarr[idx];

        if(l>end || r<start){
            return Integer.MAX_VALUE;
        }

        int mid=(start+end)/2;
        return  Math.min(query(segarr,start,mid,l,r,2*idx+1),query(segarr,mid+1,end,l,r,2*idx+2));
    }

    void update(int segarr[],int start,int end,int idx,int n,int val){

        if(start==end){
            segarr[idx]=val;
            return;
        }

        int mid=(start+end)/2;
        if(n<=mid)
            update(segarr,start,mid,2*idx+1,n,val);
        else
            update(segarr,mid+1,end,2*idx+2,n,val);

        segarr[idx]=Math.min(segarr[2*idx+1],segarr[2*idx+2]);
    }
}
