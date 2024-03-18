import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static HashSet<String> strs = new HashSet<>();

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        String[] inputSplit = input.split("");
        for (int i = 0; i < input.length(); i++) {
            StringBuilder sb = new StringBuilder(input);
            strs.add(inputSplit[i]);
            for (int j = i; j <= input.length(); j++) {
               strs.add(sb.substring(i,j));
            }

        }
        System.out.println(strs.size()-1);
    }
}
