# Leetcode 227 基本计算器 2

给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。

整数除法仅保留整数部分。

示例 1：

```
输入：s = "3+2*2"
输出：7
```

示例 2：

```
输入：s = " 3/2 "
输出：1
```

示例 3：

```
输入：s = " 3+5 / 2 "
输出：5
```

提示：

- 1 <= s.length <= 3 \* 105
- s 由整数和算符 ('+', '-', '\*', '/') 组成，中间由一些空格隔开
- s 表示一个 **有效表达式**
- 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
- 题目数据保证答案是一个 32-bit 整数

## 题解

本题没有括号，保证表达式有效，由于乘除的优先级比加减高，那么对于乘除的计算我们可以直接进行，而减法相当于加负数。

使用一个栈存放减法、乘法、除法结果的操作数，最后累加则得到结果，这里有一个难点是栈如何存放中间结果，如 4 \* 5 + 3，遍历到 5 的时候栈如何先存到 4 再取出乘 5，这里可以遍历到在下一次运算符的时候，再去计算上一个运算符的结果（如这里的+），那么记录的 5，和栈中存的 4 都是可触及的。需要注意，最后遍历到 3 的时候需要把上一个运算符（+）结果进行计算。

```java
class Solution {
    public int calculate(String s) {
        //用stack来实现乘除法的优先级
        //注意输入会有空格，需要处理
        char[] charArray = s.toCharArray();
        Stack<Integer> stack = new Stack<>();

        int num = 0;  //用num来保存上一个数字
        int ans = 0;  //用来保存最后的answer
        char preOperator = '+'; //记录上一个operator

        for(int i=0; i<charArray.length; i++){
            //charArray[i] is number
            if(Character.isDigit(charArray[i])){
                //charArray[i]前面可能是一个很大的数字比如323
                num = num*10 + (charArray[i]-'0');
            }

             //charArray[i] is operators
            //每当出现下一个operator，计算上一个operator和后面的数字
            //或者当当前charArray[i]已经是最后一个时，要把之前的preOperator算出来
            if(!Character.isDigit(charArray[i]) && charArray[i]!=' ' || i==charArray.length-1){
                if(preOperator=='+')
                    stack.push(num);
                if(preOperator=='-')
                    stack.push(-num);
                if(preOperator=='*')
                    stack.push(stack.pop()*num);
                if(preOperator=='/')
                    stack.push(stack.pop()/num);

                //计算完上一个operator的结果后
                //更新pre operator为当前charArray[i]
                //更新num=0
                preOperator = charArray[i];
                num = 0;
            }
        }

        while(!stack.isEmpty()){
            ans += stack.pop();
        }

        return ans;
    }
}
```

**复杂度分析**

时间复杂度：O(n)，其中 n 为字符串 s 的长度。需要遍历字符串 s 一次，计算表达式的值。

空间复杂度：O(n)，其中 n 为字符串 s 的长度。空间复杂度主要取决于栈的空间，栈的元素个数不超过 n。

## 进阶

于「表达式计算」这一类问题，你都可以使用这套思路进行解决。我十分建议你加强理解这套处理逻辑。

对于「任何表达式」而言，我们都使用两个栈 nums 和 ops：

nums ： 存放所有的数字
ops ：存放所有的数字以外的操作
然后从前往后做，对遍历到的字符做分情况讨论：

- 空格 : 跳过
- ( : 直接加入 ops 中，等待与之匹配的 )
- ) : 使用现有的 nums 和 ops 进行计算，直到遇到左边最近的一个左括号为止，计算结果放到 nums
  数字 : 从当前位置开始继续往后取，将整一个连续数字整体取出，加入 nums
- `+ - / ^ %` : 需要将操作放入 ops 中。在放入之前先把栈内可以算的都算掉（只有「栈内运算符」比「当前运算符」优先级高/同等，才进行运算），使用现有的 nums 和 ops 进行计算，直到没有操作或者遇到左括号，计算结果放到 nums

理解 **只有「栈内运算符」比「当前运算符」优先级高/同等，才进行运算** 是什么意思：

因为我们是从前往后做的，假设我们当前已经扫描到 2 + 1 了（此时栈内的操作为 + ）。

1. 如果后面出现的 + 2 或者 - 1 的话，满足「栈内运算符」比「当前运算符」优先级高/同等，可以将 2 + 1 算掉，把结果放到 nums 中；
2. 如果后面出现的是 \* 2 或者 / 1 的话，不满足「栈内运算符」比「当前运算符」优先级高/同等，这时候不能计算 2 + 1。

一些细节：

- 由于第一个数可能是负数，为了减少边界判断。一个小技巧是先往 nums 添加一个 0
- 为防止 () 内出现的首个字符为运算符，将所有的空格去掉，并将 (- 替换为 (0-，(+ 替换为 (0+（当然也可以不进行这样的预处理，将这个处理逻辑放到循环里去做）
- 从理论上分析，nums 最好存放的是 long，而不是 int。因为可能存在 大数 + 大数 + 大数 + … - 大数 - 大数 的表达式导致中间结果溢出，最终答案不溢出的情况

```java
class Solution {
    // 使用 map 维护一个运算符优先级
    // 这里的优先级划分按照「数学」进行划分即可
    private Map<Character, Integer> map = new HashMap<Character, Integer>(){{
        put('-', 1);
        put('+', 1);
        put('*', 2);
        put('/', 2);
        put('%', 2);
        put('^', 3);
    }};
    public int calculate(String s) {
        // 将所有的空格去掉
        s = s.replaceAll(" ", "");
        char[] charArray = s.toCharArray();
        int n = s.length();
        // 存放所有的数字
        Deque<Integer> nums = new ArrayDeque<>();
        // 为了防止第一个数为负数，先往 nums 加个 0
        nums.addLast(0);
        // 存放所有「非数字以外」的操作
        Deque<Character> ops = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char ch = charArray[i];
            if (ch == '(') {
                ops.addLast(ch);
            } else if (ch == ')') {
                // 计算到最近一个左括号为止
                while (!ops.isEmpty()) {
                    if (ops.getLast() != '(') {
                        calc(nums, ops);
                    } else {
                        ops.removeLast();
                        break;
                    }
                }
            } else {
                if (isNumber(ch)) {
                    int num = 0;
                    int numIndex = i;
                    // 将从 i 位置开始后面的连续数字整体取出，加入 nums
                    while (numIndex < n && isNumber(charArray[numIndex])) {
                        num = num * 10 + (charArray[numIndex++] - '0');
                    }
                    nums.addLast(num);
                    i = numIndex - 1;
                } else {
                    // 防止出现(+1+3)、(-1)的情况
                    if (i > 0 && (charArray[i - 1] == '(' || charArray[i - 1] == '+' || charArray[i - 1] == '-')) {
                        nums.addLast(0);
                    }
                    // 有一个新操作要入栈时，先把栈内可以算的都算了
                    // 只有满足「栈内运算符」比「当前运算符」优先级高/同等，才进行运算
                    while (!ops.isEmpty() && ops.getLast() != '(') {
                        char prev = ops.getLast();
                        if (map.get(prev) >= map.get(ch)) {
                            calc(nums, ops);
                        } else {
                            break;
                        }
                    }
                    ops.addLast(ch);
                }
            }
        }
        // 将剩余的计算完
        while (!ops.isEmpty()){
            calc(nums, ops);
        }
        return nums.getLast();
    }
    private void calc(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2) return;
        if (ops.isEmpty()) return;
        int num2 = nums.removeLast();
        int num1 = nums.removeLast();
        char op = ops.removeLast();
        int ans = 0;
        if (op == '+') ans = num1 + num2;
        else if (op == '-') ans = num1 - num2;
        else if (op == '*') ans = num1 * num2;
        else if (op == '/')  ans = num1 / num2;
        else if (op == '^') ans = (int) Math.pow(num1, num2);
        else if (op == '%') ans = num1 % num2;
        nums.addLast(ans);
    }
    private boolean isNumber(char c) {
        return Character.isDigit(c);
    }
}

```

**复杂度分析**

时间复杂度：O(n)，其中 n 为字符串 s 的长度。需要遍历字符串 s 一次，计算表达式的值。

空间复杂度：O(n)，其中 n 为字符串 s 的长度。空间复杂度主要取决于栈的空间，栈的元素个数不超过 n。
