import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();

        int[] fibonacciArr = new int[42];

        fibonacciArr[0] = 0;
        fibonacciArr[1] = 1;
        for (int i = 2; i < 41; i++) {
            fibonacciArr[i] = fibonacciArr[i-2]+fibonacciArr[i-1];
        }

        for (int i = 0; i < count; i++) {
            int testCase = sc.nextInt();
            if(testCase ==  0){
                System.out.println(1 + " " + 0);
            } else if (testCase == 1) {
                System.out.println(0 + " " + 1);
            } else {
                System.out.println(fibonacciArr[testCase-1] + " " + fibonacciArr[testCase]);
            }
        }
    }
}