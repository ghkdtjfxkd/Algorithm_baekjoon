import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        String[] Serials = input.split("");
        List<Integer> secList = new ArrayList<>();

        for (String serial : Serials) {
           secList.add(secCheck(serial));
        }
        int total = secList.stream().mapToInt(n->n).sum();
        bw.write(String.valueOf(total));
        bw.flush();
    }

    static int secCheck (String s) {
        if(s.matches("^[A-C]*$")){
            return 3;
        }
        if(s.matches("^[D-F]*$")){
            return 4;
        }
        if(s.matches("^[G-I]*$")){
            return 5;
        }
        if(s.matches("^[J-L]*$")){
            return 6;
        }
        if(s.matches("^[M-O]*$")){
            return 7;
        }
        if(s.matches("^[P-S]*$")){
            return 8;
        }
        if(s.matches("^[T-V]*$")){
            return 9;
        }
        if(s.matches("^[W-Z]*$")){
            return 10;
        }
        return 0;
    }
}