# 0557. Reverse Words in a String III

> **Difficulty:** Easy  
> **Topic(s):** Strings  
> **Pattern:** Two Pointers  
> **Platform:** LeetCode

---

# 📖 Problem Statement

Given a string `s`, reverse the characters of each word while preserving the order of the words and spaces.

**Problem Link:** https://leetcode.com/problems/reverse-words-in-a-string-iii/

---

# 📝 Examples

### Example 1

**Input**

```text
s = "Let's take LeetCode contest"
```

**Output**

```text
"s'teL ekat edoCteeL tsetnoc"
```

---

### Example 2

**Input**

```text
s = "Mr Ding"
```

**Output**

```text
"rM gniD"
```

---

# 🔒 Constraints

- 1 <= s.length <= 5 × 10⁴
- `s` contains printable ASCII characters.
- Words are separated by a single space.
- There are no leading or trailing spaces.

---

# 🎯 Intuition

Each word should be reversed independently, while the order of words remains unchanged.

Instead of creating new strings for every word, convert the string into a character array and reverse each word in-place.

Whenever a space or the end of the string is encountered, reverse the current word using two pointers.

---

# 🚀 Approach 1: Using split()

## Idea

Split the string into words.

Reverse each word individually.

Join all words back together.

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

- Uses additional arrays and strings.

---

# 🚀 Approach 2: Two Pointers (Optimal)

## Idea

Convert the string into a character array.

Traverse the array.

Whenever a space or the end is reached:

- Reverse the current word.
- Continue with the next word.

---

## Algorithm

1. Convert the string into a character array.
2. Maintain the starting index of the current word.
3. Traverse the array.
4. On encountering a space or the end:
   - Reverse the current word.
   - Update the start index.
5. Return the modified string.

---

# 🧠 Dry Run

Input

```text
"God Ding"
```

Character Array

```text
G o d   D i n g
```

Reverse first word

```text
d o G
```

Reverse second word

```text
g n i D
```

Final Output

```text
"doG gniD"
```

---

# 📊 Complexity Comparison

| Approach | Time | Space |
|-----------|------|-------|
| split() | O(n) | O(n) |
| Two Pointers ✅ | **O(n)** | **O(1)** |

---

# ✅ Why is this the Optimal Solution?

The Two Pointers approach reverses each word directly inside the character array without allocating extra arrays for every word.

It performs a single traversal and uses constant extra space.

---

# 🎯 Key Observations

- Only individual words are reversed.
- Word order remains unchanged.
- Spaces act as natural boundaries.
- Character arrays allow in-place modification.

---

# 📚 Key Learning

After solving this problem, you should understand:

- Two Pointers
- In-place String Manipulation
- Character Arrays
- Word Boundary Detection
- Helper Functions

---

# 💼 Interview Questions

### Why convert the string into a character array?

Strings in Java are immutable. A character array allows characters to be swapped directly.

---

### Why use Two Pointers?

Two pointers efficiently reverse each word in-place without extra memory.

---

### What identifies the end of a word?

A space character or reaching the end of the array.

---

### Does the order of words change?

No. Only the characters inside each word are reversed.

---

# ✅ Conclusion

The Two Pointers approach efficiently reverses every word in-place while preserving the order of words. It runs in **O(n)** time and uses **O(1)** extra space, making it the optimal solution.