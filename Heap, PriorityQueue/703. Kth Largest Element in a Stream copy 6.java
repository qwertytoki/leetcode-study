class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for(int i:nums){
            pq.add(i);
        }
        while(pq.size()>k){
            pq.poll();
        }
    }
    
    public int add(int val) {
        pq.add(val);
        while(pq.size()>k){
            pq.poll();
        }
        return pq.peek();
    }
}

// time: O(Nlog(N)+ Mlog(K))
// space: O(n)