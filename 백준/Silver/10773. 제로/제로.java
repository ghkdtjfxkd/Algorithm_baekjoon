import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String input = br.readLine();
            if(!input.equals("0")){
                stack.push(Integer.parseInt(input));
            }else {
                stack.pop();
            }
        }
        System.out.println(stack.stream().mapToInt(n->n).sum());
    }
}