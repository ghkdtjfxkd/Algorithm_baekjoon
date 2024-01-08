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
        String s = br.readLine();

        List<String> token = new ArrayList<>(List.of(s.split("")));
        List<String> alphabet = new ArrayList<>(List.of("abcdefghijklmnopqrstuvwxyz".split("")));

        alphabet.stream().map(token::indexOf).forEach(x -> System.out.print(x + " "));
    }

}