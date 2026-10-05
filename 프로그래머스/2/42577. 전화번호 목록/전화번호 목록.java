import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        // 모든 번호를 Set에 넣어둔다 (존재 여부를 O(1)로 조회하기 위해)
        Set<String> ps = new HashSet<>(Arrays.asList(phone_book));
        
        // 모든 번호를 하나씩 검사한다
        for(String num : phone_book) {
            // 각 번호는 번호 셋에 접두어가 포함되는지를 확인하는데
            // 반복해서 확인하는 건 확인할 접두어의 길이를 하나씩 늘리는 방식이다.
            // ex. 12345-> 1, 12, 123, 1234 가 셋에 있는지를 확인한다.
            // 자기 자신을 확인하지는 않는다.
            for(int i = 1; i < num.length(); i++) {
                if(ps.contains(num.substring(0, i))) {
                    return false;
                }
            }
        }
        return true;
    }
}