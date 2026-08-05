# 0387. First Unique Character in a String

> **Difficulty:** Easy  
> **Topic(s):** Strings, Hashing  
> **Pattern:** Character Frequency Array  
> **Platform:** LeetCode

---

# 📖 Problem Statement

Given a string `s`, return the index of the first non-repeating character in it.

If every character repeats, return `-1`.

**Problem Link:** https://leetcode.com/problems/first-unique-character-in-a-string/

---

# 📝 Examples

### Example 1

**Input**

```text
s = "leetcode"
```

**Output**

```text
0
```

---

### Example 2

**Input**

```text
s = "loveleetcode"
```

**Output**

```text
2
```

---

### Example 3

**Input**

```text
s = "aabb"
```

**Output**

```text
-1
```

---

# 🔒 Constraints

- 1 <= s.length <= 10⁵
- `s` consists of only lowercase English letters.

---

# 🎯 Intuition

To identify the first unique character, we first need to know how many times each character appears.

A frequency array efficiently stores the occurrence count of every lowercase letter.

After building the frequency array, we scan the string again and return the index of the first character whose frequency is exactly `1`.

---

# 🚀 Approach 1: Brute Force

## Idea

For every character, count its occurrences by scanning the entire string.

If a character appears only once, return its index.

---

## Algorithm

1. Traverse every character.
2. Count its occurrences using another loop.
3. If the count is one, return its index.
4. If no unique character exists, return `-1`.

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

- Simple implementation.
- No extra data structure required.

---

## Disadvantages

- Inefficient for long strings.

---

# 🚀 Approach 2: HashMap

## Idea

Store the frequency of every character in a HashMap.

Traverse the string again and return the first character whose frequency is one.

---

## Algorithm

1. Create a HashMap.
2. Count the frequency of every character.
3. Traverse the string again.
4. Return the index of the first character with frequency one.

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

- Works for any character set.
- Easy to implement.

---

## Disadvantages

- Uses additional memory.

---

# 🚀 Approach 3: Character Frequency Array (Optimal)

## Idea

Since the input contains only lowercase English letters, we can use a fixed-size array of length 26.

The first traversal records the frequency of each character.

The second traversal identifies the first character that appears exactly once.

---

## Algorithm

1. Create a frequency array of size 26.
2. Traverse the string and count each character.
3. Traverse the string again.
4. Return the first index where the frequency is one.
5. If none exists, return `-1`.

---

# 🧠 Dry Run

Input

```text
s = "loveleetcode"
```

Frequency:

```text
l → 2
o → 2
v → 1
e → 4
t → 1
c → 1
d → 1
```

Second Traversal:

```text
l → 2 ❌
o → 2 ❌
v → 1 ✅
```

Return

```text
2
```

---

# 📊 Complexity Comparison

| Approach | Time | Space |
|-----------|------|-------|
| Brute Force | O(n²) | O(1) |
| HashMap | O(n) | O(n) |
| Character Frequency Array ✅ | **O(n)** | **O(1)** |

---

# ✅ Why is this the Optimal Solution?

The Character Frequency Array approach performs only two linear traversals of the string while using a fixed-size array of 26 elements.

This provides the best possible time complexity with constant extra space.

---

# 🎯 Key Observations

- Every character's frequency must be known before identifying the first unique character.
- A second traversal preserves the original order of the string.
- A frequency array is sufficient because only lowercase English letters are used.

---

# 📚 Key Learning

After solving this problem, you should understand:

- Character Frequency Arrays
- Two-pass algorithms
- Frequency counting
- Order preservation
- Constant-space optimization

---

# 💼 Interview Questions

### Why are two traversals required?

The first traversal counts the frequency of every character, while the second identifies the first character with a frequency of one.

---

### Why use a frequency array instead of a HashMap?

The input contains only lowercase English letters, so a fixed-size array is faster and uses constant extra space.

---

### Why can't we identify the answer in one traversal?

When reading a character for the first time, we don't yet know whether it will appear again later in the string.

---

### What if the string contains Unicode characters?

A HashMap should be used because the character set is much larger than 26 letters.

---

# ✅ Conclusion

The Character Frequency Array approach efficiently finds the first unique character by separating frequency counting from result identification. It runs in **O(n)** time and **O(1)** extra space, making it the optimal solution for this problem.