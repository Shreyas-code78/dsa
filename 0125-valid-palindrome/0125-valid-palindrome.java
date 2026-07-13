class Solution {
    public boolean isPalindrome(String s) {
        int n=s.length();
        return checkpal(0,n-1,s);
        
    }
    private boolean checkpal(int start,int end,String s){
        
         while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
            start++;
        }
        while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
            end--;
        } 
         if(start>=end){
            return true;

        }
        if (Character.toLowerCase(s.charAt(start)) !=
            Character.toLowerCase(s.charAt(end))) {
            return false;
        }
       
       
         return checkpal(start+1,end-1,s);
    
        
        

    }
}