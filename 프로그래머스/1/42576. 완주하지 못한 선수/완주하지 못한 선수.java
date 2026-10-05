import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map<String, Integer> racer = new HashMap<>();
        
        for(String name : participant) {
            racer.put(name, racer.getOrDefault(name, 0) + 1);
        }
        
        for(String name : completion) {
            racer.replace(name, racer.get(name) - 1);
        }

        return racer.keySet().stream().filter(n -> racer.get(n) > 0).findFirst().get();
    }
}