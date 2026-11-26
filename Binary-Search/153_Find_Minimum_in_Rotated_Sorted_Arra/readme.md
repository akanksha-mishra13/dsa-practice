# 153. Find Minimum in Rotated Sorted Array

## Problem
A sorted array has been rotated at an unknown position.
All elements are distinct.

Find and return the minimum element.

## Approach: Modified Binary Search

Compare the middle element with the rightmost element.

- If nums[mid] > nums[right], the minimum is in the right half.
- Otherwise, the minimum is at mid or in the left half.

Continue reducing the search range until left == right.

## Complexity
- Time Complexity: O(log n)
- Space Complexity: O(1)

## Key Concept
Use the comparison with the right boundary to identify
which half contains the minimum element.