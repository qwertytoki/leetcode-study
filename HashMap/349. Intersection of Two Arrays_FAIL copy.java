class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //0 corner case
        //1 Create HashSet for nums1,nums2.
        //2 Create int[] whose size is longer one of nums1 or nums2.
        //3 for loop by longer nums and put to array if it intersects.
        //4 Cut off the array by index and return it.
        
        //0
        if(nums1.length==0 || nums2.length==0) return new int[0];
        //1
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i : nums1){
            set1.add(i);
        }
        for(int i : nums2){
            set2.add(i);
        }
    
        if(nums1.length >= nums2.length){
            return mergeSet(set1, set2);
        }else{
            return mergeSet(set2, set1);
        }
    }
    private int[] mergeSet(Set<Integer> longerSet, Set<Integer> set){
        //2
        int[] answer = new int[longerSet.size()];
        int idx = 0;
        //3
        for(int i : longerSet){
            if(set.contains(i)){
                answer[idx] = i;
                idx++;
            }
        }
        //4
        return Arrays.copyOf(answer,idx);

    }
}