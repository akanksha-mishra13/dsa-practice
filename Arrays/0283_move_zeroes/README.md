# 0283. Move Zeroes

> **Difficulty:** Easy  
> **Topic(s):** Arrays  
> **Pattern:** Two Pointers  
> **Platform:** LeetCode

---

# 📖 Problem Statement

Given an integer array `nums`, move all `0`s to the end of the array while maintaining the relative order of the non-zero elements.

The operation must be performed **in-place**, without making a copy of the array.

**Problem Link:** https://leetcode.com/problems/move-zeroes/

---

# 📝 Examples

### Example 1

**Input**

```text
nums = [0,1,0,3,12]
```

**Output**

```text
[1,3,12,0,0]
```

---

### Example 2

**Input**

```text
nums = [0]
```

**Output**

```text
[0]
```

---

# 🔒 Constraints

- 1 <= nums.length <= 10⁴
- -2³¹ <= nums[i] <= 2³¹ - 1

---

# 🎯 Intuition

The goal is to move all non-zero elements to the front while preserving their relative order.

Instead of shifting every zero individually, we maintain the position where the next non-zero element should be placed.

Whenever we encounter a non-zero value, we swap it into its correct position.

This ensures all non-zero elements remain in order and all zeros naturally move to the end.

---

# 🚀 Approach 1: Brute Force

## Idea

Create a temporary array.

First store all non-zero elements, then append all zeros.

Finally copy everything back into the original array.

---

## Algorithm

1. Create a temporary array.
2. Traverse the original array.
3. Copy all non-zero elements.
4. Append all zeros.
5. Copy the temporary array back.

---

## Time Complexity

```text
O(n)
```

---

## Space Complexity

```text
O(n)
```

---

## Advantages

- Easy to understand.
- Simple implementation.

---

## Disadvantages

- Uses extra memory.
- Does not satisfy the in-place requirement.

---

# 🚀 Approach 2: Two Pointers (Optimal)

## Idea

Maintain two pointers:

- `left` points to the position where the next non-zero element should be placed.
- `right` traverses the array.

Whenever a non-zero element is found, swap it with the element at `left` and move `left` forward.

---

## Algorithm

1. Initialize `left = 0`.
2. Traverse the array using `right`.
3. If the current element is non-zero:
   - Swap `nums[left]` and `nums[right]`.
   - Increment `left`.
4. Continue until the end of the array.

---

# 🧠 Dry Run

Input

```text
nums = [0,1,0,3,12]
```

Start

```text
left = 0
```

- right = 0 → value = 0 → Skip
- right = 1 → value = 1 → Swap with index 0

```text
[1,0,0,3,12]
```

left = 1

---

right = 2 → value = 0 → Skip

---

right = 3 → value = 3

Swap with index 1

```text
[1,3,0,0,12]
```

left = 2

---

right = 4 → value = 12

Swap with index 2

```text
[1,3,12,0,0]
```

Final Answer

```text
[1,3,12,0,0]
```

---

# 📊 Complexity Comparison

| Approach | Time | Space |
|-----------|------|-------|
| Brute Force | O(n) | O(n) |
| Two Pointers ✅ | **O(n)** | **O(1)** |

---

# ✅ Why is this the Optimal Solution?

The Two Pointers approach processes the array only once and performs all operations in-place.

It preserves the relative order of non-zero elements while using constant extra space.

---

# 🎯 Key Observations

- Non-zero elements should remain in the same relative order.
- Swapping avoids repeated shifting operations.
- Only one traversal is required.

---

# 📚 Key Learning

After solving this problem, you should understand:

- Two Pointer technique
- In-place array modification
- Maintaining element order
- Space optimization

---

# 💼 Interview Questions

### Why are two pointers used?

One pointer tracks the next valid position, while the other scans the array.

---

### Why is this solution O(1) space?

No additional array or data structure is created.

---

### Is the relative order preserved?

Yes. Non-zero elements are moved in the order they are encountered.

---

# ✅ Conclusion

The Two Pointers approach efficiently moves all zeros to the end while preserving the order of non-zero elements. It completes the task in **O(n)** time using **O(1)** extra space, making it the optimal solution for this problem.