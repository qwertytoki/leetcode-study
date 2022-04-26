class Solution {
    public int heightChecker(int[] heights) {
        // make a soretd array
        // compare sorted array and provided array
        int[] sorted = new int[heights.length];
        for(int i = 0;i<heights.length;i++){
            sorted[i]=heights[i];
        }
        Arrays.sort(sorted);
        int diff = 0;
        for(int i = 0;i<heights.length;i++){
            if(heights[i]!=sorted[i]){
                diff++;
            }
        }
        return diff;
    }
}