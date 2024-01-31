import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");

        if(Arrays.equals(input, new String[]{"1", "2", "3", "4", "5", "6", "7", "8"})){
            System.out.println("ascending");
        } else if (Arrays.equals(input, new String[]{"8", "7", "6", "5", "4", "3", "2", "1"})) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}