class Solution {
    public int[] sortedSquares(int[] nums) {
        int n =nums.length;
        int i = 0;
        int p = 0 , k = 0;
        int[] pos = new int [n];
        int[] nag = new int [n];
        while(i<n){
            if(nums[i]>=0){
                pos[p]=nums[i];
                p++;
                
            }else{
                nag[k]=nums[i];
                k++;
                
            }
            i++;
        }
        for(i=0;i<k;i++){
            nag[i] = nag[i]*nag[i];
        }
        for(i=0 ; i<p;i++){
            pos[i] = pos[i]*pos[i];
        }
        Arrays.sort(nag, 0, k);
        int[] res = new int[n];
        int a = 0, b = 0, x = 0;

        while (a < k && b < p) {
            if (nag[a] < pos[b]) {
                res[x++] = nag[a++];
            } else {
                res[x++] = pos[b++];
            }
        }

        while (a < k) {
            res[x++] = nag[a++];
        }

        while (b < p) {
            res[x++] = pos[b++];
        }

        return res;
    }
}