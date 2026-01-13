import java.util.*;

class Solution {
    static Area[][] island;
    static Integer col;
    static Integer row;

    
    public List<Integer> solution(String[] maps) {
        List<Integer> result = new ArrayList<>();
        col = maps.length;
        row = maps[0].length();
        
        island = new Area[col][row];
        
        for(int i = 0; i < col; i++) {
            String[] split = maps[i].split("");
            
            for(int j = 0; j < row; j++) {
                if(split[j].equals("X")) {
                    island[i][j] = new Area(-1); 
                } else {
                    island[i][j] = new Area(Integer.parseInt(split[j]));
                }
            }
        }
        
        
        for(int i = 0; i < col; i++) {
            for(int j = 0; j < row; j++) {
                
                int foodValue = searchFood(i,j);
                
                if(foodValue != 0) {
                    result.add(foodValue);
                }
            }
        }
        
        if(result.isEmpty()) {
            result.add(-1);
        }
        
        Collections.sort(result);
        return result;
    } 
    
    int searchFood (int c , int r) {
        
        if(c < 0 || r < 0 || c >= col || r  >= row) {
            return 0;
        } 
        
        Area area = island[c][r];
        
        if(area.value == -1 || area.visited) {
            return 0;
        } 
            
        area.visited = true;
            
            
        return area.value 
            + searchFood(c + 1, r)
            + searchFood(c - 1, r) 
            + searchFood(c, r + 1) 
            + searchFood(c, r - 1);
    }    
}


class Area {
    
    public Integer value;
    public boolean visited;
    
    public Area(int value) {
        this.value = value;
        this.visited =false;
    }
}
