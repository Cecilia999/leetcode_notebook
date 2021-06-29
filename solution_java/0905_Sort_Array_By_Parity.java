//思路：two pointer -->> slow fast
// fast寻找下一个偶数，找到就swap slow and fast
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        for(int i=0, j=0; j<nums.length&&i<nums.length; j++){
            if(nums[j]%2==0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i++] = temp;
            }
        }
        
        return nums;
    }
}