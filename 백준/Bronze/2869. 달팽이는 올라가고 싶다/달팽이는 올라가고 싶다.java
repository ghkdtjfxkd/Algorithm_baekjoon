import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int up = Integer.parseInt(input[0]);
        int goal = Integer.parseInt(input[2]);


        int dayUp = up - Integer.parseInt(input[1]);

        int day = 0;
        if((goal - up) % dayUp == 0){
            day = (goal - up) / dayUp + 1;
        }else {
            day = (goal - up) / dayUp + 2;
        }

        bw.write(String.valueOf(day));
        bw.flush();
    }
}