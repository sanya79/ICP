class Solution {
    public int rob(int[] arr){
        int [] dp=new int[arr.length];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        return(rob1(arr,0,dp));
    }
    public int rob1(int[] arr,int i,int [] dp) {
        if(i>=arr.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int rob=arr[i]+ rob1(arr,i+2,dp);
        int not_rob=rob1(arr,i+1,dp);
        return dp[i]=Math.max(rob,not_rob);
    }
}
