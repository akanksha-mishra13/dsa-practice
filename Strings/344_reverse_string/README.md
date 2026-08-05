# 0344. Reverse String

> **Difficulty:** Easy  
> **Topic(s):** Strings, Two Pointers  
> **Pattern:** Two Pointers  
> **Platform:** LeetCode

---

# 📖 Problem Statement

Write a function that reverses a string.

The input string is given as an array of characters `char[]`.

You must modify the input array **in-place** using **O(1)** extra memory.

**Problem Link:** https://leetcode.com/problems/reverse-string/

---

# 📝 Examples

### Example 1

**Input**

```text
s = ["h","e","l","l","o"]
```

**Output**

```text
["o","l","l","e","h"]
```

---

### Example 2

**Input**

```text
s = ["H","a","n","n","a","h"]
```

**Output**

```text
["h","a","n","n","a","H"]
```

---

# 🔒 Constraints

- 1 <= s.length <= 10⁵
- `s[i]` is a printable ASCII character.

---

# 🎯 Intuition

To reverse a string, the first character should move to the last position, the second character to the second last position, and so on.

Instead of creating another array, we can swap the characters from both ends while moving towards the center.

This approach is efficient because it performs the reversal directly within the original array.

---

# 🚀 Approach 1: Brute Force

## Idea

Create a new character array.

Copy characters from the original array in reverse order.

Finally, copy them back into the original array.

---

## Algorithm

1. Create a new array.
2. Traverse the original array from the end.
3. Store the elements in the new array.
4. Copy the new array back.

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

- Requires additional memory.
- Does not satisfy the in-place requirement.

---

# 🚀 Approach 2: Two Pointers (Optimal)

## Idea

Maintain two pointers:

- `left` starts from the beginning.
- `right` starts from the end.

Swap the characters at both pointers.

Move both pointers toward the center.

Repeat until they meet.

---

## Algorithm

1. Initialize:
   - `left = 0`
   - `right = n - 1`
2. While `left < right`:
   - Swap `s[left]` and `s[right]`.
   - Increment `left`.
   - Decrement `right`.
3. The array is now reversed.

---

# 🧠 Dry Run

Input

```text
["h","e","l","l","o"]
```

Initial

```text
left = 0
right = 4
```

Swap

```text
h ↔ o
```

Array

```text
["o","e","l","l","h"]
```

Move pointers

```text
left = 1
right = 3
```

Swap

```text
e ↔ l
```

Array

```text
["o","l","l","e","h"]
```

Pointers meet.

Final Answer

```text
["o","l","l","e","h"]
```

---

# 📊 Complexity Comparison

| Approach | Time | Space |
|-----------|------|-------|
| Brute Force | O(n) | O(n) |
| Two Pointers ✅ | **O(n)** | **O(1)** |

---

# ✅ Why is this the Optimal Solution?

The Two Pointers approach reverses the string in a single traversal without using any extra array.

It satisfies the problem requirement of modifying the array in-place while achieving the best possible time and space complexity.

---

# 🎯 Key Observations

- The first and last characters always swap.
- Swapping continues until the pointers meet.
- No additional memory is required.

---

# 📚 Key Learning

After solving this problem, you should understand:

- Two Pointer technique
- In-place array modification
- Character swapping
- Space optimization
- Symmetric traversal

---

# 💼 Interview Questions

### Why use Two Pointers?

Two pointers allow us to reverse the string efficiently in-place with constant extra space.

---

### Why not create another array?

The problem specifically requires an in-place solution using O(1) extra memory.

---

### What happens when the string length is odd?

The middle character remains unchanged because it is already in its correct position.

---

### Can this approach be used for arrays?

Yes. The same technique works for reversing arrays of any data type.

---

# ✅ Conclusion

The Two Pointers approach efficiently reverses the string by swapping characters from both ends while moving toward the center. It runs in **O(n)** time and **O(1)** extra space, making it the optimal solution.

