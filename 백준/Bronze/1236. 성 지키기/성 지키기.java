import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[][] castle;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        castle = new String[n][m];
        boolean[] XExistRow =  new boolean[n];
        boolean[] XExistCol =  new boolean[m];

        int needRow = 0;
        int needCol = 0;

        for (int i = 0; i < n; i++) {
            String[] castleFloor = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                castle[i][j] = castleFloor[j];
                if(castleFloor[j].equals("X")){
                    XExistRow[i] = true;
                    XExistCol[j] = true;
                }
            }
        }

        for (boolean b : XExistRow) {
            if(!b) {
                needRow++;
            }
        }

        for (boolean b : XExistCol) {
            if(!b){
                needCol++;
            }
        }

        if(needRow >= needCol){
            System.out.println(needRow);
        }else {
            System.out.println(needCol);
        }
    }
}