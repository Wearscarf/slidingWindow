3. Longest Substring Without Repeating Characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        int ans = 0;
        while(j < s.length()){
            char cur = s.charAt(j);
            if(set.add(cur)){
                ans = Math.max(ans, j++ - i + 1);
            }else{
                while(set.contains(s.charAt(j))){
                    set.remove(s.charAt(i++));
                }
            }
        }
        return ans;
    }
}
