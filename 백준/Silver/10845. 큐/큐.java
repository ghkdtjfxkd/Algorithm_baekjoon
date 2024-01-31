import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        MakeQueue queue = new MakeQueue();
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String[] input = br.readLine().split(" ");
            int num = -1;
            String command = input[0];
            if (input.length == 2) {
                num = Integer.parseInt(input[1]);
                queue.push(num);
                continue;
            }

            switch (command){

                case "pop": {
                    queue.pop();
                    continue;
                }
                case "size" : {
                    queue.size();
                    continue;
                }
                case "empty" : {
                    queue.empty();
                    continue;
                }
                case "front" : {
                    queue.front();
                    continue;
                }
                case "back" : {
                    queue.back();
                }
            }
        }
    }
}

class MakeQueue {


    static List<Integer> TestQueue = new ArrayList<>();

    void push(int n) {
        TestQueue.add(n);
    }

    void pop() {
        if (TestQueue.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(TestQueue.get(0));
            TestQueue.remove(0);
        }
    }

    void size() {
        System.out.println(TestQueue.size());
    }

    void empty() {
        if (TestQueue.isEmpty()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    void front() {
        if (TestQueue.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(TestQueue.get(0));
        }
    }

    void back() {
        if (TestQueue.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(TestQueue.get(TestQueue.size() - 1));
        }
    }
}