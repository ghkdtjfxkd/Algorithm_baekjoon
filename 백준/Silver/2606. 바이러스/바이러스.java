import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static Computer[] office;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        office = new Computer[t];
        for (int i = 0; i < t; i++) {
            office[i] = new Computer(i+1);
        }

        office[0].infected =true;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int input1 = Integer.parseInt(st.nextToken());
            int input2 = Integer.parseInt(st.nextToken());

            office[input1-1].linked.add(input2);
            office[input2-1].linked.add(input1);
        }

        dfs(office[0]);
        System.out.println(Arrays.stream(office).filter(c -> c.infected).count()-1);
    }

    static void dfs(Computer n){
        n.visited = true;
        n.linked.stream().filter(c -> !office[c-1].visited).forEach(c ->
        {office[c-1].infected = true;
                dfs(office[c-1]);
        });
    }
}

class Computer {
    int num;

    boolean infected;
    boolean visited;
    HashSet<Integer> linked = new HashSet<>();

    static HashSet<Integer> infections = new HashSet<>();

    public Computer(int num) {
        this.num = num;
    }

    void spreadVirus(HashSet<Computer> total) {
        if(infected){
            total.stream().filter(computer ->  linked.contains(computer.num)).forEach(computer -> computer.infected = true);
        }

    }
}