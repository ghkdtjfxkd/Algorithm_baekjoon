import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int m;

    private static HashMap<Integer,String> pocketMonDic = new HashMap<>();
    private static HashMap<String,Integer> pocketMonDic2 = new HashMap<>();


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            pocketMonDic.put(i, input);
            pocketMonDic2.put(input, i);
        }
        for (int i = 0; i < m; i++) {
            String ans = br.readLine();

            if(ans.substring(0,1).matches("^[1-9]")){
                sb.append(pocketMonDic.get(Integer.parseInt(ans))).append("\n");
            }else{
                sb.append(pocketMonDic2.get(ans)).append("\n");
            }
        }
        System.out.println(sb);
    }
}