import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        List<Signal> sigs = new ArrayList<>();
        
        int maxLimitTime = 1;
        
        for(int i = 0; i < signals.length; i++) {
            int g = signals[i][0];
            int y = signals[i][1];
            int r = signals[i][2];
            
            sigs.add(new Signal(g, y, r));
            
            maxLimitTime = lcm(maxLimitTime, g + y + r);
        }
        
        int time = 0;
        
        boolean allYellow = false;
        
        while(!allYellow) {

            time++;
            
            if (time > maxLimitTime) {
                return -1;
            }
            
            allYellow = true;
            for(Signal sig : sigs) {
                if(!sig.isYellowAt(time)) {
                    allYellow = false;
                    break;
                }
            }
        }
        
        return time;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}

class Signal {
    
    int green;
    int yellow;
    int red;
    int totalCycle;
    
    public Signal(int green, int yellow, int red) {
        this.green = green;
        this.yellow = yellow;
        this.red = red;
        this.totalCycle = green + yellow + red;
    }
    
    boolean isYellowAt(int time) {
        int cycleTime = time % totalCycle;
        
        if (cycleTime == 0) {
            cycleTime = totalCycle;
        }
        
        return cycleTime > green && cycleTime <= (green + yellow);
    }
}