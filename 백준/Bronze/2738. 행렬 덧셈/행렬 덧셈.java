import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputSize = br.readLine().split(" ");

        int row = Integer.parseInt(inputSize[0]);
        int col = Integer.parseInt(inputSize[1]);

        int[][] first = new int[row][col];
        int[][] second = new int[row][col];

        for (int i = 0; i < row; i++) {
            String[] rowInput = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                first[i][j] = Integer.parseInt(rowInput[j]);
            }
        }

        for (int i = 0; i < row; i++) {
            String[] rowInput = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                second[i][j] = Integer.parseInt(rowInput[j]);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(first[i][j] + second[i][j] + " ");
            }
            System.out.println();
        }


    }


}
