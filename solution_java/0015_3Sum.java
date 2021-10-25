//解题大意
//two sum的升级版
//nums[low] + nums[high] = nums[i]

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length-2; i++){
            int low = i+1, high = nums.length-1;
            
            if(i>0 && nums[i]==nums[i-1]) continue;
            
            while(low<high){
                if(nums[low] + nums[high] == -nums[i]){
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    
                    //如果接来的也相同的话就跳过
                    while(low<high && nums[low]==nums[low+1]) low++;
                    while(low<high && nums[high]==nums[high-1]) high--;
                    low++;
                    high--;
                }                    
                else if(nums[low] + nums[high] > -nums[i])
                    high--;
                else 
                    low++;
            }
        }
        
        return res;
    }
}