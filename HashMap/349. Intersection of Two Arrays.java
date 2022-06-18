class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int i :nums1){
            set1.add(i);
        }
        for(int i :nums2){
            set2.add(i);
        }
        
        int[] result = new int[set1.size()];
        int index = 0;
        for(int i:set1){
            if(set2.contains(i)){
                result[index++] = i;
            }
        }
        return Arrays.copyOf(result, index);
    }
}