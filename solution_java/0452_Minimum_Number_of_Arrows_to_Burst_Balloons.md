# 452. Minimum Number of Arrows to Burst Balloons

## PD
There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [x_start, x_end] denotes a balloon whose horizontal diameter stretches between x_start and x_end. You do not know the exact y-coordinates of the balloons.

Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with x_start and x_end is burst by an arrow shot at x if x_start <= x <= x_end. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.

Given the array points, return the minimum number of arrows that must be shot to burst all balloons.

 

Example 1:

Input: points = [[10,16],[2,8],[1,6],[7,12]]
Output: 2
Explanation: The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
Example 2:

Input: points = [[1,2],[3,4],[5,6],[7,8]]
Output: 4
Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.
Example 3:

Input: points = [[1,2],[2,3],[3,4],[4,5]]
Output: 2
Explanation: The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
- Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
 

Constraints:

1 <= points.length <= 105
points[i].length == 2
-231 <= xstart < xend <= 231 - 1

## solution

Greedy + Arrays.sort()

Sort by the Xend

We know that eventually we have to shoot down every balloon, so for each ballon there must be an arrow whose position is between balloon[0] and balloon[1] inclusively. Given that, we can sort the array of balloons by their ending position. Then we make sure that while we take care of each balloon in order, we can shoot as many following balloons as possible.

So what position should we pick each time? We should shoot as to the right as possible, because since balloons are sorted, this gives you the best chance to take down more balloons. Therefore the position should always be balloon[i][1] for the ith balloon.

This is exactly what I do in the for loop: check how many balloons I can shoot down with one shot aiming at the ending position of the current balloon. Then I skip all these balloons and start again from the next one (or the leftmost remaining one) that needs another arrow.

注意Arrays.sort() 的寫法，這個test case裏有 [[-2147483646,-2147483645],[2147483646,2147483647]]
```java
Arrays.sort(points, (o1, o2)->{
    if(o1[1] == o2[1]) return 0;
    if(o1[1] < o2[1]) return -1;
})
```
*We could not use o1[1]-o2[1] here because the edge case [[-2147483646,-2147483645],[2147483646,2147483647]] will overflow.*

## code

```java
class Solution {
    public int findMinArrowShots(int[][] points) {
        //find how many overlaps are there, similar to meeting room 2
        int numOfBallons = points.length;

        // Arrays.sort(points, new Comparator<int[]>(){
        //     @Override 
        //     public int compare(int[] o1, int[] o2) {
        //         return o1[1]-o2[1];
        //     }
        // });
        
        // sort by x_end
        Arrays.sort(points, (o1, o2) -> {
            // We can't simply use the o1[1] - o2[1] trick, as this will cause an 
            // integer overflow for very large or small values.
            if (o1[1] == o2[1]) return 0;
            if (o1[1] < o2[1]) return -1;
            return 1;
        });

        int overlap = 0;
        int nextBallonEnd = 0;
        for(int i=0; i<numOfBallons; i++) {
            if(points[i][0] <= points[nextBallonEnd][1]) {
                overlap++;
            }
            else {
               nextBallonEnd = i; 
            }
        }

        return numOfBallons-overlap+1;
    }
}
```

Time complexity : O(Nlog⁡N) because of sorting of input data.

Space complexity : O(N) or O(log⁡N) depending on programming language. Jave cost O(log⁡N) to sort

