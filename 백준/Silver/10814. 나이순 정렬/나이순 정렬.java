import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        List<Member> members = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            Member member = new Member(Integer.parseInt(st.nextToken()), st.nextToken());
            members.add(member);
        }

        Comparator<Member> ageComparator = new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                return o1.age - o2.age;
            }
        };

        members.sort(ageComparator);
        members.forEach(m -> sb.append(m.age).append(" ").append(m.name).append("\n"));
        System.out.println(sb);
    }
}

class Member implements Comparable<Member> {

    private static int orderCheck = 1;
    int order;
    int age;
    String name;
    
    public Member(int age, String name) {
        this.age = age;
        this.name = name;
        order = orderCheck++;
    }
    
    @Override
    public int compareTo(Member o) {
        return order - o.order;
    }
}