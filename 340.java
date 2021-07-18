class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int res = 0;
        for(int j = 0; j < s.length(); j++){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            while(map.size() > k){
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if(map.get(s.charAt(i)) == 0) map.remove(s.charAt(i));
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
        
    }
}
