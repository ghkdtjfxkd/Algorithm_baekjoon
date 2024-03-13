import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int pal = 1;
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split("");

        for (int i = 0; i < input.length / 2 ; i++) {
            if(!input[i].equals(input[input.length - i -1])){
                pal = 0;
                break;
            }
        }
        System.out.println(pal);
    }
}
