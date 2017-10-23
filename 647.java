class Solution {
    public int countSubstrings(String s) {
        if(s == null) return 0;

        int count = s.length();

        for(int i=2;i<=s.length();i++){
            for(int j=0;(i+j)<=s.length();j++){
                count += isPalindromic(s.substring(j,j+i)) ? 1 : 0;
            }
        }
        return count;
    }

    private boolean isPalindromic(String s){
        int len = s.length()/2;
        for(int i=0;i<len;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)) return false;
        }
        return true;
    }
}