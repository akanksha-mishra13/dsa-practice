# 150. Evaluate Reverse Polish Notation

## Problem
Evaluate an arithmetic expression written in
Reverse Polish Notation (RPN).

The expression contains integers and operators:
+, -, *, and /.

## Approach: Stack

- Push numbers onto the stack.
- When an operator appears, pop two numbers.
- Apply the operator in the correct order:
  first popped = second operand,
  second popped = first operand.
- Push the calculated result back.
- The final stack value is the answer.

## Complexity
- Time Complexity: O(n)
- Space Complexity: O(n)

## Key Concept
For subtraction and division, operand order matters.
If the popped values are b and a, calculate a - b
or a / b, respectively.