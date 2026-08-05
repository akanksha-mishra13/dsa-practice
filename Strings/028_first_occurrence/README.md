# 0028. Find the Index of the First Occurrence in a String

> **Difficulty:** Easy  
> **Topic(s):** Strings  
> **Pattern:** String Matching  
> **Platform:** LeetCode

---

# 📖 Problem Statement

Given two strings `haystack` and `needle`, return the index of the **first occurrence** of `needle` in `haystack`.

If `needle` is not part of `haystack`, return `-1`.

**Problem Link:** https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

---

# 📝 Examples

### Example 1

**Input**

```text
haystack = "sadbutsad"
needle = "sad"
```

**Output**

```text
0
```

---

### Example 2

**Input**

```text
haystack = "leetcode"
needle = "leeto"
```

**Output**

```text
-1
```

---

# 🔒 Constraints

- 1 <= haystack.length, needle.length <= 10⁴
- Both strings consist of lowercase English letters.

---

# 🎯 Intuition

To determine whether `needle` exists inside `haystack`, compare the characters of `needle` with every possible starting position in `haystack`.

If all characters match consecutively, return the starting index.

If no complete match is found after checking every valid position, return `-1`.

---

# 🚀 Approach 1: Built-in Function

## Idea

Use Java's built-in `indexOf()` method.

---

## Algorithm

1. Call `haystack.indexOf(needle)`.
2. Return the result.

---

## Time Complexity

```text
O(n × m)
```

*(Implementation-dependent.)*

---

## Space Complexity

```text
O(1)
```

---

## Advantages

- Very short and readable.
- Easy to implement.

---

## Disadvantages

- Does not demonstrate algorithmic understanding.
- Often avoided in coding interviews.

---

# 🚀 Approach 2: Brute Force String Matching (Optimal for Interviews)

## Idea

Try matching `needle` starting from every valid position in `haystack`.

If every character matches, return the starting index.

Otherwise, move to the next position.

---

## Algorithm

1. Let `n` be the length of `haystack`.
2. Let `m` be the length of `needle`.
3. Traverse from index `0` to `n - m`.
4. Compare every character of `needle`.
5. If all characters match, return the current index.
6. If no match exists, return `-1`.

---

# 🧠 Dry Run

Input

```text
haystack = "sadbutsad"
needle = "sad"
```

Check index **0**

```text
sad == sad
```

Complete match found.

Return

```text
0
```

---

Input

```text
haystack = "leetcode"
needle = "leeto"
```

Compare

```text
leetc
leeto
```

Mismatch occurs.

Continue checking.

No match found.

Return

```text
-1
```

---

# 📊 Complexity Comparison

| Approach | Time | Space |
|-----------|------|-------|
| Built-in `indexOf()` | O(n × m)* | O(1) |
| Brute Force String Matching ✅ | **O(n × m)** | **O(1)** |

\*Actual implementation varies by language.

---

# ✅ Why is this the Optimal Solution?

For this problem, the brute-force string matching approach is simple, easy to understand, and requires only constant extra space.

Although more advanced algorithms such as **KMP (Knuth-Morris-Pratt)** can achieve **O(n + m)** time complexity, they are generally used for larger inputs or repeated pattern matching.

---

# 🎯 Key Observations

- Only positions where `needle` can fully fit need to be checked.
- Stop comparing immediately after a mismatch.
- Return the first successful match.

---

# 📚 Key Learning

After solving this problem, you should understand:

- String matching
- Nested iteration
- Early termination
- Pattern searching
- Difference between brute-force and KMP

---

# 💼 Interview Questions

### Why don't we check beyond `n - m`?

Because `needle` cannot fit completely beyond that position.

---

### Why stop after the first mismatch?

Continuing comparisons would be unnecessary because the current starting position can no longer produce a valid match.

---

### Is there a faster algorithm?

Yes. The **KMP (Knuth-Morris-Pratt)** algorithm solves the problem in **O(n + m)** time.

---

### When should KMP be preferred?

When working with very large strings or when performing many pattern searches.

---

# ✅ Conclusion

The brute-force string matching approach checks every valid starting position and compares characters until a mismatch occurs or a complete match is found. It is simple, efficient for the given constraints, and commonly accepted in coding interviews before introducing advanced algorithms like KMP.
