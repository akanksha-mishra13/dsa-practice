# 0026. Remove Duplicates from Sorted Array

> **Difficulty:** Easy  
> **Topic(s):** Arrays, Two Pointers  
> **Platform:** LeetCode  
> **Language:** Java

---

# 📖 Problem Statement

Given an integer array `nums` sorted in **non-decreasing order**, remove the duplicates **in-place** such that each unique element appears only once.

The relative order of the elements should remain the same.

Return the number of unique elements `k`.

The first `k` elements of `nums` should contain the unique elements.

You **must not** use extra space for another array.

**Problem Link:** https://leetcode.com/problems/remove-duplicates-from-sorted-array/

---

# 📝 Example

## Example 1

**Input**

```text
nums = [1,1,2]
```

**Output**

```text
2
```

Modified array

```text
[1,2,_]
```

---

## Example 2

**Input**

```text
nums = [0,0,1,1,1,2,2,3,3,4]
```

**Output**

```text
5
```

Modified array

```text
[0,1,2,3,4,_,_,_,_,_]
```

---

# 🔒 Constraints

- 1 <= nums.length <= 3 × 10⁴
- -100 <= nums[i] <= 100
- nums is sorted in non-decreasing order

---

# Approach 1: Brute Force (Using Extra Array)

## Idea

Create a new array.

Traverse the original array.

Whenever a new element is found, copy it into the new array.

Finally copy the new array back into the original array.

---

## Algorithm

1. Create another array.
2. Copy the first element.
3. Traverse the array.
4. If current element differs from the previous one, copy it.
5. Copy the temporary array back.

---

## Dry Run

```text
nums = [1,1,2]

temp = [1]

Skip second 1

temp = [1,2]

Answer = 2
```

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
- Violates the in-place requirement of the problem.

---

# Approach 2: Optimal (Two Pointers)

## Idea

Since the array is already sorted, all duplicate elements are adjacent.

Use:

- One pointer (`i`) to track the position of the last unique element.
- Another pointer (`j`) to scan the array.

Whenever a new unique element is found:

- Move `i` one step ahead.
- Copy the unique element to `nums[i]`.

At the end, the first `i + 1` elements contain all unique values.

---

## Algorithm

1. If the array is empty, return 0.
2. Initialize:

```text
i = 0
```

3. Traverse from index 1.

4. Compare:

```text
nums[j] != nums[i]
```

5. If different:

- Increment `i`
- Copy

```text
nums[i] = nums[j]
```

6. Continue.

7. Return

```text
i + 1
```

---

# Dry Run

```text
nums = [0,0,1,1,1,2,2,3,3,4]

i = 0

j = 1

0 == 0

Skip

-------------------

j = 2

1 != 0

i++

i = 1

nums[1] = 1

Array

0 1 1 1 1 2 2 3 3 4

-------------------

j = 3

1 == 1

Skip

-------------------

j = 5

2 != 1

i++

nums[2] = 2

-------------------

Continue...

Final

0 1 2 3 4
```

---

# Optimal Java Solution

```java
class Solution {

    public int removeDuplicates(int[] nums) {

        if (nums.length == 0)
            return 0;

        int i = 0;

        for (int j = 1; j < nums.length; j++) {

            if (nums[j] != nums[i]) {

                i++;

                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}
```

---

# Time Complexity

```text
O(n)
```

Only one traversal of the array.

---

# Space Complexity

```text
O(1)
```

No extra data structure is used.

---

# Why is this the Optimal Solution?

The array is already sorted.

This guarantees that duplicate elements are adjacent.

Instead of creating another array, we overwrite duplicate values while scanning.

This satisfies the **in-place** requirement with **constant extra space**, making it the best possible solution.

---

# Complexity Comparison

| Approach | Time | Space | In-place |
|-----------|------|-------|----------|
| Brute Force | O(n) | O(n) | ❌ |
| Two Pointers ✅ | **O(n)** | **O(1)** | ✅ |

---

# Key Observations

- The array is sorted.
- Duplicate values are always consecutive.
- Two pointers allow us to overwrite duplicates without using extra memory.

---

# Key Learning

After solving this problem, you should understand:

- Two Pointer Technique
- In-place array modification
- Why sorted arrays simplify duplicate handling
- Difference between O(1) and O(n) auxiliary space

---

# Interview Questions

## Why does the Two Pointer approach work?

Because the array is sorted.

Duplicate values appear next to each other.

---

## Why can't we use a HashSet?

A HashSet requires extra memory.

The problem specifically asks us to modify the array **in-place**.

---

## Why return `i + 1`?

`i` points to the last unique element.

The number of unique elements is therefore:

```text
i + 1
```

---

## Can this problem be solved in one pass?

Yes.

The Two Pointer solution scans the array only once.

---

# Conclusion

This problem is one of the most important applications of the **Two Pointer** technique.

Although a temporary array also works, it does not satisfy the in-place requirement.

The **Two Pointer approach** is the optimal solution because it:

- Uses constant extra space.
- Requires only one traversal.
- Preserves the order of elements.
- Meets all problem constraints.

This pattern is frequently used in coding interviews and appears in many array-based problems.