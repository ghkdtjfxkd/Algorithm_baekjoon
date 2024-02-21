import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Coordinate coordinateSet[]  = new Coordinate[n];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            Coordinate coordinate = new Coordinate(Integer.parseInt(input[0])
                    , Integer.parseInt(input[1]));
            coordinateSet[i]= coordinate;
        }

        Comparator<Coordinate> xComparator = new Comparator<Coordinate>() {
            @Override
            public int compare(Coordinate o1, Coordinate o2) {
                return o1.x - o2.x;
            }
        };

        Comparator<Coordinate> yComparator = new Comparator<Coordinate>() {
            @Override
            public int compare(Coordinate o1, Coordinate o2) {
                return o1.y - o2.y;
            }
        };

        Arrays.sort(coordinateSet,yComparator);
        Arrays.sort(coordinateSet,xComparator);

        for (Coordinate coordinate : coordinateSet) {
            sb.append(coordinate.x).append(" ").append(coordinate.y).append("\n");
        }
        System.out.println(sb);
    }
}

class Coordinate implements Comparable<Coordinate> {
    public int x;
    public int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Coordinate others) {
        return x - others.x;
    }
}