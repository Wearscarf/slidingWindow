class Solution {
    public int longestSubstring(String s, int k) {
        int res = 0;
        for(int i = 1; i <= 26; i++){
            res = Math.max(res, findMax(s, i, k));
        }
        return res;
    }
    
    private int findMax(String s, int num, int k){
        int len = s.length();
        int i = 0; int j = 0;
        int res = 0;
//         character that satisfy the k condition
        int cntNum = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(j < len){
            if(map.size() <= num){
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                if(map.size() <= num && map.get(s.charAt(j)) == k) ++cntNum;
            }
            if(map.size() == num && cntNum == num){
                res = Math.max(j - i + 1, res);
            }
            while(map.size() > num){
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if(map.get(s.charAt(i)) == k - 1){
                    --cntNum;
                }
                if(map.get(s.charAt(i)) == 0){
                    map.remove(s.charAt(i));
                }
                ++i;
            }
            ++j;
            
        }
        return res;
    }
}
