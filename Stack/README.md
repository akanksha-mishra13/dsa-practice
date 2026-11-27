# Stack – Data Structures and Algorithms

## 1. Introduction

A Stack is a linear data structure that follows the **LIFO (Last In, First Out)** principle.

The element inserted last is removed first.

Example:
- Push 10
- Push 20
- Push 30
- Pop

The removed element is 30.

## 2. Basic Stack Operations

| Operation | Description | Time Complexity |
|---|---|---|
| Push | Insert an element | O(1) |
| Pop | Remove the top element | O(1) |
| Peek / Top | View the top element | O(1) |
| isEmpty | Check whether stack is empty | O(1) |
| Search | Find an element | O(n) |

## 3. Stack Implementation in Java

Java provides the Stack class through `java.util.Stack`.

Important methods:
- `push()` – Inserts an element.
- `pop()` – Removes and returns the top element.
- `peek()` – Returns the top element without removing it.
- `isEmpty()` – Checks whether the stack is empty.
- `size()` – Returns the number of elements.

## 4. Important Stack Patterns

### A. Matching Parentheses
Use a stack to match opening and closing brackets.

### B. Auxiliary Stack
Use an additional stack to maintain extra information, such as the minimum element.

### C. Expression Evaluation
Use a stack to store operands and evaluate arithmetic expressions.

### D. Monotonic Stack
Maintain elements in increasing or decreasing order to efficiently solve next greater or smaller element problems.

## 5. Problems Solved

### 20. Valid Parentheses
**Folder:** `0020_valid_parentheses`

- Approach: Stack
- Push opening brackets.
- Pop and match when a closing bracket appears.
- The stack must be empty at the end.
- Time Complexity: O(n)
- Space Complexity: O(n)

### 155. Min Stack
**Folder:** `0155_min_stack`

- Approach: Two Stacks
- Main stack stores all elements.
- Minimum stack tracks minimum values.
- Supports retrieving the minimum in constant time.
- Push: O(1)
- Pop: O(1)
- Top: O(1)
- GetMin: O(1)
- Space Complexity: O(n)

### 150. Evaluate Reverse Polish Notation
**Folder:** `0150_evaluate_reverse_polish_notation`

- Approach: Stack-based Expression Evaluation
- Push operands.
- Pop two operands when an operator appears.
- Perform the operation and push the result.
- Time Complexity: O(n)
- Space Complexity: O(n)

### 739. Daily Temperatures
**Folder:** `0739_daily_temperatures`

- Approach: Monotonic Decreasing Stack
- Store indices of temperatures.
- Pop indices when a warmer temperature is found.
- Calculate the difference between current and previous indices.
- Time Complexity: O(n)
- Space Complexity: O(n)

## 6. Important Interview Concepts

1. LIFO principle
2. Stack overflow and underflow
3. Balanced parentheses
4. Auxiliary stack
5. Expression evaluation
6. Next greater element
7. Monotonic increasing and decreasing stacks

## 7. When to Use a Stack

Use a stack when:
- The most recent element must be processed first.
- You need to match brackets.
- You need to reverse or evaluate expressions.
- You need to find the next greater or smaller element.
- You need to maintain previous elements efficiently.

## 8. Learning Goal

Understand stack operations, recognize stack-based problem patterns, and solve problems using optimal time and space complexity.