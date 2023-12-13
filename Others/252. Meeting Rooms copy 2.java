class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int max = 0;
        for(int[] interval : intervals){
            max = Math.max(max, interval[1]);
        }
        int[] available = new int[max+1];
        for(int[] interval : intervals){
            for(int i = interval[0]; i< interval[1]; i++){
                if(available[i] == 1){
                    return false;
                }else{
                    available[i] = 1;
                }
            }
        }
        return true;
    }
}