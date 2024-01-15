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
        String newStr = filterCro(input);

        bw.write(String.valueOf(newStr.length()));
        bw.flush();
    }

    static String filterCro(String s) {
        String input = s;
        List<String> cros = new ArrayList<>(List.of("c=","c-","dz=","d-","lj","nj","s=","z="));

        for (String cro : cros) {
            if(input.contains(cro)){
               input = input.replace(cro,"!");
            }
        }
        return input;
    }
}
