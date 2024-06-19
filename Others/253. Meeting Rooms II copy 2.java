class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->(a[0]-b[0]));
        List<Integer> roomsEndTime = new ArrayList<>();
        roomsEndTime.add(intervals[0][1]);
        for(int i = 1; i<intervals.length; i++){
            boolean allUsed = true;
            for(int j = 0; j<roomsEndTime.size(); j++){
                int endTime = roomsEndTime.get(j);
                if(endTime<=intervals[i][0]){
                    roomsEndTime.set(j,intervals[i][1]);
                    allUsed = false;
                    break;
                }
            }
            if(allUsed){
                roomsEndTime.add(intervals[i][1]);
            }
        }
        return roomsEndTime.size();
    }
}