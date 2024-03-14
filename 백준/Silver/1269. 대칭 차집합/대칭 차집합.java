import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static HashSet<Integer> aSet = new HashSet<>();
    private static HashSet<Integer> bSet = new HashSet<>();
    private static List<Integer> abSet = new ArrayList<>();
    private static List<Integer> baSet = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aSize = Integer.parseInt(st.nextToken());
        int bSize = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aSize; i++) {
            aSet.add(Integer.valueOf(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bSize; i++) {
            bSet.add(Integer.valueOf(st.nextToken()));
        }

        abSet = aSet.stream().filter(n -> !bSet.contains(n)).collect(Collectors.toList());
        baSet = bSet.stream().filter(n -> !aSet.contains(n)).collect(Collectors.toList());
        System.out.println(baSet.size() + abSet.size());
    }
}
