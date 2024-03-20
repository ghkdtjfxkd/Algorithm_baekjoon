import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class  Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int n = input.length() / 10;
        int l = input.length() % 10;
        int i = 0;

        while(i < n * 10){
            System.out.println( input.substring(i, i + 10));
            i += 10;
        }
        System.out.println(input.substring(i, i + l ));
    }
}