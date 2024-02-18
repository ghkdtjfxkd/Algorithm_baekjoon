import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();

        if(input.equals("A+")){
            System.out.println(4.3);
        }
        if(input.equals("A0")){
            System.out.println(4.0);
        }
        if(input.equals("A-")){
            System.out.println(3.7);
        }
        if(input.equals("B+")){
            System.out.println(3.3);
        }
        if(input.equals("B0")){
            System.out.println(3.0);
        }
        if(input.equals("B-")){
            System.out.println(2.7);
        }
        if(input.equals("C+")){
            System.out.println(2.3);
        }
        if(input.equals("C0")){
            System.out.println(2.0);
        }
        if(input.equals("C-")){
            System.out.println(1.7);
        }
        if(input.equals("D+")){
            System.out.println(1.3);
        }
        if(input.equals("D0")){
            System.out.println(1.0);
        }
        if(input.equals("D-")){
            System.out.println(0.7);
        }
        if(input.equals("F")){
            System.out.println(0.0);
        }
    }
}