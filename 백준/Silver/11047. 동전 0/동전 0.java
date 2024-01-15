import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        List<Integer> coinList = new ArrayList<>();
        HashMap<Integer, Integer> coinWallet = new HashMap<>();

        int coinVar = Integer.parseInt(input[0]);
        int total = Integer.parseInt(input[1]);

        for (int i = 0; i < coinVar; i++) {
            int coinValue = Integer.parseInt(br.readLine());
            coinList.add(coinValue);
        }


        coinFilter(coinWallet,coinList,total,coinVar);

        int sum = coinWallet.values().stream().mapToInt(n -> n).sum();

        bw.write(String.valueOf(sum));
        bw.flush();
    }
    static void coinFilter(HashMap<Integer, Integer> coinWallet,List<Integer> coinList,int value , int coinVar  ) {
       int count = 0;
       int total = value;
        for (int i = coinVar-1 ; i >=0 ; i--) {
            if(total >= coinList.get(i)){
                total -= coinList.get(i);
                count++;
                if(!coinWallet.containsKey(coinList.get(i))){
                    coinWallet.put(coinList.get(i),count);
                }
                coinWallet.replace(coinList.get(i),count);
                i++;
                continue;
            }
            count=0;
        }
    }
}
