import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            HashSet<Integer> notebook1 = writeNumbersIn();

            int M= Integer.parseInt(br.readLine());
            List<Integer> notebook2 = writeNumbersInList();

            for (int j = 0; j < M; j++) {
                if(notebook1.contains(notebook2.get(j))) {
                    bw.write("1" + System.lineSeparator());
                } else {
                    bw.write("0"+ System.lineSeparator());
                }
            }
            bw.flush();

        }
        bw.close();
        br.close();

    }

    private static HashSet<Integer> writeNumbersIn() throws IOException {
        String[] checkingNumbers = br.readLine().split(" ");
        HashSet<Integer> notebook = new HashSet<>();

        for (String checkingNumber : checkingNumbers) {
            notebook.add(Integer.parseInt(checkingNumber));
        }
        return notebook;
    } 
    
    private static List<Integer> writeNumbersInList() throws IOException {
        String[] checkingNumbers = br.readLine().split(" ");
        List<Integer> notebook = new ArrayList<>();

        for (String checkingNumber : checkingNumbers) {
            notebook.add(Integer.parseInt(checkingNumber));
        }
        return notebook;
    }
}
