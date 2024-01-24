import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.parseInt(br.readLine());
        int type=  Integer.parseInt(br.readLine());
        int amount = 0;

        for (int i = 0; i < type; i++) {
            int cals = 0;
            String[] input = br.readLine().split(" ");
            int price = Integer.parseInt(input[0]);
            int count = Integer.parseInt(input[1]);

            cals = price * count;
            amount += cals;
        }

        if (total == amount) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}