import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        long n = Integer.parseInt(input[0]);
        long m = Integer.parseInt(input[1]);
        long distance = n-m;
        System.out.println(Math.abs(distance));
    }
}