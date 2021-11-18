# 1235. Maximum Profit in Job Scheduling

## problem description

We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.

If you choose a job that ends at time X you will be able to start another job that starts at time X.

Example 1:

Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
Output: 120
Explanation: The subset chosen is the first and fourth job.
Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.

Example 2:

Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
Output: 150
Explanation: The subset chosen is the first, fourth and fifth job.
Profit obtained 150 = 20 + 70 + 60.

Example 3:

Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
Output: 6

Constraints:

1 <= startTime.length == endTime.length == profit.length <= 5 \* 10^4
1 <= startTime[i] < endTime[i] <= 10^9
1 <= profit[i] <= 10^4

## solution

1. sort jobs by startTime
2. Top-down DP(memorization)
   starting from job index cur = 0, we might either schedule the jobs[cur] or not.

- If we schedule jobs[cur], the problem becomes profit of jobs[cur] + max profit of scheduling jobs starting from next available job index.
- If we don't schedule jobs[cur], the problem becomes max profit of scheduling jobs starting from cur + 1.

We choose the one giving more profits.

3. Bottom-down DP
   从 dp[n]开始计算 dp

## code

1. Top-down DP(memorization)

```java
class Solution {
    //<job cur, profit of jobs[cur] + max profit of scheduling jobs starting from next available job index>

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for(int i=0; i<n; i++){
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        //sort by startTime
        Arrays.sort(jobs, (o1, o2)->{
            if(o1[0]==o2[0])
                return o1[1]-o2[1];
            return o1[0]-o2[0];
        });

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return dfs(0, jobs, dp);
    }

    public int dfs(int cur, int[][] jobs, int[] dp){
        if(cur==jobs.length)
            return 0;

        if(dp[cur]!=-1)
            return dp[cur];

        int next = findNext(cur, jobs);
        int includeCur = jobs[cur][2] + (next==-1? 0 : dfs(next, jobs, dp));
        int excludeCur = dfs(cur+1, jobs, dp);

        dp[cur] = Math.max(includeCur, excludeCur);
        return dp[cur];
    }

    //find the next avaliable job index
    public int findNext(int cur, int[][] jobs){
        int next = cur + 1;
        while(next<jobs.length){
            if(jobs[next][0]>=jobs[cur][1])
                return next;
            next++;
        }

        //meaning no next avaliable job if we choose cur
        return -1;
    }
}
```

2. Bottom-down DP

```java
class Solution {
    //<job cur, profit of jobs[cur] + max profit of scheduling jobs starting from next available job index>

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for(int i=0; i<n; i++){
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        //sort by startTime
        Arrays.sort(jobs, (o1, o2)->{
            if(o1[0]==o2[0])
                return o1[1]-o2[1];
            return o1[0]-o2[0];
        });

        int[] dp = new int[n];
        dp[n-1] = jobs[n-1][2];
        for(int cur=n-2; cur>=0; cur--){
            int next = findNext(cur, jobs);
            dp[cur] = Math.max(jobs[cur][2] + (next==-1? 0:dp[next]), dp[cur+1]);
        }

        return dp[0];
    }


    //find the next avaliable job index
    public int findNext(int cur, int[][] jobs){
        int next = cur + 1;
        while(next<jobs.length){
            if(jobs[next][0]>=jobs[cur][1])
                return next;
            next++;
        }

        //meaning no next avaliable job if we choose cur
        return -1;
    }
}
```
