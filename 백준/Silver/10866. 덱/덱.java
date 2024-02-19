import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<Integer> dequeue = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            if (input.trim().contains(" ")) {
                String[] pushCommand = input.split(" ");
                String command = pushCommand[0];
                int num = Integer.parseInt(pushCommand[1]);

                if(command.equals("push_back")){
                    dequeue.add(num);
                }else
                    dequeue.add(0,num);

            } else {

                switch (input) {
                    case "front":
                        System.out.println(front(dequeue));
                        break;
                    case "back":
                        System.out.println(back(dequeue));
                        break;
                    case "pop_front":
                        System.out.println(pop_front(dequeue));
                        break;
                    case "pop_back":
                        System.out.println(pop_back(dequeue));
                        break;
                    case "size":
                        System.out.println(dequeue.size());
                        break;
                    case "empty":
                        System.out.println(empty(dequeue));
                        break;

                }

            }

        }
    }

    static int pop_front(List<Integer> dequeue) {
        if (!dequeue.isEmpty()) {
            int front = dequeue.get(0);
            dequeue.remove(0);
            return front;
        }
        return -1;
    }

    static int pop_back(List<Integer> dequeue) {
        if (!dequeue.isEmpty()) {
            int back = dequeue.get(dequeue.size() - 1);
            dequeue.remove(dequeue.size() - 1);
            return back;
        }
        return -1;
    }

    static int empty(List<Integer> dequeue) {
        if (dequeue.isEmpty()) {
            return 1;
        }
        return 0;
    }

    static int front(List<Integer> dequeue) {
        if (!dequeue.isEmpty()) {
            return dequeue.get(0);
        }
        return -1;
    }

    static int back(List<Integer> dequeue) {
        if (!dequeue.isEmpty()) {
            return dequeue.get(dequeue.size() - 1);
        }
        return -1;
    }

}
