import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] lastDayForMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
        String[] weekDay = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        int daySum = 0;

        for (int i = 0; i < month -1; i++) {
            daySum += lastDayForMonth[i];
        }
        daySum += day;
        if(daySum % 7 == 0){
            System.out.println(weekDay[6]);
        } else {
            System.out.println (weekDay[daySum % 7 -1]);
        }
    }
}