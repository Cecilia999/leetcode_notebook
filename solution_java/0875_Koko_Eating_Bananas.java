// 题目大意
// 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
// 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
// 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
// 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。

// 示例 1：
// 输入: piles = [3,6,7,11], H = 8
// 输出: 4

// 示例 2：
// 输入: piles = [30,11,23,4,20], H = 5
// 输出: 30

// 示例 3：
// 输入: piles = [30,11,23,4,20], H = 6
// 输出: 23

// 解题思路
// 做速度的二分法

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //1. getMaxSpeed
        int high = Integer.MIN_VALUE;
        for(int i=0; i<piles.length; i++){
            high = Math.max(high, piles[i]);
        }
        
        //2. binary search between speed=1 to max speed
        int low=1;
        while(low<=high){
            int mid = low + (high-low)/2;

            //耗时太多，速度不够大
            if(eatAll(piles, mid) > h)
                low = mid + 1;

            // 没有区分eatAll(piles, mid) == h是因为
            // 当「二分查找」算法猜测的速度恰好使得珂珂在规定的时间内吃完香蕉的时候，
            // 还应该去尝试更小的速度是不是还可以保证在规定的时间内吃完香蕉。
            // 这是因为题目问的是「最小速度 」。
            else
                high = mid - 1;
        }
        
        return low;
    }
    
    private int eatAll(int[] piles, int speed){
        int hours = 0;
        for(int pile : piles){
            hours += (pile/speed);
            if(pile%speed!=0)
                hours++;
        }
        return hours;
    }
}