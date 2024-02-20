import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        while (true){

            String input = br.readLine();

            if(input.equals("0 0")){
                break;
            }

            String[] nums =  input.split(" ");
            int n1 = Integer.parseInt(nums[0]);
            int n2 = Integer.parseInt(nums[1]);

            if(n1 > n2){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }
}
