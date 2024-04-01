import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    private static Queue<Vertex> queue = new LinkedList<>();
    private static Vertex[] vertices;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        vertices = new Vertex[n];

        for (int i = 0; i < n; i++) {
            vertices[i] = new Vertex(i+1);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int input1= Integer.parseInt(st.nextToken());
            int input2= Integer.parseInt(st.nextToken());

            vertices[input1-1].linked.add(input2);
            vertices[input2-1].linked.add(input1);
        }


        dfs(v);
        System.out.println(sb.toString().trim());

        Arrays.stream(vertices).forEach(ver -> ver.visited = false);

        sb.setLength(0);

        bfs(v);
        System.out.println(sb.toString().trim());
    }

    static void dfs (int n) {
        vertices[n - 1].visited = true;
        queue.add(vertices[n - 1]);
        sb.append(vertices[n - 1].num).append(" ");
        while (!queue.isEmpty()) {
            queue.poll().linked.stream().sorted().collect(Collectors.toList()).stream().filter(v -> !vertices[v-1].visited).forEach(Main::dfs);
        }
    }

    static void bfs (int n){
        Queue<Vertex> queue1 = new LinkedList<>();
        queue1.add(vertices[n-1]);
        vertices[n-1].visited = true;
        sb.append(vertices[n-1].num).append(" ");
        while (!queue1.isEmpty()) {
            Vertex test = queue1.poll();
            test.linked.stream().sorted().collect(Collectors.toList())
                    .stream().filter(v -> !vertices[v-1].visited)
                    .forEach(v ->{
                        vertices[v-1].visited = true;
                        sb.append(vertices[v-1].num).append(" ");
                        queue1.add(vertices[v-1]);
                    });
        }
    }
}

class Vertex {
    int num;
    boolean visited;
    HashSet<Integer> linked = new HashSet<>();
    public Vertex(int num) {
        this.num = num;
    }
}