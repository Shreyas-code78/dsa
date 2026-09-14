class Solution {
    static void slove (String digits, String [] mapping ,int index ,List<String> result,StringBuilder output ){
        if(index >= digits.length()){
            result.add(output.toString());
            return ;
        }
        int value = digits.charAt(index) - '0';
        String mapString = mapping[value];

        for(int i =0 ; i<mapString.length (); i++){
            output.append(mapString.charAt(i));
            slove(digits, mapping, index+1 , result , output );
            output.deleteCharAt(output.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        String[] mapping = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList<>();
        int index = 0 ;
        StringBuilder output  = new StringBuilder();
        slove(digits , mapping , index , result, output);
        return result;
    }
}