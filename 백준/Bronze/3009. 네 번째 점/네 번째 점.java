import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<Integer, Integer> xVals = new HashMap<>();
    static HashMap<Integer, Integer> yVals = new HashMap<>();

    public static void main(String[] args) throws IOException {
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int inputX = Integer.parseInt(st.nextToken());
            int inputY = Integer.parseInt(st.nextToken());

            if (!xVals.keySet().contains(inputX)) {
                xVals.put(inputX, 1);
            } else {
                xVals.put(inputX, xVals.get(inputX)+1);
            }
            if (!yVals.keySet().contains(inputY)) {
                yVals.put(inputY, 1);
            }else {
                yVals.put(inputY, yVals.get(inputY)+1);
            }
        }
        xVals.keySet().stream().filter(k ->xVals.get(k).equals(1)).forEach(sb::append);
        sb.append(" ");
        yVals.keySet().stream().filter(k ->yVals.get(k).equals(1)).forEach(sb::append);
        System.out.println(sb);
    }
}