# 0268. Missing Number

> **Difficulty:** Easy  
> **Topic(s):** Arrays, Bit Manipulation, Math  
> **Pattern:** XOR  
> **Platform:** LeetCode

---

# 📖 Problem Statement

Given an array `nums` containing `n` distinct numbers in the range `[0, n]`, return the only number in the range that is missing from the array.

**Problem Link:** https://leetcode.com/problems/missing-number/

---

# 📝 Examples

### Example 1

**Input**

```text
nums = [3,0,1]
```

**Output**

```text
2
```

---

### Example 2

**Input**

```text
nums = [0,1]
```

**Output**

```text
2
```

---

### Example 3

**Input**

```text
nums = [9,6,4,2,3,5,7,0,1]
```

**Output**

```text
8
```

---

# 🔒 Constraints

- n == nums.length
- 1 <= n <= 10⁴
- 0 <= nums[i] <= n
- All numbers are unique.

---

# 🎯 Intuition

The array contains every number from `0` to `n` except one.

Instead of checking each number individually, we can use the properties of the XOR operation.

When a number is XORed with itself, it becomes `0`.

If we XOR all indices, all array elements, and the value `n`, every number appears twice except the missing one.

The remaining value is the answer.

---

# 🚀 Approach 1: Brute Force

## Idea

For every number from `0` to `n`, search the entire array.

If a number is not found, return it.

---

## Algorithm

1. Iterate from `0` to `n`.
2. Search the entire array.
3. Return the missing number.

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

- Very easy to understand.
- No extra data structure required.

---

## Disadvantages

- Extremely slow for large inputs.

---

# 🚀 Approach 2: HashSet

## Idea

Store every element in a HashSet.

Then iterate from `0` to `n`.

The first number not present in the HashSet is the answer.

---

## Algorithm

1. Insert all numbers into a HashSet.
2. Traverse from `0` to `n`.
3. Return the first missing number.

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

- Simple implementation.
- Fast lookup.

---

## Disadvantages

- Requires additional memory.

---

# 🚀 Approach 3: Mathematical Formula

## Idea

Calculate the expected sum of numbers from `0` to `n`.

Subtract the actual sum of the array.

The difference is the missing number.

---

## Algorithm

1. Compute expected sum = `n × (n + 1) / 2`.
2. Compute actual array sum.
3. Return the difference.

---

## Time Complexity

```text
O(n)
```

---

## Space Complexity

```text
O(1)
```

---

## Advantages

- Very efficient.
- Constant extra space.

---

## Disadvantages

- May cause integer overflow for very large numbers in some languages.

---

# 🚀 Approach 4: XOR (Optimal)

## Idea

Use the following XOR properties:

- `a ^ a = 0`
- `a ^ 0 = a`
- XOR is commutative and associative.

XOR every index, every array element, and `n`.

All matching values cancel each other.

Only the missing number remains.

---

## Algorithm

1. Initialize `xor` with `n`.
2. Traverse the array.
3. XOR the index.
4. XOR the current element.
5. Return the remaining XOR value.

---

# 🧠 Dry Run

Input

```text
nums = [3,0,1]
```

n = 3

Start

```text
xor = 3
```

Iteration 1

```text
xor = 3 ^ 0 ^ 3 = 0
```

Iteration 2

```text
xor = 0 ^ 1 ^ 0 = 1
```

Iteration 3

```text
xor = 1 ^ 2 ^ 1 = 2
```

Final Answer

```text
2
```

---

# 📊 Complexity Comparison

| Approach | Time | Space |
|-----------|------|-------|
| Brute Force | O(n²) | O(1) |
| HashSet | O(n) | O(n) |
| Mathematical Formula | O(n) | O(1) |
| XOR ✅ | **O(n)** | **O(1)** |

---

# ✅ Why is this the Optimal Solution?

The XOR approach solves the problem in a single traversal while using constant extra space.

It avoids additional memory and does not rely on arithmetic formulas.

---

# 🎯 Key Observations

- Every number except one appears exactly twice during XOR.
- Equal numbers cancel each other.
- The missing number remains.

---

# 📚 Key Learning

After solving this problem, you should understand:

- XOR properties
- Bit manipulation basics
- Constant-space algorithms
- Alternative approaches to array problems

---

# 💼 Interview Questions

### Why does XOR work?

Because identical numbers cancel each other out (`a ^ a = 0`), leaving only the missing value.

---

### Is the mathematical formula also optimal?

Yes, both the XOR and mathematical formula approaches run in O(n) time and O(1) space. XOR avoids concerns about arithmetic overflow in some languages.

---

### When should XOR be preferred?

When problems involve finding a unique or missing value among paired elements.

---

# ✅ Conclusion

The XOR approach is an elegant and efficient solution that uses the cancellation property of XOR to identify the missing number. It achieves **O(n)** time complexity with **O(1)** extra space, making it one of the best solutions for this problem.