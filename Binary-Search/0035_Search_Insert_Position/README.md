# 35. Search Insert Position

Difficulty: Easy
Topics: Array, Binary Search

## Problem
Given a sorted array and a target, return its index if found.
Otherwise return the index where it should be inserted to
maintain sorted order.

## Approach 1: Linear Search

Traverse the array and find the first element greater than
or equal to the target.

Time Complexity: O(n)
Space Complexity: O(1)

## Approach 2: Binary Search (Optimal)

1. Initialize left = 0 and right = n - 1.
2. Calculate mid.
3. If nums[mid] equals target, return mid.
4. If nums[mid] is smaller, move left to mid + 1.
5. Otherwise move right to mid - 1.
6. If the loop ends, return left.

Time Complexity: O(log n)
Space Complexity: O(1)

## Important Observation

When the loop ends, left represents the correct insertion
position.

This is also known as the lower-bound position.

## Best Approach

Binary Search.

## Key Learning

Binary Search can find both an existing element and the
correct insertion position of a missing element.