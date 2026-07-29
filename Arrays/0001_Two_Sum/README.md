# 0001. Two Sum

> **Difficulty:** Easy  
> **Topic(s):** Arrays, HashMap, Two Pointers (Alternative)  
> **Platform:** LeetCode  
> **Language:** Java

---

## 📖 Problem Statement

Given an integer array `nums` and an integer `target`, return the indices of the **two numbers** such that they add up to `target`.

You may assume that:

- Each input has **exactly one solution**.
- You may **not use the same element twice**.
- You can return the answer in any order.

**Problem Link:** https://leetcode.com/problems/two-sum/

---

## 📝 Example

### Example 1

**Input**

```text
nums = [2,7,11,15]
target = 9
```

**Output**

```text
[0,1]
```

**Explanation**

```text
nums[0] + nums[1] = 2 + 7 = 9
```

---

### Example 2

**Input**

```text
nums = [3,2,4]
target = 6
```

**Output**

```text
[1,2]
```

---

## 🔍 Constraints

- 2 <= nums.length <= 10⁴
- -10⁹ <= nums[i] <= 10⁹
- -10⁹ <= target <= 10⁹
- Exactly one valid answer exists.

---

# Approach 1: Brute Force

### Idea

Check every possible pair of numbers.

If their sum equals the target, return their indices.

### Algorithm

1. Traverse the array using the first loop.
2. For every element, check all remaining elements.
3. If the sum equals the target, return both indices.

### Dry Run

```text
nums = [2,7,11,15]
target = 9

2 + 7 = 9 ✅
Answer = [0,1]
```

### Time Complexity

```text
O(n²)
```

### Space Complexity

```text
O(1)
```

### Pros

- Very easy to understand.
- No extra data structure required.

### Cons

- Too slow for large inputs.

---

# Approach 2: Two Pointers (After Sorting)

### Idea

Two pointers only work efficiently on a sorted array.

Since the original array is unsorted, we first:

- Store every element along with its original index.
- Sort based on value.
- Apply the two-pointer technique.
- Return the original indices.

### Algorithm

1. Store `(value, originalIndex)` for every element.
2. Sort according to value.
3. Initialize two pointers:
   - `left = 0`
   - `right = n - 1`
4. Calculate the sum.
5. If:
   - Sum == target → return original indices.
   - Sum < target → move `left++`.
   - Sum > target → move `right--`.

### Dry Run

```text
nums = [11,2,15,7]
target = 9

Store

11 -> 0
2  -> 1
15 -> 2
7  -> 3

Sort

2 -> 1
7 -> 3
11 -> 0
15 -> 2

left = 2
right = 15

2 + 15 = 17
Move Right

2 + 11 = 13
Move Right

2 + 7 = 9

Return

[1,3]
```

### Time Complexity

```text
O(n log n)
```

(Sorting dominates.)

### Space Complexity

```text
O(n)
```

### Pros

- Demonstrates understanding of the two-pointer technique.
- Useful when working with sorted data.

### Cons

- Slower than the HashMap solution because sorting is required.
- Requires additional storage for original indices.

---

# Approach 3: HashMap (Optimal)

### Idea

While traversing the array, store each visited number and its index inside a HashMap.

For every element:

- Calculate its complement.

```text
complement = target - nums[i]
```

If the complement already exists inside the map, we have found the answer.

Otherwise, store the current element and continue.

---

## Algorithm

1. Create an empty HashMap.
2. Traverse the array.
3. Compute:

```text
complement = target - nums[i]
```

4. Check whether the complement exists inside the map.
5. If yes:

```text
return {map.get(complement), i}
```

6. Otherwise:

```text
map.put(nums[i], i)
```

7. Continue until the answer is found.

---

## Dry Run

```text
nums = [2,7,11,15]
target = 9

Map = {}

i = 0

Current = 2

Complement = 7

Map doesn't contain 7

Store

2 -> 0

-----------------

i = 1

Current = 7

Complement = 2

Map contains 2 ✅

Return

[0,1]
```

---

## Time Complexity

```text
O(n)
```

Only one traversal of the array is required.

---

## Space Complexity

```text
O(n)
```

The HashMap may store every element.

---

## Why is this the Optimal Solution?

The HashMap solution solves the problem in **linear time** by avoiding nested loops and eliminating the need to sort the array.

Compared to other approaches:

| Approach | Time | Space |
|----------|------|-------|
| Brute Force | O(n²) | O(1) |
| Two Pointers | O(n log n) | O(n) |
| HashMap ✅ | **O(n)** | **O(n)** |

For interview and production environments, the **HashMap approach is generally preferred** because it provides the best overall time complexity while preserving the original indices.

---

# Key Learning

After solving this problem, you should understand:

- Brute Force searching
- HashMap fundamentals
- Complement concept
- Time vs Space trade-off
- Two Pointer technique
- Why sorting changes element positions
- Importance of preserving original indices

---

# Interview Follow-up Questions

### Q1. Why can't we directly use Two Pointers?

Because the array is **unsorted**. Two pointers rely on sorted order to decide whether to move the left or right pointer.

---

### Q2. Why store original indices?

Sorting changes the positions of elements. We need the original indices to return the correct answer.

---

### Q3. Why is HashMap faster?

HashMap provides average **O(1)** lookup time, allowing us to find the complement in constant time while traversing the array only once.

---

### Q4. Can this problem be solved without extra space?

Yes, by sorting and using two pointers, but the time complexity becomes **O(n log n)** and extra work is needed to preserve the original indices.

---

# Conclusion

This problem introduces one of the most important interview patterns:

- HashMap lookup
- Complement technique
- Two Pointer technique
- Trade-offs between different approaches

The **HashMap solution** is the optimal approach and is the one most commonly expected during coding interviews.