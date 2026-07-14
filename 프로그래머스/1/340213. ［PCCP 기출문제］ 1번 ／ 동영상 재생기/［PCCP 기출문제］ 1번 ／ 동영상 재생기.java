class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int totalTime = convertToSecond(video_len);
        int current = convertToSecond(pos);
        int opEnd = convertToSecond(op_end);
        
        if(current >= convertToSecond(op_start) && current < opEnd) {
            current = opEnd;
        }
        
        int pivot = 0;
        while(pivot != commands.length) {    
            if(commands[pivot].equals("next")) {
                
                current += 10;
                if(current > totalTime) {
                    current = totalTime;
                }
            } else {
                current -= 10;
                if(current < 0) {
                    current = 0;
                }
            }
            
            if(current >= convertToSecond(op_start) && current < opEnd) {
                current = opEnd;
            }
            pivot++;
        }

        int min = current / 60;
        int sec = current % 60;
        
        return String.format("%02d:%02d", min, sec);
    }
    
    public int convertToSecond(String t) {
        return 60 * Integer.parseInt(t.substring(0,2)) + Integer.parseInt(t.substring(3,5));
    }
}