# 735. Asteroid Collision

## problem description

We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.

Constraints:

2 <= asteroids.length <= 104
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0

## solution

1. stack
2. collide while loop
   - stack.peek()>0, if current asteroid has a larger size than stack.peek() -> continue collide
   - if stack is empty/asteroid is > 0/stack.peek()<0 -> add asteroid to the stack
   - is asteroid == stack.peek() -> stack.pop()

## code

```java
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int asteroid : asteroids){
            while(!stack.isEmpty() && stack.peek()>0 && -asteroid > stack.peek()){
                stack.pop();
            }

            if(stack.isEmpty() || asteroid>0 || stack.peek()<0){
                stack.push(asteroid);
            }
            else if(asteroid == - stack.peek()){
                stack.pop();
            }
        }

        return stack.stream().mapToInt(i->i).toArray();

    }
}
```
