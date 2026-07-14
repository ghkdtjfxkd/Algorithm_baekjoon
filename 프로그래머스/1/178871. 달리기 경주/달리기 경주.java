import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> playerPositions = new HashMap<>();
        String[] current = new String[players.length];
        for(int i = 0; i < players.length; i++) {
            playerPositions.put(players[i], i);       
            current[i] = players[i];
        }
        
   
        for(String name : callings) {
            int prev = playerPositions.get(name) - 1;
            String prevPlayer = current[prev];
            
            playerPositions.replace(name,  playerPositions.get(name) - 1);
            playerPositions.replace(prevPlayer,  playerPositions.get(prevPlayer) + 1);
            
            current[prev] = name;
            current[prev+1] = prevPlayer;
        }
        
        return current;
    }
}