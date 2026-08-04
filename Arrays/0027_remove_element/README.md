# 0027. Remove Element

> **Difficulty:** Easy  
> **Topic(s):** Arrays, Two Pointers  
> **Platform:** LeetCode  
> **Language:** Java

---

# 📖 Problem Statement

Given an integer array `nums` and an integer `val`, remove all occurrences of `val` **in-place**.

The order of the remaining elements may be changed.

Return the number of elements that are **not equal** to `val`.

Do not allocate another array.

**Problem Link:** https://leetcode.com/problems/remove-element/

---

# 📝 Example 1

Input

```text
nums = [3,2,2,3]
val = 3
```

Output

```text
2
```

Modified array

```text
[2,2]
```

---

# 📝 Example 2

Input

```text
nums = [0,1,2,2,3,0,4,2]
val = 2
```

Output

```text
5
```

Modified array

```text
[0,1,3,0,4]
```

---

# 🔒 Constraints

- 0 <= nums.length <= 100
- 0 <= nums[i] <= 50
- 0 <= val <= 100

---

# Approach 1: Brute Force

## Idea

Create another array.

Copy every element that is **not equal** to `val`.

Finally copy the new array back.

---

## Algorithm

1. Create a temporary array.
2. Traverse the original array.
3. Ignore elements equal to `val`.
4. Copy remaining elements.
5. Return the number of copied elements.

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

## Disadvantages

- Uses extra memory.
- Does not satisfy the in-place requirement.

---

# Approach 2: Optimal (Two Pointers)

## Idea

Maintain two pointers:

- `i` scans every element.
- `k` stores the position where the next valid element should be placed.

Whenever the current element is **not equal** to `val`:

- Copy it to index `k`.
- Increment `k`.

After one traversal, the first `k` elements contain all valid values.

---

## Algorithm

1. Initialize `k = 0`.
2. Traverse the array.
3. If `nums[i] != val`:
   - Copy `nums[i]` to `nums[k]`.
   - Increment `k`.
4. Return `k`.

---

# Dry Run

```text
nums = [3,2,2,3]
val = 3

k = 0

i = 0

3 == val

Skip

----------------

i = 1

2 != val

nums[0] = 2

k = 1

----------------

i = 2

2 != val

nums[1] = 2

k = 2

----------------

i = 3

3 == val

Skip

Final Array

[2,2]
```

---

# Optimal Java Solution

```java
class Solution {

    public int removeElement(int[] nums, int val) {

        int k = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
```

---

# Time Complexity

```text
O(n)
```

Only one traversal is required.

---

# Space Complexity

```text
O(1)
```

No extra array is used.

---

# Why is this the Optimal Solution?

The solution modifies the array in-place while scanning it only once.

It satisfies all problem requirements and uses constant extra space.

---

# Complexity Comparison

| Approach | Time | Space | In-place |
|-----------|------|-------|----------|
| Brute Force | O(n) | O(n) | ❌ |
| Two Pointers ✅ | **O(n)** | **O(1)** | ✅ |

---

# Key Learning

- In-place array modification
- Two Pointer technique
- Array traversal
- Space optimization

---

# Interview Questions

### Why use two pointers?

One pointer reads the array, while the other keeps track of where to place the next valid element.

---

### Why is the solution O(1) space?

No additional array or data structure is created.

---

### Does the order of remaining elements matter?

For this solution, the original order is preserved, although the problem states that changing the order is also acceptable.

---

# Conclusion

This problem is a classic example of the **Two Pointer** technique for in-place array modification.

The optimal solution completes the task in **O(n)** time with **O(1)** extra space, making it the preferred approach for coding interviews.
