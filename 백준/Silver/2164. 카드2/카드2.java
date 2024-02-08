import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int input = Integer.parseInt(br.readLine());
        int squareN = squareCheck(input, 0);
        int inputOrder = input - ((int) Math.pow(2, squareN + 1) - (int) Math.pow(2, squareN));

        if (inputOrder == 0) {
            System.out.println(input);
        } else {
            System.out.println((inputOrder) * 2);
        }
    }

    static int squareCheck(int i, int powerN) {
        if (i / Math.pow(2, powerN) == 0) {
            return powerN - 1;
        } else {
            i /= 2;
            powerN++;
            return squareCheck(i, powerN);
        }
    }
}