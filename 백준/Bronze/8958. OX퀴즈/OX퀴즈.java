import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {

            int total = 0;
            String OXCase = br.readLine();

            List<String> splitForX = new ArrayList<>(List.of(OXCase.split("X")));
            
            for (String Os: splitForX) {
              total += cals(Os.length());
            }
            System.out.println(total);
        }





    }

    static int cals (int count){
        if(count == 0){
            return 0;
        }
        else{
            return count + cals(count -1);
        }
    }
}