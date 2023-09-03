class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occMap = new HashMap<>();
        for(int i : arr){
            occMap.put(i, occMap.getOrDefault(i,0)+1);
        }
        Set<Integer> occSet = new HashSet<>();
        for(int i:occMap.keySet()){
            occSet.add(occMap.get(i));
        }
        return occSet.size() == occMap.size();
    }
}