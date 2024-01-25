import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] plate = new int[9][9];
        int maxNum = 0;
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < 9; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                plate[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(plate[i][j] >= maxNum){
                    maxNum = plate[i][j];
                    maxRow = i+1;
                    maxCol = j+1;
                }

            }
        }

        System.out.println(maxNum);
        System.out.println(maxRow + " " + maxCol);

    }
}