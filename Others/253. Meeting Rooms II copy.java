class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // PriorityQueue使って、終了時間過ぎてるMTG ROOMを開放していく
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] interval : intervals){
            if(pq.size() > 0){
                if(pq.peek()<= interval[0]){
                    pq.poll();
                }
            }
            pq.add(interval[1]);
        }
        return pq.size();
    }
}