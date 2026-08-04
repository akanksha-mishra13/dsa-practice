# 0242. Valid Anagram

> **Difficulty:** Easy  
> **Topic(s):** Strings, Hashing  
> **Pattern:** Character Frequency Array  
> **Platform:** LeetCode

---

# 📖 Problem Statement

Given two strings `s` and `t`, return **true** if `t` is an anagram of `s`, and **false** otherwise.

An **anagram** is a word or phrase formed by rearranging the letters of another word, using all the original letters exactly once.

**Problem Link:** https://leetcode.com/problems/valid-anagram/

---

# 📝 Examples

### Example 1

**Input**

```text
s = "anagram"
t = "nagaram"
```

**Output**

```text
true
```

---

### Example 2

**Input**

```text
s = "rat"
t = "car"
```

**Output**

```text
false
```

---

# 🔒 Constraints

- 1 <= s.length, t.length <= 5 × 10⁴
- `s` and `t` consist of lowercase English letters.

---

# 🎯 Intuition

Two strings are anagrams if every character appears the same number of times in both strings.

Instead of sorting both strings or comparing every character repeatedly, we can count the frequency of each letter.

If the frequency of every character matches, the strings are anagrams.

Since there are only 26 lowercase English letters, a fixed-size frequency array is sufficient.

---

# 🚀 Approach 1: Brute Force

## Idea

Sort both strings alphabetically.

If the sorted strings are identical, they are anagrams.

---

## Algorithm

1. Convert both strings into character arrays.
2. Sort both arrays.
3. Compare the sorted arrays.
4. Return the result.

---

## Time Complexity

```text
O(n log n)
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

- Sorting increases time complexity.

---

# 🚀 Approach 2: HashMap

## Idea

Store the frequency of every character using a HashMap.

Increase the count for the first string and decrease it for the second string.

If every frequency becomes zero, the strings are anagrams.

---

## Algorithm

1. Create a HashMap.
2. Traverse both strings.
3. Update frequencies.
4. Compare all frequencies.
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

- Works for Unicode characters.
- Easy to modify.

---

## Disadvantages

- Uses additional memory.

---

# 🚀 Approach 3: Character Frequency Array (Optimal)

## Idea

Since the input contains only lowercase English letters, we can use an integer array of size 26.

Increase the frequency for each character in the first string and decrease it for the corresponding character in the second string.

If all values become zero, both strings contain exactly the same characters.

---

## Algorithm

1. Check if both strings have equal length.
2. Create a frequency array of size 26.
3. Traverse both strings simultaneously.
4. Increment the count for characters in the first string.
5. Decrement the count for characters in the second string.
6. Traverse the frequency array.
7. If any value is not zero, return `false`.
8. Otherwise, return `true`.

---

# 🧠 Dry Run

Input

```text
s = "anagram"
t = "nagaram"
```

Frequency changes:

```text
a → +1 then -1 = 0
n → +1 then -1 = 0
a → +1 then -1 = 0
g → +1 then -1 = 0
r → +1 then -1 = 0
a → +1 then -1 = 0
m → +1 then -1 = 0
```

All frequencies become:

```text
0
```

Final Answer

```text
true
```

---

# 📊 Complexity Comparison

| Approach | Time | Space |
|-----------|------|-------|
| Sorting | O(n log n) | O(n) |
| HashMap | O(n) | O(n) |
| Character Frequency Array ✅ | **O(n)** | **O(1)** |

---

# ✅ Why is this the Optimal Solution?

The frequency array performs a single traversal of both strings while using a fixed array of size 26.

Since the array size is constant, the extra space is considered **O(1)**.

It is faster than sorting and more memory-efficient than a HashMap.

---

# 🎯 Key Observations

- Anagrams always have the same length.
- Every character must have the same frequency.
- A fixed-size array is sufficient for lowercase English letters.

---

# 📚 Key Learning

After solving this problem, you should understand:

- Character frequency counting
- Frequency arrays
- Difference between HashMap and arrays
- Constant-space optimization
- Efficient string comparison

---

# 💼 Interview Questions

### Why check the string lengths first?

If the lengths are different, they cannot be anagrams.

---

### Why use an array instead of a HashMap?

The input contains only lowercase English letters, so a fixed-size array is faster and uses less memory.

---

### When should a HashMap be preferred?

When the input may contain Unicode characters or a larger character set.

---

### Why is the space complexity O(1)?

The frequency array always has 26 elements regardless of the input size.

---

# ✅ Conclusion

The Character Frequency Array approach efficiently determines whether two strings are anagrams by comparing character counts. It runs in **O(n)** time with **O(1)** extra space, making it the optimal solution for lowercase English letters.