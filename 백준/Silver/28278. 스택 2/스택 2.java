import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Stack<Integer> myStack = new Stack<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int x = -1;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int order = Integer.parseInt(st.nextToken());
            if (order == 1) {
                x = Integer.parseInt(st.nextToken());
            }
            switch (order) {
                case 1:
                    myStack.add(x);
                    break;
                case 2:
                    if (!myStack.empty()) {
                        bw.write(myStack.pop() + "\n");
                    } else {
                        bw.write(-1 + "\n");
                    }
                    break;
                case 3:
                    bw.write(myStack.size() + "\n");
                    break;
                case 4:
                    if (myStack.empty()) {
                        bw.write(1 + "\n");
                    } else {
                        bw.write(0 + "\n");
                    }
                    break;
                case 5:
                    if (!myStack.isEmpty()) {
                        bw.write(myStack.peek() + "\n");
                    } else {
                        bw.write(-1 + "\n");
                    }
                    break;
            }
        }
        bw.flush();
    }
}