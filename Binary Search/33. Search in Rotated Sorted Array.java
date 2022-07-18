class Solution {
    int [] nums;
    int target;
    
    public int search(int[] nums, int target) {
        // まず最小値(ローテーション)を探して、その後2つの配列でバイナリサーチをかける
        this.nums = nums;
        this.target = target;
        int n = nums.length;

        if(n==1){
            return nums[0]==target?0:-1;
        }
        int rotateIdx = findRotateIndex(0,n-1);

        //ターゲットが最小値かをチェック
        if(target == nums[rotateIdx]){
            return rotateIdx;
        }
        //ローテーションしてないのであれば、ただのバイナリサーチ
        if(rotateIdx ==0){  
            return search(0,n-1);    
        }
        
        //ローテーションしてるなら、ターゲットとnums[0]を比較
        //ターゲットのほうが小さければ右側を、 nums[0]のほうが小さければ左側をバイナリサーチ
        if(target < nums[0]){
            return search(rotateIdx,n-1);
        }else{
            return search(0,rotateIdx);
        }
    }
        
        
        
    public int search(int left,int right){
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]== target){
                return mid;
            }

            if(target > nums[mid]){
                left= mid+1;
            }else{
                right = mid-1;
            }
        }

        return -1;
    }

    public int findRotateIndex(int left, int right){
        if(nums[left]< nums[right]){
            return 0;
        }
        while(left <= right){
            int pivot = (left + right)/2;
            if(nums[pivot]>nums[pivot+1]){
                return pivot+1;
            }
            else{
                if(nums[pivot]<nums[left]){
                    right = pivot-1;
                }else{
                    left = pivot+1;
                }
            }
        }
        return 0;
    }
        
}