# 162. Find Peak Element

## Problem
A peak element is an element that is strictly greater
than its neighboring elements.

Find and return the index of any peak element.

Assume nums[-1] and nums[n] are negative infinity.

## Approach: Binary Search

Compare nums[mid] with nums[mid + 1].

- If nums[mid] > nums[mid + 1], a peak exists at mid
  or somewhere on its left.
- Otherwise, a peak exists on the right.

Keep reducing the search range until one index remains.

## Complexity
- Time Complexity: O(log n)
- Space Complexity: O(1)

## Key Concept
Follow the direction of the increasing slope to locate
a peak without checking every element.