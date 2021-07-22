// 描述
// 现在有2副扑克牌，从扑克牌中随机五张扑克牌，我们需要来判断一下是不是顺子。
// 有如下规则：
// 1. A为1，J为11，Q为12，K为13，A不能视为14
// 2. 大、小王为 0，0可以看作任意牌
// 3. 如果给出的五张牌能组成顺子（即这五张牌是连续的）就输出true，否则就输出false。
// 例如：给出数据[6,0,2,0,4]
// 中间的两个0一个看作3，一个看作5 。即：[6,3,2,5,4]
// 这样这五张牌在[2,6]区间连续，输出true
// 数据保证每组5个数字，每组最多含有4个零，数组的数取值为 [0, 13]

// 示例1
// 输入：[6,0,2,0,4]
// 返回值：true

// 示例2
// 输入：[0,3,2,6,4]
// 返回值：true

// 示例3
// 输入：[1,0,0,1,0]
// 返回值：false

// 示例4
// 输入：[13,12,11,0,1]
// 返回值：false

// 解题思路
// 除大小王外，所有牌 无重复 ；
// 设此 55 张牌中最大的牌为 max ，最小的牌为 min（大小王除外），则需满足：
// max - min < 5
// 用hashset来检查 有没有重复的牌
// 遇到大小王就跳过

import java.util.*;

public class Solution {
    public boolean IsContinuous(int [] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int num : nums){
            if(num==0) continue;
            if(set.contains(num))
                return false;
            max = Math.max(max, num);
            min = Math.min(min, num);

            //！！！！！！！
            if(max-min>=5)
                return false;
            set.add(num);
        }
        return true;
    }
}