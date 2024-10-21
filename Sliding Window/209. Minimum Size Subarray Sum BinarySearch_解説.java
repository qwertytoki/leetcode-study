class Solution {
    /**
    例: nums = [2, 3, 1, 2, 4, 3]、target = 7

	1.	初期設定:
		left = 1
		right = 6
	2.	最初の二分探索の試行:
		mid = (1 + 6) / 2 = 3
		isValid(3, 7, prefixSum)をチェック:
		サブ配列の長さ3の和をチェック:
		prefixSum[3] - prefixSum[0] = 6 - 0 = 6 (ダメ)
		prefixSum[4] - prefixSum[1] = 8 - 2 = 6 (ダメ)
		prefixSum[5] - prefixSum[2] = 12 - 5 = 7 (OK)
		この時点で、minLengthは3になります。
		rightをmid - 1に設定 (right = 2)
	3.	次の二分探索の試行:
		mid = (1 + 2) / 2 = 1
		isValid(1, 7, prefixSum)をチェック:
		サブ配列の長さ1の和をチェック:
		どのサブ配列もtarget以上ではないため、leftをmid + 1に設定 (left = 2)
	4.	次の二分探索の試行:
		mid = (2 + 2) / 2 = 2
		isValid(2, 7, prefixSum)をチェック:
		サブ配列の長さ2の和をチェック:
		prefixSum[2] - prefixSum[0] = 5 - 0 = 5 (ダメ)
		prefixSum[3] - prefixSum[1] = 6 - 2 = 4 (ダメ)
		prefixSum[4] - prefixSum[2] = 8 - 5 = 3 (ダメ)
		prefixSum[5] - prefixSum[3] = 12 - 6 = 6 (ダメ)
		prefixSum[6] - prefixSum[4] = 15 - 8 = 7 (OK)
		この時点で、minLengthは2になります。
		rightをmid - 1に設定 (right = 1)

これで、最小のサブ配列の長さは2となり、結果を返します。
     */
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n+1];
        for(int i = 0; i<n; i++){
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }
        int left = 1, right = n;
        int minLength = 0;
        while(left <= right){
            int mid = (left + right)/2;
            if(isValid(mid, target, prefixSum)){
                minLength = mid;
                right =mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return minLength;
    }

    private boolean isValid(int length, int target, int[] prefixSum ){
        for(int i =0; i+ length < prefixSum.length; i++){
            if(prefixSum[i+length] - prefixSum[i] >= target){
                return true;
            }
        }
        return false;
    }
}