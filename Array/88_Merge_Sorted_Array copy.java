class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0){
            return;
        }
        int mIndex = 0;
        int nIndex = 0;
        List<Integer> list = new ArrayList<>();
        while(list.size()< m+n){
            int mVal = mIndex<m ? nums1[mIndex] : Integer.MAX_VALUE;
            int nVal = nIndex<n ? nums2[nIndex] : Integer.MAX_VALUE;
            if(mVal<=nVal){
                list.add(nums1[mIndex]);
                mIndex++;
            }else{
                list.add(nums2[nIndex]);
                nIndex++;
            }
        }
        for(int i =0; i< list.size(); i++){
            nums1[i] = list.get(i);
        }
    }
}