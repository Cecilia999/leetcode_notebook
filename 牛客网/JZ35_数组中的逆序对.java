// 题目大意
// 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
// 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007

// 输入描述：
// 题目保证输入的数组中没有的相同的数字
// 示例1
// 输入：
// [1,2,3,4,5,6,7,0]
// 返回值：
// 7

//解题思路
//方法1
// 对于此题，按住一个arr[i], 依次判断{i+1 ... n-1]是否满足条件。n为数组的大小。
//     代码如下：
//     class Solution {
//     private:
//         const int kmod = 1000000007;
//     public:
//         int InversePairs(vector<int> data) {
//             int ret = 0;
//             int n = data.size();
//             for (int i = 0; i < n; ++i) {
//                 for (int j = i + 1; j < n; ++j) {
//                     if (data[i] > data[j]) {
//                         ret += 1;
//                         ret %= kmod;
//                     }
//                 }
//             }
     
//             return ret;
//         }
//     };
//     对于10^5数据，O(N^2)算法显然超时。
//     时间复杂度：O(N^2)
//     空间复杂度：O(1)

//方法2
//这道题就是考察merge sort
//把array分成左右两个有序区间，left <-> mid vs mid+1 <-> right
//如果左区间的i>右区间的j
//那么从i到mid的每一个值都大于 右区间的j
//逆序对的数量count += mid-i+1

public class Solution {
    public int InversePairs(int [] array) {
        int[] temp = new int[array.length];
        int res = sort(array, 0, array.length-1, temp, 0);
        return res;
    }
    
    public int sort(int[] arr, int left, int right, int[] temp, int count){
        int res = 0;
        if(left<right){
            int mid = left + (right-left)/2;
            res += sort(arr, left, mid, temp, count);
            res += sort(arr, mid+1, right, temp, count);
            
            res += merge(arr, left, mid, right, temp, count);
        }
        return res % 1000000007;
    }
    
    public int merge(int[] arr, int left, int mid, int right, int[] temp, int count){
        int i=left;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=right){
            if(arr[i]<=arr[j])
                temp[k++] = arr[i++];
            else{
                temp[k++] = arr[j++];
                
                //左边和右边都是部分有序，如果arr[i]>arr[j]
                //那么i～mid 都会大于add[j]，都是逆序对
                count += mid-i+1;        
                count %= 1000000007;
            }
        }
        
        while(i<=mid)
            temp[k++] = arr[i++];
        while(j<=right)
            temp[k++] = arr[j++];
        
        k=0;
        while(left<=right){
            arr[left++] = temp[k++];
        }
        
        return count;
    }
    
}