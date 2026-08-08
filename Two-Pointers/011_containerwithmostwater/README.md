# 0011. Container With Most Water

> **Difficulty:** Medium  
> **Topics:** Arrays, Two Pointers, Greedy  
> **Pattern:** Two Pointers  
> **Platform:** LeetCode

---

## 📖 Problem Statement

You are given an integer array `height`.

Each element represents the height of a vertical line drawn at that index.

Choose two lines such that together with the x-axis they form a container that can hold the maximum possible amount of water.

Return the maximum amount of water that the container can store.

The container cannot be tilted.

### Problem Link

https://leetcode.com/problems/container-with-most-water/

---

## 📝 Example 1

### Input

```text
height = [1,8,6,2,5,4,8,3,7]
```

### Output

```text
49
```

### Explanation

Choose the lines at indices `1` and `8`.

Their heights are:

```text
8 and 7
```

Width:

```text
8 - 1 = 7
```

The container height is limited by the shorter line:

```text
min(8,7) = 7
```

Therefore:

```text
Area = width × height
     = 7 × 7
     = 49
```

---

## 📝 Example 2

### Input

```text
height = [1,1]
```

### Output

```text
1
```

---

## 🔒 Constraints

- `2 <= height.length <= 10^5`
- `0 <= height[i] <= 10^4`

---

# 🧠 Core Formula

For two lines at positions `left` and `right`:

```text
Width = right - left
```

The amount of water is limited by the shorter line:

```text
Height = min(height[left], height[right])
```

Therefore:

```text
Area = (right - left) × min(height[left], height[right])
```

The goal is to maximize this area.

---

# 🎯 Core Observation

The area depends on two things:

1. Width
2. Height

The height is always determined by the shorter of the two lines.

Initially, if we place one pointer at each end:

```text
left  → beginning
right → end
```

we get the maximum possible width.

As we move either pointer toward the center, the width decreases.

Therefore, we need to decide which pointer can be safely moved without losing the possibility of finding a larger area.

The answer is:

> Always move the pointer pointing to the shorter line.

---

# 🚀 Approach 1: Brute Force

## 💡 Intuition

The simplest solution is to check every possible pair of lines.

For every pair of indices:

1. Calculate the width.
2. Find the shorter height.
3. Calculate the area.
4. Update the maximum area.

Since every possible pair is checked, this approach guarantees the correct answer.

---

## 🔄 Algorithm

1. Start with the first index.
2. Pair it with every index after it.
3. Calculate the area for each pair.
4. Store the maximum area.
5. Move to the next starting index.
6. Repeat until every possible pair has been checked.
7. Return the maximum area.

---

## 🧠 Brute Force Example

For:

```text
height = [1,8,6,2]
```

The algorithm checks:

```text
(0,1)
(0,2)
(0,3)
(1,2)
(1,3)
(2,3)
```

Every possible pair is considered.

---

## ⏱️ Time Complexity

```text
O(n²)
```

There can be approximately:

```text
n × (n - 1) / 2
```

possible pairs.

Therefore, the number of operations grows quadratically.

---

## 💾 Space Complexity

```text
O(1)
```

Only a constant number of variables are required.

---

## ✅ Advantages

- Very easy to understand.
- Checks every possible container.
- Simple implementation.
- Uses constant extra space.

---

## ❌ Disadvantages

- Very slow for large input sizes.
- Performs unnecessary comparisons.
- Does not optimize the search space.
- Can result in Time Limit Exceeded for large arrays.

---

# 🚀 Approach 2: Two Pointers ⭐ Optimal

## 💡 Intuition

Instead of checking every pair, use two pointers:

```text
left  → first element
right → last element
```

This gives us the maximum possible width initially.

At every step:

1. Calculate the current area.
2. Update the maximum.
3. Move the pointer corresponding to the shorter line.

This eliminates many impossible pairs without checking them individually.

---

# 🔍 Why Do We Move the Shorter Pointer?

This is the most important idea in the problem.

Suppose:

```text
height[left] = 4
height[right] = 9
```

The container height is:

```text
min(4,9) = 4
```

Therefore:

```text
Area = width × 4
```

Now consider moving the `right` pointer.

The width becomes smaller.

But the left height is still `4`.

Even if the new right line has height `10`, the container is still limited by:

```text
min(4,10) = 4
```

So we have:

- Smaller width
- Same limiting height

Therefore, moving the taller line cannot produce a better area.

---

## ✅ Why Moving the Shorter Pointer Can Help

Suppose:

```text
height[left] = 4
height[right] = 9
```

The limiting height is `4`.

If we move `left`, we may find a taller line:

```text
new height[left] = 7
```

Now the limiting height could become:

```text
min(7,9) = 7
```

Although the width decreased, the height increased.

Therefore, a larger area is still possible.

This is why we move the shorter pointer.

---

# 🔄 Two Pointer Algorithm

1. Set `left = 0`.
2. Set `right = n - 1`.
3. Calculate the width.
4. Find the minimum of the two heights.
5. Calculate the current area.
6. Update the maximum area.
7. If `height[left] < height[right]`, move `left`.
8. Otherwise, move `right`.
9. Continue while `left < right`.
10. Return the maximum area.

---

# 🧠 Dry Run

Consider:

```text
height = [1,8,6,2,5,4,8,3,7]
```

Initially:

```text
left = 0
right = 8
```

Values:

```text
height[left] = 1
height[right] = 7
```

Width:

```text
8 - 0 = 8
```

Height:

```text
min(1,7) = 1
```

Area:

```text
8 × 1 = 8
```

Maximum:

```text
8
```

The left side is shorter, so:

```text
left++
```

---

## Step 2

Now:

```text
left = 1
right = 8
```

Values:

```text
8 and 7
```

Width:

```text
8 - 1 = 7
```

Height:

```text
min(8,7) = 7
```

Area:

```text
7 × 7 = 49
```

Maximum becomes:

```text
49
```

The right side is shorter:

```text
7 < 8
```

Therefore:

```text
right--
```

---

## Step 3

Now:

```text
left = 1
right = 7
```

Values:

```text
8 and 3
```

Width:

```text
7 - 1 = 6
```

Height:

```text
min(8,3) = 3
```

Area:

```text
6 × 3 = 18
```

Maximum remains:

```text
49
```

The right side is shorter, so:

```text
right--
```

The same process continues until:

```text
left >= right
```

The maximum area found is:

```text
49
```

---

# 🔍 Why Is It Safe to Eliminate a Pointer?

Suppose:

```text
height[left] <= height[right]
```

The current container is limited by:

```text
height[left]
```

Now consider every possible container that uses this same `left` position but a smaller `right`.

For all of them:

- Width will be smaller.
- The left height will remain the same limiting factor.
- Therefore, none can produce a larger area than the current pair.

So the current `left` position can safely be discarded.

We move:

```text
left++
```

The same reasoning applies when:

```text
height[right] < height[left]
```

In that case, we safely move:

```text
right--
```

This elimination of impossible candidates is what reduces the complexity from `O(n²)` to `O(n)`.

---

# 📊 Approach Comparison

| Approach | Time Complexity | Space Complexity | Optimal |
|----------|-----------------|------------------|---------|
| Brute Force | O(n²) | O(1) | ❌ |
| Two Pointers | **O(n)** | **O(1)** | ✅ |

---

# 🏆 Why Two Pointers Is the Optimal Approach

The brute-force solution checks every possible pair.

This requires:

```text
O(n²)
```

time.

The Two Pointer solution starts with the maximum possible width and eliminates impossible candidates by moving the shorter boundary.

Each pointer only moves toward the center.

Therefore, each pointer moves at most `n` times.

Overall:

```text
O(n)
```

time.

The algorithm only uses a few variables:

```text
left
right
width
currentHeight
currentArea
maxArea
```

Therefore:

```text
O(1)
```

extra space is required.

---

# ⏱️ Final Complexity

## Approach 1 — Brute Force

```text
Time:  O(n²)
Space: O(1)
```

## Approach 2 — Two Pointers

```text
Time:  O(n)
Space: O(1)
```

---

# 🎯 Key Observations

1. The area depends on width and minimum height.
2. The shorter line determines the water level.
3. Initially, the two pointers provide the maximum possible width.
4. Moving either pointer decreases the width.
5. Moving the taller pointer cannot increase the limiting height.
6. Moving the shorter pointer gives a chance to find a taller boundary.
7. Therefore, always move the shorter pointer.
8. Every pointer moves only toward the center.
9. Each element is processed at most once.
10. The optimal solution uses constant extra space.

---

# ⚠️ Common Mistakes

## Mistake 1: Moving the Taller Pointer

If:

```text
height[left] < height[right]
```

move:

```text
left++
```

Do not move `right`.

---

## Mistake 2: Using the Maximum Height

The water level is determined by the shorter line.

Correct:

```text
min(height[left], height[right])
```

Incorrect:

```text
max(height[left], height[right])
```

---

## Mistake 3: Incorrect Width

The width is:

```text
right - left
```

Not:

```text
right - left + 1
```

---

## Mistake 4: Forgetting to Update the Maximum

Every calculated area must be compared with the current maximum.

---

## Mistake 5: Stopping Before the Pointers Meet

Continue until:

```text
left >= right
```

---

# 💼 Interview Questions

### Q1. What determines the amount of water?

The area is determined by:

```text
width × minimum height
```

---

### Q2. Why does the shorter line determine the height?

Water cannot rise above the shorter boundary without overflowing.

---

### Q3. Why do we move the shorter pointer?

Because it is the limiting factor. Moving it may allow us to find a taller boundary.

---

### Q4. Why don't we move the taller pointer?

Moving the taller pointer reduces the width while keeping the shorter line as the limiting height, so the area cannot improve because of that move.

---

### Q5. What is the time complexity of the brute-force solution?

```text
O(n²)
```

---

### Q6. What is the time complexity of the Two Pointer solution?

```text
O(n)
```

---

### Q7. What is the space complexity?

```text
O(1)
```

---

### Q8. Is this problem based on a Greedy idea?

Yes.

At every step, we make a locally justified decision to discard the shorter boundary.

---

### Q9. Why is sorting not useful here?

Sorting would destroy the original positions of the lines, which are necessary to calculate the width.

---

### Q10. What is the most important observation?

The shorter boundary is the bottleneck, so it is the only boundary that should be moved.

---

# 📚 Key Learning

This problem teaches:

- Two Pointer technique
- Greedy thinking
- Array traversal
- Maximum-area calculation
- Pointer movement
- Eliminating impossible candidates
- Time complexity optimization
- Constant-space algorithms

---

# 🧩 Pattern Recognition

When you see a problem involving:

- Two ends of an array
- A pair of elements
- Maximum or minimum values
- A need to reduce an `O(n²)` pair search
- A rule that tells you which side can be discarded

Think about:

```text
TWO POINTERS
```

Then ask:

> Which pointer can I safely move without eliminating a possible optimal answer?

For this problem:

```text
Move the shorter boundary.
```

---

# 🔗 Related Problems

The Two Pointer pattern from this problem is useful for:

- LeetCode 167 — Two Sum II
- LeetCode 15 — 3Sum
- LeetCode 18 — 4Sum
- LeetCode 42 — Trapping Rain Water
- LeetCode 977 — Squares of a Sorted Array
- LeetCode 881 — Boats to Save People

---

# 🏁 Final Conclusion

There are two major approaches for this problem.

### Brute Force

```text
Time:  O(n²)
Space: O(1)
```

It checks every possible pair and is easy to understand, but it is inefficient for large inputs.

### Two Pointers

```text
Time:  O(n)
Space: O(1)
```

It starts with the maximum possible width and intelligently eliminates impossible candidates.

The shorter boundary is always moved because it is the limiting factor.

Therefore:

> **Two Pointers is the optimal approach for Container With Most Water.**

The final optimal complexity is:

```text
Time:  O(n)
Space: O(1)
```