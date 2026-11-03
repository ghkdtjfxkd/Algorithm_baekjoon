class Solution {
    static int N;
    public String[] solution(int n, int[] arr1, int[] arr2) {
        N = n;
        String[][] overlapped = new String[n][n];
        
        for(int i = 0; i < n; i++) {
            String[] strs = convert(arr1[i]).split("");
            for(int j = 0; j < n; j++) {
                if(strs[j].equals("0")){
                    overlapped[i][j] = " ";
                } else {
                    overlapped[i][j] = "#";
                }
            }
        }
        
       for(int i = 0; i < n; i++) {
            String[] strs = convert(arr2[i]).split("");
            for(int j = 0; j < n; j++) {
                if(strs[j].equals("0") && overlapped[i][j].equals(" ")){
                    overlapped[i][j] = " ";
                } else {
                    overlapped[i][j] = "#";
                }
            }
        }
        
        String[] answer = new String[n];
        for(int i = 0; i < n; i++) {
            answer[i] = String.join("", overlapped[i]);
        }
        
        return answer;
    }

    String convert(int num) {
        int cur = num;
        int exp = N - 1;
        
        String binStr = "";
        while(exp >= 0) {
            if(cur >= Math.pow(2, exp)) {
                binStr += "1";
                cur -= Math.pow(2, exp);
            } else {
                binStr += "0";
            }
            exp--;
        }
        
        return binStr;
    }
}