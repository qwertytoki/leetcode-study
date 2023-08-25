class Solution {
    public int largestAltitude(int[] gain) {
        int highest = 0;
        int current = 0;
        for(int i:gain){
            current += i;
            highest = Math.max(highest, current);
        }
        return highest;
    }
}