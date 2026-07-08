class Solution {
    public int solution(int n) {
        int people = n;
        int curPizza = 7;
        int pizzaCount = 1;
        while(people > 0) {
            people--;
            if(curPizza == 0) {
                pizzaCount++;
                curPizza = 7;
            }
            curPizza--;
        }
        return pizzaCount;
    }
}