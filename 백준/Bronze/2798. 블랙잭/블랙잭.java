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

        String input = br.readLine();
        List<String> inputList = new ArrayList<>(List.of(input.split(" ")));
        List<Integer> dealer = inputList.stream().map(Integer::parseInt).collect(Collectors.toList());

        int cardNum = dealer.get(0);
        int maxNum = dealer.get(1);

        input = br.readLine();
        inputList.clear();
        inputList = new ArrayList<>(List.of(input.split(" ")));
        List<Integer> userInputList = inputList.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        userInputList = userInputList.stream().sorted().collect(Collectors.toList());
        List<Integer> sumList = new ArrayList<>();

        int sum = 0;
        int startIndex = 0;

        for (int i = 0; i < userInputList.size() - 2; i++) {

            sum += userInputList.get(i);

            for (int j =  i + 1; j < userInputList.size() - 1 ; j++) {

                sum += userInputList.get(j);

                for (int k = j + 1 ; k < userInputList.size(); k++) {

                    sum += userInputList.get(k);
                    sumList.add(sum);
                    sum -= userInputList.get(k);

                }

                sum -= userInputList.get(j);
            }

            sum -= userInputList.get(i);
        }

        int result = sumList.stream().mapToInt(n -> maxNum - n)
                .filter(n -> n >= 0).min().getAsInt();

        bw.write(String.valueOf(sumList.stream().filter(n -> maxNum - n == result).findFirst().get()));
        bw.flush();
    }
}