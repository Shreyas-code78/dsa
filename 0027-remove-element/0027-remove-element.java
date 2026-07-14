class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int k=0;
        int i=0;
        int j=0;


    for(i=0;i<nums.length;i++){

  
 if(nums[i]==val){
    continue;
 }
 else{
  
    nums[j]=nums[i];
    j++;
    k++;
 }

}
       
 
       return k;
    
    }
}