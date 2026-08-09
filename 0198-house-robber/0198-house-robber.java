class Solution {
    public int rob(int[] nums) {
        int n=  nums.length;


        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(nums, n-1,dp);

        
    }

    int solve(int [] arr , int n,int[] dp){
        if(n<0){
            return 0;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int rob =  arr[n] +solve(arr, n-2,dp);
        int notrob= solve(arr ,  n-1,dp);

        return dp[n]= Math.max(rob ,  notrob);
    }
}