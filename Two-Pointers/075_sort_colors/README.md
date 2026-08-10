# 0075. Sort Colors

> **Difficulty:** Medium  
> **Topics:** Arrays, Two Pointers, Sorting  
> **Pattern:** Three Pointers / Dutch National Flag Algorithm  
> **Platform:** LeetCode

---

## 📖 Problem Statement

Given an array `nums` containing integers representing colors:

```text
0 → Red
1 → White
2 → Blue
```

Sort the array in-place so that objects of the same color are adjacent.

The colors must appear in this order:

```text
0 → 1 → 2
```

You are not allowed to use the library's built-in sorting function.

The solution should use constant extra space.

---

## 🔗 Problem Link

https://leetcode.com/problems/sort-colors/

---

## 📝 Example 1

### Input

```text
nums = [2,0,2,1,1,0]
```

### Output

```text
[0,0,1,1,2,2]
```

---

## 📝 Example 2

### Input

```text
nums = [2,0,1]
```

### Output

```text
[0,1,2]
```

---

## 🔒 Constraints

- `n == nums.length`
- `1 <= n <= 300`
- `nums[i]` is either `0`, `1`, or `2`

---

# 🎯 Goal

We need to rearrange the array so that:

```text
All 0s → All 1s → All 2s
```

The important requirements are:

- Sort in-place.
- Do not use built-in sorting.
- Use constant extra space.
- Ideally solve the problem in one pass.

---

# 🚀 Approach 1: Built-in Sorting

## 💡 Intuition

The easiest solution is to use the language's built-in sorting method.

For example, Java provides:

```text
Arrays.sort(nums)
```

This automatically arranges the elements in ascending order.

---

## 🔄 Algorithm

1. Take the input array.
2. Apply the built-in sorting algorithm.
3. The array becomes sorted as:

```text
0 → 1 → 2
```

---

## ⏱️ Time Complexity

For Java's primitive integer array sorting:

```text
O(n log n)
```

---

## 💾 Space Complexity

The exact auxiliary space depends on the implementation, but it is not the intended constant-space solution for this problem.

---

## ❌ Why We Should Not Choose It

The problem specifically asks us not to use the built-in sorting function.

More importantly, the input contains only three possible values:

```text
0, 1, 2
```

This special property allows us to design a more efficient solution.

---

# 🚀 Approach 2: Counting

## 💡 Intuition

Since the array contains only:

```text
0, 1, 2
```

we can count how many times each value occurs.

Maintain three counters:

```text
count0
count1
count2
```

Then overwrite the array:

```text
count0 times → 0
count1 times → 1
count2 times → 2
```

---

## 🔄 Algorithm

1. Traverse the array.
2. Count the number of `0`s.
3. Count the number of `1`s.
4. Count the number of `2`s.
5. Rewrite the array using those counts.

For example:

```text
nums = [2,0,2,1,1,0]
```

Counts:

```text
0 → 2
1 → 2
2 → 2
```

Rewrite:

```text
[0,0,1,1,2,2]
```

---

## ⏱️ Time Complexity

First traversal:

```text
O(n)
```

Second traversal:

```text
O(n)
```

Overall:

```text
O(n)
```

---

## 💾 Space Complexity

Only three counters are required:

```text
O(1)
```

---

## ✅ Advantages

- Linear time.
- Constant extra space.
- Easy to understand.
- Does not use built-in sorting.

---

## ❌ Disadvantages

- Requires two passes.
- Does not fully utilize the one-pass nature of the Dutch National Flag algorithm.
- Requires rewriting the array.

---

# 🚀 Approach 3: Dutch National Flag Algorithm ⭐ Optimal

## 💡 Intuition

The optimal solution uses three pointers:

```text
low
mid
high
```

The array is divided into four regions:

```text
[0 ... low-1]     → 0s
[low ... mid-1]   → 1s
[mid ... high]    → Unknown
[high+1 ... n-1]  → 2s
```

The `mid` pointer processes the unknown region.

At every step, we examine:

```text
nums[mid]
```

There are only three possibilities:

```text
0
1
2
```

Each value tells us exactly what to do.

---

# 📌 Pointer Meaning

## `low`

`low` represents the position where the next `0` should go.

Everything before `low` is already sorted and contains only `0`s.

---

## `mid`

`mid` represents the current element that needs to be examined.

Everything before `mid` has already been processed.

---

## `high`

`high` represents the position where the next `2` should go.

Everything after `high` is already sorted and contains only `2`s.

---

# 🔄 Three Cases

## Case 1: `nums[mid] == 0`

A `0` belongs on the left side.

Swap:

```text
nums[low]
```

with:

```text
nums[mid]
```

Then:

```text
low++
mid++
```

Why increment both?

Because after the swap:

- The `0` is placed correctly at `low`.
- The element moved from `low` to `mid` has already been processed.

---

# Case 2: `nums[mid] == 1`

A `1` already belongs in the middle.

No swap is required.

Simply:

```text
mid++
```

---

# Case 3: `nums[mid] == 2`

A `2` belongs on the right side.

Swap:

```text
nums[mid]
```

with:

```text
nums[high]
```

Then:

```text
high--
```

Important:

> Do NOT increment `mid` here.

Why?

Because the element that comes from `high` into `mid` has not been examined yet.

We need to process it again.

---

# 🧠 Dry Run

Consider:

```text
nums = [2,0,2,1,1,0]
```

Initially:

```text
low = 0
mid = 0
high = 5
```

---

## Step 1

Current element:

```text
nums[mid] = 2
```

A `2` belongs on the right.

Swap positions `mid` and `high`:

```text
[0,0,2,1,1,2]
```

Then:

```text
high--
```

Now:

```text
low = 0
mid = 0
high = 4
```

We do NOT increment `mid`.

---

## Step 2

Current element:

```text
nums[mid] = 0
```

A `0` belongs on the left.

Swap `low` and `mid`.

The array remains:

```text
[0,0,2,1,1,2]
```

Then:

```text
low++
mid++
```

Now:

```text
low = 1
mid = 1
high = 4
```

---

## Step 3

Current element:

```text
nums[mid] = 0
```

Again, `0` belongs on the left.

After processing:

```text
low = 2
mid = 2
high = 4
```

Array:

```text
[0,0,2,1,1,2]
```

---

## Step 4

Current element:

```text
nums[mid] = 2
```

Swap with `high`.

Array becomes:

```text
[0,0,1,1,2,2]
```

Then:

```text
high--
```

Now:

```text
low = 2
mid = 2
high = 3
```

Again, `mid` does not move.

---

## Step 5

Current element:

```text
nums[mid] = 1
```

A `1` is already in the correct middle region.

So:

```text
mid++
```

Now:

```text
mid = 3
```

---

## Step 6

Current element:

```text
nums[mid] = 1
```

Again:

```text
mid++
```

Now:

```text
mid = 4
```

The condition:

```text
mid <= high
```

is now false.

The final array is:

```text
[0,0,1,1,2,2]
```

---

# 🧠 Why Does the Dutch National Flag Algorithm Work?

At every point, the array is divided into four regions:

```text
0s | 1s | Unknown | 2s
```

The goal is to reduce the unknown region.

Whenever we encounter:

```text
0
```

we move it to the `0` region.

Whenever we encounter:

```text
1
```

we leave it in the middle.

Whenever we encounter:

```text
2
```

we move it to the `2` region.

Eventually, there are no unknown elements left.

Therefore, the entire array is sorted.

---

# 🔍 Important Detail: Why `mid` Does Not Move for 2

This is one of the most important interview questions.

Suppose:

```text
nums[mid] = 2
```

We swap it with:

```text
nums[high]
```

The element coming from `high` could be:

```text
0
```

or:

```text
1
```

or even:

```text
2
```

We have not examined it yet.

Therefore, we cannot move `mid`.

We must examine the new element at `mid`.

So:

```text
2 case:
high--
```

but:

```text
mid
```

does not change.

---

# 🔍 Why `mid` Moves for 0

When:

```text
nums[mid] = 0
```

we swap it with `nums[low]`.

Because the entire region before `mid` has already been processed, the element coming from `low` is already known to belong in the processed region.

Therefore:

```text
low++
mid++
```

are both safe.

---

# 📊 Approach Comparison

| Approach | Time | Space | Passes | Optimal |
|---|---:|---:|---:|---|
| Built-in Sorting | O(n log n) | Depends | — | ❌ |
| Counting | O(n) | O(1) | 2 | Good |
| Dutch National Flag | **O(n)** | **O(1)** | **1** | ✅ |

---

# 🏆 Best Approach

The **Dutch National Flag Algorithm** is the best approach.

### Why?

It provides:

```text
Time: O(n)
Space: O(1)
```

and processes the array in a single pass.

It also directly uses the fact that there are only three possible values:

```text
0, 1, 2
```

This makes it more elegant and efficient than general-purpose sorting.

---

# ⏱️ Final Complexity

## Approach 1 — Built-in Sorting

```text
Time: O(n log n)
Space: Implementation dependent
```

## Approach 2 — Counting

```text
Time: O(n)
Space: O(1)
```

## Approach 3 — Dutch National Flag

```text
Time: O(n)
Space: O(1)
```

---

# 🎯 Key Observations

1. The array contains only `0`, `1`, and `2`.
2. We need all `0`s before `1`s.
3. All `1`s must come before `2`s.
4. Three pointers can represent the three regions.
5. `low` manages the `0` region.
6. `mid` processes unknown elements.
7. `high` manages the `2` region.
8. `0` → swap with `low`.
9. `1` → simply move `mid`.
10. `2` → swap with `high`.
11. Do not increment `mid` after swapping a `2`.
12. Continue until `mid > high`.
13. The array becomes sorted in-place.
14. No additional array is required.

---

# ⚠️ Common Mistakes

## Mistake 1: Incrementing `mid` After Processing 2

Incorrect:

```text
2 → swap with high
mid++
high--
```

Correct:

```text
2 → swap with high
high--
```

The new value at `mid` must be processed.

---

## Mistake 2: Forgetting to Increment `low`

When a `0` is found:

```text
low++
mid++
```

Both pointers must move.

---

## Mistake 3: Using Extra Arrays

The optimal solution sorts the array in-place.

No additional array is required.

---

## Mistake 4: Using Built-in Sort

The problem specifically asks not to use the built-in sorting function.

---

## Mistake 5: Wrong Loop Condition

The correct processing condition is:

```text
mid <= high
```

The unknown region ends when:

```text
mid > high
```

---

# 💼 Interview Questions

### Q1. What algorithm is used for the optimal solution?

The Dutch National Flag Algorithm.

### Q2. How many pointers are used?

Three:

```text
low
mid
high
```

### Q3. What does `low` represent?

The position where the next `0` should be placed.

### Q4. What does `mid` represent?

The current unknown element being processed.

### Q5. What does `high` represent?

The position where the next `2` should be placed.

### Q6. What happens when `nums[mid] == 0`?

Swap `nums[mid]` with `nums[low]`, then:

```text
low++
mid++
```

### Q7. What happens when `nums[mid] == 1`?

Simply:

```text
mid++
```

### Q8. What happens when `nums[mid] == 2`?

Swap `nums[mid]` with `nums[high]`, then:

```text
high--
```

Do not increment `mid`.

### Q9. Why don't we increment `mid` when we find 2?

Because the element swapped from `high` into `mid` has not been processed.

### Q10. What is the time complexity?

```text
O(n)
```

### Q11. What is the space complexity?

```text
O(1)
```

### Q12. Is the solution in-place?

Yes.

The array is rearranged without using another array.

---

# 📚 Key Learning

This problem teaches:

- Three Pointer technique
- Dutch National Flag Algorithm
- In-place array manipulation
- One-pass algorithms
- Constant-space algorithms
- Region-based array processing
- Pointer movement
- Greedy partitioning

---

# 🧩 Pattern Recognition

When an array contains a small fixed number of categories and needs to be partitioned into groups, think about:

```text
Dutch National Flag Algorithm
```

For three categories:

```text
0 | 1 | 2
```

use:

```text
low | mid | high
```

General idea:

```text
0 → move left
1 → keep in middle
2 → move right
```

---

# 🔗 Related Problems

The partitioning idea from this problem is useful for:

- Quick Sort partitioning
- Partition Array
- Move Zeroes
- Sort Array By Parity
- Segregate 0s and 1s
- Three-way partitioning
- Three Sum

---

# 🏁 Final Conclusion

There are three possible approaches.

### Built-in Sorting

```text
Time: O(n log n)
```

Simple but not allowed by the problem.

### Counting

```text
Time: O(n)
Space: O(1)
```

Efficient but requires multiple passes.

### Dutch National Flag

```text
Time: O(n)
Space: O(1)
```

The Dutch National Flag Algorithm is the optimal approach because it sorts the array in-place in a single pass.

The three-pointer strategy maintains:

```text
0s | 1s | Unknown | 2s
```

and continuously reduces the unknown region.

Therefore:

> **Dutch National Flag Algorithm is the best approach for Sort Colors.**

Final complexity:

```text
Time: O(n)
Space: O(1)
```