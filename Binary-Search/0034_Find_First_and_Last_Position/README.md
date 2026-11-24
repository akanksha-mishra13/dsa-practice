# 34. Find First and Last Position of Element in Sorted Array

Difficulty: Medium
Topics: Array, Binary Search

## Problem
Given a sorted array, find the first and last positions
of a target element.

Return [-1, -1] if the target does not exist.

## Approach 1: Linear Search

Traverse the array and record the first and last occurrence.

Time Complexity: O(n)
Space Complexity: O(1)

## Approach 2: Modified Binary Search (Optimal)

Perform two independent binary searches.

First Search:
- When target is found, save its index.
- Continue searching the left half.
- This finds the first occurrence.

Second Search:
- When target is found, save its index.
- Continue searching the right half.
- This finds the last occurrence.

Time Complexity: O(log n)
Space Complexity: O(1)

## Example

Input:
nums = [5,7,7,8,8,10]
target = 8

Output:
[3,4]

## Why Two Searches?

Finding the target once is not enough because duplicates
may exist on either side.

We must continue searching after finding it.

## Best Approach

Modified Binary Search.

## Key Learning

Binary Search can find boundary positions in sorted arrays,
not just the index of an element.