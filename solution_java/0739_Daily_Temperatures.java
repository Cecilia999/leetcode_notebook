class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        if(temperatures.length==0) return res;
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0; i<temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int index = stack.pop();
                res[index] = i-index;
            }
            stack.push(i);
        }

        return res;
    }
}