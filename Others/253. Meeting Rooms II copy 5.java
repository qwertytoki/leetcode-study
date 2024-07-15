class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<int[]> startPq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        PriorityQueue<int[]> endPq = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        int count = 1;
        for(int[] interval:intervals){
            startPq.add(interval);
        }
        int[] val =  startPq.poll();
        endPq.add(val);
        while(!startPq.isEmpty()){
            val =  startPq.poll();
            if(val[0]>=endPq.peek()[1]){
                endPq.poll();
            }
            endPq.add(val);
            count = Math.max(endPq.size(), count);
            
        }

        return count;
        
    }
}