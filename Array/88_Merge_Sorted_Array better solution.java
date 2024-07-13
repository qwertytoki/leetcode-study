class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mIdx = m-1;
        int nIdx = n-1;
        
        for(int i = m+n-1; i>= 0; i--){
            if(nIdx <0)return;
            
            if(mIdx >= 0 && nums1[mIdx] > nums2[nIdx]){
                nums1[i] = nums1[mIdx--];
            }else{
                nums1[i] = nums2[nIdx--];
            }
        }
    }
}