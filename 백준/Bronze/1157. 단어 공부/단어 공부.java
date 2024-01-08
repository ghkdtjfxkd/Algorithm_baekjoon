import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> input = new ArrayList<>(List.of(sc.nextLine().toUpperCase().split("")));
        List<String> inputElement = input.stream().distinct().collect(Collectors.toList());
        List<Integer> countList = new ArrayList<>();

        int best = 0;

        for (String s : inputElement) {
            long count = input.stream().filter(n -> n.equals(s)).count();
            countList.add((int) count);
        }

        for (Integer i : countList) {
            if(best < i){
                best = i;
            }
        }

        final int bestFix = best;
        boolean extraBest = countList.stream().filter(n -> n.equals(bestFix)).count() >= 2;

        if(extraBest){
            System.out.println("?");
        }else {
            System.out.println(inputElement.get(countList.indexOf(best)));
        }
        
    }
}