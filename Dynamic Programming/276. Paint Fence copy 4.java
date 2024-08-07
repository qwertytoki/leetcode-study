class Solution {
    HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
    public int numWays(int i, int k) {
        if (i == 1) return k;
        if (i == 2) return k * k;
        
        
        // Check if we have already calculated totalWays(i)
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        
        // Use the recurrence relation to calculate totalWays(i)
        memo.put(i, (k - 1) * (numWays(i - 1, k) + numWays(i - 2, k)));
        return memo.get(i);
    }

}