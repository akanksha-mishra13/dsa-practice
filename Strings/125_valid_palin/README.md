# 0125. Valid Palindrome

> **Difficulty:** Easy  
> **Topic(s):** Strings, Two Pointers  
> **Pattern:** Two Pointers  
> **Platform:** LeetCode

---

# 📖 Problem Statement

A phrase is considered a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward.

Given a string `s`, return **true** if it is a palindrome, otherwise return **false**.

**Problem Link:** https://leetcode.com/problems/valid-palindrome/

---

# 📝 Examples

### Example 1

**Input**

```text
s = "A man, a plan, a canal: Panama"
```

**Output**

```text
true
```

---

### Example 2

**Input**

```text
s = "race a car"
```

**Output**

```text
false
```

---

### Example 3

**Input**

```text
s = " "
```

**Output**

```text
true
```

---

# 🔒 Constraints

- 1 <= s.length <= 2 × 10⁵
- String consists of printable ASCII characters.

---

# 🎯 Intuition

The palindrome property means the characters should match when compared from both ends.

However, this problem ignores:

- Uppercase and lowercase differences.
- Spaces.
- Punctuation.
- Special characters.

Instead of creating a new cleaned string, we can directly use two pointers and skip non-alphanumeric characters while comparing characters in lowercase.

This saves extra memory and performs the comparison efficiently.

---

# 🚀 Approach 1: Brute Force

## Idea

Create a new string containing only lowercase alphanumeric characters.

Then reverse the cleaned string and compare it with the original cleaned string.

---

## Algorithm

1. Traverse the string.
2. Store only lowercase letters and digits.
3. Reverse the cleaned string.
4. Compare both strings.
5. Return the result.

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

- Requires extra memory for the cleaned string.

---

# 🚀 Approach 2: Two Pointers (Optimal)

## Idea

Use one pointer from the beginning and one from the end.

If either pointer points to a non-alphanumeric character, simply move it.

When both pointers point to valid characters, convert them to lowercase and compare.

If they differ, the string is not a palindrome.

Otherwise, continue until the pointers meet.

---

## Algorithm

1. Initialize:
   - `left = 0`
   - `right = s.length() - 1`
2. While `left < right`:
   - Skip non-alphanumeric characters from the left.
   - Skip non-alphanumeric characters from the right.
   - Convert both characters to lowercase.
   - Compare them.
   - If they are different, return `false`.
   - Otherwise move both pointers inward.
3. If all comparisons succeed, return `true`.

---

# 🧠 Dry Run

Input

```text
"A man, a plan, a canal: Panama"
```

Compare

```text
A ↔ a
```

Equal after lowercase conversion.

Move inward.

Skip

```text
' '
','
':'
```

Compare

```text
m ↔ m
a ↔ a
n ↔ n
```

Continue until pointers cross.

Final Answer

```text
true
```

---

# 📊 Complexity Comparison

| Approach | Time | Space |
|-----------|------|-------|
| Brute Force | O(n) | O(n) |
| Two Pointers ✅ | **O(n)** | **O(1)** |

---

# ✅ Why is this the Optimal Solution?

The Two Pointers approach processes the string only once while using constant extra space.

It avoids creating a new string and directly compares valid characters, making it both time-efficient and memory-efficient.

---

# 🎯 Key Observations

- Ignore spaces and punctuation.
- Ignore uppercase and lowercase differences.
- Compare only letters and digits.
- Two pointers naturally solve symmetric comparison problems.

---

# 📚 Key Learning

After solving this problem, you should understand:

- Two Pointer technique
- Character validation
- Using `Character.isLetterOrDigit()`
- Using `Character.toLowerCase()`
- In-place string traversal

---

# 💼 Interview Questions

### Why use Two Pointers instead of reversing the string?

Two Pointers avoid creating an additional string, reducing the space complexity to O(1).

---

### Why use `Character.isLetterOrDigit()`?

Because the problem specifies that only alphanumeric characters should be considered.

---

### Why convert both characters to lowercase?

So that uppercase and lowercase versions of the same letter are treated as equal.

---

### Can this problem be solved using extra space?

Yes. Build a cleaned string, reverse it, and compare both strings. However, this requires O(n) extra space.

---

# ✅ Conclusion

The Two Pointers approach efficiently checks whether a string is a palindrome while ignoring non-alphanumeric characters and letter casing. It runs in **O(n)** time and **O(1)** extra space, making it the optimal solution for this problem.