# 33. Search in Rotated Sorted Array

Difficulty: Medium
Topics: Array, Binary Search

## Problem
A sorted array is rotated at an unknown pivot.

Find the target and return its index.
Return -1 if it does not exist.

All elements are distinct.

## Approach 1: Linear Search

Check every element until the target is found.

Time Complexity: O(n)
Space Complexity: O(1)

## Approach 2: Modified Binary Search (Optimal)

Even after rotation, at least one half of the current
search range is always sorted.

1. Calculate mid.
2. If nums[mid] equals target, return mid.
3. Check whether the left half is sorted.
4. If sorted, check whether target belongs to that half.
5. Otherwise search the right half.
6. If the left half is not sorted, the right half is sorted.
7. Check whether target belongs to the right half.
8. Eliminate the irrelevant half.

Time Complexity: O(log n)
Space Complexity: O(1)

## Example

Input:
nums = [4,5,6,7,0,1,2]
target = 0

Output:
4

## Important Observation

At least one half is always sorted.

Use the sorted half to decide which part to eliminate.

## Best Approach

Modified Binary Search.

## Key Learning

Binary Search can work on rotated sorted arrays by
identifying the sorted half at every iteration.