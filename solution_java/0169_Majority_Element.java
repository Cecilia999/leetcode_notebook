// 题目大意
// 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。

// method3 : Boyer-Moore 投票算法
// time complexity:O(n) && space complexity:O(1)

class Solution {
    public int majorityElement(int[] nums) {
        //Boyer-Moore 投票算法
        // 投票算法证明：
        // - 如果候选人不是maj 则 maj,会和其他非候选人一起反对 会反对候选人,所以候选人一定会下台(maj==0时发生换届选举)
        // - 如果候选人是maj , 则maj 会支持自己，其他候选人会反对，同样因为maj 票数超过一半，所以maj 一定会成功当选
        
        //用count来记录当前数的得票数，
        //如果当前数==candidate，得票数++，else 得票数--
        //如果当前candidate是majority，那count永远不会==0
        
        int count = 0, candidate=nums[0];
        for(int num : nums){
            if(count==0)
                candidate = num;
            
            if(num==candidate)
                count++;
            else
                count--;
        }
        return  candidate;
    }
}

// method1: HashMap 
// time complexity:O(n) && space complexity:O(n)
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
                if(counts.get(num)>nums.length/2)
                    return num;
            }
        }
        return nums[nums.length-1];
    }
}

// method2: Arrays.sort() 
// time complexity:O(nlogn) && space complexity:O(logn)
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];   //因为出现次数比n/2多的数字，一定会占用nums[nums.length/2]的位置
    }
}