# Programming-Pattern :computer:
 - Programming Pattern Assignment
 - This work is to test out our problem solving skill
 - There are six questions to answer
 - Level of Difficulty: Easy

# Table of Contents
- [Programming-Pattern :computer:](#programming-pattern-computer)
- [Table of Contents](#table-of-contents)
- [What to Solve](#what-to-solve)
  - [Problem 1](#problem-1)
    - [Explanation](#explanation)
    - [Solution](#solution)
  - [Problem 2](#problem-2)
    - [Explanation](#explanation-1)
    - [Solution](#solution-1)
  - [Problem 3](#problem-3)
    - [Explanation](#explanation-2)
    - [Solution](#solution-2)
  - [Problem 4](#problem-4)
    - [Explanation](#explanation-3)
    - [Solution](#solution-3)
  - [Problem 5](#problem-5)
    - [Explanation](#explanation-4)
    - [Solution](#solution-4)
  - [Problem 6](#problem-6)
    - [Explanation](#explanation-5)
    - [Solution](#solution-5)
- [Suggestion](#suggestion)

# What to Solve
## Problem 1
- Given an integer list `nums` sorted in non-decreasing order, return an `array` of **the squares of each number** sorted in non-decreasing order.
- Example: 
```java
input: List<Integer> nums = Arrays.asList(-4,-1,0,3,10);
Output: [0,1,9,16,100]
```
### Explanation
- After squaring, the array becomes [16,1,0,100].
- After sorting, it becomes [0,1,9,16,100].
- **Take Note** all the methods should return an array. We do this by converting the list to an array beforehand using Java stream.
 
### Solution
- To accomplish the square operation I used `mapToInt` and Math.pow function.
  - Example: `mapToInt(e -> Math.pow(e,2))`
- To sort it and transform it to an Array, i used `.sorted().toArray()` which is another java 8 stream functionality.

## Problem 2
- Squaring each element and sorting the new array is very trivial, could you find an 0(n) solution using a different approach for the previous problem.
  
### Explanation
 - The first solution is not efficient since it traverse the array twice. The first one is to square the array and the other one is to sort the array. We need to find a way that does the two actions in a single loop.

### Solution
- One of the efficient solution is based on the two-pointer method as the array is already sorted we can compare the first and last element to check which is bigger and proceed with the result.
- To get the full detailed explanation about the solution visit [geeksforgeeks.org](https://www.geeksforgeeks.org/sort-array-converting-elements-squares/), this shows a 0(n) time complexity.

## Problem 3
- Given an integer list `nums` move all **zeroes** to the end of it while maintaining the relative order of the non-zero elements. **Note** that you must do this in-place without making a copy of the array.

### Explanation
- If the length of the array is 1, it should return the same value.
- Don't use sorting method because this will change the natural order of the numbers
- All zeroes must be in the right side or end of the array.

### Solution
- Creates a counter index to keep track of non-zero elements
- It traverses the array and once it encounters a non-zero elements, it swaps this value to the array with the index counter. Then it increments the counter and check for the next value.
- After the for loop, all non-zero elements are shifted to the left. Then we use the while loop to traverse the array while counter is less than the length of the array. From counter to the end we turn the array's value to 0;

## Problem 4
- Could you minimize the total number of operations done for the previous problem?

### Explanation
- Solution for problem 3 is already efficient but with programming there is always a better way to do things

### Solution
- Problem 4 uses a while loop and two pointer.
- This solution is provided by *Shaneen6* from *leetcode*

## Problem 5
- Given two sorted integer lists `nums1` and `nums2`, merge `nums2` into `nums1` as **one sorted array**. The number of elements initialized in `nums1` and `nums2` are `m` and `n` respectively. You may assume that `nums1` has a size equal to `m + n` such that it has enough space to hold additional elements from `nums2`.

### Explanation
- Combine the two list and return an array
- Constraint: m and n represents the number elements that is included in the array.
- The combined array has the size of m + n

### Solution
- To combine the two list, I used Java 8 Stream `.concat()`. I limit both list using whatever value m and n represents. For this, I used another stream method which is `.limit()`. Finally convert this merge list to an array.
- The `.sorted()` sorts the array in ascending order.

## Problem 6
- Solve the previous problem without using any sorting methods.

### Explanation
- You are not allowed to use any Collections or any other built in method to sort the array.
- You have to implement your own sorting algorithm.

### Solution
- To sort an array we need to implement two for loops. An outer loop and inner loop. Outer loop represents the current value and the inner loop represents the next value. The inner loop will continue to traverse the loop until it breaks the condition.
- **Optional:** I implemented a private method that swaps two values in an array. You can do this directly inside the inner loop
- The inner loop checks wether or not a outer value is greater than the inner value. If it is, we perform the swap method else inner loop will continue to traverse until it reaches the end, then the outer loop continues.

# Suggestion
- If you find a bug, mistakes or better solution to do the problems mention, don't hesitate to contact me.