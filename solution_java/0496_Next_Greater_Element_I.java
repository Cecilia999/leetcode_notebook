// 题目大意
// 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
// 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
// nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。

// 示例 1:
// 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
// 输出: [-1,3,-1]

// 解题思路
// 当nums2[i]比要栈顶要大，即找到了栈顶的下一个最大最大元素，加入map，出栈
// 遍历nums1[]如果存在在map中，return map.get（nums1[i]），否则return -1

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i<nums2.length; i++){
            while(!stack.isEmpty() && stack.peek()<nums2[i]){
                map.put(stack.peek(), nums2[i]);
                stack.pop();
            }
            stack.push(nums2[i]);
        }
        
        int[] res = new int[nums1.length];
        for(int i=0; i<res.length; i++){
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}