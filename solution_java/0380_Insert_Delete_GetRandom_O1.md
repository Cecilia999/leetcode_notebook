# 380. Insert Delete GetRandom O(1)

## problem

Implement the RandomizedSet class:

RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
You must implement the functions of the class such that each function works in average O(1) time complexity.

Example 1:

Input
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]
Output
[null, true, false, true, 2, true, false, 2]

Constraints:

-231 <= val <= 231 - 1
At most 2 \* 105 calls will be made to insert, remove, and getRandom.
There will be at least one element in the data structure when getRandom is called.

## solution

hashmap + arraylist

hashmap has put/get/remove -> O(1)
arraylist has remove -> O(n), add/get -> O(1)

need to swap the remove node with the last node to make remove O(1)

## code

```java
class RandomizedSet {
    Map<Integer, Integer> set;
    List<Integer> nums;

    public RandomizedSet() {
        set = new HashMap<>();
        nums = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(!set.containsKey(val)){
            set.put(val, set.size());
            nums.add(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        //为了让ArrayList.remove O(1)
        //swap val with the last node in set and nums
        //removelast() only cost O(1)

        if(set.containsKey(val)){
            int index = set.get(val);

            //if node is not the last one
            if(index < set.size()-1){
                int lastVal = nums.get(nums.size()-1);
                nums.set(index, lastVal);
                set.put(lastVal, index);
            }
            set.remove(val);  //O(1)
            nums.remove(nums.size()-1); //O(1)

            return true;
        }
        return false;
    }

    public int getRandom() {
        Random rand = new Random();
        int index = rand.nextInt(set.size());
        return nums.get(index); //ArrayList.get() O(1)
    }
}
```
