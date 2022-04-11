class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> halfSet = new HashSet<>();
        for(int i:arr){
            if( i!=0 && i%2==0){
                halfSet.add(i/2);
            }
        }
        for(int i : arr){
            if(halfSet.contains(i)){
                return true;
            }
        }
        return false;
    }
}