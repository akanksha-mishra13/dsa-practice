# 1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold

> Difficulty: Medium  
> Topics: Array, Sliding Window  
> Pattern: Fixed-Size Sliding Window  
> Platform: LeetCode

---

# 📖 Problem Statement

Given an integer array `arr` and two integers:

    k
    threshold

Return the number of contiguous subarrays of size exactly `k`
whose average is greater than or equal to `threshold`.

---

# 🔗 Problem Link

https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/

---

# 📝 Example 1

Input:

    arr = [2,2,2,2,5,5,5,8]
    k = 3
    threshold = 4

Output:

    3

Explanation:

The subarrays of size 3 are:

    [2,2,2]       average = 2
    [2,2,2]       average = 2
    [2,2,5]       average = 3
    [2,5,5]       average = 4
    [5,5,5]       average = 5
    [5,5,8]       average = 6
    [5,8]         invalid

The valid windows are:

    [2,5,5]
    [5,5,5]
    [5,5,8]

Therefore:

    answer = 3

---

# 📝 Example 2

Input:

    arr = [1,1,1,1,1]
    k = 1
    threshold = 0

Output:

    5

Every subarray has average:

    1

which is greater than or equal to:

    0

---

# 🔒 Constraints

- `1 <= arr.length <= 10^5`
- `1 <= k <= arr.length`
- `0 <= arr[i] <= 10^4`
- `0 <= threshold <= 10^4`

---

# 🎯 Goal

We need to count how many contiguous subarrays:

    have exactly k elements

and:

    average >= threshold

The important part is that every candidate window has the same
fixed size `k`.

This immediately suggests:

    Fixed-Size Sliding Window

---

# 🔑 Important Mathematical Observation

For a window of size `k`:

    average = sum / k

We need:

    average >= threshold

Therefore:

    sum / k >= threshold

Multiply both sides by `k`:

    sum >= k * threshold

So instead of calculating the average for every window, we can
simply compare:

    windowSum >= k * threshold

This avoids unnecessary floating-point calculations.

---

# 🚀 Approach 1: Brute Force

## 💡 Intuition

The straightforward approach is to consider every possible
subarray of size `k`.

For each window:

1. Calculate its sum.
2. Calculate its average.
3. Check whether the average is at least `threshold`.
4. If yes, increment the answer.

---

# 🔄 Algorithm

1. Start from every possible starting index.
2. Calculate the sum of the next `k` elements.
3. Calculate:

       average = sum / k

4. Compare the average with `threshold`.
5. Increment the count if the condition is satisfied.

---

# ⏱️ Time Complexity

There are:

    O(n)

possible windows.

Calculating each window's sum from scratch requires:

    O(k)

Therefore:

    O(n × k)

In the worst case:

    O(n²)

---

# 💾 Space Complexity

Only a few variables are required.

Therefore:

    O(1)

---

# ❌ Why Brute Force Is Not Optimal

Consecutive windows contain many of the same elements.

For example:

    [2,2,2]
    [2,2,5]

The two windows share:

    [2,2]

There is no reason to calculate these elements again.

We can reuse the previous window's sum.

---

# 🚀 Approach 2: Prefix Sum

## 💡 Intuition

Create a prefix sum array where:

    prefix[i]

represents the sum of the first `i` elements.

Then the sum of any window can be found in constant time.

For a window from `i` to `j`:

    sum = prefix[j + 1] - prefix[i]

Since every window has size `k`, each window can be checked
in O(1) time.

---

# 🔄 Algorithm

1. Build a prefix sum array.
2. Iterate through every possible window.
3. Calculate its sum using the prefix array.
4. Check whether:

       sum >= k * threshold

5. Increment the answer when the condition is satisfied.

---

# ⏱️ Time Complexity

Building prefix sums:

    O(n)

Checking all windows:

    O(n)

Total:

    O(n)

---

# 💾 Space Complexity

The prefix array requires:

    O(n)

extra space.

---

# ✅ Advantages

- Linear time.
- Simple range-sum calculation.
- Useful when many different range queries are required.

---

# ❌ Disadvantages

For this particular problem, the prefix array is unnecessary.

We only need the sum of the current fixed-size window.

A running sum can achieve:

    O(n)

time

with:

    O(1)

space.

---

# 🚀 Approach 3: Fixed-Size Sliding Window ⭐ Optimal

## 💡 Intuition

Maintain the sum of the current window.

First calculate the sum of the first `k` elements.

Then move the window one position at a time.

When the window moves:

    Add the new element

and:

    Remove the element that leaves

Therefore:

    newWindowSum
        =
    oldWindowSum
        + incomingElement
        - outgoingElement

After updating the sum, check whether:

    windowSum >= k * threshold

If yes:

    count++

---

# 🪟 Fixed-Size Window

The window always contains:

    k

elements.

For example:

    arr = [2,2,2,2,5]
    k = 3

Windows are:

    [2,2,2]
     ↓
    [2,2,2]
     ↓
    [2,2,5]

The size never changes.

Only the contents of the window change.

---

# 🔄 Algorithm

1. Calculate the sum of the first `k` elements.
2. Calculate the required minimum sum:

       k * threshold

3. Check whether the first window satisfies the condition.
4. Start sliding from index `k`.
5. Add the new element entering the window.
6. Subtract the element leaving the window.
7. Check the updated window sum.
8. Increment the count if the condition is satisfied.
9. Continue until all windows are processed.
10. Return the count.

---

# 🧠 Dry Run

Consider:

    arr = [2,2,2,2,5,5,5,8]
    k = 3
    threshold = 4

---

# Step 1: Calculate Required Sum

We know:

    average >= threshold

is equivalent to:

    sum >= k * threshold

Therefore:

    requiredSum = 3 * 4

    requiredSum = 12

So every window needs a sum of at least:

    12

---

# Step 2: First Window

First three elements:

    [2,2,2]

Sum:

    6

Check:

    6 >= 12

False.

Count:

    0

---

# Step 3: Slide

New window:

    [2,2,2]

Sum remains:

    6

Check:

    6 >= 12

False.

Count:

    0

---

# Step 4: Slide Again

New window:

    [2,2,5]

Previous sum:

    6

Add:

    5

Remove:

    2

New sum:

    6 + 5 - 2

    = 9

Check:

    9 >= 12

False.

Count:

    0

---

# Step 5: Slide Again

New window:

    [2,5,5]

Previous sum:

    9

Add:

    5

Remove:

    2

New sum:

    12

Check:

    12 >= 12

True.

Count:

    1

---

# Step 6: Slide Again

New window:

    [5,5,5]

Previous sum:

    12

Add:

    5

Remove:

    2

New sum:

    15

Check:

    15 >= 12

True.

Count:

    2

---

# Step 7: Final Window

New window:

    [5,5,8]

Previous sum:

    15

Add:

    8

Remove:

    2

New sum:

    21

Check:

    21 >= 12

True.

Count:

    3

Final answer:

    3

---

# 🔍 Why Sliding Window Works

Two consecutive windows of size `k` differ by only two elements:

1. One element leaves.
2. One element enters.

Therefore, instead of calculating the complete sum again,
we update the existing sum.

This changes the work for each new window from:

    O(k)

to:

    O(1)

---

# 🧠 Why We Compare Sums Instead of Averages

The condition is:

    average >= threshold

Since:

    average = sum / k

we get:

    sum / k >= threshold

Therefore:

    sum >= k * threshold

So we only need integer comparison.

This is simpler and avoids floating-point precision issues.

---

# 📊 Approach Comparison

| Approach | Time Complexity | Space Complexity | Best |
|---|---:|---:|---|
| Brute Force | O(n × k), worst O(n²) | O(1) | ❌ |
| Prefix Sum | O(n) | O(n) | Good |
| Fixed Sliding Window | O(n) | O(1) | ✅ |

---

# 🏆 Why Sliding Window Is Optimal

Every element may need to be examined at least once.

Therefore, an:

    O(n)

solution is optimal.

The Sliding Window solution performs:

    O(1)

work when moving from one window to the next.

Therefore:

    Total Time = O(n)

Only the current sum, count, and pointers are stored.

Therefore:

    Extra Space = O(1)

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

1. Every window has exactly `k` elements.
2. This makes the problem a Fixed-Size Sliding Window problem.
3. Average can be converted into a sum comparison.
4. The required sum is:

       k * threshold

5. Build the first window.
6. Track its sum.
7. Add the incoming element when sliding.
8. Remove the outgoing element.
9. Check the updated sum.
10. Increment the count when the condition is satisfied.
11. Every element is processed a constant number of times.
12. Therefore time complexity is O(n).
13. Only constant extra variables are required.
14. Therefore space complexity is O(1).

---

# ⚠️ Common Mistakes

## Mistake 1: Calculating Average Every Time

There is no need to calculate:

    sum / k

for every window.

Compare:

    sum >= k * threshold

instead.

---

## Mistake 2: Forgetting the First Window

The first `k` elements must be processed before sliding begins.

---

## Mistake 3: Forgetting to Remove the Outgoing Element

When the window moves, one element leaves.

Always subtract it.

---

## Mistake 4: Incorrect Outgoing Index

When the new element is at:

    right

the element leaving is:

    right - k

---

## Mistake 5: Using a Variable-Size Window

The window must always contain exactly:

    k

elements.

There is no need to shrink or expand based on the condition.

---

## Mistake 6: Integer Overflow

For the given constraints, an `int` is sufficient.

However, in problems with larger values, using `long` for the
window sum can be safer.

---

# 💼 Interview Questions

### Q1. What pattern does this problem use?

Fixed-Size Sliding Window.

---

### Q2. Why?

Because every subarray must contain exactly `k` elements.

---

### Q3. What is the optimal time complexity?

    O(n)

---

### Q4. What is the optimal space complexity?

    O(1)

---

### Q5. How do you convert the average condition into a sum condition?

Starting with:

    sum / k >= threshold

multiply both sides by `k`:

    sum >= k * threshold

---

### Q6. Why is Sliding Window better than brute force?

It reuses the previous window's sum instead of recalculating
the entire window.

---

### Q7. What happens when the window moves?

One element enters and one element leaves.

---

### Q8. What is the window update formula?

    newSum = oldSum + incoming - outgoing

---

### Q9. Can Prefix Sum solve this problem?

Yes.

But it uses O(n) extra space, while Sliding Window uses O(1).

---

### Q10. What type of Sliding Window is used?

Fixed-Size Sliding Window.

---

# 📚 Key Learning

This problem teaches:

- Fixed-Size Sliding Window
- Running sum
- Prefix Sum alternative
- Mathematical transformation
- Avoiding floating-point calculations
- Array traversal
- Space optimization

---

# 🧩 Pattern Recognition

When a problem asks:

- Count subarrays
- Exactly `k` elements
- Average greater than or equal to a threshold
- Fixed window size

Think:

    FIXED-SIZE SLIDING WINDOW

General pattern:

    Create first window
          ↓
    Calculate window sum
          ↓
    Check condition
          ↓
    Add incoming element
          ↓
    Remove outgoing element
          ↓
    Check condition again
          ↓
    Repeat

---

# 🔗 Related Problems

Fixed-Size Sliding Window:

- LeetCode 643 — Maximum Average Subarray I
- LeetCode 1343 — Number of Sub-arrays of Size K and Average ≥ Threshold
- LeetCode 1456 — Maximum Number of Vowels in a Substring of Given Length

Variable-Size Sliding Window:

- LeetCode 209 — Minimum Size Subarray Sum
- LeetCode 3 — Longest Substring Without Repeating Characters
- LeetCode 1004 — Max Consecutive Ones III
- LeetCode 424 — Longest Repeating Character Replacement
- LeetCode 76 — Minimum Window Substring

---

# 🏁 Final Conclusion

There are three main approaches.

## Brute Force

    Time: O(n × k)
    Worst Case: O(n²)
    Space: O(1)

Simple but inefficient.

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

    requiredSum = k * threshold

Then:

    Build first window
          ↓
    Check its sum
          ↓
    Slide window
          ↓
    Add incoming element
          ↓
    Remove outgoing element
          ↓
    Check window sum
          ↓
    Increment count if valid

Therefore:

> **Fixed-Size Sliding Window is the optimal approach because
> it achieves O(n) time and O(1) extra space.**

Final complexity:

    Time: O(n)
    Space: O(1)