# 875. Koko Eating Bananas

## Problem
Koko has several piles of bananas and h hours to eat them.

She eats at a fixed speed of k bananas per hour.
Find the minimum eating speed that allows her to finish
all piles within h hours.

## Approach: Binary Search on Answer

The minimum possible speed is 1.
The maximum possible speed is the largest pile.

For each middle speed:
- Calculate the total hours required.
- If hours <= h, the speed is sufficient.
- Otherwise, increase the speed.

Find the smallest valid speed.

## Complexity
- Time Complexity: O(n log m)
- Space Complexity: O(1)

Here, n is the number of piles and m is the maximum pile size.

## Key Concept
Binary search can be applied to possible answers
when a condition changes monotonically from invalid to valid.