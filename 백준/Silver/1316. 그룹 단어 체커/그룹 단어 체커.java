
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

        int count = Integer.parseInt(br.readLine());
        int correct = 0;

        for (int i = 0; i < count; i++) {
            String inputStr = br.readLine();
            if(groupWord(inputStr)){
                correct++;
            }
        }
        bw.write(String.valueOf(correct));
        bw.flush();
    }

    static boolean groupWord(String str){

        StringBuilder sb = new StringBuilder(str);
        List<String> stringList = new ArrayList<>();

        int start=0;
        int end=1;

        while (end + 1 <= str.length()){
            String check = sb.substring(start,end);
            String next = sb.substring(start+1,end+1);
            if(!check.equals(next)){
                stringList.add(check);
                check = next;
            }
            start++;
            end++;
            if(end ==str.length()){
                stringList.add(check);
            }
        }

        List<String> testStringList = stringList.stream().distinct().collect(Collectors.toList());

        if(testStringList.equals(stringList)){
            return true;
        }

        return  false;
    }
}
