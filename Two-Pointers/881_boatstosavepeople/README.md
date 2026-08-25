# 0881. Boats to Save People

> Difficulty: Medium  
> Topics: Array, Sorting, Two Pointers, Greedy  
> Pattern: Sorting + Two Pointers + Greedy  
> Platform: LeetCode

---

# 📖 Problem Statement

You are given an array `people` where:

    people[i]

represents the weight of the `i-th` person.

You are also given an integer:

    limit

which represents the maximum weight that a rescue boat can carry.

Each boat can carry at most two people.

The total weight of the people in a boat cannot exceed:

    limit

Return the minimum number of boats required to carry everyone.

---

# 🔗 Problem Link

https://leetcode.com/problems/boats-to-save-people/

---

# 📝 Example 1

Input:

    people = [1,2]
    limit = 3

Output:

    1

Explanation:

The two people can share one boat:

    1 + 2 = 3

---

# 📝 Example 2

Input:

    people = [3,2,2,1]
    limit = 3

Output:

    3

Possible arrangement:

    [1,2]
    [2]
    [3]

Therefore:

    3 boats

are required.

---

# 📝 Example 3

Input:

    people = [3,5,3,4]
    limit = 5

Output:

    4

No two people can be paired while staying within the limit.

---

# 🔒 Constraints

- 1 <= people.length <= 5 * 10^4
- 1 <= people[i] <= limit
- 1 <= limit <= 3 * 10^4

---

# 🎯 Goal

We need to minimize the number of boats.

Each boat can contain:

    at most 2 people

and their combined weight must be:

    <= limit

The main challenge is deciding which two people should share
a boat.

---

# 🚀 Approach 1: Brute Force

## 💡 Intuition

A naive idea is to repeatedly search for pairs of people whose
combined weight does not exceed the limit.

For each person, we could search through the remaining people
to find the heaviest possible partner.

This attempts to make as many valid pairs as possible.

---

# 🔄 Algorithm

1. Pick a person.
2. Search for another person who can share a boat.
3. Try to find the best possible partner.
4. Mark both people as transported.
5. Repeat until everyone is transported.

---

# ⏱️ Time Complexity

Searching for partners repeatedly can require:

    O(n²)

time.

---

# 💾 Space Complexity

Depending on implementation:

    O(n)

may be required to track transported people.

---

# ❌ Why Brute Force Is Not Optimal

With:

    n = 50,000

an:

    O(n²)

solution can require billions of operations.

We need a more efficient way to find valid pairs.

---

# 🚀 Approach 2: Sorting + Greedy Search

## 💡 Intuition

Sort the people by weight.

For example:

    [3,2,2,1]

becomes:

    [1,2,2,3]

Now we can easily identify:

    lightest person
    heaviest person

The most important decision is what to do with the heaviest person.

---

# 🔑 Greedy Observation

Consider the heaviest remaining person.

Suppose:

    heaviest = 3
    limit = 5

The best possible partner for this person is the lightest
remaining person.

If:

    lightest + heaviest <= limit

then we can pair them.

If even the lightest person cannot fit with the heaviest person,
then nobody else can fit either because everyone else is heavier.

Therefore, the heaviest person must take a boat alone.

This observation leads directly to the Two Pointer solution.

---

# 🚀 Approach 3: Sorting + Two Pointers + Greedy ⭐ Optimal

## 💡 Intuition

After sorting:

    [1,2,2,3]

maintain two pointers:

    left
    right

where:

    left = lightest remaining person
    right = heaviest remaining person

We always process the heaviest person.

There are only two possibilities.

---

# Case 1: Lightest + Heaviest Can Fit

If:

    people[left] + people[right] <= limit

then put them together in one boat.

Move both pointers:

    left++
    right--

and increase the boat count.

---

# Case 2: Lightest + Heaviest Cannot Fit

If:

    people[left] + people[right] > limit

then the heaviest person cannot share a boat with anyone.

Why?

Because `people[left]` is already the lightest remaining person.

Everyone else weighs at least as much as `people[left]`.

Therefore, no other person can fit with the heaviest person.

So the heaviest person must travel alone.

Move only:

    right--

and increase the boat count.

---

# 🔄 Algorithm

1. Sort the `people` array.
2. Set:

       left = 0

3. Set:

       right = n - 1

4. Initialize:

       boats = 0

5. While:

       left <= right

6. Check whether:

       people[left] + people[right] <= limit

7. If yes:
   - Pair the lightest and heaviest people.
   - Move `left` forward.

8. Regardless of whether pairing occurred:
   - The heaviest person has now been assigned a boat.
   - Move `right` backward.
   - Increment `boats`.

9. Return `boats`.

---

# 🧠 Dry Run

Consider:

    people = [3,2,2,1]
    limit = 3

First sort:

    [1,2,2,3]

Initialize:

    left = 0
    right = 3
    boats = 0

---

# Step 1

Lightest:

    1

Heaviest:

    3

Check:

    1 + 3 = 4

Since:

    4 > 3

they cannot share a boat.

The heaviest person must go alone.

So:

    right--

    boats++

Now:

    boats = 1

---

# Step 2

Remaining:

    [1,2,2]

Pointers:

    left = 0
    right = 2

Values:

    1 and 2

Check:

    1 + 2 = 3

They can share a boat.

Therefore:

    left++
    right--
    boats++

Now:

    boats = 2

---

# Step 3

Remaining:

    [2]

The final person needs one boat.

Therefore:

    boats = 3

Final answer:

    3

---

# 🧠 Why Does the Greedy Strategy Work?

The heaviest person is the hardest person to accommodate.

Therefore, we should decide their boat first.

Suppose:

    heaviest + lightest > limit

Then the heaviest person cannot pair with anyone.

There is no reason to search for another partner because every
other person is heavier than the lightest person.

Therefore:

    heaviest → alone

If:

    heaviest + lightest <= limit

then pairing them is safe.

The lightest person is the easiest person to pair with someone else,
while the heaviest person has the fewest pairing possibilities.

Therefore, pairing the heaviest person with the lightest person
whenever possible is optimal.

---

# 🔍 Why Not Pair the Heaviest Person With Another Heavy Person?

Suppose:

    [1,2,2,3]
    limit = 3

The heaviest person is:

    3

Pairing:

    3 + 2

would exceed the limit.

So the `3` must go alone.

The `1` can instead pair with a `2`.

This maximizes the number of people sharing boats.

---

# 🔍 Why Always Process the Heaviest Person?

Because the heaviest person has the most restrictions.

A lighter person can potentially pair with many people.

A heavier person can pair with fewer people.

So the greedy strategy is:

    Handle the most difficult person first.

---

# 🔍 Why Move Right Every Time?

The `right` pointer represents the heaviest remaining person.

That person must get a boat in the current iteration.

Whether they:

    share a boat

or:

    travel alone

their assignment is complete.

Therefore:

    right--

always happens.

---

# 🔍 Why Move Left Only When They Can Pair?

If:

    people[left] + people[right] <= limit

both people use the same boat.

Therefore both are removed:

    left++
    right--

If they cannot fit together:

    people[left] + people[right] > limit

only the heaviest person is assigned a boat.

The lightest person remains available.

Therefore only:

    right--

is performed.

---

# 📊 Approach Comparison

| Approach | Time Complexity | Space Complexity | Best |
|---|---:|---:|---|
| Brute Force | O(n²) | O(n) | ❌ |
| Sorting + Greedy Search | O(n²) | O(1)* | ❌ |
| Sorting + Two Pointers | O(n log n) | O(1)* | ✅ |

`*` Auxiliary space excluding the sorting implementation and output.

---

# 🏆 Why Two Pointers Is Optimal

Sorting takes:

    O(n log n)

After sorting, the two pointers traverse the array only once.

The pointer traversal takes:

    O(n)

Therefore:

    O(n log n) + O(n)

which simplifies to:

    O(n log n)

This is the optimal standard solution.

---

# ⏱️ Final Complexity

## Brute Force

    Time: O(n²)
    Space: O(n)

---

## Sorting + Greedy Search

    Time: O(n²)
    Space: O(1)*

---

## Sorting + Two Pointers

    Time: O(n log n)
    Space: O(1)*

`*` Excluding sorting's internal implementation details.

---

# 🎯 Key Observations

1. Each boat can carry at most two people.
2. Sort the people by weight.
3. Always consider the heaviest remaining person.
4. Pair them with the lightest person if possible.
5. If they cannot fit together, the heaviest person must go alone.
6. The heaviest person always gets assigned a boat.
7. Therefore `right` always moves.
8. `left` moves only when a pair is formed.
9. Sorting makes the greedy decision possible.
10. Two pointers avoid repeatedly searching for partners.
11. The solution uses a greedy strategy.
12. The final complexity is `O(n log n)`.

---

# ⚠️ Common Mistakes

## Mistake 1: Pairing Two Heavy People First

This wastes boat capacity.

The best candidate for the heaviest person is the lightest
remaining person.

---

## Mistake 2: Searching for a Partner for the Heaviest Person

If the lightest person cannot fit with the heaviest person,
nobody else can fit either.

So no additional search is necessary.

---

## Mistake 3: Moving left When a Pair Cannot Fit

Suppose:

    people[left] + people[right] > limit

The lightest person cannot fit with the heaviest person.

The lightest person should remain available for a lighter person.

Therefore, only:

    right--

should happen.

---

## Mistake 4: Forgetting to Sort

The greedy Two Pointer strategy depends on knowing:

    lightest
    heaviest

Therefore sorting is essential.

---

## Mistake 5: Using Only One Pointer

One pointer cannot efficiently determine whether the heaviest
person can be paired with the lightest person.

Two pointers are required.

---

# 💼 Interview Questions

### Q1. What is the optimal approach?

Sorting + Two Pointers + Greedy.

---

### Q2. What is the time complexity?

    O(n log n)

The sorting dominates the linear two-pointer traversal.

---

### Q3. What is the space complexity?

    O(1)

auxiliary space excluding sorting implementation details.

---

### Q4. Why do we pair the heaviest person with the lightest?

The heaviest person has the fewest possible partners.

If they can fit with the lightest person, we can safely use
one boat for both.

---

### Q5. What happens if the lightest and heaviest cannot fit?

The heaviest person must travel alone.

---

### Q6. Why?

Because the lightest person is the smallest remaining person.
If even they cannot fit with the heaviest person, nobody else can.

---

### Q7. Why does right always move?

The heaviest person is assigned a boat in every iteration.

---

### Q8. Why does left move only when pairing occurs?

When two people share a boat, both are removed from consideration.

When the heaviest person travels alone, the lightest person
remains available.

---

### Q9. Is this a Two Pointer problem or a Greedy problem?

It is both.

The greedy decision is:

    Process the heaviest person first.

The Two Pointer technique efficiently finds the lightest possible
partner.

---

### Q10. Why is sorting necessary?

Sorting allows us to maintain direct access to:

    lightest → left

    heaviest → right

---

# 📚 Key Learning

This problem teaches:

- Two Pointer technique
- Greedy algorithms
- Sorting
- Pairing strategies
- Array traversal
- Optimization
- Decision making based on extreme values

---

# 🧩 Pattern Recognition

When you see a problem involving:

- Pairing people/items
- A maximum capacity
- At most two elements per group
- Minimizing the number of groups

Think:

    SORT
      ↓
    LEFT = LIGHTEST
      ↓
    RIGHT = HEAVIEST
      ↓
    Try to pair them
      ↓
    If possible → move both
    Otherwise → move right only

---

# 🔗 Related Problems

Related Two Pointer problems:

- LeetCode 11 — Container With Most Water
- LeetCode 15 — 3Sum
- LeetCode 18 — 4Sum
- LeetCode 42 — Trapping Rain Water
- LeetCode 167 — Two Sum II
- LeetCode 881 — Boats to Save People

Related Greedy problems:

- LeetCode 455 — Assign Cookies
- LeetCode 435 — Non-overlapping Intervals
- LeetCode 763 — Partition Labels

---

# 🏁 Final Conclusion

There are multiple ways to solve the problem.

## Brute Force

    Time: O(n²)

Too slow for large inputs.

---

## Sorting + Greedy Search

    Time: O(n²)

Better, but still performs unnecessary searches.

---

## Sorting + Two Pointers + Greedy

    Time: O(n log n)
    Space: O(1)*

This is the preferred optimal approach.

The core strategy is:

    Sort the array
          ↓
    Take the heaviest person
          ↓
    Check the lightest person
          ↓
    If they fit → put them together
          ↓
    Otherwise → heaviest goes alone
          ↓
    Repeat

Therefore:

> **Sorting + Two Pointers + Greedy is the optimal approach for Boats to Save People.**

Final complexity:

    Time: O(n log n)
    Space: O(1)*

`*` Excluding sorting implementation details.