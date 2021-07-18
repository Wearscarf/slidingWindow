class Solution {
    public String minWindow(String s1, String s2) {
//         i and j are corresponding index on s1 and s2
        if(s2.length() > s1.length()) return "";
        int i = 0, j = 0;
        int len = Integer.MAX_VALUE;
        String res = "";
        while(i < s1.length()){
            if(s1.charAt(i) == s2.charAt(j)){
                ++j;
//                 we find a match, backtrack
                if(j == s2.length()){
                    --j;
                    int endOnS1 = i;
                    while(j >= 0){
                        if(s2.charAt(j) == s1.charAt(i)){
                            --j;
                        }
                        --i;
                    }
//                     we deduct one more index in the previous while loop
                    ++i;
                    ++j;
                    if(endOnS1 - i + 1 < len){
                        res = s1.substring(i, endOnS1 + 1);
                        len = endOnS1 - i + 1;
                        // System.out.println(res);
                    }
                }
            }
            ++i;
        }
        return res;
    }
}
