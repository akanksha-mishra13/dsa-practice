# 71. Simplify Path

## Problem
Given an absolute Unix-style file path, convert it
into its simplified canonical path.

Rules:
- "." represents the current directory.
- ".." represents the parent directory.
- Multiple consecutive slashes count as one slash.

## Approach: Stack

- Split the path using "/".
- Ignore empty strings and ".".
- For "..", remove the last directory if available.
- Push normal directory names onto the stack.
- Join the remaining directories with "/".

## Complexity
- Time Complexity: O(n)
- Space Complexity: O(n)

## Key Concept
A stack helps move backward through directories
when the parent directory symbol ".." appears.