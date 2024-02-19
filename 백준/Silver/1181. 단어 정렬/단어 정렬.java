import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(br.readLine());

        int[] lengthArr = new int[51];
        String[] words = new String[count];
        List<String> sortedWords = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String input = br.readLine();
            lengthArr[input.length()]++;
            words[i] = input;
        }

        for (int i = 1; i < lengthArr.length; i++) {
            List<String> miniSet = new ArrayList<>();
            for (int j = 0; j < words.length; j++) {

                if(lengthArr[i]!=0){
                    if (words[j].length() == i) {
                        miniSet.add(words[j]);
                        words[j] = "";
                        lengthArr[i]--;
                    }
                }
            }
            sortedWords.addAll(miniSet.stream().distinct().sorted().collect(Collectors.toList()));
        }

        sortedWords.forEach(s-> sb.append(s+"\n"));
        System.out.println(sb);
    }
}