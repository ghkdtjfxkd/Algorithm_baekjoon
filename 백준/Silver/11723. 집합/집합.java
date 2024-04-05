import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> set = new HashSet<>();
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            if (order.equals("add")) {
                set.add(Integer.parseInt(st.nextToken()));
                continue;
            }

            if (order.equals("remove")) {
                int removeNum = Integer.parseInt(st.nextToken());
                if (set.contains(removeNum)) {
                    set.remove(removeNum);
                }
                continue;
            }

            if (order.equals("check")) {
                int checkNum = Integer.parseInt(st.nextToken());
                if (set.contains(checkNum)) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
                continue;
            }

            if (order.equals("toggle")) {
                int togNum = Integer.parseInt(st.nextToken());

                if (set.contains(togNum)) {
                    set.remove(togNum);
                } else {
                    set.add(togNum);
                }
                continue;
            }
            if (order.equals("empty")) {
                set.removeAll(set);
                continue;
            }
            if (order.equals("all")) {
                set.removeAll(set);
                for (int j = 0; j < 20; j++) {
                    set.add(j + 1);
                }
            }
        }
        System.out.println(sb);
    }
}
