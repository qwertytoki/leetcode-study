class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int greatest = 0;
        for(int candy: candies){
            greatest = Math.max(greatest, candy);
        }
        List<Boolean> result = new ArrayList<>();
        
        for(int candy:candies){
            if(candy + extraCandies >= greatest){
                result.add(true);
            }else{
                result.add(false);
            }
        }
        return result;
    }
}