import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        String input = br.readLine();
        List<String> inputSplit = new ArrayList<>(List.of(input.split(" ")));
        List<Integer> numList = inputSplit.stream().map(Integer::parseInt).collect(Collectors.toList());


        bw.write(String.valueOf(numList.stream().filter(Main::decimalCheck).count()));
        bw.flush();
    }

    static boolean decimalCheck(int num){
        int test = 0;
        for (int i = 1; i <= num; i++) {
            if(num % i == 0){
                test++;
            }
        }
        return test==2;
    }
}