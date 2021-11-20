# 1710. Maximum Units on a Truck

## problem description

You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:

numberOfBoxesi is the number of boxes of type i.
numberOfUnitsPerBoxi is the number of units in each box of the type i.
You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.

Return the maximum total number of units that can be put on the truck.

Example 1:

Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
Output: 8
Explanation: There are:

- 1 box of the first type that contains 3 units.
- 2 boxes of the second type that contain 2 units each.
- 3 boxes of the third type that contain 1 unit each.
  You can take all the boxes of the first and second types, and one box of the third type.
  The total number of units will be = (1 _ 3) + (2 _ 2) + (1 \* 1) = 8.

Constraints:
1 <= boxTypes.length <= 1000
1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000
1 <= truckSize <= 106

## solve

greedy:

We can easiliy observe that it will always be better to choose the box with maximum number of units in it so that the overall number of units that can be put on truck is maximized.

## code

```java
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2)->{
            return o2[1]-o1[1];
        });
        int res = 0;

        int i=0, n=boxTypes.length;
        while(i<n && truckSize>0){
            int box = Math.min(boxTypes[i][0], truckSize);
            truckSize -= boxTypes[i][0];
            res += box*boxTypes[i][1];
            i++;
        }

        return res;
    }
}
```
