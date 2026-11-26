# 20. Valid Parentheses

## Problem
Given a string containing brackets, determine whether
the brackets are valid and correctly balanced.

## Approach: Stack

- Push every opening bracket onto the stack.
- For a closing bracket, check whether the stack is empty.
- Pop the top element and check whether it matches.
- At the end, the stack must be empty.

## Complexity
- Time Complexity: O(n)
- Space Complexity: O(n)

## Key Concept
A stack follows LIFO (Last In, First Out).
The most recently opened bracket must be closed first.