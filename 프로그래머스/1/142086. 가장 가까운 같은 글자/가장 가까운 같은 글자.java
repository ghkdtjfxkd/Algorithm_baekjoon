import java.util.*; 
class Solution {
    public int[] solution(String s) {
        Map<Character, Integer> lastIdx = new HashMap<>();
        List<Integer> op = new ArrayList<>();
        char[] ch = s.toCharArray();
        
        for(int i = 0; i < ch.length; i++) {
            if(!lastIdx.containsKey(ch[i])) {
                op.add(-1);
            } else {
                op.add(i - lastIdx.get(ch[i]));
            }
            
            lastIdx.put(ch[i], i); 
        }
        
        return op.stream().mapToInt(Integer::intValue).toArray();
    }
}