import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution  {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        String[] input = br.readLine().split(" ");
        String inputStr = input[0];
        int repeat = Integer.parseInt(input[1]);
        
        for(int i = 0; i < repeat ; i++){
            bw.write(inputStr);
        }
        bw.flush();
    }
}