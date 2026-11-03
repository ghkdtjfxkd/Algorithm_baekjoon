class Solution {
    
    static Integer[][] dp;
    
    public int solution(int[][] triangle) {
        dp = new Integer[triangle.length][triangle.length];
        
        return maxSum(0, 0, triangle);
    }
    
    int maxSum(int row, int col, int[][] triangle) {
        if(row >= triangle.length || col >= triangle.length) return 0;

        if(dp[row][col] != null) {
            return dp[row][col];
        } else {
            int cur = triangle[row][col];
            dp[row][col] = cur + Math.max(maxSum(row + 1, col, triangle),
                                    maxSum(row + 1, col + 1, triangle));
            return dp[row][col];
        }
    }
}