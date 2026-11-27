# 1047. Remove All Adjacent Duplicates In String

## Problem
Given a string, repeatedly remove two adjacent
characters if they are equal.

Return the final string after all removals.

## Approach: Stack

- Traverse the string character by character.
- If the current character matches the stack top,
  remove the top character.
- Otherwise, push the current character.
- Return the remaining characters.

A StringBuilder is used as a stack.

## Complexity
- Time Complexity: O(n)
- Space Complexity: O(n)

## Key Concept
Removing a pair can create a new adjacent duplicate.
The stack automatically handles these newly formed pairs.