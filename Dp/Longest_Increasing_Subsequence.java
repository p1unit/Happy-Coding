package Dp;

import java.util.Arrays;

public class Longest_Increasing_Subsequence {

    public int lis(int []arr){
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int ans=1;
        for(int i=0;i<n;i++){
            ans=Math.max(dp[i],ans);
        }

        return ans;
    }
}
