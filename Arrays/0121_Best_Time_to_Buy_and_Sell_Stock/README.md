# 0121. Best Time to Buy and Sell Stock

> **Difficulty:** Easy  
> **Topic(s):** Arrays, Greedy  
> **Pattern:** Prefix Minimum Tracking  
> **Platform:** LeetCode

---

# 📖 Problem Statement

You are given an array `prices` where `prices[i]` is the price of a given stock on the `i-th` day.

You want to maximize your profit by choosing a single day to buy one stock and a different future day to sell that stock.

Return the maximum profit you can achieve.

If no profit is possible, return `0`.

**Problem Link:** https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

---

# 📝 Example

### Example 1

**Input**

prices = [7,1,5,3,6,4]

**Output**

4

**Explanation**

Buy on day 2 (price = 1) and sell on day 5 (price = 6).

Profit = 6 - 1 = 5

---

### Example 2

**Input**

prices = [7,6,4,3,1]

**Output**

0

**Explanation**

The prices always decrease, so no profit can be made.

---

# 🔒 Constraints

- 1 <= prices.length <= 10⁵
- 0 <= prices[i] <= 10⁴

---

# 🎯 Intuition

To maximize profit, we should always buy at the lowest price seen so far and calculate the profit if we sell on the current day.

Instead of checking every possible buy and sell pair, we continuously track the minimum price and the maximum profit while traversing the array once.

---

# 🚀 Approach 1: Brute Force

## Idea

Check every possible buying day with every possible selling day.

Calculate the profit for each pair.

Return the maximum profit.

## Algorithm

1. Select every day as the buying day.
2. Compare it with every future selling day.
3. Compute the profit.
4. Keep track of the maximum profit.

## Time Complexity

O(n²)

## Space Complexity

O(1)

## Advantages

- Easy to understand.
- Straightforward implementation.

## Disadvantages

- Very slow for large inputs.

---

# 🚀 Approach 2: Optimal (Greedy / Prefix Minimum)

## Idea

Maintain the minimum stock price encountered so far.

For each day:

- Update the minimum price if today's price is smaller.
- Otherwise, calculate the profit if sold today.
- Update the maximum profit if the current profit is greater.

This ensures that every selling price is paired with the best buying price seen before it.

---

## Algorithm

1. Initialize:
   - `minPrice` as a very large value.
   - `maxProfit` as `0`.
2. Traverse the array.
3. If the current price is less than `minPrice`, update `minPrice`.
4. Otherwise, calculate:
   - `currentProfit = currentPrice - minPrice`
5. Update `maxProfit` if `currentProfit` is greater.
6. Return `maxProfit`.

---

# 🧠 Dry Run

Input:

prices = [7,1,5,3,6,4]

- Day 1: minPrice = 7, profit = 0
- Day 2: minPrice = 1
- Day 3: profit = 5 - 1 = 4 → maxProfit = 4
- Day 4: profit = 3 - 1 = 2 → maxProfit = 4
- Day 5: profit = 6 - 1 = 5 → maxProfit = 5
- Day 6: profit = 4 - 1 = 3 → maxProfit = 5

Final Answer = 5

---

# 📊 Complexity Comparison

| Approach | Time | Space |
|----------|------|-------|
| Brute Force | O(n²) | O(1) |
| Greedy (Optimal) | O(n) | O(1) |

---

# ✅ Why is this the Optimal Solution?

- Only one traversal of the array is required.
- No extra data structures are used.
- Always keeps track of the best buying opportunity seen so far.
- Produces the maximum possible profit efficiently.

---

# 🎯 Key Observations

- Selling must always happen after buying.
- The best buying day is the minimum price encountered before the current day.
- There is no need to compare every pair of days.

---

# 📚 Key Learning

- Greedy algorithm
- Prefix minimum concept
- One-pass array traversal
- Optimizing nested loop problems

---

# 💼 Interview Questions

### Why doesn't this require two nested loops?

Because the minimum buying price can be maintained while traversing the array once.

---

### Why initialize profit to 0?

If no profitable transaction exists, the answer should be 0.

---

### Can this problem be solved using Dynamic Programming?

Yes, but it is unnecessary because the greedy solution is simpler and already optimal.

---

# ✅ Conclusion

The Greedy approach efficiently solves the problem by tracking the minimum buying price and the maximum achievable profit in a single pass. It runs in **O(n)** time with **O(1)** extra space, making it the optimal solution.