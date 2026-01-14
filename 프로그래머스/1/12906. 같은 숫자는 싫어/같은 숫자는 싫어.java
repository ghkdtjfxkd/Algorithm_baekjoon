import java.util.*;

public class Solution {
    public List<Integer> solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i : arr) {
            if(stack.empty()) {
                stack.push(i);
                continue;
            }
            
            if(stack.peek() != i) {
                stack.push(i);
            }
        }
        
        Stack<Integer> stack2 = new Stack<>();
        while(!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        while(!stack2.isEmpty()) {
            queue.offer(stack2.pop());
        }
        
        return new ArrayList<>(queue);
    }
}