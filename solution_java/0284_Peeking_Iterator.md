# 284. Peeking Iterator 

## Problem Description

Design an iterator that supports the peek operation on an existing iterator in addition to the hasNext and the next operations.

Implement the PeekingIterator class:

`PeekingIterator(Iterator<int> nums)` - Initializes the object with the given integer iterator iterator.
`int next()` - Returns the next element in the array and moves the pointer to the next element.
`boolean hasNext()` - Returns true if there are still elements in the array.
`int peek()` -  the next element in the array without moving the pointer.

Note: Each language may have a different implementation of the constructor and Iterator, but they all support the int `next()` and boolean `hasNext()` functions.

 

Example 1:

Input
["PeekingIterator", "next", "peek", "next", "next", "hasNext"]
[[[1, 2, 3]], [], [], [], [], []]
Output
[null, 1, 2, 2, 3, false]

Explanation
`PeekingIterator peekingIterator = new PeekingIterator([1, 2, 3])`; // [1,2,3]
`peekingIterator.next()`;    // return 1, the pointer moves to the next element [1,2,3].
`peekingIterator.peek()`;    // return 2, the pointer does not move [1,2,3].
`peekingIterator.next()`;    // return 2, the pointer moves to the next element [1,2,3]
`peekingIterator.next()`;    // return 3, the pointer moves to the next element [1,2,3]
`peekingIterator.hasNext()`; // return False
 

Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 1000
All the calls to next and peek are valid.
At most 1000 calls will be made to next, hasNext, and peek.
 
Follow up: How would you extend your design to be generic and work with all types, not just integer?

## Solution

### Datatype - Iterator

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

```java
import java.util.NoSuchElementException;

class PeekingIterator implements Iterator<Integer> {
	private Iterator<Integer> iter;
	private Integer peekedValue = null;
	
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iter = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        //if peekedValue is empty then get the next value in the iterator and store
		//if there is no such next value, return NoSuchElementException
		if(peekedValue == null) {
			if(!iter.hasNext()) {
				throw new NoSuchElementException();
			}
			peekedValue = iter.next();
		}
		return peekedValue;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		//if peekedValue is not null means last operation is peek()
		//so iter is already points to the next value
		//the value you need to return is inside peekedValue and you don't need to move the pointer forward again
		//else you need to move the pointer forward.
	    if(peekedValue != null) {
			Integer res = peekedValue;
			peekedValue = null;
			return res;
		}
		if(!iter.hasNext()) {
			throw new NoSuchElementException();
		}

		return iter.next();
	}
	
	@Override
	public boolean hasNext() {
		//check if peekedValue has value stored in, or there are values remaining in ther iterator.
	    return peekedValue != null || iter.hasNext();
	}
}
```