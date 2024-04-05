import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n ; i++) {
            sb.append("I").append("O");
        }
        sb.append("I");
        String pn = sb.toString();
        int m = Integer.parseInt(br.readLine());
        sb.setLength(0);
        String str = br.readLine();
        int ptrInt = 0;
        for (int i = 0; i <= m - pn.length() ; i++) {
            String newStr = str.substring(i, i + pn.length());
            if (newStr.equals(pn)) {
                ptrInt++;
            }
        }
        System.out.println(ptrInt);
    }
}