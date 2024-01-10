import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        int rangeStart = 1;
        int rangeEnd = 1;
        int count = 1;

        while(true){
            if( input >= rangeStart && input <= rangeEnd){
                break;
            }
            count++;
            rangeStart = rangeEnd + 1;
            rangeEnd += 6 * (count -1);
        }
        bw.write(String.valueOf(count));
        bw.flush();
    }
}