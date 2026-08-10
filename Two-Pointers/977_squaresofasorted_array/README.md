# 0977. Squares of a Sorted Array

> **Difficulty:** Easy  
> **Topic(s):** Arrays, Two Pointers  
> **Pattern:** Two Pointers  
> **Platform:** LeetCode

---

## 📖 Problem Statement

Given an integer array `nums` sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

### Problem Link

https://leetcode.com/problems/squares-of-a-sorted-array/

---

## 📝 Examples

### Example 1

**Input:**

```text
nums = [-4,-1,0,3,10]
```

**Output:**

```text
[0,1,9,16,100]
```

### Example 2

**Input:**

```text
nums = [-7,-3,2,3,11]
```

**Output:**

```text
[4,9,9,49,121]
```

---

## 🔒 Constraints

- `1 <= nums.length <= 10^4`
- `-10^4 <= nums[i] <= 10^4`
- `nums` is sorted in non-decreasing order.

---

# 🎯 Core Observation

The input array is sorted, but after squaring the elements, the resulting values may no longer remain sorted.

For example:

```text
[-4,-1,0,3,10]
```

After squaring:

```text
[16,1,0,9,100]
```

The important observation is that the **largest square must come from either end of the original sorted array**.

For example:

```text
[-7,-3,-1,2,4]
```

The two possible largest values are:

```text
(-7)² = 49
4² = 16
```

Therefore, we can compare the values at both ends using two pointers.

---

# 🚀 Approach 1: Brute Force

## 💡 Intuition

The simplest approach is to square every element and store the results.

Since squaring does not guarantee that the resulting array will remain sorted, we can sort the squared values afterward.

---

## 🔄 Algorithm

1. Create a result array.
2. Traverse every element of the input array.
3. Square each element.
4. Store the square in the result array.
5. Sort the result array.
6. Return the sorted array.

---

## ⏱️ Time Complexity

```text
O(n log n)
```

### Explanation

- Squaring all elements: `O(n)`
- Sorting the result: `O(n log n)`

Therefore:

```text
O(n) + O(n log n) = O(n log n)
```

---

## 💾 Space Complexity

```text
O(n)
```

The result array requires `O(n)` space.

---

## ✅ Advantages

- Very simple.
- Easy to understand.
- Easy to implement.
- Does not require knowledge of the Two Pointer technique.

---

## ❌ Disadvantages

- Sorting is unnecessary.
- Does not take advantage of the sorted input.
- Slower than the optimal approach.

---

# 🚀 Approach 2: Two Pointers ⭐ Optimal

## 💡 Intuition

Because the original array is sorted, the largest absolute value must be located at either:

- The left end, or
- The right end.

Therefore, maintain two pointers:

```text
left  → beginning of array
right → end of array
```

Compare:

```text
nums[left]²
```

and

```text
nums[right]²
```

Whichever is larger is the largest remaining square.

Place that value at the **end of the result array**.

Then move the pointer that produced the larger square.

---

## 🔄 Algorithm

1. Create a result array of the same size as `nums`.
2. Set `left = 0`.
3. Set `right = n - 1`.
4. Start filling the result array from the last position.
5. Compare the square of `nums[left]` with the square of `nums[right]`.
6. Place the larger square at the current result position.
7. Move the corresponding pointer.
8. Move the result position one step backward.
9. Continue until all elements are processed.
10. Return the result array.

---

# 🧠 Dry Run

Consider:

```text
nums = [-4,-1,0,3,10]
```

### Step 1

```text
left  → -4
right → 10
```

Compare:

```text
(-4)² = 16
10² = 100
```

The larger value is `100`.

Place it at the end:

```text
[_,_,_,_,100]
```

Move `right`.

---

### Step 2

```text
left  → -4
right → 3
```

Compare:

```text
(-4)² = 16
3² = 9
```

The larger value is `16`.

```text
[_,_,_,16,100]
```

Move `left`.

---

### Step 3

```text
left  → -1
right → 3
```

Compare:

```text
(-1)² = 1
3² = 9
```

The larger value is `9`.

```text
[_,_,9,16,100]
```

Move `right`.

---

### Step 4

```text
left  → -1
right → 0
```

Compare:

```text
(-1)² = 1
0² = 0
```

Place `1`:

```text
[_,1,9,16,100]
```

---

### Step 5

Remaining value:

```text
0² = 0
```

Final result:

```text
[0,1,9,16,100]
```

---

# 🔍 Why Does the Two Pointer Approach Work?

The input is sorted.

Therefore, the largest absolute value can only occur at one of the two ends.

For example:

```text
[-8,-5,-2,1,4]
```

The largest absolute values are:

```text
8 and 4
```

So the largest square must be either:

```text
8² = 64
```

or:

```text
4² = 16
```

There is no need to compare the middle elements for the largest square.

After selecting the largest square, we move the corresponding pointer inward and repeat the same process.

This allows us to process the entire array without sorting.

---

# ⏱️ Time Complexity

```text
O(n)
```

Each element is processed exactly once.

Both pointers only move toward each other.

---

# 💾 Space Complexity

```text
O(n)
```

The output array requires `O(n)` space.

However, the **auxiliary space** used by the algorithm apart from the output array is:

```text
O(1)
```

Therefore:

```text
Output Space:    O(n)
Auxiliary Space: O(1)
Overall Space:   O(n)
```

---

# 📊 Approach Comparison

| Approach | Time Complexity | Space Complexity | Uses Sorted Property | Optimal |
|----------|-----------------|------------------|----------------------|---------|
| Brute Force + Sorting | O(n log n) | O(n) | ❌ No | ❌ |
| Two Pointers | **O(n)** | **O(n)** | ✅ Yes | ✅ |

### Auxiliary Space Comparison

| Approach | Auxiliary Space |
|----------|-----------------|
| Brute Force + Sorting | O(n) |
| Two Pointers | **O(1)** |

---

# 🏆 Why Is Two Pointers the Best Approach?

The Two Pointer approach is optimal because it directly uses the fact that the input array is already sorted.

Instead of:

```text
Square → Sort
```

we do:

```text
Compare both ends → Place largest → Move pointer
```

This eliminates the `O(n log n)` sorting operation.

### Final Complexity

```text
Time:  O(n)
Space: O(n)
```

where the `O(n)` space is required for the output array.

The algorithm itself uses only:

```text
Auxiliary Space: O(1)
```

---

# 🎯 Key Observations

1. The input array is sorted.
2. Squaring can destroy the original sorted order.
3. The largest square must come from one of the two ends.
4. Two pointers allow us to compare both ends.
5. The result should be filled from right to left.
6. The largest remaining square is selected at every step.
7. No additional sorting is required.
8. The algorithm processes every element exactly once.

---

# ⚠️ Common Mistakes

## 1. Assuming Squared Values Stay Sorted

For:

```text
[-4,-1,0,3,10]
```

the squares are:

```text
[16,1,0,9,100]
```

They are not sorted.

---

## 2. Only Checking the Right Side

A negative number at the left side can have a larger square.

Example:

```text
[-10,1,2,3]
```

Here:

```text
(-10)² = 100
3² = 9
```

Therefore, both ends must be compared.

---

## 3. Filling the Result From Left to Right

The largest square is found first.

Therefore, it should be placed at the **last position** of the result array.

---

## 4. Forgetting Negative Numbers

The absolute value of a negative number can be larger than the positive numbers.

Always compare the squares rather than comparing the original values.

---

# 💼 Interview Questions

### Q1. Why can Two Pointers be used for this problem?

Because the input array is sorted, allowing us to determine that the largest absolute value must be at one of the two ends.

---

### Q2. Why do we compare the squares at both ends?

Because either the most negative number or the largest positive number can produce the largest square.

---

### Q3. Why do we fill the result array from right to left?

The largest square is found first, so it belongs at the last position of the sorted result.

---

### Q4. What happens when the left square is larger?

Place the left square at the current result position and move the `left` pointer forward.

---

### Q5. What happens when the right square is larger?

Place the right square at the current result position and move the `right` pointer backward.

---

### Q6. What is the time complexity of the brute-force sorting approach?

```text
O(n log n)
```

---

### Q7. What is the time complexity of the Two Pointer approach?

```text
O(n)
```

---

### Q8. What is the auxiliary space complexity of the Two Pointer approach?

```text
O(1)
```

The result array itself requires `O(n)` space.

---

### Q9. Why is sorting unnecessary?

Because the sorted input allows us to determine the largest remaining square directly by comparing the two ends.

---

# 📚 Key Learning

After solving this problem, you should understand:

- Two Pointer technique
- Sorted array properties
- Handling negative numbers
- Comparing both ends of an array
- Building a sorted result
- Filling an array from right to left
- Auxiliary space vs output space
- Eliminating unnecessary sorting

---

# 🔗 Related Problems

The same Two Pointer pattern appears in:

- LeetCode 167 — Two Sum II
- LeetCode 11 — Container With Most Water
- LeetCode 15 — 3Sum
- LeetCode 18 — 4Sum
- LeetCode 42 — Trapping Rain Water
- LeetCode 881 — Boats to Save People

---

# 🎓 Pattern Recognition

When you see:

- A sorted array
- Values at both ends that need comparison
- A requirement to find minimum/maximum combinations
- A need to avoid nested loops

Think about:

```text
TWO POINTERS
```

The key question to ask is:

> "Can I eliminate part of the search space by moving one pointer based on a comparison?"

If yes, the Two Pointer technique may be applicable.

---

# 🏁 Final Conclusion

The problem can be solved using multiple approaches.

### Brute Force + Sorting

```text
Time:  O(n log n)
Space: O(n)
```

### Two Pointers

```text
Time:  O(n)
Space: O(n)
Auxiliary Space: O(1)
```

The **Two Pointer approach is optimal** because it uses the sorted nature of the input array and avoids unnecessary sorting.

It processes every element exactly once and produces the required sorted squared array efficiently.