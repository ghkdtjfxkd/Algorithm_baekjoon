import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        List<List<String>> totalInput = new ArrayList<>();

        List<List<String>> newTotalList = new ArrayList<>();

        int maxLen = 0;

        for (int i = 0; i < 5; i++) {
            totalInput.add(List.of(br.readLine().split("")));
            if (totalInput.get(i).size() >= maxLen) {
                maxLen = totalInput.get(i).size();
            }
        }

        for (List<String> stringList : totalInput) {

            List<String> passList = new ArrayList<>();
            if (stringList.size() < maxLen) {

                passList.addAll(stringList);
                for (int i = 0; i < maxLen - stringList.size(); i++) {
                    passList.add("-1");
                }
                newTotalList.add(passList);

            } else {
                passList.addAll(stringList);
                newTotalList.add(passList);
            }
        }

        for (int i = 0; i < maxLen; i++) {
            for (List<String> stringList : newTotalList) {
                if(!Objects.equals(stringList.get(i), "-1")){
                System.out.print(stringList.get(i));
                }
            }
        }
    }
}
