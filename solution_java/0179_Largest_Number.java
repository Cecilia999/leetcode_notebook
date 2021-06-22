//这道题用array.sort()但是要写一个自己的comparator
//如何override一个comparator：

Arrays.sort(snum, new Comparator<String>() {
    @Override
    public int compare(String i, String j) {
        String s1 = i+j;
        String s2 = j+i;
        
        //compare(a, b) calls a.compareTo(b) you'll get ascending order; 
        //if it calls b.compareTo(a) you'll get descending order.
        //we need descending order here
        return s2.compareTo(s1);
    }
});

//这一题很容易想到把数字都转化为字符串，利用字符串比较，来排序，这样 9 开头的一定排在最前面。不过这样做有一个地方是错误的，比如：“3” 和 “30” 比较，“30” 比 “3” 的字符序要大，这样排序以后就出错了。实际上就这道题而言， “3” 应该排在 “30” 前面。

// 在比较 2 个字符串大小的时候，不单纯的只用字符串顺序进行比较，还加入一个顺序。

// Go
// aStr := a + b
// bStr := b + a
// 通过比较 aStr 和 bStr 的大小来得出是 a 大还是 b 大。

// 举个例子，还是 “3” 和 “30” 的例子，比较这 2 个字符串的大小。

// Go
// aStr := "3" + "30" = "330"
// bStr := "30" + "3" = "303"
// 通过互相补齐位数之后再进行比较，就没有问题了。很显然这里 “3” 比 “30” 要大。

class Solution {
    public String largestNumber(int[] nums) {
        if(nums.length==0)
            return null;
        
        //Integer.valueOf(s); // returns an Integer object
        //String.valueOf(num); // integer to string
        String[] snum = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            snum[i] = String.valueOf(nums[i]);
            //snum[i] = nums[i]+"";  这样也可以把int arr变成string arr
        }
        
        //create our own comparator
        Arrays.sort(snum, new Comparator<String>() {
            @Override
            public int compare(String i, String j) {
                String s1 = i+j;
                String s2 = j+i;
                
                //compare(a, b) calls a.compareTo(b) you'll get ascending order; 
                //if it calls b.compareTo(a) you'll get descending order.
                //we need descending order here
                return s2.compareTo(s1);
            }
        });
        
        // An extreme edge case by lc, when you have only a bunch of 0 in your int array
		if(snum[0].charAt(0) == '0')
			return "0";
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<nums.length; i++){
            sb.append(snum[i]);
        }
        
        return sb.toString();       
    }
}