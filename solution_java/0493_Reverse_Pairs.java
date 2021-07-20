// 题目大意 #
// 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
// 你需要返回给定数组中的重要翻转对的数量。

// 注意:
// 给定数组的长度不会超过 50000。
// 输入数组中的所有数字都在 32 位整数的表示范围内。

//解题思路
//再merge sort的基础上，先计算nums[i] > 2*nums[j]的数量，再进行排序

class Solution {
    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        return sort(nums, 0, nums.length-1, temp, 0);
    }
    
    public int sort(int[] arr, int left, int right, int[] temp, int count){
        int res = 0;
        if(left<right){
            int mid = left + (right-left)/2;
            
            res += sort(arr, left, mid, temp, count);
            res += sort(arr, mid+1, right, temp, count);
            
            //先数数，再排序
            res += countAmount(arr, left, mid, right, count);
            merge(arr, left, mid, right, temp);
        }
        return res;
    }
    
    public int countAmount(int[] arr, int left, int mid, int right, int count){
        int i=left;
        int j=mid+1;
        int k=0;
        
         while(i <= mid){
             //It's so tricky to use : nums[i] / 2.0 > nums[j] rather than nums[i] > nums[j] * 2 to avoid overflow 1!!
            while (j <= right && (arr[i] / 2.0 > arr[j]) ) {
                j++;
            }
            count += j - mid - 1;
            i++;
        }
        
        return count;
    }
    
    public void merge(int[] arr, int left, int mid, int right, int[] temp){
        int i=left;
        int j=mid+1;
        int k=0;
        
        while(i<=mid && j<=right){
            if(arr[i]<=arr[j] ){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }
        
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        while(j<=right){
            temp[k++] = arr[j++];
        }
        
        k = 0;
        while(left<=right){
            arr[left++] = temp[k++];
        }
    }
}