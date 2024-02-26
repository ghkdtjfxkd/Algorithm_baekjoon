import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringBuilder sb = new StringBuilder();

    static String coor;
    static int target;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        target = Integer.parseInt(br.readLine());

        int[][] shell = new int[n][n];

        shell[(n-1)/2][(n-1)/2] = 1;
        goNorth(shell,((n -1) / 2 ), ((n-1)/2), n , 1);

        for (int[] ints : shell) {
            for (int anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);

        if(target == 1){
            System.out.println(((n-1)/2+1) + " " + ((n-1)/2+1));
        }else {
            System.out.println(coor);
        }

    }

    static boolean canGoNorth(int[][] shell, int row, int col) {
        if (row > 0) {
            return shell[row - 1][col] == 0;
        }
        return false;
    }

    static boolean canGoSouth(int[][] shell, int row, int col, int n) {
        if (row < n - 1) {
            return shell[row + 1][col] == 0;
        }
        return false;
    }

    static boolean canGoEast(int[][] shell, int row, int col, int n) {
        if (col < n - 1) {
            return shell[row][col + 1] == 0;
        }
        return false;
    }

    static boolean canGoWest(int[][] shell, int row, int col) {
        if (col > 0) {
            return shell[row][col - 1] == 0;
        }
        return false;
    }

    static void getCoor(int row, int col, int target, int now){
        if(now == target){
            sb.append(row+1).append(" ").append(col+1);

        coor = String.valueOf(sb);
        sb.setLength(0);}
    }


    static void goNorth(int[][] shell, int row, int col, int n, int count) {
        if (canGoNorth(shell, row, col)) {
            row -= 1;
            count += 1;
            getCoor(row,col,target,count);
            shell[row][col] = count;
            if (!canGoEast(shell, row, col, n) &&  canGoNorth(shell, row, col)&& count < n * n ) {
                goNorth(shell, row, col, n, count);
            }
            if(count < n * n ){
                goEast(shell, row, col, n, count);
            }
        }
    }

    static void goEast(int[][] shell, int row, int col, int n, int count) {
        if (canGoEast(shell, row, col, n)) {
            col += 1;
            count +=1;
            getCoor(row,col,target,count);
            shell[row][col] = count;
            if (!canGoSouth(shell, row, col, n) &&canGoEast(shell, row, col, n) && count < n * n ) {
                goEast(shell, row, col, n, count);
            }
            if(count < n * n ){
                goSouth(shell, row, col, n, count);
            }
        }
    }

    static void goSouth(int[][] shell, int row, int col, int n, int count) {
        if (canGoSouth(shell, row, col, n)) {
            row += 1;
            count += 1;
            getCoor(row,col,target,count);
            shell[row][col] = count;

            if (!canGoWest(shell, row, col) && canGoSouth(shell, row, col, n) &&count < n * n ) {
                goSouth(shell, row, col, n, count);
            }
            if(count < n * n ){
                goWest(shell, row, col, n, count);
            }
        }
    }

    static void goWest(int[][] shell, int row, int col, int n, int count) {
        if (canGoWest(shell, row, col)) {
            col -= 1;
            count+=1;
            getCoor(row,col,target,count);
            shell[row][col] = count;

            if (!canGoNorth(shell, row, col) && canGoWest(shell, row, col) &&  count < n * n ) {
                goWest(shell, row, col, n, count);
            }
            if(count < n * n ){
                goNorth(shell, row, col, n, count);
            }
        }
    }
}