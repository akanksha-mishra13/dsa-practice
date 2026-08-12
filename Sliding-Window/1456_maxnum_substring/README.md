# 1456. Maximum Number of Vowels in a Substring of Given Length

> Difficulty: Medium  
> Topics: String, Sliding Window  
> Pattern: Fixed-Size Sliding Window  
> Platform: LeetCode

---

# 📖 Problem Statement

Given a string `s` and an integer `k`, return the maximum number
of vowel letters in any substring of `s` with length exactly `k`.

The vowels are:

    a
    e
    i
    o
    u

Only lowercase English letters are present.

---

# 🔗 Problem Link

https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/

---

# 📝 Example 1

Input:

    s = "abciiidef"
    k = 3

Output:

    3

Explanation:

The substring:

    "iii"

contains three vowels.

Therefore:

    answer = 3

---

# 📝 Example 2

Input:

    s = "aeiou"
    k = 2

Output:

    2

Every substring of length 2 contains at most two vowels.

---

# 📝 Example 3

Input:

    s = "leetcode"
    k = 3

Output:

    2

The substring:

    "lee"

contains two vowels.

---

# 🔒 Constraints

- `1 <= k <= s.length <= 10^5`
- `s` consists of lowercase English letters.

---

# 🎯 Goal

We need to find a substring of exactly:

    k

characters that contains the maximum number of vowels.

The important words are:

    substring
    exactly k

Because the window size is fixed, this is a:

    Fixed-Size Sliding Window

problem.

---

# 🔑 Important Observation

Every candidate substring contains exactly `k` characters.

We do not need to store the entire substring.

We only need to know:

    How many vowels are currently inside the window?

Therefore, instead of storing the characters of every window,
we maintain a single:

    vowelCount

variable.

---

# 🚀 Approach 1: Brute Force

## 💡 Intuition

Check every possible substring of length `k`.

For every substring:

1. Examine all `k` characters.
2. Count the vowels.
3. Update the maximum vowel count.

---

# 🔄 Algorithm

1. Start from index `0`.
2. Take the next `k` characters.
3. Count how many are vowels.
4. Update the maximum.
5. Move the starting position by one.
6. Repeat for every possible substring.

---

# ⏱️ Time Complexity

There are:

    O(n)

possible windows.

For every window, we examine:

    O(k)

characters.

Therefore:

    O(n × k)

In the worst case:

    O(n²)

---

# 💾 Space Complexity

Only a few variables are required.

Therefore:

    O(1)

---

# ❌ Why Brute Force Is Not Optimal

Consecutive windows overlap heavily.

For example:

    "abc"
    "bcd"

Both windows contain:

    "bc"

There is no reason to count the vowels in these characters
again.

We can reuse the previous window's count.

This leads to Sliding Window.

---

# 🚀 Approach 2: Prefix Sum

## 💡 Intuition

Convert every character into a binary value:

    vowel → 1
    consonant → 0

Then build a prefix sum array.

For example:

    s = "abc"

becomes:

    [1,0,0]

The prefix sum allows us to calculate the number of vowels in
any substring in O(1).

---

# 🔄 Algorithm

1. Convert each character conceptually into:
   - `1` if it is a vowel.
   - `0` if it is a consonant.
2. Build a prefix sum array.
3. For every substring of length `k`, calculate its vowel count.
4. Track the maximum.

---

# ⏱️ Time Complexity

Building the prefix sum:

    O(n)

Checking all windows:

    O(n)

Total:

    O(n)

---

# 💾 Space Complexity

The prefix sum array requires:

    O(n)

extra space.

---

# ✅ Advantages

- Linear time.
- Simple range-sum calculation.
- Useful when many different substring queries are required.

---

# ❌ Disadvantages

For this problem, storing all prefix sums is unnecessary.

Only the previous window's vowel count is needed.

Therefore, we can reduce the extra space from:

    O(n)

to:

    O(1)

using Sliding Window.

---

# 🚀 Approach 3: Fixed-Size Sliding Window ⭐ Optimal

## 💡 Intuition

Maintain the number of vowels inside the current window.

First process the first `k` characters.

Then slide the window one character at a time.

When the window moves:

    One character enters.

and:

    One character leaves.

If the incoming character is a vowel:

    vowelCount++

If the outgoing character is a vowel:

    vowelCount--

After every movement:

    maxVowels = max(maxVowels, vowelCount)

---

# 🪟 Sliding Window

Suppose:

    s = "abciiidef"
    k = 3

The windows are:

    "abc"
     ↓
    "bci"
     ↓
    "cii"
     ↓
    "iii"
     ↓
    "iid"
     ↓
    "ide"
     ↓
    "def"

Each window has exactly:

    3

characters.

Instead of recounting all three characters every time,
we update the previous count.

---

# 🔄 Algorithm

1. Count vowels in the first `k` characters.
2. Store this count as `maxVowels`.
3. Start sliding from index `k`.
4. Check the new character entering the window.
5. If it is a vowel, increment `vowelCount`.
6. Check the character leaving the window.
7. If it is a vowel, decrement `vowelCount`.
8. Update `maxVowels`.
9. Continue until the end of the string.
10. Return `maxVowels`.

---

# 🧠 Dry Run

Consider:

    s = "abciiidef"
    k = 3

---

# Step 1: First Window

First three characters:

    "abc"

Vowels:

    a → vowel
    b → consonant
    c → consonant

Therefore:

    vowelCount = 1

So:

    maxVowels = 1

---

# Step 2: Slide

New window:

    "bci"

The new character:

    i

is a vowel.

Therefore:

    vowelCount = 2

The character leaving:

    a

is also a vowel.

Therefore:

    vowelCount = 2 - 1

    = 1

So:

    maxVowels = 1

---

# Step 3: Slide

New window:

    "cii"

New character:

    i

is a vowel.

Therefore:

    vowelCount = 2

Character leaving:

    b

is a consonant.

Therefore:

    vowelCount remains 2

So:

    maxVowels = 2

---

# Step 4: Slide

New window:

    "iii"

New character:

    i

is a vowel.

Therefore:

    vowelCount = 3

Character leaving:

    c

is a consonant.

Therefore:

    vowelCount = 3

Update:

    maxVowels = 3

---

# Step 5: Remaining Windows

The remaining windows cannot contain more than three vowels
because:

    k = 3

Therefore the final answer is:

    3

---

# 🔍 Why Sliding Window Works

Two consecutive windows of the same size differ by only two
characters:

    One enters.
    One leaves.

Therefore, the number of vowels can be updated using only
these two characters.

There is no need to inspect all `k` characters again.

This reduces the work for each window from:

    O(k)

to:

    O(1)

---

# 🧠 Core Formula

When the window moves:

    If incoming is vowel:
        vowelCount++

    If outgoing is vowel:
        vowelCount--

Then:

    maxVowels = max(maxVowels, vowelCount)

This is the fundamental Fixed-Size Sliding Window pattern.

---

# 📊 Approach Comparison

| Approach | Time Complexity | Space Complexity | Best |
|---|---:|---:|---|
| Brute Force | O(n × k), worst O(n²) | O(1) | ❌ |
| Prefix Sum | O(n) | O(n) | Good |
| Fixed Sliding Window | O(n) | O(1) | ✅ |

---

# 🏆 Why Sliding Window Is Optimal

Every character must potentially be examined.

Therefore:

    O(n)

is the optimal time complexity.

The Sliding Window approach processes each character only a
constant number of times.

Therefore:

    Time = O(n)

Only:

    vowelCount
    maxVowels

and pointer-related variables are maintained.

Therefore:

    Space = O(1)

---

# ⏱️ Final Complexity

## Brute Force

    Time: O(n × k)
    Worst Case: O(n²)

    Space: O(1)

---

## Prefix Sum

    Time: O(n)

    Space: O(n)

---

## Fixed-Size Sliding Window

    Time: O(n)

    Space: O(1)

---

# 🎯 Key Observations

1. The substring must have exactly `k` characters.
2. Therefore this is a Fixed-Size Sliding Window problem.
3. We only need the number of vowels in the current window.
4. Store that number in `vowelCount`.
5. Add the incoming vowel.
6. Remove the outgoing vowel.
7. Track the maximum count.
8. A window can contain at most `k` vowels.
9. Every character is processed a constant number of times.
10. Therefore time complexity is O(n).
11. No extra array is needed.
12. Therefore space complexity is O(1).

---

# ⚠️ Common Mistakes

## Mistake 1: Recounting Every Window

Do not scan all `k` characters for every window.

Use:

    incoming
    outgoing

to update the current count.

---

## Mistake 2: Forgetting the Character Leaving

When the window moves, the old first character is removed.

If it is a vowel, decrement:

    vowelCount

---

## Mistake 3: Forgetting the Character Entering

The new character must also be checked.

If it is a vowel:

    vowelCount++

---

## Mistake 4: Updating the Maximum Before Updating the Window

The maximum should be checked after both:

    incoming character

and:

    outgoing character

have been processed.

---

## Mistake 5: Using a Variable-Size Window

The window must always have exactly:

    k

characters.

There is no need to shrink or expand based on the vowel count.

---

## Mistake 6: Incorrect Outgoing Index

When the new character is at:

    right

the outgoing character is:

    right - k

---

# 💼 Interview Questions

### Q1. What pattern does this problem use?

Fixed-Size Sliding Window.

---

### Q2. Why?

Because every substring must have exactly `k` characters.

---

### Q3. What is the optimal time complexity?

    O(n)

---

### Q4. What is the optimal space complexity?

    O(1)

---

### Q5. What information do we maintain?

The number of vowels in the current window.

---

### Q6. How do we update the vowel count?

Add one if the incoming character is a vowel and subtract one
if the outgoing character is a vowel.

---

### Q7. Why is Sliding Window better than brute force?

It avoids recounting characters shared between consecutive
windows.

---

### Q8. Can Prefix Sum solve this problem?

Yes.

But Prefix Sum requires O(n) additional space.

---

### Q9. What type of Sliding Window is this?

Fixed-Size Sliding Window.

---

### Q10. What is the key operation?

When the window moves:

    add incoming
    remove outgoing

---

# 📚 Key Learning

This problem teaches:

- Fixed-Size Sliding Window
- String traversal
- Character classification
- Running count
- Prefix Sum alternative
- Space optimization
- Window transitions

---

# 🧩 Pattern Recognition

Whenever a problem asks for:

- A substring of exactly `k` characters
- Maximum/minimum count of some property
- Number of vowels
- Number of consonants
- Number of special characters
- Maximum frequency inside a fixed window

Think:

    FIXED-SIZE SLIDING WINDOW

General pattern:

    Build first window
          ↓
    Calculate property
          ↓
    Save answer
          ↓
    Add incoming character
          ↓
    Remove outgoing character
          ↓
    Update property
          ↓
    Update answer
          ↓
    Repeat

---

# 🔗 Related Problems

Fixed-Size Sliding Window:

- LeetCode 643 — Maximum Average Subarray I
- LeetCode 1343 — Number of Sub-arrays of Size K and Average ≥ Threshold
- LeetCode 1456 — Maximum Number of Vowels in a Substring of Given Length

Variable-Size Sliding Window:

- LeetCode 209 — Minimum Size Subarray Sum
- LeetCode 3 — Longest Substring Without Repeating Characters
- LeetCode 1004 — Max Consecutive Ones III
- LeetCode 424 — Longest Repeating Character Replacement
- LeetCode 76 — Minimum Window Substring

---

# 🏁 Final Conclusion

There are three major approaches.

## Brute Force

    Time: O(n × k)
    Worst Case: O(n²)
    Space: O(1)

Simple but inefficient because every window is counted from
scratch.

---

## Prefix Sum

    Time: O(n)
    Space: O(n)

Efficient but requires an additional array.

---

## Fixed-Size Sliding Window

    Time: O(n)
    Space: O(1)

This is the optimal approach.

The core idea is:

    Build the first window
          ↓
    Count its vowels
          ↓
    Slide one position
          ↓
    Add incoming vowel
          ↓
    Remove outgoing vowel
          ↓
    Update maximum
          ↓
    Repeat

Therefore:

> **Fixed-Size Sliding Window is the optimal approach because
> it achieves O(n) time and O(1) extra space.**

Final complexity:

    Time: O(n)
    Space: O(1)