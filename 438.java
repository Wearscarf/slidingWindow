class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] hash = new int[26];
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < p.length(); i++){
            hash[p.charAt(i) - 'a']++;
        }
//         num of char need to be matched
        int cnt = p.length();
        int i = 0, j = 0;
        while(j < s.length()){
//             negative numbers mean that it's not on p
            if(hash[s.charAt(j++) - 'a']-- >= 1){
                --cnt;
            }
            if(cnt == 0) res.add(i);
//             should be positive or 0 on hashmap, meaning that they exist on p
            if(j - i == p.length() && hash[s.charAt(i++) - 'a']++ >= 0){
                ++cnt;
            } 
        }
        return res;
    }
}
