class KthLargest {
    //1 put everything in the PriorityQueue pq
    //2 remove biggest num from pq until we find Kth largest. 
    //3 in add func, add to pq and remove num if nums > k 
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        //1
        for(int i:nums){
            pq.add(i);
        }

        //2
        while(pq.size()>k){
            pq.poll();
        }
        
    }
    
    public int add(int val) {
        //3 
        pq.add(val);
        if(pq.size() > k){
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */