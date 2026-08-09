class Solution {
    public boolean solution(String s) {
        int l = s.length();
        
        if(l != 4 && l != 6) {
            return false;
        }
                
        if(s.matches("^[0-9]+$")) return true;
        
        return false;
    }
}