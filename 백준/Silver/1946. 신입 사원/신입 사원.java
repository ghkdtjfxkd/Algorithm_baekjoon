import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            List<Volunteer> volunteers = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                int paper = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());

                volunteers.add(new Volunteer(paper,interview));
            }
            List<Volunteer> list = volunteers.stream().sorted(Comparator.comparing(vol -> vol.paper)).collect(Collectors.toList());
            System.out.println(prove(list));

        }
    }

    private static int prove(List<Volunteer> saved) {
        int count = 1; 
        int bestInterview = saved.get(0).interview; 

        for (int i = 1; i < saved.size(); i++) {
            if (saved.get(i).interview < bestInterview) { 
                count++;
                bestInterview = saved.get(i).interview; 
            }
        }

        return count;
    }

    static class Volunteer {
        int paper;
        int interview;

        public Volunteer(int paper, int interview) {
            this.paper = paper;
            this.interview = interview;
        }
    }
}
