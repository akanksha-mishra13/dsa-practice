# 496. Next Greater Element I

## Problem
For every element in nums1, find the first greater
element to its right in nums2.

If no greater element exists, return -1.

## Approach: Monotonic Decreasing Stack

- Traverse nums2 from left to right.
- If the current element is greater than the stack top,
  it is the next greater element for that stack value.
- Store the answer in a HashMap.
- Use nums1 to retrieve the required answers.

## Complexity
- Time Complexity: O(n + m)
- Space Complexity: O(n + m)

Here, n and m are the lengths of nums1 and nums2.

## Key Concept
A monotonic decreasing stack efficiently finds
the next greater element.