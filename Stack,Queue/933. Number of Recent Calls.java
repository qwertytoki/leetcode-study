class RecentCounter {
    LinkedList<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        queue.add(t);
        boolean isInRange = false;
        while(!isInRange){
            int i = queue.peek();
            if(t - 3000 > i){
                isInRange = false;
                queue.poll();
            }else{
                isInRange = true;
            }
        }
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */