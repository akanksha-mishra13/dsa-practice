# 74. Search a 2D Matrix

## Problem
Search for a target in a 2D matrix where:
- Each row is sorted in ascending order.
- The first element of each row is greater than the last element of the previous row.

Return true if the target exists, otherwise false.

## Approach: Binary Search

Treat the 2D matrix as a single sorted 1D array.

Convert a 1D index into matrix coordinates:
- Row = mid / number of columns
- Column = mid % number of columns

Apply normal binary search to find the target.

## Complexity
- Time Complexity: O(log(m × n))
- Space Complexity: O(1)

## Key Concept
A sorted 2D matrix can be searched using binary search
by mapping virtual 1D indices to 2D coordinates.