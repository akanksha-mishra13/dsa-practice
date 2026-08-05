# 0409. Longest Palindrome

> **Difficulty:** Easy  
> **Topic(s):** Strings, Hashing, Greedy  
> **Pattern:** Character Frequency Counting  
> **Platform:** LeetCode

---

# 📖 Problem Statement

Given a string `s` consisting of uppercase and lowercase English letters, return the length of the **longest palindrome** that can be built using those letters.

You may rearrange the characters in any order.

**Problem Link:** https://leetcode.com/problems/longest-palindrome/

---

# 📝 Examples

### Example 1

**Input**

```text
s = "abccccdd"
```

**Output**

```text
7
```

**Explanation**

One possible palindrome is:

```text
dccaccd
```

---

### Example 2

**Input**

```text
s = "a"
```

**Output**

```text
1
```

---

# 🔒 Constraints

- 1 <= s.length <= 2000
- The string consists of uppercase and lowercase English letters.

---

# 🎯 Intuition

A palindrome is symmetric.

- Characters with **even frequencies** can always be used completely.
- Characters with **odd frequencies** can contribute all but one occurrence (e.g., 5 contributes 4).
- At most **one odd-frequency character** can be placed at the center of the palindrome.

By counting the frequency of every character, we can calculate the maximum possible palindrome length.

---

# 🚀 Approach 1: Brute Force

## Idea

Generate every possible arrangement of characters and check whether it forms a palindrome.

Track the longest valid palindrome.

---

## Time Complexity

```text
O(n!)
```

---

## Space Complexity

```text
O(n)
```

---

## Advantages

- Demonstrates the concept.

---

## Disadvantages

- Completely impractical for large inputs.

---

# 🚀 Approach 2: HashMap

## Idea

Count the frequency of every character using a HashMap.

For each frequency:

- Add the largest even part.
- Remember if any odd frequency exists.

Finally, if at least one odd frequency exists, add one extra character for the center.

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

---

## Disadvantages

- Requires additional memory.

---

# 🚀 Approach 3: Frequency Array + Greedy (Optimal)

## Idea

Since the input contains only English letters, we can use a fixed-size frequency array.

For every character:

- If its frequency is even, use all occurrences.
- If its frequency is odd, use `count - 1`.
- Keep track of whether any odd frequency exists.

If at least one odd frequency exists, place one character in the center.

---

## Algorithm

1. Create a frequency array.
2. Count every character.
3. Traverse the frequency array.
4. Add all even frequencies.
5. For odd frequencies, add `count - 1`.
6. If any odd frequency exists, add one more character.
7. Return the total length.

---

# 🧠 Dry Run

Input

```text
s = "abccccdd"
```

Frequency

```text
a → 1
b → 1
c → 4
d → 2
```

Contribution

```text
a → 0
b → 0
c → 4
d → 2
```

Current Length

```text
6
```

There are odd frequencies (`a` and `b`), so one can be placed in the center.

Final Length

```text
7
```

---

# 📊 Complexity Comparison

| Approach | Time | Space |
|-----------|------|-------|
| Brute Force | O(n!) | O(n) |
| HashMap | O(n) | O(n) |
| Frequency Array + Greedy ✅ | **O(n)** | **O(1)** |

---

# ✅ Why is this the Optimal Solution?

The frequency array stores character counts in constant space, while the greedy observation ensures we always build the longest possible palindrome.

It requires only one pass to count frequencies and one pass to compute the answer.

---

# 🎯 Key Observations

- Even frequencies are always fully usable.
- Odd frequencies contribute one less than their count.
- Only one odd character can occupy the center.
- Rearranging the characters allows us to maximize the palindrome length.

---

# 📚 Key Learning

After solving this problem, you should understand:

- Frequency counting
- Greedy strategy
- Palindrome properties
- Character frequency arrays
- Maximization using mathematical observations

---

# 💼 Interview Questions

### Why can only one odd-frequency character be used completely?

A palindrome has only one center position, so only one character may appear an odd number of times.

---

### Why subtract one from odd frequencies?

Removing one occurrence makes the remaining count even, allowing those characters to be placed symmetrically.

---

### Why use a frequency array instead of a HashMap?

The input contains only English letters, so a fixed-size array is simpler and more efficient.

---

### Is rearranging the string allowed?

Yes. The problem asks for the longest palindrome that can be built using the given letters, not the original order.

---

# ✅ Conclusion

The Frequency Array + Greedy approach efficiently computes the maximum palindrome length by using all even-frequency characters and at most one odd-frequency character as the center. It achieves **O(n)** time and **O(1)** extra space, making it the optimal solution.