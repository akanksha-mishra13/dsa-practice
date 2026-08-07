# 0058. Length of Last Word

> **Difficulty:** Easy  
> **Topic(s):** Strings  
> **Pattern:** Reverse Traversal  
> **Platform:** LeetCode

---

# 📖 Problem Statement

Given a string `s` consisting of words and spaces, return the **length of the last word** in the string.

A word is defined as a maximal substring consisting of non-space characters only.

**Problem Link:** https://leetcode.com/problems/length-of-last-word/

---

# 📝 Examples

### Example 1

**Input**

```text
s = "Hello World"
```

**Output**

```text
5
```

---

### Example 2

**Input**

```text
s = "   fly me   to   the moon  "
```

**Output**

```text
4
```

---

### Example 3

**Input**

```text
s = "luffy is still joyboy"
```

**Output**

```text
6
```

---

# 🔒 Constraints

- 1 <= s.length <= 10⁴
- `s` consists of English letters and spaces.
- There will be at least one word.

---

# 🎯 Intuition

The last word is located at the end of the string, but there may be trailing spaces.

Instead of splitting the string or traversing from the beginning, we can start from the last character.

First, ignore all trailing spaces.

Then count the characters until another space or the beginning of the string is reached.

This avoids unnecessary extra memory.

---

# 🚀 Approach 1: Using split()

## Idea

Split the string into words using spaces.

Return the length of the last word.

---

## Algorithm

1. Remove leading and trailing spaces.
2. Split the string by spaces.
3. Return the length of the last element.

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
- Very short implementation.

---

## Disadvantages

- Creates additional arrays.
- Uses extra memory.

---

# 🚀 Approach 2: Reverse Traversal (Optimal)

## Idea

Traverse the string from the end.

Ignore trailing spaces.

Count characters until a space or the beginning of the string is encountered.

The count represents the length of the last word.

---

## Algorithm

1. Start from the last index.
2. Skip all trailing spaces.
3. Count characters until a space is found.
4. Return the count.

---

# 🧠 Dry Run

Input

```text
"Hello World"
```

Initial Index

```text
i = 10
```

Skip Spaces

```text
No trailing spaces.
```

Count

```text
d → 1
l → 2
r → 3
o → 4
W → 5
```

Space encountered.

Return

```text
5
```

---

# 📊 Complexity Comparison

| Approach | Time | Space |
|-----------|------|-------|
| split() | O(n) | O(n) |
| Reverse Traversal ✅ | **O(n)** | **O(1)** |

---

# ✅ Why is this the Optimal Solution?

Reverse traversal scans the string only once and does not create any additional arrays or strings.

It efficiently handles trailing spaces while using constant extra space.

---

# 🎯 Key Observations

- The last word may be followed by spaces.
- Traversing from the end avoids processing unnecessary characters.
- No extra data structures are required.

---

# 📚 Key Learning

After solving this problem, you should understand:

- Reverse traversal
- Handling trailing spaces
- Character-by-character processing
- Space optimization
- Efficient string scanning

---

# 💼 Interview Questions

### Why traverse from the end?

The answer depends only on the last word, so starting from the end avoids unnecessary work.

---

### Why not use split()?

`split()` creates additional arrays and consumes extra memory, while reverse traversal works in constant space.

---

### What if there are trailing spaces?

The algorithm skips them before counting the last word.

---

### Can the last word be the only word?

Yes. In that case, its entire length is returned.

---

# ✅ Conclusion

The Reverse Traversal approach efficiently finds the length of the last word by scanning the string from the end, skipping trailing spaces, and counting characters until a space is reached. It runs in **O(n)** time and **O(1)** extra space, making it the optimal solution.