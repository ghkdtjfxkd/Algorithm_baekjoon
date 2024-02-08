import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        while (true) {

            String[] input = br.readLine().split(" ");

            int line1 = Integer.parseInt(input[0]);
            int line2 = Integer.parseInt(input[1]);
            int line3 = Integer.parseInt(input[2]);

            if(line1 == 0 && line2 == 0 && line3 ==0){
                break;
            }

            if(triangleCheck(line1,line2,line3)){
                if(checkRightAngle(line1,line2,line3)){
                    System.out.println("right");
                }else {
                    System.out.println("wrong");
                }
            }else {
                System.out.println("wrong");
            }
        }
    }


    static boolean triangleCheck(int a,int b, int c ){
        return a + b > c && a + c > b && b + c > a;
    }

    static int biggest(int a, int b, int c){
        int big = -1;
        if(a > b){
            if(a > c){
                big = a;
            }else {
                big = c;
            }
        } else {
            if(a == b){
                if(a> c){
                    big = a;
                }else {
                    big = c;
                }
            } else {
                if(b> c){
                    big = b;
                }else {
                    big = c;
                }
            }
        }
        return big;
    }
    static boolean checkRightAngle(int a, int b, int c){
        int big = biggest(a,b,c);
        if(big == a){
           if(Math.pow(big,2) == Math.pow(b,2) + Math.pow(c,2)){
               return true;
           }
        }
        if(big == b){
            if(Math.pow(big,2) == Math.pow(a,2) + Math.pow(c,2)){
                return true;
            }
        }
        if(big == c){
            if(Math.pow(big,2) == Math.pow(b,2) + Math.pow(a,2)){
                return true;
            }
        }
        return false;
    }

}
