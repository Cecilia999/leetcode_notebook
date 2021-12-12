# 1353. Maximum Number of Events That Can Be Attended

## problem

Given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.

You can attend an event i at any day d where startTimei <= d <= endTimei. Notice that you can only attend one event at any time d.

Return the maximum number of events you can attend.

Example 1:

Input: events = [[1,2],[2,3],[3,4]]
Output: 3
Explanation: You can attend all the three events.
One way to attend them all is as shown.
Attend the first event on day 1.
Attend the second event on day 2.
Attend the third event on day 3.
Example 2:

Input: events= [[1,2],[2,3],[3,4],[1,2]]
Output: 4
Example 3:

Input: events = [[1,4],[4,4],[2,2],[3,4],[1,1]]
Output: 4
Example 4:

Input: events = [[1,100000]]
Output: 1
Example 5:

Input: events = [[1,1],[1,2],[1,3],[1,4],[1,5],[1,6],[1,7]]
Output: 7

Constraints:

1 <= events.length <= 105
events[i].length == 2
1 <= startDayi <= endDayi <= 105

## solution

PriorityQueue + greedy

greedy 一般都 sort by start 并且用一些别的 data structure

## code

```java
class Solution {
    public int maxEvents(int[][] events) {
        //用priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Arrays.sort(events, (e1, e2)->{
            if(e1[0]==e2[0])
                return e1[1]-e2[1];
            return e1[0]-e2[0];
        });

        int d=0, count=0;
        int i=0, n=events.length;

        while(i<n || !pq.isEmpty()){
            if(pq.isEmpty() ){
                d = events[i][0];
            }

            while(i<n && events[i][0]<=d){
                pq.offer(events[i][1]);
                i++;
            }

            pq.poll();
            count++;
            d++;

            while(!pq.isEmpty() && pq.peek()<d){
                pq.poll();
            }
        }


        return count;
    }
}
```
