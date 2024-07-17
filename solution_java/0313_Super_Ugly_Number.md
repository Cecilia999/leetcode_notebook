# 313. Super Ugly Number

https://leetcode.com/problems/super-ugly-number/description/

## Solution

```java
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        //instead of using one int value to keep the head of the prime
        //like 264. Ugly Number II
        //We use product2, product3 and product5 to preserve head value
        //We need an int array contain 3 items in it.
        //int [] {product, prime, p}
        //and put the array into a priority queue

        PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        //lamba way to define comparator.
        // PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> {
        //     return a[0] - b[0];
        // });

        for(int i=0; i<primes.length; i++) {
            int[] pair = {1, primes[i], 1};
            pq.offer(pair);
        }

        int[] ugly = new int[n+1];
        int p = 1;
        while(p <= n) {
            int[] pair = pq.poll();
            int product = pair[0];
            int prime = pair[1];
            int index = pair[2];

            //we don't put duplicate ugly number in the array
            //but we need to increase each linked list head value no matter if we find the next minimum ugly number.
            if(product != ugly[p-1]) {
                ugly[p] = product;
                p++;
            }

            //if product == ugly[p-1]
            //that means we don't need to put the same ugly number in the ugly array again
            //but we still need to update the linked list head value
            int[] nextPair = new int[]{prime * ugly[index], prime, index + 1};
            pq.offer(nextPair);
        }

        return ugly[n];
    }
}
```