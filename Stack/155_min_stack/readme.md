# 155. Min Stack

## Problem
Design a stack that supports:
- push()
- pop()
- top()
- getMin()

All operations must work in O(1) time.

## Approach: Two Stacks

1. Main stack stores all elements.
2. Minimum stack stores the minimum values.

When pushing:
- Push into the main stack.
- Push into the minimum stack if the value is
  smaller than or equal to its current minimum.

When popping:
- Remove from the main stack.
- If the removed value equals the minimum,
  also pop from the minimum stack.

## Complexity
- Push: O(1)
- Pop: O(1)
- Top: O(1)
- GetMin: O(1)
- Space Complexity: O(n)

## Key Concept
An auxiliary stack helps track the minimum element
without searching through the entire stack.