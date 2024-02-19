import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        String[] nums = br.readLine().split(" ");

        int det = Integer.parseInt(nums[0]);
        int bo = Integer.parseInt(nums[1]);

        List<String> detBoList = new ArrayList<>();
        Set<String> detList = new HashSet<>();

        for (int i = 0; i < det; i++) {
            detList.add(br.readLine());
        }
        for (int i = 0; i < bo; i++) {
            String boInput = br.readLine();
            if(detList.contains(boInput)){
                detBoList.add(boInput);
                detList.remove(boInput);
            }
        }

        System.out.println(detBoList.size());
        Collections.sort(detBoList);
        detBoList.forEach(s -> sb.append(s+ "\n"));

        System.out.println(sb);
    }
}