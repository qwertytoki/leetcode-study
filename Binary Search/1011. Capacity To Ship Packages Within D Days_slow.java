class Solution {
    public int shipWithinDays(int[] weights, int days) {
      //解けないので地道にやる -> この解法は Time Limit Exceeded
      // sort them and pick the heaviest. -> is the start point
      // while resultPassed == false
      // current = 0; 
      // accumerate, if it over, pick previous one. and add current +1
      // 
      int[] sorted = Arrays.copyOf(weights, weights.length);
      Arrays.sort(sorted);
      int capacity = sorted[sorted.length-1];
      boolean resultPassed = false;
      
      while(!resultPassed){
        int currentWeights = 0;
        int currentDays = 1;
        int index = 0;
        while(index < weights.length){
          if(currentWeights + weights[index] > capacity){
            currentDays++;
            currentWeights = 0;
          }else{
            currentWeights += weights[index];
            index++;
          }
        }
        if(currentDays <= days){
          resultPassed = true;
        }else{
          capacity++;
        }
      }
      return capacity;
    }
}