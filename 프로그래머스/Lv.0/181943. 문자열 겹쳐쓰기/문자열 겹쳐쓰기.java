class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        StringBuilder sb = new StringBuilder(my_string);
        my_string = String.valueOf(sb.replace(s,s+overwrite_string.length(),overwrite_string));
        return my_string;
    }
}