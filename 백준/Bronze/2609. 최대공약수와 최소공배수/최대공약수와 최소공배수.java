import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        List<Integer> aList = factors(a);
        List<Integer> bList = factors(b);
        int aCount = 1;
        int bCount = 1;
        
        System.out.println(aList.stream().filter(bList::contains).mapToInt(n->n).max().getAsInt());
        while (true) {

            if (a * aCount == b * bCount) {
                System.out.println(a * aCount);
                break;
            } else if (a * aCount > b * bCount) {
                bCount++;
            } else {
                aCount++;
            }
        }
    }

    static List<Integer> factors (int a) {
        List<Integer> li = new ArrayList<>();
        if(a != 1){
            li.add(a);
            for (int i = 2; i <= a; i++) {
                int test = a;
                if (test % i == 0) {
                    while(test % i == 0){
                        test /= i;
                        li.add(test);
                    }
                }
            }
        }
        else li.add(1);
        return li;
    }
}