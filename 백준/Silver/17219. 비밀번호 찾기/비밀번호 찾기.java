import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] inputNums = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        int total = Integer.parseInt(inputNums[0]);
        int find = Integer.parseInt(inputNums[1]);

        HashMap<String,String> siteAndPW = new HashMap<>();

        for (int i = 0; i < total; i++) {
            String[] siteAndPWInput = br.readLine().split(" ");
            siteAndPW.put(siteAndPWInput[0],siteAndPWInput[1]);
        }

        for (int i = 0; i < find; i++) {
            String inputSite = br.readLine();
            sb.append(siteAndPW.get(inputSite));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}