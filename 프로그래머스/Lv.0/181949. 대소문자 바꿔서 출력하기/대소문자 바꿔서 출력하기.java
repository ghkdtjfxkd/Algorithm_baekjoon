import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split("");

        for (String s : input) {
            if(s.matches("^[a-z]*$")){
                s = s.toUpperCase();
                bw.write(s);
                continue;
            }
            if(s.matches("^[A-Z]*$")){
                s = s.toLowerCase();
                bw.write(s);
            }
        }
        bw.flush();
    }
}