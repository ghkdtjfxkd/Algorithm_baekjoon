class Solution {
    public String solution(String s) {
        String[] sp = s.split(" ", -1);
        
        for(int i = 0; i < sp.length; i++) {
            String cur = sp[i];
            
            if (cur.isEmpty()) continue;
            
            sp[i] = cur.substring(0, 1).toUpperCase() + cur.substring(1).toLowerCase();
        }
        
        return String.join(" ", sp);
    }
}