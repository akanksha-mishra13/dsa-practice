Sliding Window — LeetCode Problems

This section contains 5 important LeetCode problems based on the Sliding Window technique.

The problems cover both major types of sliding window:

Fixed Size Sliding Window
Variable Size Sliding Window

The goal is to understand how to avoid repeatedly processing the same elements and reduce unnecessary time complexity.

What is Sliding Window?

Sliding Window is a technique used mainly for problems involving:

Arrays
Strings
Subarrays
Substrings
Consecutive elements

Instead of checking every possible subarray or substring separately, we maintain a window using two pointers:

left → beginning of window
right → end of window

As right moves forward, we add elements to the window.

When the window violates a condition, we move left forward to make the window valid again.

General Template
int left = 0;

for (int right = 0; right < n; right++) {

    // Add nums[right] to the window

    while (window is invalid) {
        // Remove nums[left]
        left++;
    }

    // Update answer
}