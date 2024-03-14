import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    private static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    private static HashSet<String> employees= new HashSet<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String move = st.nextToken();

            if(move.equals("enter")) {
                employees.add(name);
            } else {
                employees.remove(name);
            }
        }
       employees.stream().sorted(Comparator.reverseOrder())
               .collect(Collectors.toList())
               .forEach(System.out::println);
    }
}
