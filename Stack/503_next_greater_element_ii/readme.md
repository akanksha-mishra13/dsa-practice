# 503. Next Greater Element II

## Problem
Given a circular integer array, find the next greater
element for every element.

The next element can be searched by wrapping around
to the beginning of the array.

If no greater element exists, return -1.

## Approach: Circular Monotonic Stack

- Traverse the array twice to simulate circular movement.
- Use modulo (%) to wrap around the array.
- Maintain indices in a decreasing monotonic stack.
- When a greater element is found, update the answer
  for the index at the stack top.
- Push indices only during the first traversal.

## Complexity
- Time Complexity: O(n)
- Space Complexity: O(n)

## Key Concept
Traversing twice with modulo simulates a circular array.
Each index is pushed and popped at most once.