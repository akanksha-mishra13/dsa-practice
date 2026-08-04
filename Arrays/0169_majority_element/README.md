# 0169. Majority Element

> **Difficulty:** Easy  
> **Topic(s):** Arrays  
> **Pattern:** Boyer-Moore Voting Algorithm  
> **Platform:** LeetCode

---

# 📖 Problem Statement

Given an integer array `nums` of size `n`, return the **majority element**.

The majority element is the element that appears **more than ⌊n / 2⌋ times**.

You may assume that the majority element always exists in the array.

**Problem Link:** https://leetcode.com/problems/majority-element/

---

# 📝 Examples

### Example 1

**Input**

```text
nums = [3,2,3]
```

**Output**

```text
3
```

---

### Example 2

**Input**

```text
nums = [2,2,1,1,1,2,2]
```

**Output**

```text
2
```

---

# 🔒 Constraints

- 1 <= nums.length <= 5 × 10⁴
- -10⁹ <= nums[i] <= 10⁹

---

# 🎯 Intuition

The majority element appears more than half of the total number of elements.

This means that if we repeatedly cancel one occurrence of the majority element with one occurrence of a different element, the majority element will still remain.

The Boyer-Moore Voting Algorithm uses this observation to identify the majority element in a single traversal using constant extra space.

---

# 🚀 Approach 1: Brute Force

## Idea

Count the frequency of every element by comparing it with all other elements.

The element with frequency greater than `n / 2` is the answer.

## Algorithm

1. Traverse every element.
2. Count its occurrences using another loop.
3. If the count is greater than `n / 2`, return that element.

## Time Complexity

```text
O(n²)
```

## Space Complexity

```text
O(1)
```

## Advantages

- Easy to understand.
- No additional data structure is required.

## Disadvantages

- Very slow for large arrays.

---

# 🚀 Approach 2: HashMap

## Idea

Store the frequency of each element using a HashMap.

The first element whose frequency exceeds `n / 2` is the majority element.

## Algorithm

1. Create a HashMap.
2. Traverse the array.
3. Increase the frequency of the current element.
4. Check if its frequency becomes greater than `n / 2`.
5. Return that element.

## Time Complexity

```text
O(n)
```

## Space Complexity

```text
O(n)
```

## Advantages

- Fast lookup.
- Easy implementation.

## Disadvantages

- Requires additional memory.

---

# 🚀 Approach 3: Boyer-Moore Voting Algorithm (Optimal)

## Idea

Maintain:

- A candidate element.
- A counter.

Whenever the counter becomes zero, select the current element as the new candidate.

If the current element matches the candidate, increase the counter.

Otherwise, decrease the counter.

Since the majority element appears more than half the time, it will remain as the final candidate.

---

## Algorithm

1. Initialize:
   - `candidate = 0`
   - `count = 0`
2. Traverse the array.
3. If `count == 0`, set the current element as the candidate.
4. If the current element equals the candidate:
   - Increment `count`.
5. Otherwise:
   - Decrement `count`.
6. Return the candidate.

---

# 🧠 Dry Run

Input:

```text
nums = [2,2,1,1,1,2,2]
```

- Start: candidate = -, count = 0
- Read 2 → candidate = 2, count = 1
- Read 2 → count = 2
- Read 1 → count = 1
- Read 1 → count = 0
- Read 1 → candidate = 1, count = 1
- Read 2 → count = 0
- Read 2 → candidate = 2, count = 1

Final Answer:

```text
2
```

---

# 📊 Complexity Comparison

| Approach | Time | Space |
|-----------|------|-------|
| Brute Force | O(n²) | O(1) |
| HashMap | O(n) | O(n) |
| Boyer-Moore Voting Algorithm ✅ | **O(n)** | **O(1)** |

---

# ✅ Why is this the Optimal Solution?

The Boyer-Moore Voting Algorithm identifies the majority element in a single traversal without using any additional data structures.

It satisfies the problem constraints while achieving the best possible time and space complexity.

---

# 🎯 Key Observations

- The majority element appears more than half the time.
- Different elements cancel each other out.
- After all cancellations, the majority element remains.

---

# 📚 Key Learning

After solving this problem, you should understand:

- Frequency counting
- HashMap usage
- Boyer-Moore Voting Algorithm
- Candidate elimination
- Time and space optimization

---

# 💼 Interview Questions

### Why does the Boyer-Moore algorithm work?

Because the majority element appears more than half the time, all other elements combined cannot completely cancel it out.

---

### When should this algorithm not be used?

If the problem does **not guarantee** the existence of a majority element, an additional verification pass is required.

---

### Why is it better than HashMap?

It achieves the same linear time complexity while reducing the extra space from **O(n)** to **O(1)**.

---

# ✅ Conclusion

The Boyer-Moore Voting Algorithm is the optimal solution because it solves the problem in **O(n)** time using **O(1)** extra space. It is one of the most elegant algorithms for identifying a majority element and is frequently asked in coding interviews.