
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        while (true) {
            String input = br.readLine();
            if (Integer.parseInt(input) == 0) {
                break;
            }

            if (stringLengthOdd(input)) {
                System.out.println(palindromeOddCheck(input));
            } else {
                System.out.println(palindromeEvenCheck(input));
            }
        }
    }
    static boolean stringLengthOdd(String s) {
        return s.length() % 2 != 0;
    }

    static String palindromeOddCheck(String s) {
        int mid = s.length() / 2;
        boolean palindrome = true;
        String[] split = s.split("");

        String[] front = new String[mid + 1];
        String[] behind = new String[mid + 1];

        for (int i = 0; i < mid + 1; i++) {
            front[i] = split[i];
        }

        for (int i = s.length() - 1; i >= mid; i--) {
            behind[s.length() - 1 - i] = split[i];
        }

        for (int i = 0; i < mid; i++) {
            if (!behind[i].equals(front[i])) {
                palindrome = false;
                break;
            }
        }

        if (palindrome) {
            return "yes";
        } else {
            return "no";
        }
    }

    static String palindromeEvenCheck(String s) {
        int mid = s.length() / 2;
        boolean palindrome = true;
        String[] split = s.split("");

        String[] front = new String[mid];
        String[] behind = new String[mid];

        for (int i = 0; i < mid; i++) {
            front[i] = split[i];
        }

        for (int i = s.length() - 1; i >= mid; i--) {
            behind[s.length() - 1 - i] = split[i];
        }

        for (int i = 0; i < mid; i++) {
            if (!behind[i].equals(front[i])) {
                palindrome = false;
                break;
            }
        }

        if (palindrome) {
            return "yes";
        } else {
            return "no";
        }
    }
}
