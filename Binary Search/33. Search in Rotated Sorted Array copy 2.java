class Solution {
    int[] nums;
    int target;
    public int search(int[] nums, int target) {
        // 折り返し点をみつける
        // 左端〜折返し点 折り返し点〜右端 どちらにtargetがあるかを見極め、searchする
        this.nums = nums;
        this.target = target;
        int start= 0;
        int end = nums.length-1;
        if(end == 0){
            return nums[0]==target ? 0 : -1;
        }
        int minPoint = findMinimum(start, end);
        
        if(target == nums[minPoint]){
            return minPoint;
        }
        if(minPoint == 0){
            return search(start,end);
        }
        if(nums[start]<= target && target<= nums[minPoint-1]){
            return search(start, minPoint-1);
        }
        if(nums[minPoint]<= target && target <= nums[end]){
            return search(minPoint+1,end);
        }
        return -1;
    }

    private int findMinimum(int start, int end){
        if(nums[start]<nums[end]){
            return 0;
        }
            
        while(start<=end){
            int mid = (start + end)/2;
            if(nums[mid]>nums[mid+1]){
                return mid+1;
            }
            if(nums[mid-1]>nums[mid]){
                return mid;
            }
            if(nums[mid] > nums[start]){
                start = mid +1;  
            }else{
                end = mid -1;
            }
        }
        return -1;
    }

    private int search(int start, int end){
        while(start<=end){
            int mid = (start + end)/2;
            if(target == nums[mid]){
                return mid;
            }
            if(target>nums[mid]){
                start = mid+1;
            }else{
                end = mid -1;
            }
        }
        return -1;
    }
}