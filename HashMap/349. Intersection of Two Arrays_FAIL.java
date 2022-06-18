class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums1){
            map.put(i,null);
        }
        
        for(int i:nums2){
            if(map.containsKey(i)){
                map.put(i,i);
            }
        }
        int[] result = new int[map.keySet().size()];
        for(int i :map.keySet()){
            if(map.get(i) != null){
                result.put(i);
            }
        }
        return result;
    }
}