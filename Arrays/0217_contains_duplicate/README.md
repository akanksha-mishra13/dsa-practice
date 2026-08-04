# 0217. Contains Duplicate

> **Difficulty:** Easy  
> **Topic(s):** Arrays, Hashing  
> **Pattern:** HashSet  
> **Platform:** LeetCode

---

# 📖 Problem Statement

Given an integer array `nums`, return **true** if any value appears at least twice in the array, and return **false** if every element is distinct.

**Problem Link:** https://leetcode.com/problems/contains-duplicate/

---

# 📝 Examples

### Example 1

**Input**

```text
nums = [1,2,3,1]
```

**Output**

```text
true
```

---

### Example 2

**Input**

```text
nums = [1,2,3,4]
```

**Output**

```text
false
```

---

### Example 3

**Input**

```text
nums = [1,1,1,3,3,4,3,2,4,2]
```

**Output**

```text
true
```

---

# 🔒 Constraints

- 1 <= nums.length <= 10⁵
- -10⁹ <= nums[i] <= 10⁹

---

# 🎯 Intuition

The problem asks whether any element appears more than once.

Instead of comparing every pair of elements, we can store the elements we have already seen.

If we encounter an element that already exists in our collection, we immediately know a duplicate exists.

A HashSet is ideal because it provides average **O(1)** lookup and insertion.

---

# 🚀 Approach 1: Brute Force

## Idea

Compare every element with every other element.

If two elements are equal, return `true`.

Otherwise, continue checking.

---

## Algorithm

1. Traverse the array.
2. For every element, compare it with all remaining elements.
3. If a duplicate is found, return `true`.
4. If no duplicates exist, return `false`.

---

## Time Complexity

```text
O(n²)
```

---

## Space Complexity

```text
O(1)
```

---

## Advantages

- Very simple implementation.
- Does not require extra memory.

---

## Disadvantages

- Extremely slow for large arrays.

---

# 🚀 Approach 2: Sorting

## Idea

If the array is sorted, duplicate elements become adjacent.

After sorting, compare every element with its next element.

---

## Algorithm

1. Sort the array.
2. Traverse from left to right.
3. If two adjacent elements are equal, return `true`.
4. Otherwise, return `false`.

---

## Time Complexity

```text
O(n log n)
```

---

## Space Complexity

```text
O(1)` or `O(log n)` (depends on sorting implementation)
```

---

## Advantages

- Faster than brute force.
- Does not require a HashSet.

---

## Disadvantages

- Sorting changes the original order.
- Slower than the HashSet approach.

---

# 🚀 Approach 3: HashSet (Optimal)

## Idea

Maintain a HashSet containing all previously visited elements.

For each number:

- Check whether it already exists in the HashSet.
- If yes, a duplicate has been found.
- Otherwise, insert it into the HashSet.

Since HashSet operations are constant time on average, the entire solution requires only one traversal.

---

## Algorithm

1. Create an empty HashSet.
2. Traverse the array.
3. If the current element already exists in the HashSet:
   - Return `true`.
4. Otherwise:
   - Insert the current element into the HashSet.
5. If the traversal finishes, return `false`.

---

# 🧠 Dry Run

Input

```text
nums = [1,2,3,1]
```

HashSet = {}

Read 1

Set = {1}

Read 2

Set = {1,2}

Read 3

Set = {1,2,3}

Read 1

1 already exists

Return

```text
true
```

---

# 📊 Complexity Comparison

| Approach | Time | Space |
|-----------|------|-------|
| Brute Force | O(n²) | O(1) |
| Sorting | O(n log n) | O(1)* |
| HashSet ✅ | **O(n)** | **O(n)** |

\*Space complexity depends on the sorting algorithm used.

---

# ✅ Why is this the Optimal Solution?

The HashSet approach performs only one traversal of the array while providing constant-time lookups.

Although it requires extra memory, it achieves the best possible time complexity and is the preferred solution in coding interviews.

---

# 🎯 Key Observations

- We only need to know whether an element has appeared before.
- HashSet automatically stores only unique elements.
- Duplicate detection becomes an average O(1) operation.

---

# 📚 Key Learning

After solving this problem, you should understand:

- HashSet fundamentals
- Fast duplicate detection
- Time vs. space trade-offs
- Choosing the right data structure for lookup problems

---

# 💼 Interview Questions

### Why use a HashSet instead of an ArrayList?

HashSet provides average O(1) lookup, whereas searching an ArrayList takes O(n).

---

### Why is sorting not considered the optimal solution?

Sorting increases the time complexity to O(n log n) and modifies the original array.

---

### Can this problem be solved without extra space?

Yes, by sorting the array first, but the time complexity increases.

---

# ✅ Conclusion

The HashSet approach is the optimal solution because it detects duplicates in a single traversal with average O(1) lookups. It balances simplicity, efficiency, and readability, making it the preferred solution for interviews.