# 0042. Trapping Rain Water

> Difficulty: Hard  
> Topics: Array, Two Pointers, Dynamic Programming, Stack  
> Pattern: Two Pointers  
> Platform: LeetCode

---

# 📖 Problem Statement

Given an array `height` where each element represents the height
of a vertical bar, calculate how much water can be trapped
after raining.

Each bar has width `1`.

The goal is to calculate the total amount of trapped water.

---

# 🔗 Problem Link

https://leetcode.com/problems/trapping-rain-water/

---

# 📝 Example 1

Input:

    height = [0,1,0,2,1,0,1,3,2,1,2,1]

Output:

    6

The bars create several valleys where water can be stored.

The total trapped water is:

    6

---

# 📝 Example 2

Input:

    height = [4,2,0,3,2,5]

Output:

    9

---

# 🔒 Constraints

- 1 <= height.length <= 2 * 10^4
- 0 <= height[i] <= 10^5

---

# 🎯 Core Idea

For every position, the amount of water it can hold depends on:

    tallest bar on the left

and:

    tallest bar on the right

The water level is limited by the shorter of these two boundaries.

Therefore:

    Water at index i
    =
    min(leftMax, rightMax) - height[i]

If the result is negative, no water can be stored there.

---

# 🚀 Approach 1: Brute Force

## 💡 Intuition

For every position, find:

1. The tallest bar on its left.
2. The tallest bar on its right.
3. The smaller of those two heights.
4. Calculate the water above the current bar.

For every index:

    water =
    min(maxLeft, maxRight) - height[i]

If this value is positive, add it to the total.

---

# 🔄 Algorithm

For each index:

1. Traverse all elements to the left.
2. Find the maximum left height.
3. Traverse all elements to the right.
4. Find the maximum right height.
5. Calculate the trapped water.
6. Add it to the answer.

---

# ⏱️ Time Complexity

For every element, we may scan the entire array.

Therefore:

    O(n²)

---

# 💾 Space Complexity

Only a few variables are required:

    O(1)

---

# ❌ Why Brute Force Is Not Optimal

The same elements are repeatedly scanned.

For a large array, this results in:

    O(n²)

operations.

We can improve this by avoiding repeated searches.

---

# 🚀 Approach 2: Prefix/Suffix Maximum Arrays

## 💡 Intuition

Instead of finding the maximum left and right height repeatedly,
precompute them.

Create:

    leftMax[i]

which stores the maximum height from the beginning up to index `i`.

Create:

    rightMax[i]

which stores the maximum height from index `i` to the end.

Then:

    water[i] =
    min(leftMax[i], rightMax[i]) - height[i]

---

# 🔄 Algorithm

1. Create a `leftMax` array.
2. Traverse from left to right.
3. Store the maximum height seen so far.
4. Create a `rightMax` array.
5. Traverse from right to left.
6. Store the maximum height seen so far.
7. Traverse the array again.
8. Calculate water at every index.
9. Add it to the total.

---

# ⏱️ Time Complexity

Three linear traversals are performed.

Therefore:

    O(n)

---

# 💾 Space Complexity

Two additional arrays are used.

Therefore:

    O(n)

---

# ✅ Advantages

- Easy to understand.
- Linear time.
- Directly follows the water formula.
- Easier to implement than the optimal Two Pointer solution.

---

# ❌ Disadvantages

The algorithm uses additional arrays.

The problem can be solved with:

    O(1)

extra space.

Therefore, this is not the most space-efficient approach.

---

# 🚀 Approach 3: Two Pointers ⭐ Optimal

## 💡 Intuition

Instead of storing the maximum boundary for every position,
we can maintain two pointers:

    left
    right

and two maximum heights:

    leftMax
    rightMax

Initially:

    left = 0
    right = n - 1

The key observation is:

> We can process the side with the smaller boundary height.

If:

    height[left] <= height[right]

then the left side determines the current water level.

If:

    height[right] < height[left]

then the right side determines the current water level.

---

# 📌 Variables

## left

Points to the current position from the left.

---

## right

Points to the current position from the right.

---

## leftMax

Stores the tallest bar encountered from the left.

---

## rightMax

Stores the tallest bar encountered from the right.

---

## water

Stores the total amount of trapped water.

---

# 🔑 Main Observation

Suppose:

    height[left] <= height[right]

Then there is a bar on the right that is at least as tall as
the current left bar.

Therefore, the amount of water at the left position can be
determined using:

    leftMax

We don't need the exact maximum right boundary yet.

Similarly, when:

    height[right] < height[left]

the right side can be processed using:

    rightMax

This allows us to solve the problem without additional arrays.

---

# 🔄 Algorithm

1. Initialize:

       left = 0
       right = n - 1

2. Initialize:

       leftMax = 0
       rightMax = 0

3. Initialize:

       water = 0

4. While:

       left < right

5. Compare:

       height[left]
       height[right]

6. If the left height is smaller or equal:
   - Update `leftMax` if necessary.
   - Otherwise, add:

         leftMax - height[left]

   - Move:

         left++

7. Otherwise:
   - Update `rightMax` if necessary.
   - Otherwise, add:

         rightMax - height[right]

   - Move:

         right--

8. Return `water`.

---

# 🧠 Dry Run

Consider:

    height = [4,2,0,3,2,5]

Initially:

    left = 0
    right = 5

    leftMax = 0
    rightMax = 0
    water = 0

---

# Step 1

Values:

    height[left] = 4
    height[right] = 5

Since:

    4 < 5

process the left side.

Current:

    4 >= leftMax

Therefore:

    leftMax = 4

Move:

    left++

---

# Step 2

Now:

    left = 1
    right = 5

Values:

    2 and 5

Again:

    2 < 5

Process left.

Current:

    height[left] = 2

We already have:

    leftMax = 4

Therefore:

    water += 4 - 2

So:

    water = 2

Move:

    left++

---

# Step 3

Now:

    left = 2

Value:

    height[left] = 0

Since:

    0 < 5

Process left.

Water:

    4 - 0 = 4

Total:

    water = 6

Move:

    left++

---

# Step 4

Now:

    left = 3

Value:

    height[left] = 3

Still:

    3 < 5

Water:

    4 - 3 = 1

Total:

    water = 7

Move:

    left++

---

# Step 5

Now:

    left = 4

Value:

    height[left] = 2

Water:

    4 - 2 = 2

Total:

    water = 9

Move:

    left++

Eventually the pointers meet.

Final answer:

    9

---

# 🔍 Why Does the Two Pointer Approach Work?

The important idea is that water is controlled by the smaller
boundary.

Suppose:

    height[left] <= height[right]

The right boundary is already at least as high as the current
left boundary.

Therefore, if we know the highest wall encountered on the left,
we can determine how much water can be stored at `left`.

The right side cannot become the limiting boundary because the
current right boundary is already high enough.

So we safely process the left side.

Similarly:

    height[right] < height[left]

means the right side can be safely processed.

This allows us to eliminate one side at every step.

---

# 🧠 Understanding leftMax

Suppose:

    leftMax = 5
    height[left] = 2

Then the current position can hold:

    5 - 2 = 3

units of water.

If:

    height[left] >= leftMax

then the current bar becomes the new maximum boundary.

So:

    leftMax = height[left]

and no water is added at that position.

---

# 🧠 Understanding rightMax

The same idea works from the right.

Suppose:

    rightMax = 6
    height[right] = 2

Then:

    water += 6 - 2

If:

    height[right] >= rightMax

update:

    rightMax = height[right]

---

# 📊 Approach Comparison

| Approach | Time | Space | Best |
|---|---:|---:|---|
| Brute Force | O(n²) | O(1) | ❌ |
| Prefix/Suffix Arrays | O(n) | O(n) | Good |
| Two Pointers | O(n) | O(1) | ✅ |

---

# 🏆 Why Two Pointers Is Optimal

The Two Pointer solution processes each position at most once.

Therefore:

    Time = O(n)

Only four important variables are maintained:

    left
    right
    leftMax
    rightMax

Therefore:

    Space = O(1)

This gives:

    O(n) time
    O(1) space

which is optimal for this problem.

---

# ⏱️ Final Complexity

## Brute Force

    Time: O(n²)
    Space: O(1)

## Prefix/Suffix Arrays

    Time: O(n)
    Space: O(n)

## Two Pointers

    Time: O(n)
    Space: O(1)

---

# 🎯 Key Observations

1. Water needs a boundary on both sides.
2. The shorter boundary determines the water level.
3. `leftMax` stores the tallest left boundary seen so far.
4. `rightMax` stores the tallest right boundary seen so far.
5. If left height is smaller, process the left side.
6. If right height is smaller, process the right side.
7. A new maximum cannot trap water at that position.
8. A smaller bar can trap water up to the current maximum boundary.
9. Each pointer moves only toward the center.
10. Every element is processed at most once.
11. No extra array is required.
12. The optimal solution runs in linear time.

---

# ⚠️ Common Mistakes

## Mistake 1: Using the Current Height Instead of Maximum

Water depends on:

    leftMax
    rightMax

not simply:

    height[left]
    height[right]

---

## Mistake 2: Using max Instead of min

The theoretical formula is:

    min(leftMax, rightMax) - height[i]

because the shorter boundary limits the water.

---

## Mistake 3: Adding Negative Water

If the current bar is taller than the maximum boundary,
it becomes a new maximum.

Do not add negative water.

---

## Mistake 4: Forgetting to Update leftMax

When:

    height[left] >= leftMax

update:

    leftMax = height[left]

---

## Mistake 5: Forgetting to Update rightMax

Similarly:

    height[right] >= rightMax

requires:

    rightMax = height[right]

---

## Mistake 6: Moving the Wrong Pointer

Remember:

    height[left] <= height[right]
        → process left

    height[right] < height[left]
        → process right

---

# 💼 Interview Questions

### Q1. What is the optimal approach?

Two Pointers.

---

### Q2. What is the time complexity?

    O(n)

---

### Q3. What is the space complexity?

    O(1)

---

### Q4. What determines the amount of trapped water?

The smaller of the maximum boundaries on the left and right.

---

### Q5. Why do we maintain leftMax?

It represents the highest boundary encountered from the left.

---

### Q6. Why do we maintain rightMax?

It represents the highest boundary encountered from the right.

---

### Q7. Why can we process the left side when height[left] <= height[right]?

Because the current right boundary is at least as high as the
current left boundary, so the left side can be determined using
the left maximum.

---

### Q8. Why do we move only one pointer at a time?

Each processed position can be resolved using the smaller side's
known boundary.

---

### Q9. Can this problem be solved using Dynamic Programming?

Yes.

Prefix and suffix maximum arrays are effectively a Dynamic
Programming-style solution.

---

### Q10. Can this problem be solved using a Stack?

Yes.

A monotonic stack is another common O(n) solution.

However, the Two Pointer solution achieves O(1) auxiliary space.

---

# 📚 Key Learning

This problem teaches:

- Two Pointer technique
- Maximum boundary tracking
- Greedy reasoning
- Array traversal
- Space optimization
- Prefix/suffix concepts
- Dynamic Programming alternative
- Monotonic Stack alternative

---

# 🧩 Pattern Recognition

When a problem involves:

- Heights
- Boundaries
- Water between elements
- Left and right maximums

Think about:

    Two Pointers

Maintain:

    leftMax
    rightMax

Then process the side with the smaller current height.

---

# 🔗 Related Problems

Related Two Pointer problems:

- LeetCode 11 — Container With Most Water
- LeetCode 167 — Two Sum II
- LeetCode 15 — 3Sum
- LeetCode 18 — 4Sum
- LeetCode 881 — Boats to Save People

Other approaches worth learning:

- Monotonic Stack
- Prefix Maximum
- Suffix Maximum
- Dynamic Programming

---

# 🏁 Final Conclusion

There are three major approaches.

## Brute Force

    Time: O(n²)
    Space: O(1)

Easy to understand but inefficient.

---

## Prefix/Suffix Maximum Arrays

    Time: O(n)
    Space: O(n)

Efficient in time but requires additional arrays.

---

## Two Pointers

    Time: O(n)
    Space: O(1)

This is the preferred optimal approach.

The core idea is:

    left = beginning
    right = end

    leftMax = highest left boundary
    rightMax = highest right boundary

Then:

    smaller current side → process that side

Therefore:

> **Two Pointers is the optimal approach because it achieves O(n) time and O(1) auxiliary space.**

Final complexity:

    Time: O(n)
    Space: O(1)