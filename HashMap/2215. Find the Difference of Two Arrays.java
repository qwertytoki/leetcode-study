class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i : nums1){
            set1.add(i);
        }
        for(int i : nums2){
            set2.add(i);
        }
        
        Set<Integer> res1 = new HashSet<>();
        Set<Integer> res2 = new HashSet<>();

        for(int i : nums1){
            if(!set2.contains(i)){
                res1.add(i);
            }
        }
        for(int i : nums2){
            if(!set1.contains(i)){
                res2.add(i);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>(res1));
        result.add(new ArrayList<Integer>(res2));
        return result;
    }
}
