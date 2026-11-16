import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] mess = {"님이 들어왔습니다." , "님이 나갔습니다."};
        
        Map<String, String> idName = new HashMap<>();
        List<String> sentence = new ArrayList<>();
        
        for(String s : record) {
            String[] sp = s.split(" ");
            
            if(sp[0].equals("Enter")) {
                idName.put(sp[1], sp[2]);
                sentence.add(sp[1] + " " + mess[0]);
            } else if(sp[0].equals("Leave")) {
                sentence.add(sp[1] + " " + mess[1]);
            } else {
                idName.replace(sp[1], sp[2]);
            }
        }
        
        int len = sentence.size();
        
        String[] an = new String[len];
        
        for(int i = 0; i < len; i++) {
            
            String[] sp = sentence.get(i).split(" ");
            an[i] = idName.get(sp[0]) + sp[1] + " " +  sp[2];
        }
        
        return an;
    }
}