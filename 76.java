class Solution {
    public String minWindow(String s, String t) {
        int i = 0, j = 0;
        int sLen = s.length();
        int tLen = t.length();
        int start = 0, end = sLen + 1;
//         the characters to be matched in s
        int cnt = t.length();
        Map<Character, Integer> map = new HashMap<>();
        for(int m = 0; m < tLen; m++){
            map.put(t.charAt(m), map.getOrDefault(t.charAt(m), 0) + 1);
        }
        while(j < s.length()){
            char cur = s.charAt(j);
            if(!map.containsKey(s.charAt(j))){
                ++j;
                continue;
            }
//             if a value of character in map is negtive
//             which means that the char in s is overused and doesn't count to cnt
            map.put(cur, map.get(cur) - 1);
            if(map.get(cur) >= 0){
                --cnt;
            }
//             there's a match
            while(cnt == 0){
                if(j - i + 1 < end - start + 1){
                    start = i;
                    end = j;
                }
                char curChar = s.charAt(i++);
                if(map.containsKey(curChar)){
                    map.put(curChar, map.get(curChar) + 1);
                    if(map.get(curChar) > 0){
                        ++cnt;
                    }
                }
            }
            ++j;
        }
        return end - start == s.length() + 1 ? "" : s.substring(start, end + 1);
    }
}
