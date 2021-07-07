//题目大意：使得偶数位于奇数前

//思路：two pointer -->> slow fast
// fast寻找下一个偶数，找到就swap slow and fast
//slow指向的一定是奇数
//只要是偶数在奇数前就行，顺序没有要求
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int slow=0, fast=0;
        
        for( ; slow<nums.length && fast<nums.length; fast++){
            if(nums[fast]%2==0){
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
            }
        }
        
        return nums;
    }
}