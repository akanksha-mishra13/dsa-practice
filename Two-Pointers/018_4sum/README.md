# 0018. 4Sum

> Difficulty: Medium  
> Topics: Array, Sorting, Two Pointers  
> Pattern: Sorting + Two Pointers  
> Platform: LeetCode

---

# 📖 Problem Statement

Given an integer array `nums` and an integer `target`, return all unique
quadruplets:

    [nums[a], nums[b], nums[c], nums[d]]

such that:

    a != b
    a != c
    a != d
    b != c
    b != d
    c != d

and:

    nums[a] + nums[b] + nums[c] + nums[d] == target

The returned answer must not contain duplicate quadruplets.

The order of the quadruplets does not matter.

---

# 🔗 Problem Link

https://leetcode.com/problems/4sum/

---

# 📝 Example 1

Input:

    nums = [1,0,-1,0,-2,2]
    target = 0

Output:

    [
        [-2,-1,1,2],
        [-2,0,0,2],
        [-1,0,0,1]
    ]

---

# 📝 Example 2

Input:

    nums = [2,2,2,2,2]
    target = 8

Output:

    [[2,2,2,2]]

Even though there are multiple ways to select four `2`s,
the same quadruplet must appear only once.

---

# 🔒 Constraints

- 1 <= nums.length <= 200
- -10^9 <= nums[i] <= 10^9
- -10^9 <= target <= 10^9

---

# 🎯 Goal

We need to find every unique combination of four numbers whose sum equals
the target.

The important challenges are:

1. Finding four elements efficiently.
2. Avoiding duplicate quadruplets.
3. Handling negative and positive numbers.
4. Handling large integer values safely.
5. Keeping the solution efficient enough for the constraints.

---

# 🚀 Approach 1: Brute Force

## 💡 Intuition

The simplest approach is to choose every possible group of four elements.

We can use four nested loops:

    i
    j
    k
    l

For every combination, calculate:

    nums[i] + nums[j] + nums[k] + nums[l]

If the sum equals the target, store the quadruplet.

---

# 🔄 Algorithm

1. Choose the first element.
2. Choose the second element.
3. Choose the third element.
4. Choose the fourth element.
5. Calculate their sum.
6. If the sum equals the target, store the quadruplet.
7. Remove duplicate quadruplets.
8. Continue until every combination has been checked.

---

# ⏱️ Time Complexity

There are four nested loops.

Therefore:

    O(n^4)

This is extremely expensive for large arrays.

---

# 💾 Space Complexity

Ignoring the output:

    O(1)

Additional space may be required if a data structure is used
to remove duplicate results.

---

# ❌ Why Brute Force Is Not Optimal

The number of combinations grows very quickly.

For an array of size `n`, we potentially examine:

    O(n^4)

combinations.

This makes brute force unsuitable for the problem constraints.

We need to reduce the number of nested searches.

---

# 🚀 Approach 2: HashSet

## 💡 Intuition

Another approach is to fix two elements and use a HashSet to search
for the remaining two values.

After fixing:

    nums[i]
    nums[j]

we need:

    nums[k] + nums[l]
        =
    target - nums[i] - nums[j]

A HashSet can help determine whether a required value exists.

---

# 🔄 Algorithm

1. Fix the first element.
2. Fix the second element.
3. Traverse the remaining elements.
4. Use a HashSet to search for required values.
5. Store valid quadruplets.
6. Use a set to remove duplicates.

---

# ⏱️ Time Complexity

Depending on implementation:

    O(n^3)

The outer loops select two elements and another traversal
searches for the remaining values.

---

# 💾 Space Complexity

The HashSet requires:

    O(n)

additional space.

---

# ❌ Why It Is Not the Preferred Approach

Although it improves over brute force, it requires additional memory
and duplicate handling can become complicated.

The sorted Two Pointer approach is more structured and gives:

    O(n^3)

time
    O(1)

auxiliary space excluding output.

---

# 🚀 Approach 3: Sorting + Two Pointers ⭐ Optimal

## 💡 Intuition

The best standard approach extends the idea used in 3Sum.

For 3Sum we used:

    Fix one element
    +
    Two Pointers

For 4Sum we use:

    Fix two elements
    +
    Two Pointers

First sort the array.

Then:

1. Fix `i`.
2. Fix `j`.
3. Use `left` and `right` to find the remaining two values.

The four elements are:

    nums[i]
    nums[j]
    nums[left]
    nums[right]

We want:

    nums[i] + nums[j] + nums[left] + nums[right] = target

---

# 🔑 Why Sorting Is Important

After sorting:

    [-2,-1,0,0,1,2]

we know that:

- Moving `left` forward increases the sum.
- Moving `right` backward decreases the sum.

Therefore, we can intelligently move the pointers instead of
checking every possible pair.

---

# 🔄 Algorithm

1. Sort the array.
2. Loop through the first element using `i`.
3. Skip duplicate `i` values.
4. Loop through the second element using `j`.
5. Skip duplicate `j` values.
6. Set:

       left = j + 1

       right = n - 1

7. Calculate the four-element sum.
8. If the sum equals the target:
   - Store the quadruplet.
   - Skip duplicate `left` values.
   - Skip duplicate `right` values.
   - Move both pointers.
9. If the sum is smaller than the target:
   - Move `left` forward.
10. If the sum is larger than the target:
   - Move `right` backward.
11. Continue until `left >= right`.
12. Continue with the next `j`.
13. Continue with the next `i`.

---

# 🧠 Pointer Logic

Suppose:

    sum < target

We need a larger sum.

Because the array is sorted, increase `left`:

    left++

This moves toward a larger value.

---

If:

    sum > target

We need a smaller sum.

Because the array is sorted, decrease `right`:

    right--

This moves toward a smaller value.

---

If:

    sum == target

We found a valid quadruplet.

Store it and move both pointers.

---

# 🧠 Dry Run

Consider:

    nums = [1,0,-1,0,-2,2]
    target = 0

First sort:

    [-2,-1,0,0,1,2]

---

## Step 1: Fix i

Take:

    nums[i] = -2

Now choose:

    nums[j] = -1

Set:

    left = 2
    right = 5

Values:

    -2, -1, 0, 2

Sum:

    -2 + -1 + 0 + 2
    = -1

The sum is smaller than target:

    -1 < 0

Therefore:

    left++

---

## Continue

Eventually:

    -2 + -1 + 1 + 2 = 0

We found:

    [-2,-1,1,2]

Add it to the result.

---

## Next j

Now choose:

    nums[j] = 0

The two pointers search for:

    [-2,0,0,2]

Sum:

    -2 + 0 + 0 + 2 = 0

Store:

    [-2,0,0,2]

---

## Next i

Eventually:

    nums[i] = -1

The algorithm finds:

    [-1,0,0,1]

So the final result becomes:

    [
        [-2,-1,1,2],
        [-2,0,0,2],
        [-1,0,0,1]
    ]

---

# 🔍 Duplicate Handling

Duplicate handling is extremely important in 4Sum.

For example:

    [2,2,2,2,2]

with target:

    8

There is only one unique answer:

    [2,2,2,2]

We must prevent the algorithm from adding the same quadruplet
multiple times.

---

# 1️⃣ Skip Duplicate i

After processing an `i`, if:

    nums[i] == nums[i - 1]

skip it.

This prevents duplicate first elements.

---

# 2️⃣ Skip Duplicate j

Similarly, after processing a `j`, if:

    nums[j] == nums[j - 1]

skip it.

This prevents duplicate second elements.

---

# 3️⃣ Skip Duplicate left

After finding a valid quadruplet, if:

    nums[left] == nums[left + 1]

move `left` forward until a different value is found.

---

# 4️⃣ Skip Duplicate right

Similarly:

    nums[right] == nums[right - 1]

means we should move `right` backward.

---

# 🧠 Why Do We Use long?

The values can be as large as:

    10^9

Adding four such values can exceed the safe range of a Java `int`.

For example:

    1,000,000,000
    + 1,000,000,000
    + 1,000,000,000
    + 1,000,000,000

equals:

    4,000,000,000

which is larger than Java's maximum `int` value:

    2,147,483,647

Therefore, the sum should be calculated using `long`.

This prevents integer overflow.

---

# 🔍 Why Move left When sum < target?

Suppose:

    sum < target

The current sum is too small.

Because the array is sorted, increasing `left` selects
a larger number.

Therefore:

    left++

can increase the total sum.

---

# 🔍 Why Move right When sum > target?

Suppose:

    sum > target

The current sum is too large.

Because the array is sorted, decreasing `right` selects
a smaller number.

Therefore:

    right--

can reduce the total sum.

---

# 🏆 Why This Approach Is Optimal

The algorithm fixes two elements using two loops:

    O(n²)

For every pair, it uses two pointers:

    O(n)

Therefore:

    O(n²) × O(n)
    
    = O(n³)

The initial sorting takes:

    O(n log n)

Therefore total complexity is:

    O(n log n + n³)

which simplifies to:

    O(n³)

This is significantly better than:

    O(n⁴)

from brute force.

---

# 📊 Approach Comparison

| Approach | Time Complexity | Extra Space | Best? |
|---|---:|---:|---|
| Brute Force | O(n⁴) | O(1)* | ❌ |
| HashSet | O(n³) | O(n) | Good |
| Sorting + Two Pointers | O(n³) | O(1)* | ✅ |

`*` Output space is excluded.

---

# ⏱️ Final Complexity

## Brute Force

    Time: O(n⁴)
    Space: O(1)*

## HashSet

    Time: O(n³)
    Space: O(n)

## Sorting + Two Pointers

    Time: O(n³)
    Space: O(1)*

`*` Excluding the output.

---

# 🎯 Key Observations

1. 4Sum is an extension of 3Sum.
2. Sort the array first.
3. Fix two elements.
4. Use two pointers for the remaining two elements.
5. If the sum is too small, increase `left`.
6. If the sum is too large, decrease `right`.
7. If the sum equals the target, store the quadruplet.
8. Skip duplicate `i` values.
9. Skip duplicate `j` values.
10. Skip duplicate `left` values.
11. Skip duplicate `right` values.
12. Use `long` for the sum to prevent integer overflow.
13. Sorting takes `O(n log n)`.
14. The two-pointer search takes `O(n)` for each pair.
15. Overall complexity is `O(n³)`.

---

# ⚠️ Common Mistakes

## Mistake 1: Using int for the Sum

Do not calculate the complete sum using only `int`.

Use:

    long sum

to avoid integer overflow.

---

## Mistake 2: Not Sorting

Without sorting, pointer movement cannot be used effectively.

---

## Mistake 3: Not Skipping Duplicate i

This can produce duplicate quadruplets.

---

## Mistake 4: Not Skipping Duplicate j

This can also produce duplicate quadruplets.

---

## Mistake 5: Not Skipping Duplicate Pointers

After finding a valid quadruplet, duplicate values at
`left` and `right` must be skipped.

---

## Mistake 6: Moving the Wrong Pointer

Remember:

    sum < target → left++

    sum > target → right--

---

## Mistake 7: Using Four Nested Loops

That produces:

    O(n⁴)

and is unnecessarily slow.

---

# 💼 Interview Questions

### Q1. What is the optimal approach for 4Sum?

Sorting followed by Two Pointers.

---

### Q2. What is the time complexity?

    O(n³)

---

### Q3. Why is it O(n³)?

Two loops fix the first two elements:

    O(n²)

The two-pointer scan takes:

    O(n)

Therefore:

    O(n² × n) = O(n³)

---

### Q4. Why do we sort the array?

Sorting allows us to determine which pointer to move based
on whether the current sum is smaller or larger than the target.

---

### Q5. Why do we move left when the sum is too small?

Because the array is sorted and increasing `left` increases the sum.

---

### Q6. Why do we move right when the sum is too large?

Because decreasing `right` moves to a smaller value and reduces the sum.

---

### Q7. How do you avoid duplicate quadruplets?

Skip duplicates for:

    i
    j
    left
    right

---

### Q8. Why is long used instead of int?

Because adding four values near `10^9` can exceed the range of
Java's `int`.

---

### Q9. What is the space complexity?

Excluding the output:

    O(1)

auxiliary space for the pointer-based algorithm, subject to the
sorting implementation.

---

### Q10. What problem is 4Sum based on?

It is a natural extension of 3Sum.

The pattern is:

    2Sum → Two Pointers
    3Sum → Fix 1 + Two Pointers
    4Sum → Fix 2 + Two Pointers

---

# 📚 Key Learning

This problem teaches:

- Sorting
- Two Pointer technique
- Nested pointer searching
- Duplicate handling
- Array manipulation
- Integer overflow
- Target-sum problems
- Complexity optimization
- Combination problems

---

# 🧩 Pattern Recognition

When you see a problem asking for:

    Four elements
    +
    A target sum
    +
    Unique combinations

Think:

    SORT
    ↓
    FIX TWO ELEMENTS
    ↓
    TWO POINTERS
    ↓
    SKIP DUPLICATES

The general pattern is:

    nums[i] + nums[j] + nums[left] + nums[right]

Then:

    sum < target → left++

    sum > target → right--

    sum == target → store + skip duplicates

---

# 🔗 Related Problems

This pattern connects directly to:

- LeetCode 1 — Two Sum
- LeetCode 15 — 3Sum
- LeetCode 16 — 3Sum Closest
- LeetCode 18 — 4Sum
- LeetCode 167 — Two Sum II
- LeetCode 259 — 3Sum Smaller

---

# 🏁 Final Conclusion

There are three main approaches.

## Brute Force

    Time: O(n⁴)

Simple but inefficient.

---

## HashSet

    Time: O(n³)
    Space: O(n)

Better than brute force but requires additional memory.

---

## Sorting + Two Pointers

    Time: O(n³)
    Space: O(1)*

This is the preferred optimal standard solution.

The core idea is:

    Sort
      ↓
    Fix first element
      ↓
    Fix second element
      ↓
    Use left and right pointers
      ↓
    Find target sum
      ↓
    Skip duplicates

Therefore:

> **Sorting + Two Pointers is the best approach for 4Sum.**

Final complexity:

    Time: O(n³)
    Space: O(1)*

`*` Excluding output space.