# 0643. Maximum Average Subarray I

> Difficulty: Easy  
> Topics: Array, Sliding Window  
> Pattern: Fixed-Size Sliding Window  
> Platform: LeetCode

---

# 📖 Problem Statement

You are given an integer array `nums` consisting of `n` elements
and an integer `k`.

Find a contiguous subarray whose length is exactly `k` and whose
average value is maximum.

Return the maximum average.

The answer will be accepted if it is within `10^-5` of the actual
answer.

---

# 🔗 Problem Link

https://leetcode.com/problems/maximum-average-subarray-i/

---

# 📝 Example 1

Input:

    nums = [1,12,-5,-6,50,3]
    k = 4

Output:

    12.75000

Explanation:

The subarray:

    [12,-5,-6,50]

has the maximum average.

Its sum is:

    12 + (-5) + (-6) + 50 = 51

Its average is:

    51 / 4 = 12.75

---

# 📝 Example 2

Input:

    nums = [5]
    k = 1

Output:

    5.00000

The only possible subarray is:

    [5]

Therefore the maximum average is:

    5

---

# 🔒 Constraints

- `n == nums.length`
- `1 <= k <= n <= 10^5`
- `-10^4 <= nums[i] <= 10^4`

---

# 🎯 Goal

We need to find the contiguous subarray of exactly `k` elements
having the maximum average.

The important word is:

    exactly k elements

Therefore, every possible window must have the same size.

---

# 🔑 Important Observation

Every candidate subarray has exactly `k` elements.

The average is:

    average = sum / k

Since `k` is fixed for every candidate:

    Maximum average
          ↓
    Maximum sum

Therefore, instead of calculating the average for every window,
we only need to find the maximum sum of any subarray of length `k`.

After finding the maximum sum, divide it by `k`.

This converts the problem into a fixed-size Sliding Window problem.

---

# 🚀 Approach 1: Brute Force

## 💡 Intuition

The straightforward approach is to consider every possible
subarray of length `k`.

For each starting position:

    i

calculate the sum of:

    nums[i]
    nums[i + 1]
    ...
    nums[i + k - 1]

Then calculate its average.

Keep track of the maximum average.

---

# 🔄 Algorithm

1. Start from index `0`.
2. Calculate the sum of the next `k` elements.
3. Calculate their average.
4. Update the maximum average.
5. Move the starting position by one.
6. Repeat until every possible window has been checked.

---

# ⏱️ Time Complexity

There can be approximately:

    O(n)

windows.

For every window, calculating the sum requires:

    O(k)

time.

Therefore:

    O(n × k)

In the worst case:

    O(n²)

---

# 💾 Space Complexity

Only a few variables are needed.

Therefore:

    O(1)

---

# ❌ Why Brute Force Is Not Optimal

The main problem is that we repeatedly calculate sums.

For example, consider:

    [1,2,3,4,5]

with:

    k = 3

First window:

    [1,2,3]

Second window:

    [2,3,4]

The values:

    2
    3

were already included in the previous window.

Recalculating them wastes work.

We need a way to reuse the previous window's sum.

This leads to Sliding Window.

---

# 🚀 Approach 2: Prefix Sum

## 💡 Intuition

We can calculate prefix sums so that the sum of any subarray
can be obtained in constant time.

Create:

    prefix[i]

which stores the sum of the first `i` elements.

For a window from `i` to `j`:

    sum = prefix[j + 1] - prefix[i]

Since every window has size `k`, we can calculate each window
sum in:

    O(1)

time.

---

# 🔄 Algorithm

1. Create a prefix sum array.
2. Store cumulative sums.
3. For every starting index `i`, calculate the sum of the
   window of length `k`.
4. Keep the maximum sum.
5. Divide the maximum sum by `k`.

---

# ⏱️ Time Complexity

Building the prefix sum:

    O(n)

Checking every window:

    O(n)

Total:

    O(n)

---

# 💾 Space Complexity

The prefix array requires:

    O(n)

additional space.

---

# ✅ Advantages

- Linear time.
- Simple mathematical calculation.
- Can answer multiple range-sum queries efficiently.

---

# ❌ Disadvantages

The additional prefix array is unnecessary for this problem.

We only need the previous window's sum.

Therefore, we can achieve the same:

    O(n)

time

with:

    O(1)

extra space.

---

# 🚀 Approach 3: Fixed-Size Sliding Window ⭐ Optimal

## 💡 Intuition

Instead of recalculating the sum for every window,
maintain the current window sum.

When the window moves one position to the right:

1. Add the new element entering the window.
2. Remove the old element leaving the window.

So:

    newWindowSum
        =
    oldWindowSum
        + enteringElement
        - leavingElement

This allows every window to be processed in constant time.

---

# 🪟 What Is a Sliding Window?

A Sliding Window represents a continuous section of an array.

For this problem, the window always has exactly:

    k

elements.

For example:

    nums = [1,2,3,4,5]
    k = 3

The windows are:

    [1,2,3]
     ↓
    [2,3,4]
     ↓
    [3,4,5]

Instead of calculating every sum from scratch, we slide the
existing window.

---

# 🔄 Algorithm

1. Calculate the sum of the first `k` elements.
2. Store it as the current window sum.
3. Store it as the initial maximum sum.
4. Start from index `k`.
5. Add the new element entering the window.
6. Remove the element leaving the window.
7. Compare the current sum with the maximum sum.
8. Continue until the entire array has been processed.
9. Divide the maximum sum by `k`.

---

# 🧠 Window Formula

Suppose the current window is:

    nums[left ... right]

When the window moves one position:

    left++

    right++

The new sum becomes:

    newSum
      =
    oldSum
      + nums[right]
      - nums[left]

In the implementation, we can use:

    nums[right]
    -
    nums[right - k]

because the element `k` positions behind the new right index
is exactly the element leaving the window.

---

# 🧠 Dry Run

Consider:

    nums = [1,12,-5,-6,50,3]
    k = 4

---

## Step 1: First Window

Take the first four elements:

    [1,12,-5,-6]

Sum:

    1 + 12 - 5 - 6
    = 2

So:

    maxSum = 2

---

# Step 2: Slide the Window

The next window is:

    [12,-5,-6,50]

Instead of recalculating:

    12 - 5 - 6 + 50

we use the previous sum.

Previous:

    2

Add the new element:

    +50

Remove the element leaving:

    -1

Therefore:

    newSum = 2 + 50 - 1
           = 51

Now:

    maxSum = 51

---

# Step 3: Slide Again

The next window is:

    [-5,-6,50,3]

Add:

    3

Remove:

    12

Therefore:

    newSum = 51 + 3 - 12
           = 42

Compare:

    maxSum = max(51,42)

Therefore:

    maxSum = 51

---

# Step 4: Calculate Average

The maximum sum is:

    51

The window size is:

    4

Therefore:

    maximum average = 51 / 4

    = 12.75

Final answer:

    12.75

---

# 🔍 Why Sliding Window Is Efficient

Without Sliding Window, every window's sum is calculated
from scratch.

With Sliding Window, only two operations are needed when
the window moves:

    Add one element

and:

    Remove one element

Therefore, each window takes:

    O(1)

time.

Since there are:

    O(n)

windows, the complete algorithm takes:

    O(n)

time.

---

# 🧠 Why We Maximize Sum Instead of Average

The average formula is:

    sum / k

The value `k` never changes because every window contains
exactly `k` elements.

Therefore:

    average1 > average2

if and only if:

    sum1 > sum2

So we only need to compare sums.

This avoids unnecessary floating-point calculations while
searching for the answer.

Only the final division needs to produce a decimal result.

---

# 📊 Approach Comparison

| Approach | Time Complexity | Space Complexity | Best |
|---|---:|---:|---|
| Brute Force | O(n × k), worst O(n²) | O(1) | ❌ |
| Prefix Sum | O(n) | O(n) | Good |
| Fixed Sliding Window | O(n) | O(1) | ✅ |

---

# 🏆 Why Sliding Window Is Optimal

The array must be examined at least once to determine the
maximum possible window.

Therefore, an:

    O(n)

solution is optimal.

The Sliding Window approach achieves:

    Time: O(n)

and only maintains a few variables:

    windowSum
    maxSum
    right

Therefore:

    Space: O(1)

This makes it better than the Prefix Sum approach in terms
of extra memory.

---

# ⏱️ Final Complexity

## Brute Force

    Time: O(n × k)
    Worst Case: O(n²)

    Space: O(1)

---

## Prefix Sum

    Time: O(n)

    Space: O(n)

---

## Fixed-Size Sliding Window

    Time: O(n)

    Space: O(1)

---

# 🎯 Key Observations

1. Every candidate subarray has exactly `k` elements.
2. Because `k` is fixed, maximizing average is equivalent
   to maximizing sum.
3. Recalculating every window is unnecessary.
4. A window can be shifted one position at a time.
5. Add the new element entering the window.
6. Remove the old element leaving the window.
7. This gives O(1) work per window.
8. There are O(n) possible windows.
9. Therefore the total time is O(n).
10. Only a few variables are required.
11. Therefore extra space is O(1).
12. This is a Fixed-Size Sliding Window problem.

---

# ⚠️ Common Mistakes

## Mistake 1: Recalculating Every Window

Do not calculate every window sum from scratch.

Instead:

    newSum = oldSum + incoming - outgoing

---

## Mistake 2: Forgetting to Remove the Leaving Element

When the window moves, one element leaves.

That element must be subtracted.

---

## Mistake 3: Using Integer Division

The final answer may be decimal.

Therefore, the final calculation must perform floating-point
division.

Conceptually:

    maximumSum / (double) k

---

## Mistake 4: Calculating Average for Every Window

There is no need.

Since `k` is fixed, compare sums instead.

Calculate the average only once after finding the maximum sum.

---

## Mistake 5: Incorrect Window Size

The window must always contain exactly:

    k

elements.

---

## Mistake 6: Incorrect Leaving Index

When the right pointer is at:

    right

the element leaving the window is:

    right - k

---

# 💼 Interview Questions

### Q1. What pattern does this problem use?

Fixed-Size Sliding Window.

---

### Q2. Why can we maximize the sum instead of the average?

Because every window has the same size `k`.

---

### Q3. What is the optimal time complexity?

    O(n)

---

### Q4. What is the optimal space complexity?

    O(1)

---

### Q5. How do you update the window sum?

Add the new element and subtract the element that leaves.

---

### Q6. Why is Sliding Window better than brute force?

It avoids recalculating elements that are common between
consecutive windows.

---

### Q7. Why is Prefix Sum not the optimal space solution?

Prefix Sum uses:

    O(n)

extra memory.

Sliding Window achieves the same linear time using:

    O(1)

extra space.

---

### Q8. What type of Sliding Window is this?

Fixed-Size Sliding Window.

The window size always remains:

    k

---

### Q9. Can this technique work when the window size changes?

Not directly.

For variable-size windows, we need a different Sliding Window
strategy where the window expands and contracts according to
a condition.

---

### Q10. What is the key formula?

    newWindowSum
        =
    oldWindowSum
        + incomingElement
        - outgoingElement

---

# 📚 Key Learning

This problem teaches:

- Sliding Window
- Fixed-size windows
- Running sum
- Array traversal
- Prefix Sum comparison
- Space optimization
- Avoiding repeated calculations

---

# 🧩 Pattern Recognition

Whenever a problem asks for:

- A contiguous subarray
- Exactly `k` elements
- Maximum/minimum sum
- Maximum/minimum average
- A fixed window size

Think:

    FIXED-SIZE SLIDING WINDOW

The general pattern is:

    Build first window
          ↓
    Save its result
          ↓
    Add incoming element
          ↓
    Remove outgoing element
          ↓
    Update result
          ↓
    Repeat

---

# 🔗 Related Problems

Related Fixed-Size Sliding Window problems:

- LeetCode 643 — Maximum Average Subarray I
- LeetCode 1343 — Number of Sub-arrays of Size K and Average ≥ Threshold
- LeetCode 1456 — Maximum Number of Vowels in a Substring of Given Length

Related Variable-Size Sliding Window problems:

- LeetCode 209 — Minimum Size Subarray Sum
- LeetCode 3 — Longest Substring Without Repeating Characters
- LeetCode 1004 — Max Consecutive Ones III
- LeetCode 424 — Longest Repeating Character Replacement
- LeetCode 76 — Minimum Window Substring

---

# 🏁 Final Conclusion

There are three major approaches.

## Brute Force

    Time: O(n × k)
    Worst Case: O(n²)
    Space: O(1)

Simple but repeatedly calculates the same elements.

---

## Prefix Sum

    Time: O(n)
    Space: O(n)

Efficient but uses additional memory.

---

## Fixed-Size Sliding Window

    Time: O(n)
    Space: O(1)

This is the optimal approach.

The core idea is:

    Create first window
          ↓
    Calculate its sum
          ↓
    Slide the window
          ↓
    Add incoming element
          ↓
    Remove outgoing element
          ↓
    Track maximum sum
          ↓
    Divide by k

Therefore:

> **Fixed-Size Sliding Window is the optimal approach for Maximum Average Subarray I.**

Final complexity:

    Time: O(n)
    Space: O(1)