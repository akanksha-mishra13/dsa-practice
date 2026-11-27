# 704. Binary Search

Difficulty: Easy
Topics: Array, Binary Search

## Problem
Given a sorted integer array nums and an integer target,
return the index of target if it exists. Otherwise return -1.

## Approach 1: Linear Search

Check every element until the target is found.

Time Complexity: O(n)
Space Complexity: O(1)

## Approach 2: Binary Search (Optimal)

Since the array is sorted, compare the target with the
middle element.

1. Initialize left = 0 and right = n - 1.
2. Calculate the middle index.
3. If middle element equals target, return mid.
4. If middle element is smaller, search the right half.
5. Otherwise, search the left half.
6. Continue until the target is found or the range becomes empty.

Time Complexity: O(log n)
Space Complexity: O(1)

## Why Binary Search?

Every comparison eliminates approximately half of the
remaining search space.

## Best Approach

Iterative Binary Search.

It achieves O(log n) time and O(1) extra space.

## Important Formula

mid = left + (right - left) / 2

## Key Learning

Binary Search works on sorted arrays and repeatedly
reduces the search space by half.