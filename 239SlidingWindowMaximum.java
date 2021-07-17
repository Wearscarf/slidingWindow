// 239SlidingWindowMaximum
class Solution {
//     maintain a non-increasing deque, store the index
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int len = nums.length;
        int[] res = new int[len - k + 1];
        int j = 0;
        for(int i = 0; i < len; i++){
            if(!deque.isEmpty() && i - deque.peekFirst() == k){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            if(i >= k - 1) res[j++] = nums[deque.peekFirst()];
        }
        return res;
    }
}
