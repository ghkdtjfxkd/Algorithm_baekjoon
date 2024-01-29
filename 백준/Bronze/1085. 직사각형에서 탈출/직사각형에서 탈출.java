import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");

        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        int w = Integer.parseInt(input[2]);
        int h = Integer.parseInt(input[3]);

        int upLength = h - y;
        int rightLength = w - x;
        int downLength = y;
        int leftLength = x;

        List<Integer> directionLength = new ArrayList<>();
        directionLength.add(upLength);
        directionLength.add(rightLength);
        directionLength.add(downLength);
        directionLength.add(leftLength);

        System.out.println(directionLength.stream().mapToInt(n -> n).min().getAsInt());
    }
}