import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static double totalPoint;
    private static double lecTime;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 20; i++) {
            String[] lec = br.readLine().split(" ");
            if(lec[2].equals("P")){
                continue;
            }
            totalPoint += Double.parseDouble(lec[1]) * conductor(lec[2]);
            lecTime += Double.parseDouble(lec[1]);
        }
        System.out.println(totalPoint/lecTime);
    }

    private static double conductor(String s) {
        if (s.equals("A+")) {
            return 4.5;
        } else if (s.equals("A0")) {
            return 4.0;
        } else if (s.equals("B+")) {
            return 3.5;
        } else if (s.equals("B0")) {
            return 3.0;
        } else if (s.equals("C+")) {
            return 2.5;
        } else if (s.equals("C0")) {
            return 2.0;
        } else if (s.equals("D+")) {
            return 1.5;
        } else if (s.equals("D0")) {
            return 1.0;
        } else {
            return 0;
        }
    }
}
