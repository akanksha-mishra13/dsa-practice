# LeetCode 1004 — Max Consecutive Ones III

## 📌 Problem

Given a binary array `nums` and an integer `k`, return the maximum number of consecutive `1`s in the array if you can flip at most `k` zeros.

---

## 💡 Approach

This problem can be solved using the **Variable Size Sliding Window** technique.

The important observation is that we can have at most `k` zeros inside our current window because we can flip at most `k` zeros into ones.

We maintain:

```text
left  → start of window
right → end of window
zeros → number of zeros inside window
```

### Main Idea

1. Move `right` through the array.
2. If `nums[right] == 0`, increase `zeros`.
3. If `zeros > k`, the window becomes invalid.
4. Move `left` forward until the number of zeros becomes valid again.
5. Calculate the maximum valid window length.

---

## 🔍 Example

```text
nums = [1,1,1,0,0,0,1,1,1,1,0]
k = 2
```

We are allowed to flip at most `2` zeros.

Consider:

```text
[1,1,1,0,0]
```

There are `2` zeros, so this window is valid.

We can flip both zeros:

```text
[1,1,1,1,1]
```

Now suppose we include another zero:

```text
[1,1,1,0,0,0]
```

There are `3` zeros.

Since:

```text
3 > k
```

the window becomes invalid.

So we move `left` forward until only `2` zeros remain.

---

## 💻 Java Solution

```java
class Solution {
    public int longestOnes(int[] nums, int k) {

        int left = 0;
        int zeros = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] == 0) {
                zeros++;
            }

            while (zeros > k) {

                if (nums[left] == 0) {
                    zeros--;
                }

                left++;
            }

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

## 🧠 Why Sliding Window Works

We don't actually need to change every zero into one.

We only need to know how many zeros are inside the current window.

If:

```text
zeros <= k
```

the window is valid.

If:

```text
zeros > k
```

the window is invalid, so we shrink it.

This allows us to find the longest valid window efficiently.

---

## 🔄 Sliding Window Flow

```text
Expand window
     ↓
Count zeros
     ↓
zeros <= k ?
   ↙       ↘
 YES       NO
  ↓         ↓
Valid     Shrink
window    from left
  ↓         ↓
Update    zeros--
answer      ↓
       Continue
```

---

## 📌 Important Code Logic

### Expand the window

```java
if (nums[right] == 0) {
    zeros++;
}
```

Whenever we encounter a zero, we increase the zero count.

### Shrink the window

```java
while (zeros > k) {

    if (nums[left] == 0) {
        zeros--;
    }

    left++;
}
```

If there are too many zeros, move `left` forward until the window becomes valid.

### Update answer

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

## ⏱️ Complexity Analysis

### Time Complexity

```text
O(n)
```

The `right` pointer moves through the array once, and `left` also moves forward at most `n` times.

### Space Complexity

```text
O(1)
```

Only a few variables are used.

---

## 🎯 Pattern

**Pattern:** Variable Size Sliding Window

### Important Condition

```text
Number of zeros <= k
```

The window represents a sequence that can be converted entirely into `1`s using at most `k` flips.

---

## 🔑 Key Takeaway

Remember this pattern:

```text
right → expand
left  → shrink
```

And the most important condition:

```java
while (zeros > k) {
    left++;
}
```

Whenever the number of zeros exceeds the allowed number of flips, shrink the window.

---

## 📊 Complexity

| Complexity | Value  |
| ---------- | ------ |
| Time       | `O(n)` |
| Space      | `O(1)` |

---

## 🚀 LeetCode Details

* **Problem:** 1004
* **Title:** Max Consecutive Ones III
* **Difficulty:** Medium
* **Pattern:** Sliding Window
* **Type:** Variable Size Window
