import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int UNVISITED = 0;
    private static int VISITED = 1;
    private static int WALL = 2;

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int doyeanN = -1;
        int doyeanM = -1;

        String[][] campus = new String[n][m];
        int[][] checkingArr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] campusLineN = br.readLine().split("");
            for (int j = 0; j < m; j++) {

                campus[i][j] = campusLineN[j];

                checkingArr[i][j] = conductor(campusLineN[j]);

                if (campusLineN[j].equals("I")) {
                    doyeanN = i;
                    doyeanM = j;
                }
            }
        }

        int answer = meetPerson(campus, checkingArr, doyeanN, doyeanM, n, m);
        if(answer == 0){
            System.out.println("TT");
        }else {
            System.out.println(answer);
        }
    }

    static int conductor (String s) {
        if(s.equals("P") || s.equals("O") || s.equals("I")){
            return UNVISITED;
        } else {
            return WALL;
        }
    }

    static boolean inCampus(int row, int col, int n, int m) {
        if (row < 0 || col < 0 || row >= n || col >= m) {
            return false;
        }
        return true;
    }

    static boolean hitTheWall(int[][]checkingArr, int row, int col) {
        if(checkingArr[row][col] == WALL)
            return true;
        return false;
    }

    static boolean alreadyVisited (int[][] checkingArr, int row, int col) {
        if(checkingArr[row][col] == VISITED){
            return true;
        }
        return false;
    }

    static int meetPerson(String[][]campusArr, int[][]checkingArr, int row , int col, int n, int m){

        int peopleCount = 0;

        if(!inCampus(row,col,n,m)) {
            return 0;
        }
        else if(hitTheWall(checkingArr,row,col)) {
            return 0;
        }
        else if(alreadyVisited(checkingArr,row,col)) {
            return 0;
        }
        else {
            checkingArr[row][col] = VISITED;

            if (campusArr[row][col].equals("P")) {
                peopleCount = 1;
            }

            return peopleCount + meetPerson(campusArr, checkingArr, row - 1, col, n, m)
                    + meetPerson(campusArr, checkingArr, row, col + 1, n, m)
                    + meetPerson(campusArr, checkingArr, row + 1, col, n, m)
                    + meetPerson(campusArr, checkingArr, row, col - 1, n, m);

        }
    }
}