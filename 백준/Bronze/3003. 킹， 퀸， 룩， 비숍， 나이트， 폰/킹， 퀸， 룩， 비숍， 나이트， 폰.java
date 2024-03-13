import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] chessPieces = new int[6];
    private static int[] correctPieces = {1, 1, 2, 2, 2, 8};
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int pieceNum = 0;
        while (pieceNum != 6) {
            chessPieces[pieceNum++] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < 6; i++) {
            sb.append(correctPieces[i] - chessPieces[i]).append(" ");
        }
        System.out.println(sb);
    }
}