class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        int j = 0;
        MedianFinder mf = new MedianFinder();
        for(int i = 0; i < nums.length; i++){
            if(mf.size >= k){
                mf.remove(nums[i - k]);
            } 
            mf.addNum(nums[i]);
            if(i >= k - 1){
                res[j++] = mf.findMedian();
            } 
        }
        return res;
    }
    
    class MedianFinder {

        /** initialize your data structure here. */
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;
        int size = 0;
        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        }

        public void addNum(int num) {
//         maxHeap has one more element than minHeap
            if(maxHeap.isEmpty() || num <= maxHeap.peek()){
                maxHeap.offer(num); 
            }else{
                minHeap.offer(num);
            }

            balance();
            ++size;
        }

        public void remove(int num){
            if(maxHeap.contains(num)){
                maxHeap.remove(num);
            }else{
                minHeap.remove(num);
            }
            balance();
            --size;
        }

        public double findMedian() {
            if(size % 2 == 1){
                return (double)maxHeap.peek();
            }else{
                return (double)maxHeap.peek() + ((double)minHeap.peek() - (double)maxHeap.peek()) / 2.0;
            }
        }


        private void balance(){
            while(minHeap.size() > maxHeap.size()){
                maxHeap.offer(minHeap.poll());
            }
            while(maxHeap.size() > minHeap.size() + 1){
                minHeap.offer(maxHeap.poll());
            }
        }
    }
}
