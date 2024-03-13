import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i -1; j++) {
                System.out.print(" ");
            }
            for (int j = n - i-1; j < n -1 ; j++) {
                System.out.print("*");
            }
            System.out.print("*");
            for (int j = n - i-1; j < n -1 ; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        for (int i = 0; i < n * 2-1; i++) {
            System.out.print("*");
        }

        System.out.println();

        for (int i = n -2; i >= 0; i--) {
            for (int j = 0; j < n - i -1; j++) {
                System.out.print(" ");
            }
            for (int j = n - i-1; j < n -1 ; j++) {
                System.out.print("*");
            }
            System.out.print("*");
            for (int j = n - i-1; j < n -1 ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
