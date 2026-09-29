import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportMap = new LinkedHashMap<>();
        Map<String, Integer> reportCount = new HashMap<>();
    
        for(int i = 0; i < id_list.length; i++) {
            reportMap.put(id_list[i], new HashSet<>());
        }
        
        for(int i = 0; i < report.length; i++) {
            String[] split = report[i].split(" ");
            String from = split[0];
            String to = split[1];
            
            if(reportMap.get(from).add(to)) {
                reportCount.put(to, reportCount.getOrDefault(to, 0) + 1);
            }
        }
        
        Set<String> banned = new HashSet<>();
    
        reportCount.keySet().stream()
            .filter(name -> reportCount.get(name) >= k)
            .forEach(name -> banned.add(name));

        
        int[] answer = reportMap.values().stream()             
            .mapToInt(set -> (int) set.stream().filter(banned::contains).count())
            .toArray();
            
        return answer;
    }
    
}

