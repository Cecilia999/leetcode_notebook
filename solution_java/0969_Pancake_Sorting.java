// 题目大意
// 给你一个整数数组 arr ，请使用 煎饼翻转 完成对数组的排序。

// 一次煎饼翻转的执行过程如下：

// 选择一个整数 k ，1 <= k <= arr.length
// 反转子数组 arr[0...k-1]（下标从 0 开始）
// 例如，arr = [3,2,1,4] ，选择 k = 3 进行一次煎饼翻转，反转子数组 [3,2,1] ，得到 arr = [1,2,3,4] 。

// 以数组形式返回能使 arr 有序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * arr.length 范围内的有效答案都将被判断为正确。

// 示例1
// 输入：[3,2,4,1]
// 输出：[4,2,4,3]
// 解释：
// 我们执行 4 次煎饼翻转，k 值分别为 4，2，4，和 3。
// 初始状态 arr = [3, 2, 4, 1]
// 第一次翻转后（k = 4）：arr = [1, 4, 2, 3]
// 第二次翻转后（k = 2）：arr = [4, 1, 2, 3]
// 第三次翻转后（k = 4）：arr = [3, 2, 1, 4]
// 第四次翻转后（k = 3）：arr = [1, 2, 3, 4]，此时已完成排序。 

// 提示
// 1 <= arr.length <= 100
// 1 <= arr[i] <= arr.length
// arr 中的所有整数互不相同（即，arr 是从 1 到 arr.length 整数的一个排列）

// 解题思路
// 1. find the next max num that are not sorted
//     但是题目已经说明了只会有1-n不重复的数字，所以也可以直接利用这一点
// 2. 从max num处翻转到队头，在把max num翻转到unsorted部分的队尾
//     记录max num一开始的index和 unsorted_arr.length的index

class Solution {
    public static List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            int nextMax = findNext(arr, arr.length-i);
            flip(arr, nextMax);
            res.add(nextMax+1);
            flip(arr, arr.length-i-1);
            res.add(arr.length-i);
        }

        return res;
    }

    public static int findNext(int[] arr, int end){
        int max = arr[0], index = 0;
        for (int i = 1; i < end; i++) {
            if(arr[i]>max){
                max = arr[i];
                index = i;
            }
        }
        return index;
    }

    public static void flip(int[] arr, int index){
        for(int i=0, j=index; i<j; i++, j--){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}