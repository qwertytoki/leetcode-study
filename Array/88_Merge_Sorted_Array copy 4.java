
class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //後ろから決めていく
        int mpointer = m - 1;
        int npointer = n - 1;
        int length = m + n - 1;
        for (int i = length; i >= 0; i--) {
            int mVal = mpointer < 0 ? -120000 : nums1[mpointer];
            int nVal = npointer < 0 ? -120000 : nums2[npointer];
            if (mVal < nVal) {
                nums1[i] = nVal;
                npointer--;
            } else {
                nums1[i] = mVal;
                mpointer--;
            }
        }
    }
}
