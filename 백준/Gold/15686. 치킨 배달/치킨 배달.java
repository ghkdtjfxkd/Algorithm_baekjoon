import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Chicken {
        int row;
        int col;

        Chicken(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static class House {
        int row;
        int col;

        House(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int cityCD = Integer.MAX_VALUE;
    static List<Chicken> chickens = new ArrayList<>();
    static List<House> houses = new ArrayList<>();
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int tile = Integer.parseInt(st.nextToken());
                if(tile == 1) houses.add(new House(i, j));
                if(tile == 2) chickens.add(new Chicken(i, j));
            }
        }

        int[] cds = new int[houses.size()];
        Arrays.fill(cds, Integer.MAX_VALUE);
        dfs(0, m, cds);

        System.out.println(cityCD);
    }

    static void dfs(int index, int leftSelect, int[] cds) {
        if(leftSelect == 0) {
            cityCD = Math.min(cityCD, Arrays.stream(cds).sum());
            return;
        }
        int[] copy = Arrays.stream(cds).toArray();

        for (int i = index; i < chickens.size(); i++) {
            Chicken cur = chickens.get(i);
            dfs(i + 1 , leftSelect - 1, updatedCds(cur.row, cur.col, copy));
        }
    }

    static int[] updatedCds (int r, int c, int[] cds) {
        int[] updated = new int[cds.length];

        for (int i = 0; i < cds.length; i++) {
            House house = houses.get(i);
            int nd = Math.abs(house.row - r) + Math.abs(house.col - c);
            updated[i] = Math.min(nd, cds[i]);
        }
        return updated;
    }
}
