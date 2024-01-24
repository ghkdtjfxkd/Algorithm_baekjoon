import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int hour = Integer.parseInt(input[0]);
        int min = Integer.parseInt(input[1]);

        int cookMin = Integer.parseInt(br.readLine());

        if(cookMin + min >=60){
            int plusHour =  (min + cookMin) / 60;
            hour += plusHour;
            min = (min + cookMin - 60 * plusHour);

            if(hour >= 24){
                hour %= 24;
            }
            if(min == 60){
                min = 0;
            }
        } else
            min += cookMin;
        System.out.println(hour + " " + min);
    }
}