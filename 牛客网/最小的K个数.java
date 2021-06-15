//这道题就是leetcode215题：kth largest element in an array

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] nums, int k) {
        ArrayList<Integer> list = new ArrayList();
        if(k>nums.length || k==0) return list;
        
        //kth start from 0
        findKthSmallest(nums, 0, nums.length-1, k-1);
        for(int i=0; i<k; i++){
            list.add(nums[i]);
        }
        return list;
    }
    
    private int[] findKthSmallest(int[] nums, int start, int end, int k){
        int pivot=start, l=start, r=end;
        
        while(l<r){
            while(nums[r]>=nums[pivot] && l<r)
                r--;
            while(nums[l]<=nums[pivot] && l<r)
                l++;
            
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
        
        int temp = nums[pivot];
        nums[pivot] = nums[l];
        nums[l] = temp;
        
        if(k==l)
            return nums;
        else if(l<k)
            return findKthSmallest(nums, l+1, end, k);
        else 
            return findKthSmallest(nums, start, l-1, k);
        
    }
}