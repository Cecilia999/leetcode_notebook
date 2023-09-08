# 253. Meeting Rooms II

## Problem Description

Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

 

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1
 

Constraints:

1 <= intervals.length <= 104
0 <= starti < endi <= 106

## Solution

```java
class Solution {
    //Arrays.sort() + two pointer

    public int minMeetingRooms(int[][] intervals) {
        //sort with meeting start time, if meeting start time is the same then sort with end time in ascending order
        int start[] = new int[intervals.length];
        int end[] = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int rooms = 0;
        int last = 0;
        for(int cur=0; cur<intervals.length; cur++) {
            int currentMeetingStartTime = start[cur];
            int lastMeetingEndTime = end[last];
            //calculate how many meetings started before the next earliest-ended meeting ends
            if(currentMeetingStartTime < lastMeetingEndTime) {
                rooms++;
            }
            //move to next earliest-ended meeting
            else{
                last++;
            }
        }

        return rooms;
    }
}
```