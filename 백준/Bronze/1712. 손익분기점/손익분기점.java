import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int fixedPrice = Integer.parseInt(input[0]);
        int variableCost = Integer.parseInt(input[1]);
        int laptopPrice = Integer.parseInt(input[2]);
        
        int laptopCount = -1;
        int pureBenefits = laptopPrice - variableCost;
        
        if(pureBenefits > 0){
           laptopCount = fixedPrice / pureBenefits +1;
        }

        bw.write(String.valueOf(laptopCount));
        bw.flush();
    }
}