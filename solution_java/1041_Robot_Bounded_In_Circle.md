# [1041. Robot Bounded In Circle](https://leetcode.com/problems/robot-bounded-in-circle/)

## 题目大意

On an infinite plane, a robot initially stands at (0, 0) and faces north. The robot can receive one of three instructions:

"G": go straight 1 unit;
"L": turn 90 degrees to the left;
"R": turn 90 degrees to the right.
The robot performs the instructions given in order, and repeats them forever.

Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

Input: instructions = "GGLLGG"
Output: true
Explanation: The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.

Input: instructions = "GG"
Output: false
Explanation: The robot moves north indefinitely.

## 解题思路

because the robot initially stands at (0, 0) and faces north
So the robot leaves the circle if it keep moving in the North direction.
we need to keep track of the points and direction
x = 0, y = 0, dir = North

1. when instruction = G
   we move 1 point to the current direction
   e.g. if dir = North, y += 1
   if dir = South, y -= 1
2. when instruction = L
   we change the direction
   e.g. if dir = North, dir = West
3. when instruction = R
   same as 2
   if the final point x=0, y=0, robot is in a circle
   if the final point is not (x,y)=(0,0) and direction is North, robot is not in a circle
   else robot is in a circle

## code

```java
class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0; //robot original position
        String dir = "North"; //robot original direction

        for(char ch : instructions.toCharArray()){
            if(ch=='G'){
                if(dir.equals("North"))
                    y += 1;
                else if(dir.equals("South"))
                    y -= 1;
                else if(dir.equals("West"))
                    x -= 1;
                else
                    x += 1;
            }
            else if(ch=='L'){
                if(dir.equals("North"))
                    dir = "West";
                else if(dir.equals("South"))
                    dir = "East";
                else if(dir.equals("West"))
                    dir = "South";
                else
                    dir = "North";
            }
            else{
                if(dir.equals("North"))
                    dir = "East";
                else if(dir.equals("South"))
                    dir = "West";
                else if(dir.equals("West"))
                    dir = "North";
                else
                    dir = "South";
            }
        }

        if(x==0 && y==0) //不管什么方向
            return true;
        else if(dir.equals("North"))
            return false;
        else
            return true;
    }
}
```
