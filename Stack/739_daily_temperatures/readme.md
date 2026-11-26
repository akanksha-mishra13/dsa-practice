# 739. Daily Temperatures

## Problem
Given an array of daily temperatures, find how many
days each day must wait for a warmer temperature.

If no warmer day exists, store 0.

## Approach: Monotonic Stack

- Store indices of days in the stack.
- Traverse the temperature array.
- If the current temperature is warmer than the
  temperature at the stack's top index:
  - Pop that index.
  - Calculate the waiting days.
  - Store the difference in the answer array.
- Push the current index.

## Complexity
- Time Complexity: O(n)
- Space Complexity: O(n)

## Key Concept
A monotonic decreasing stack maintains indices
whose temperatures are in decreasing order.

Each index is pushed and popped at most once.