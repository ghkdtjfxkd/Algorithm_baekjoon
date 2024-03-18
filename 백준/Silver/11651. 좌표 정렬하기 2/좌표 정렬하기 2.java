import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        Coor[] coors = new Coor[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Coor coor = new Coor(x,y);
            coors[i]= coor;
        }

        Comparator<Coor> xComparator = new Comparator<Coor>() {
            @Override
            public int compare(Coor o1, Coor o2) {
                return o1.x- o2.x;
            }
        };

        Comparator<Coor> yComparator = new Comparator<Coor>() {
            @Override
            public int compare(Coor o1, Coor o2) {
                return o1.y - o2.y;
            }
        };

        Arrays.sort(coors,xComparator);
        Arrays.sort(coors,yComparator);

        for (Coor coor : coors) {
            sb.append(coor.x).append(" ").append(coor.y).append("\n");
        }
        System.out.println(sb);
    }

}

class Coor{
    int x;
    int y;

    public Coor(int x, int y) {
        this.x = x;
        this.y = y;
    }
}