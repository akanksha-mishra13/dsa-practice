# 0345. Reverse Vowels of a String

> **Difficulty:** Easy  
> **Topic(s):** Strings, Two Pointers  
> **Pattern:** Two Pointers  
> **Platform:** LeetCode

---

# 📖 Problem Statement

Given a string `s`, reverse only the vowels in the string and return the resulting string.

The positions of all non-vowel characters should remain unchanged.

**Problem Link:** https://leetcode.com/problems/reverse-vowels-of-a-string/

---

# 📝 Examples

### Example 1

**Input**

```text
s = "hello"
```

**Output**

```text
"holle"
```

---

### Example 2

**Input**

```text
s = "leetcode"
```

**Output**

```text
"leotcede"
```

---

# 🔒 Constraints

- 1 <= s.length <= 3 × 10⁵
- `s` consists of printable ASCII characters.

---

# 🎯 Intuition

Only vowels need to be reversed.

Instead of reversing the entire string, use two pointers:

- One starts from the beginning.
- One starts from the end.

Move each pointer until it reaches a vowel.

Swap the vowels and continue until the pointers meet.

This preserves the positions of all non-vowel characters.

---

# 🚀 Approach 1: Extra List of Vowels

## Idea

Store all vowels in a separate list.

Traverse the string again and replace each vowel with the last stored vowel.

---

## Algorithm

1. Collect all vowels.
2. Reverse their order.
3. Replace vowels in the original string.

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
- Straightforward implementation.

---

## Disadvantages

- Requires additional memory.

---

# 🚀 Approach 2: Two Pointers (Optimal)

## Idea

Maintain two pointers:

- `left` starts from the beginning.
- `right` starts from the end.

Move both pointers until they point to vowels.

Swap those vowels.

Continue until the pointers cross.

---

## Algorithm

1. Convert the string into a character array.
2. Initialize `left = 0` and `right = n - 1`.
3. Move `left` until a vowel is found.
4. Move `right` until a vowel is found.
5. Swap the vowels.
6. Move both pointers inward.
7. Convert the character array back into a string.

---

# 🧠 Dry Run

Input

```text
"hello"
```

Character Array

```text
h e l l o
```

Pointers

```text
left = 0
right = 4
```

Move `left`

```text
h → e
```

Move `right`

```text
o
```

Swap

```text
e ↔ o
```

Array

```text
h o l l e
```

Pointers meet.

Final Answer

```text
"holle"
```

---

# 📊 Complexity Comparison

| Approach | Time | Space |
|-----------|------|-------|
| Extra List | O(n) | O(n) |
| Two Pointers ✅ | **O(n)** | **O(1)** |

---

# ✅ Why is this the Optimal Solution?

The Two Pointers approach performs only one traversal of the string while using constant extra space.

It swaps only the vowels and leaves all other characters untouched.

---

# 🎯 Key Observations

- Only vowels participate in swapping.
- Consonants never change position.
- Two pointers efficiently locate vowels from both ends.

---

# 📚 Key Learning

After solving this problem, you should understand:

- Two Pointer technique
- Selective swapping
- Character array manipulation
- Helper methods
- In-place processing

---

# 💼 Interview Questions

### Why convert the string into a character array?

Strings in Java are immutable, so we need a mutable character array to perform swaps.

---

### Why use a helper method?

A helper method keeps the code clean and avoids repeating vowel-checking logic.

---

### Why use Two Pointers?

Two pointers efficiently find vowels from both ends, reducing unnecessary comparisons.

---

### Does this preserve the positions of consonants?

Yes. Only vowels are swapped, while consonants remain in their original positions.

---

# ✅ Conclusion

The Two Pointers approach efficiently reverses only the vowels in a string while preserving all other characters. It runs in **O(n)** time and uses **O(1)** extra space, making it the optimal solution.