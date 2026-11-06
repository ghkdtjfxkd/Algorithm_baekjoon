class Solution {
    public int[] solution(int brown, int yellow) {
        int col = yellow;
        
        for(int row = 1; row <= yellow; row++) {
            if(yellow % row != 0) continue;
            col = yellow / row;
            
            int bRow = row + 2;
            int bCol = col + 2;
            if(bRow * bCol - yellow == brown) return new int[] {bCol, bRow};
        }
        
        return new int[] {};
    }
}