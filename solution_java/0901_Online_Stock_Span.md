# 901. Online Stock Span

## problem description

Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.

The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backward) for which the stock price was less than or equal to today's price.

For example, if the price of a stock over the next 7 days were [100,80,60,70,60,75,85], then the stock spans would be [1,1,1,2,1,4,6].
Implement the StockSpanner class:

StockSpanner() Initializes the object of the class.
int next(int price) Returns the span of the stock's price given that today's price is price.

Example 1:

Input
["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]
Output
[null, 1, 1, 1, 2, 1, 4, 6]

Explanation
StockSpanner stockSpanner = new StockSpanner();
stockSpanner.next(100); // return 1
stockSpanner.next(80); // return 1
stockSpanner.next(60); // return 1
stockSpanner.next(70); // return 2
stockSpanner.next(60); // return 1
stockSpanner.next(75); // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
stockSpanner.next(85); // return 6

Constraints:

1 <= price <= 105
At most 104 calls will be made to next.

## solution

1. pair<price, result>
2. monotonic stack

## code

```java
class StockSpanner {
    class Pair{
        int price;
        int result;
        Pair(int price, int result){
            this.price = price;
            this.result = result;
        }
    }

    Stack<Pair> stack;
    int idx;

    public StockSpanner() {
        this.stack = new Stack<>();
        idx = 0;
    }

    public int next(int price) {
        int res = 1;
        if(!stack.isEmpty() && price >= stack.peek().price){
            while(!stack.isEmpty() && stack.peek().price <= price){
                res += stack.pop().result;
            }
        }

        stack.push(new Pair(price, res));
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
```
