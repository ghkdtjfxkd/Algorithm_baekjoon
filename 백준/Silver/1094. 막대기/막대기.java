import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int x = Integer.parseInt(br.readLine());

        List<Double> stickList = new ArrayList<>();
        stickList.add(64.0);
        System.out.println(makeStick(x,stickList));
    }

    static int makeStick (int target , List<Double> sticks){
        if(sticks.stream().mapToDouble(n->n).sum() == target){
            return sticks.size();
        }else {
            double min = sticks.stream().mapToDouble(n -> n).min().getAsDouble();
            sticks.remove(min);
            sticks.add(min/2);
            
            if(sticks.stream().mapToDouble(n->n).sum() < target){
                sticks.add(min/2);
            }
            return makeStick(target,sticks);
        }
    }
}