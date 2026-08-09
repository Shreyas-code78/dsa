class Solution {
    
    public int rob(int[] nums){
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
    int nums1[]=new int [n];
     int nums2[]=new int [n];
     int j=0;
     for(int i=0;i<n;i++){
        if(i!=0){
            nums1[j++]=nums[i];
        }
     }
      int k=0;
     for(int i=0;i<n;i++){
        if(i!=n-1){
            nums2[k++]=nums[i];
        }
     }
     return Math.max(roblinear(nums1),roblinear(nums2));
    }
    public int roblinear(int[] nums) {
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

