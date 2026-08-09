import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        
        int[] b = Arrays.stream(B)
            .boxed()
            .sorted(Collections.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();
       
        for(int i = 0; i < A.length; i++) {
            answer += A[i] * b[i];
        }
        
        return answer;
    }
}