class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        // this is difficult
        // for loop and get index, all value should be there, 
        // so nums[index] should have value.
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            nums[i] = - nums[nums[i]-1];
        }
        for(int i = 0; i<nums.length; i++){
            if(nums[i] > 0){
                result.add(i+1);
            }
        }
        return result;
    }
}