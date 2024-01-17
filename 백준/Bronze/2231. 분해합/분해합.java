import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] inputs = input.split("");

        int inputNum = Integer.parseInt(input);
        int firstNum = Integer.parseInt(inputs[0]);
        int digit = input.length();

        List<List<Integer>> splitNumList = new ArrayList<>();
        List<Integer> eachNums = new ArrayList<>();
        int result = 0;
        
        try{
            for (int i = 1; i <=firstNum + (digit -1) * 9 ; i++) {
                eachNums.add(inputNum - i);
                splitNumList.add(test(inputNum - i));
            }

            List<Integer> sums = splitNumList.stream()
                    .map(n -> n.stream()
                            .mapToInt(i -> i)
                            .sum())
                    .collect(Collectors.toList());

            for (int i = (firstNum+ (digit-1) * 9) -1 ; i >= 0; i--) {
                if (inputNum - eachNums.get(i) - sums.get(i) == 0) {
                    result = eachNums.get(i);
                    break;
                }
            }
           
            System.out.println(result);

        } catch (NumberFormatException e){
            System.out.println(0);
        }
    }

    static List<Integer> test(int i) {
        List<Integer> inList = new ArrayList<>();
        String[] strArr = String.valueOf(i).split("");
        for (String s : strArr) {
            inList.add(Integer.parseInt(s));
        }
        return inList;
    }
}