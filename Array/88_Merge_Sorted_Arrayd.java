class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m-1;
        int index2 = n-1;
        
        for(int i = nums1.length-1; i>=0; i--){
            if(index2 < 0){
                break;
            }
            if(index1 < 0){
                for(int j = index2;j>=0; j--){
                    nums1[i]=nums2[j];
                    i--;
                }
                break;
            }
            if(nums1[index1]>=nums2[index2]){
                nums1[i] = nums1[index1];
                index1--;
            }else{
                nums1[i] = nums2[index2];
                index2--;
            }
        }
        
    }
}