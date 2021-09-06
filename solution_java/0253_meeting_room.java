import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: MingChen
 * @Date: 2021/9/6
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1, el], [$2, el,...](i<e), find the minimum number of conference rooms required
 * Example 1
 * Input:「[0,30],[5,10],[15,20]
 * Output: 2
 *
 * Example 2:
 * Input:[[7,10],[2,4]
 * Output: 1
 */
public class Test4 {
    public static int meetingRoom(int[][] timeInterval){
        Arrays.sort(timeInterval, (o1, o2)->{
            if(o1[0]!=o2[0])
                return o1[1]-o2[1];
            return o1[0]-o2[0];
        });

        //优先队列小顶堆存储会议结束的时间，堆顶是结束时间早的
        //下一个会议开始时间早于堆顶的房间结束时间，该会议新开一个room，push进队列
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int i=0; i<timeInterval.length; i++){
            if(!pq.isEmpty() && timeInterval[i][0] >= pq.peek()){
                pq.remove();
            }
            pq.offer(timeInterval[i][1]);
        }

        return pq.size();
    }

    public static void main(String[] args) {
        int[][] a={{0, 30}, {5,10}, {15, 20}};
        System.out.println(meetingRoom(a));
    }
}
