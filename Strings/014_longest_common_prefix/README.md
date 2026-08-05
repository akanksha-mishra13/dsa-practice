# 0014. Longest Common Prefix

> **Difficulty:** Easy  
> **Topic(s):** Strings  
> **Pattern:** String Traversal  
> **Platform:** LeetCode

---

# 📖 Problem Statement

Write a function to find the **longest common prefix string** amongst an array of strings.

If there is no common prefix, return an empty string `""`.

**Problem Link:** https://leetcode.com/problems/longest-common-prefix/

---

# 📝 Examples

### Example 1

**Input**

```text
strs = ["flower","flow","flight"]
```

**Output**

```text
"fl"
```

---

### Example 2

**Input**

```text
strs = ["dog","racecar","car"]
```

**Output**

```text
""
```

---

# 🔒 Constraints

- 1 <= strs.length <= 200
- 0 <= strs[i].length <= 200
- `strs[i]` consists of lowercase English letters.

---

# 🎯 Intuition

The first string can be treated as the initial candidate prefix.

Compare this prefix with every other string.

If a string does not start with the current prefix, shorten the prefix by removing its last character.

Repeat until every string begins with the same prefix or the prefix becomes empty.

---

# 🚀 Approach 1: Brute Force (Character-by-Character)

## Idea

Compare the characters at each index across all strings.

As soon as a mismatch occurs, return the prefix formed before that index.

---

## Algorithm

1. Find the shortest string length.
2. Compare characters column by column.
3. Stop at the first mismatch.
4. Return the prefix.

---

## Time Complexity

```text
O(n × m)
```

Where:

- `n` = number of strings
- `m` = length of the shortest string

---

## Space Complexity

```text
O(1)
```

---

## Advantages

- Simple logic.
- No extra memory.

---

## Disadvantages

- Requires checking every string for each character position.

---

# 🚀 Approach 2: Prefix Reduction (Optimal)

## Idea

Assume the first string is the common prefix.

Compare it with every other string.

If the current string does not start with the prefix, remove the last character from the prefix.

Continue reducing the prefix until it matches.

---

## Algorithm

1. Set the first string as the initial prefix.
2. Traverse the remaining strings.
3. While the current string does not start with the prefix:
   - Remove the last character from the prefix.
4. If the prefix becomes empty, return an empty string.
5. After processing all strings, return the prefix.

---

# 🧠 Dry Run

Input

```text
["flower","flow","flight"]
```

Initial Prefix

```text
flower
```

Compare with

```text
flow
```

Reduce:

```text
flower
→ flowe
→ flow
```

Now `flow` matches.

Compare with

```text
flight
```

Reduce:

```text
flow
→ flo
→ fl
```

Now `flight` starts with `"fl"`.

Final Answer

```text
fl
```

---

# 📊 Complexity Comparison

| Approach | Time | Space |
|-----------|------|-------|
| Character-by-Character | O(n × m) | O(1) |
| Prefix Reduction ✅ | **O(n × m)** | **O(1)** |

---

# ✅ Why is this the Optimal Solution?

The Prefix Reduction approach avoids unnecessary character comparisons by shrinking the candidate prefix only when required.

It uses constant extra space and efficiently handles varying string lengths.

---

# 🎯 Key Observations

- The longest common prefix can never be longer than the shortest string.
- Once the prefix becomes empty, no common prefix exists.
- Reducing the prefix is more efficient than rebuilding it repeatedly.

---

# 📚 Key Learning

After solving this problem, you should understand:

- Prefix comparison
- String traversal
- Using `startsWith()`
- String manipulation with `substring()`
- Handling edge cases

---

# 💼 Interview Questions

### Why choose the first string as the prefix?

Any common prefix must be a prefix of the first string, making it a natural starting point.

---

### Why use `startsWith()`?

It quickly checks whether the current string begins with the candidate prefix.

---

### What happens if no common prefix exists?

The prefix gradually shrinks until it becomes an empty string, which is returned.

---

### Can this problem be solved using sorting?

Yes. Sort the array, then compare only the first and last strings. Their common prefix is the answer because they differ the most lexicographically.

---

# ✅ Conclusion

The Prefix Reduction approach efficiently finds the longest common prefix by progressively shortening the candidate prefix until it matches every string. It runs in **O(n × m)** time with **O(1)** extra space, making it a clean and interview-friendly solution.