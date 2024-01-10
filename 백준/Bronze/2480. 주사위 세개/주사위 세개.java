
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input= br.readLine();

        List<String> dice = new ArrayList<>(List.of(input.split(" ")));
        List<Integer> diceInt =  dice.stream().map(Integer::parseInt).collect(Collectors.toList());

        int total = 0;

        if(diceInt.get(0) == diceInt.get(1) && diceInt.get(1) == diceInt.get(2)){
            total = 10_000 + diceInt.get(0) * 1000;
        }

        else if(diceInt.get(0) == diceInt.get(1) && diceInt.get(1) != diceInt.get(2)){
            total = 1_000 + diceInt.get(0) * 100;
        }

        else if(diceInt.get(0) == diceInt.get(2) && diceInt.get(1) != diceInt.get(2)){
            total = 1_000 + diceInt.get(0) * 100;
        }

        else if(diceInt.get(1) == diceInt.get(2) && diceInt.get(1) != diceInt.get(0)){
            total = 1_000 + diceInt.get(1) * 100;
        }

        else if(diceInt.get(0) != diceInt.get(1) && diceInt.get(1) != diceInt.get(2)){
            int max = 0;
            for (Integer i : diceInt) {
                if(max < i){
                    max = i;
                }
            }
            total = max * 100;
        }


        bw.write(String.valueOf(total));
        bw.flush();
    }
}