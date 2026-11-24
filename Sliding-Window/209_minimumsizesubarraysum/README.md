LeetCode 209 — Minimum Size Subarray Sum
🔗 Problem

Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target.

If no such subarray exists, return 0.

💡 Approach

This is a Variable Size Sliding Window problem.

Unlike the previous problems, the window size is not fixed.

We expand the window using right.

When:

sum >= target

we try to shrink the window from the left because we want the minimum possible length.

Steps
1.Start left = 0.
2.Move right through the array.
3.Add nums[right] to the sum.
4.While sum >= target:
Update the minimum length.
Remove nums[left].
Move left.
5.Return the minimum length.

Example
target = 7
nums = [2,3,1,2,4,3]

A valid subarray is:

[4,3]

Sum:4 + 3 = 7
Length:2
Answer:2

⏱ Complexity

Time Complexity: O(n)

Space Complexity: O(1)