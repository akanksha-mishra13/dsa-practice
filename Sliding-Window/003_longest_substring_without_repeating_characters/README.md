# LeetCode 3 — Longest Substring Without Repeating Characters

## 📌 Problem

Given a string `s`, find the length of the longest substring without repeating characters.

---

## 💡 Approach

This problem is solved using **Variable Size Sliding Window + HashSet**.

We need to maintain a substring where every character is unique.

We use:

```text
left  → starting position of window
right → ending position of window
```

A `HashSet` is used to keep track of the characters currently present in the window.

---

## 🧠 Main Idea

As `right` moves forward, we add characters to the window.

If the current character is already present in the `HashSet`, we have a duplicate.

Therefore, we remove characters from the left until the duplicate character is removed.

Then we add the current character and update the maximum length.

---

## 🔍 Example

```text
s = "abcabcbb"
```

Start with an empty window.

### Step 1

```text
"a"
```

No duplicate.

Length:

```text
1
```

### Step 2

```text
"ab"
```

No duplicate.

Length:

```text
2
```

### Step 3

```text
"abc"
```

No duplicate.

Length:

```text
3
```

### Step 4

The next character is `a`.

Current window:

```text
"abc"
```

`a` already exists.

So we remove characters from the left:

```text
"abc"
 ↑
left
```

Remove `a`.

Window becomes:

```text
"bc"
```

Now we can add the new `a`:

```text
"bca"
```

Length:

```text
3
```

The longest substring remains:

```text
"abc"
```

Therefore:

```text
Answer = 3
```

---

## 💻 Java Solution

```java
import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            maxLength = Math.max(
                maxLength,
                right - left + 1
            );
        }

        return maxLength;
    }
}
```

---

## 🔄 Sliding Window Flow

```text
        right
          ↓
    a b c a b c b b
    ↑
   left
```

When `right` finds a duplicate:

```text
while (duplicate exists)
        ↓
remove s[left]
        ↓
left++
        ↓
check again
```

Once the duplicate is removed, the window becomes valid again.

---

## 📌 Important Code Logic

### Check for duplicate

```java
while (set.contains(s.charAt(right))) {
```

If the current character already exists, the current window cannot remain valid.

---

### Remove from left

```java
set.remove(s.charAt(left));
left++;
```

We keep shrinking the window until the duplicate disappears.

---

### Add current character

```java
set.add(s.charAt(right));
```

Now the window contains unique characters again.

---

### Update maximum

```java
maxLength = Math.max(
    maxLength,
    right - left + 1
);
```

The current window length is:

```text
right - left + 1
```

---

## 🧠 Why Use HashSet?

A `HashSet` allows us to efficiently check whether a character already exists.

Instead of repeatedly searching through the substring, we can use:

```java
set.contains(character)
```

and:

```java
set.remove(character)
```

This makes the sliding window efficient.

---

## ❌ Brute Force Approach

A brute-force solution would generate every possible substring and check whether it contains duplicate characters.

This can take approximately:

```text
O(n²)
```

or worse depending on how uniqueness is checked.

Sliding Window reduces the overall traversal to:

```text
O(n)
```

---

## ⏱️ Complexity Analysis

### Time Complexity

```text
O(n)
```

Although there is a `while` loop inside the `for` loop, every character is added to and removed from the `HashSet` at most once.

Therefore, the total work is linear.

### Space Complexity

```text
O(min(n, charset))
```

The `HashSet` stores the characters currently present in the window.

For a fixed character set, this is effectively `O(1)`.

---

## 🎯 Pattern

**Pattern:** Variable Size Sliding Window + HashSet

Use this pattern when the problem involves:

* Longest substring
* Shortest substring
* Unique characters
* Duplicate characters
* Frequency/occurrence constraints

---

## 🔑 Key Takeaway

The core pattern is:

```text
right → expand the window
left  → shrink the window
```

For this problem:

```text
If duplicate:
    shrink from left

If valid:
    update maximum
```

The important condition is:

```java
while (set.contains(s.charAt(right))) {
    set.remove(s.charAt(left));
    left++;
}
```

---

## 📊 Complexity

| Complexity | Value                |
| ---------- | -------------------- |
| Time       | `O(n)`               |
| Space      | `O(min(n, charset))` |

---

## 🚀 LeetCode Details

* **Problem:** 3
* **Title:** Longest Substring Without Repeating Characters
* **Difficulty:** Medium
* **Pattern:** Sliding Window
* **Type:** Variable Size Window + HashSet
