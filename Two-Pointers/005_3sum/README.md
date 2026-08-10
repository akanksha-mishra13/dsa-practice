# 0015. 3Sum

> **Difficulty:** Medium  
> **Topics:** Arrays, Sorting, Two Pointers  
> **Pattern:** Two Pointers  
> **Platform:** LeetCode

---

# 📖 Problem Statement

Given an integer array `nums`, return all the triplets:

```text
[nums[i], nums[j], nums[k]]
```

such that:

```text
i != j
i != k
j != k
```

and:

```text
nums[i] + nums[j] + nums[k] == 0
```

The returned solution must not contain duplicate triplets.

---

# 🔗 Problem Link

https://leetcode.com/problems/3sum/

---

# 📝 Example 1

### Input

```text
nums = [-1,0,1,2,-1,-4]
```

### Output

```text
[[-1,-1,2],[-1,0,1]]
```

### Explanation

The valid triplets are:

```text
-1 + -1 + 2 = 0
```

and:

```text
-1 + 0 + 1 = 0
```

The answer must not contain duplicate triplets.

---

# 📝 Example 2

### Input

```text
nums = [0,1,1]
```

### Output

```text
[]
```

There is no combination of three elements whose sum is zero.

---

# 📝 Example 3

### Input

```text
nums = [0,0,0]
```

### Output

```text
[[0,0,0]]
```

Even though there are three zeroes, the triplet should appear only once.

---

# 🔒 Constraints

- `3 <= nums.length <= 3000`
- `-10^5 <= nums[i] <= 10^5`

---

# 🎯 Goal

We need to find all unique triplets whose sum is:

```text
0
```

A direct approach would check every possible combination of three elements.

However, that would be too slow.

The optimal solution uses:

```text
Sorting + Two Pointers
```

---

# 🚀 Approach 1: Brute Force

## 💡 Intuition

The most straightforward solution is to choose every possible combination of three elements.

Use three loops:

```text
i
j
k
```

For every combination, calculate:

```text
nums[i] + nums[j] + nums[k]
```

If the sum is zero, add the triplet to the answer.

Duplicates would then need to be removed separately.

---

# 🔄 Algorithm

1. Choose the first element using `i`.
2. Choose the second element using `j`.
3. Choose the third element using `k`.
4. Check whether their sum is zero.
5. Store valid triplets.
6. Remove duplicate triplets.
7. Return the result.

---

# ⏱️ Time Complexity

There are three nested loops.

Therefore:

```text
O(n³)
```

If duplicate removal requires additional processing, the practical complexity can become even worse.

---

# 💾 Space Complexity

Depending on how duplicates are handled, additional space may be required.

Ignoring the output:

```text
O(1)
```

for the basic traversal itself.

However, storing the result is naturally excluded from auxiliary-space analysis.

---

# ❌ Why Brute Force Is Not Optimal

For:

```text
n = 3000
```

an `O(n³)` algorithm performs an enormous number of operations.

Therefore, brute force is not suitable for the constraints.

We need to reduce the problem from three nested loops.

---

# 🚀 Approach 2: Sorting + Binary Search

## 💡 Intuition

Another possibility is to fix two elements and binary-search for the third element.

First sort the array.

For every pair:

```text
nums[i]
nums[j]
```

we need:

```text
target = -(nums[i] + nums[j])
```

Then search for the target using binary search.

---

# 🔄 Algorithm

1. Sort the array.
2. Fix the first element.
3. Fix the second element.
4. Calculate the required third value.
5. Use binary search to find it.
6. Handle duplicate triplets.
7. Continue for all pairs.

---

# ⏱️ Time Complexity

There are:

```text
O(n²)
```

pairs.

Binary search takes:

```text
O(log n)
```

Therefore:

```text
O(n² log n)
```

---

# 💾 Space Complexity

Ignoring the output:

```text
O(1)
```

additional algorithmic space can be used after sorting, depending on the sorting implementation.

---

# ❌ Why It Is Not the Best

Although much better than brute force, it is still slower than the Two Pointer solution.

The Two Pointer approach can solve the search for the third value in linear time after fixing the first element.

---

# 🚀 Approach 3: Sorting + Two Pointers ⭐ Optimal

## 💡 Intuition

The optimal approach combines:

```text
Sorting
+
Two Pointers
```

First sort the array.

Then fix one element:

```text
nums[i]
```

For the remaining portion of the array, use two pointers:

```text
left = i + 1
right = n - 1
```

We want:

```text
nums[i] + nums[left] + nums[right] = 0
```

Rearrange:

```text
nums[left] + nums[right] = -nums[i]
```

Because the array is sorted, we can intelligently move the pointers depending on the current sum.

---

# 🔑 Why Sorting Helps

Suppose the sorted array is:

```text
[-4,-1,-1,0,1,2]
```

If:

```text
sum < 0
```

we need a larger value.

Because the array is sorted, move:

```text
left++
```

This increases the sum.

If:

```text
sum > 0
```

we need a smaller value.

Therefore:

```text
right--
```

This decreases the sum.

If:

```text
sum == 0
```

we found a valid triplet.

---

# 🔄 Algorithm

1. Sort the array.
2. Iterate through the array using `i`.
3. Skip duplicate values for `i`.
4. Set:

```text
left = i + 1
right = n - 1
```

5. Calculate:

```text
sum = nums[i] + nums[left] + nums[right]
```

6. If:

```text
sum == 0
```

add the triplet.
7. Skip duplicate values.
8. Move both pointers inward.
9. If:

```text
sum < 0
```

move `left`.
10. If:

```text
sum > 0
```

move `right`.
11. Continue until:

```text
left >= right
```

12. Continue with the next `i`.

---

# 🧠 Dry Run

Consider:

```text
nums = [-1,0,1,2,-1,-4]
```

First sort the array:

```text
[-4,-1,-1,0,1,2]
```

---

## Step 1: Choose `i = 0`

```text
nums[i] = -4
```

Set:

```text
left = 1
right = 5
```

Values:

```text
-4 + (-1) + 2 = -3
```

The sum is negative.

We need a larger value.

Therefore:

```text
left++
```

---

## Continue

Eventually, every possible pair with `-4` is examined.

No valid triplet is found.

---

# Step 2: Choose `i = 1`

```text
nums[i] = -1
```

Set:

```text
left = 2
right = 5
```

Current values:

```text
-1, -1, 2
```

Sum:

```text
-1 + -1 + 2 = 0
```

We found:

```text
[-1,-1,2]
```

Add it to the result.

Then skip duplicates and move:

```text
left++
right--
```

---

# Continue With `i = 1`

Now:

```text
left = 3
right = 4
```

Values:

```text
-1,0,1
```

Sum:

```text
-1 + 0 + 1 = 0
```

Add:

```text
[-1,0,1]
```

Now:

```text
left++
right--
```

The pointers meet.

---

# Step 3: Duplicate `-1`

The next value of `i` is also:

```text
-1
```

But we already processed the previous `-1`.

If we process it again, we may generate duplicate triplets.

Therefore:

```text
if nums[i] == nums[i - 1]
    skip
```

This prevents duplicate first elements.

---

# 🧠 Handling Duplicates

Duplicate handling is one of the most important parts of this problem.

There are three places where duplicates must be considered.

---

## 1. Duplicate `i`

Suppose:

```text
[-1,-1,0,1]
```

Both `-1`s could become the first element.

But they would generate duplicate triplets.

Therefore, skip the second occurrence:

```text
if (i > 0 && nums[i] == nums[i - 1])
```

---

## 2. Duplicate `left`

After finding a valid triplet, suppose:

```text
nums[left] == nums[left + 1]
```

Using both would generate the same triplet.

Therefore, skip duplicate left values.

---

## 3. Duplicate `right`

Similarly, if:

```text
nums[right] == nums[right - 1]
```

we skip duplicate right values.

---

# 🔍 Why Do We Move `left` When Sum Is Too Small?

Suppose:

```text
sum < 0
```

The current sum is smaller than zero.

Because the array is sorted:

```text
moving left forward
```

means choosing a larger value.

Therefore, the sum increases.

So:

```text
sum < 0
→ left++
```

---

# 🔍 Why Do We Move `right` When Sum Is Too Large?

Suppose:

```text
sum > 0
```

The sum is too large.

Because the array is sorted:

```text
moving right backward
```

means choosing a smaller value.

Therefore, the sum decreases.

So:

```text
sum > 0
→ right--
```

---

# 🔍 Why Does This Work?

Sorting gives us a predictable relationship between pointer movement and the sum.

If the sum is too small:

```text
increase left
```

If the sum is too large:

```text
decrease right
```

This means we do not need to check every possible pair.

The two pointers eliminate impossible combinations.

---

# 📊 Approach Comparison

| Approach | Time Complexity | Space Complexity | Optimal |
|---|---:|---:|---|
| Brute Force | O(n³) | O(1)* | ❌ |
| Binary Search | O(n² log n) | O(1)* | ❌ |
| Sorting + Two Pointers | **O(n²)** | **O(1)*** | ✅ |

`*` Output storage is not included.

---

# 🏆 Why Sorting + Two Pointers Is Optimal

The first element is fixed using a loop:

```text
O(n)
```

For every fixed first element, the remaining array is searched using two pointers:

```text
O(n)
```

Therefore:

```text
O(n) × O(n)
```

gives:

```text
O(n²)
```

The initial sorting takes:

```text
O(n log n)
```

Therefore, the total complexity is:

```text
O(n log n + n²)
```

which simplifies to:

```text
O(n²)
```

The algorithm uses only a constant number of pointer variables apart from the output.

Therefore, auxiliary space is:

```text
O(1)
```

depending on the sorting implementation.

---

# ⏱️ Final Complexity

## Approach 1 — Brute Force

```text
Time: O(n³)
Space: O(1)*
```

## Approach 2 — Binary Search

```text
Time: O(n² log n)
Space: O(1)*
```

## Approach 3 — Sorting + Two Pointers

```text
Time: O(n²)
Space: O(1)*
```

`*` Output storage is excluded.

---

# 🎯 Key Observations

1. We need three numbers whose sum is zero.
2. Sorting makes pointer movement predictable.
3. Fix one element.
4. Use two pointers for the remaining elements.
5. If the sum is too small, move `left`.
6. If the sum is too large, move `right`.
7. If the sum is zero, record the triplet.
8. Duplicate values must be skipped.
9. The first element's duplicates must be skipped.
10. Duplicate left values must be skipped.
11. Duplicate right values must be skipped.
12. Sorting costs `O(n log n)`.
13. The two-pointer search costs `O(n)` for each fixed element.
14. Overall complexity is `O(n²)`.
15. Sorting + Two Pointers is the optimal standard solution.

---

# ⚠️ Common Mistakes

## Mistake 1: Not Sorting the Array

Without sorting, we cannot efficiently decide whether to move:

```text
left
```

or:

```text
right
```

---

## Mistake 2: Forgetting Duplicate `i`

Without:

```text
if (i > 0 && nums[i] == nums[i - 1])
```

duplicate triplets may be produced.

---

## Mistake 3: Not Skipping Duplicate `left`

After finding a valid triplet, duplicate left values should be skipped.

---

## Mistake 4: Not Skipping Duplicate `right`

Duplicate right values can also produce duplicate triplets.

---

## Mistake 5: Moving the Wrong Pointer

If:

```text
sum < 0
```

move:

```text
left++
```

If:

```text
sum > 0
```

move:

```text
right--
```

---

## Mistake 6: Using Three Nested Loops

Three nested loops result in:

```text
O(n³)
```

which is too slow.

---

## Mistake 7: Returning Duplicate Triplets

For example:

```text
[-1,0,1]
[-1,0,1]
```

should appear only once.

---

# 💼 Interview Questions

### Q1. What is the optimal approach for 3Sum?

Sorting followed by Two Pointers.

### Q2. What is the time complexity?

```text
O(n²)
```

### Q3. Why do we sort the array?

Sorting allows us to intelligently move the two pointers based on whether the current sum is too small or too large.

### Q4. Why do we move `left` when sum is negative?

Because the array is sorted, increasing `left` increases the sum.

### Q5. Why do we move `right` when sum is positive?

Because decreasing `right` moves to a smaller value and decreases the sum.

### Q6. Why do we skip duplicate `i` values?

To avoid generating the same triplet multiple times.

### Q7. Why do we skip duplicates after finding a valid triplet?

To ensure the result contains only unique triplets.

### Q8. What happens if the array contains three zeroes?

The answer contains:

```text
[0,0,0]
```

only once.

### Q9. What is the space complexity?

The auxiliary algorithmic space is:

```text
O(1)
```

excluding the output.

### Q10. Is Two Pointer alone enough?

No.

The array needs to be sorted first so that pointer movements have predictable effects on the sum.

---

# 📚 Key Learning

This problem teaches:

- Sorting
- Two Pointer technique
- Duplicate handling
- Array traversal
- Searching pairs efficiently
- Greedy pointer movement
- In-place processing
- Complexity optimization
- Combination problems

---

# 🧩 Pattern Recognition

When you see a problem asking for:

- Three elements
- A target sum
- Unique combinations
- A sorted or sortable array

Think:

```text
SORT
+
FIX ONE ELEMENT
+
TWO POINTERS
```

For 3Sum:

```text
nums[i] + nums[left] + nums[right] = 0
```

Then:

```text
sum < 0 → left++
sum > 0 → right--
sum == 0 → store triplet
```

---

# 🔗 Related Problems

The same pattern can help with:

- LeetCode 1 — Two Sum
- LeetCode 167 — Two Sum II
- LeetCode 16 — 3Sum Closest
- LeetCode 18 — 4Sum
- LeetCode 259 — 3Sum Smaller
- LeetCode 611 — Valid Triangle Number

---

# 🏁 Final Conclusion

There are three major approaches.

### Brute Force

```text
Time: O(n³)
```

Simple but too slow.

### Binary Search

```text
Time: O(n² log n)
```

Better, but still not optimal.

### Sorting + Two Pointers

```text
Time: O(n²)
Space: O(1)*
```

This is the optimal standard approach.

The key idea is:

```text
Sort
↓
Fix one element
↓
Use two pointers
↓
Skip duplicates
↓
Find all unique triplets
```

Therefore:

> **Sorting + Two Pointers is the best approach for 3Sum.**

Final complexity:

```text
Time: O(n²)
Space: O(1)*
```

`*` Excluding the space required to store the output.