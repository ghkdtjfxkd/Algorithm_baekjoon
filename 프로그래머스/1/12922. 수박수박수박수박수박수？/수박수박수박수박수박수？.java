class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        
        char[] ch = new char[n];
        ch[0] = '수';
        
        for(int i = 1; i < n; i++) {
            if(ch[i - 1] == '수') {
                ch[i] = '박';
                continue;
            } 
            
            if(ch[i - 1] == '박') {
                ch[i] = '수';
            }
        }
        
        return String.valueOf(ch);
    }
}