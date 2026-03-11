# Problem 3: The Tournament Bracket 🏆

## The Challenge

Four players competed in a tournament over **3 rounds**. Their scores are stored as a **list of lists** — each inner list holds one player's scores across all 3 rounds:

```
players = ["Alice", "Bob", "Charlie", "Diana"]
scores  = [
    [72, 88, 65],   # Alice's scores
    [91, 60, 84],   # Bob's scores
    [78, 78, 78],   # Charlie's scores
    [95, 40, 90]    # Diana's scores
]
```

Each player's **total** is the sum of their 3 round scores:
- Alice → 72 + 88 + 65 = **225**
- Bob → 91 + 60 + 84 = **235**
- Charlie → 78 + 78 + 78 = **234**
- Diana → 95 + 40 + 90 = **225**

**Your Mission:** Find the **name of the winner** — the player with the highest total score.

Answer: `"Bob"` with a total of **235**

---

## Understanding the Problem 🤔

### What's a 2D list?
A 2D list is a **list of lists** — like a table with rows and columns.

```python
scores = [
    [72, 88, 65],  # row 0 → Alice
    [91, 60, 84],  # row 1 → Bob
]

scores[0]     → [72, 88, 65]   # Alice's full list of scores
scores[0][1]  → 88             # Alice's score in round 2 (index 1)
scores[1][2]  → 84             # Bob's score in round 3 (index 2)
```

Think of `scores[i][j]` as: **player `i`, round `j`**.

### Important Note!
To get each player's total, you need **two loops** — an outer loop to go through each player, and an inner loop to add up that player's round scores. The outer index `i` connects `players[i]` to `scores[i]`.

---

## Your Task 📝

1. **Write a program** that loops through the `players` and `scores` lists
2. **Calculate each player's total** by summing their inner list
3. **Find and print the winner's name** — the player with the highest total

---

## Explaining Your Algorithm 💡

Before you start coding, think about HOW you'll solve this problem. An algorithm is just a step-by-step plan!

### Questions to Guide You:

1. **How do you add up scores stored in an inner list?**
   - Hint: Use an inner loop to go through each value in `scores[i]`...

2. **How do you remember the highest total you've seen so far?**
   - Hint: Try saving the highest total AND its index as you go...

3. **Once you know the index of the highest total, how do you get the player's name?**
   - Hint: The same index works for both `players` and `scores`!

### Write Your Algorithm Here:
```
Step 1: 
Step 2: 
Step 3: 
(Add more steps as needed!)
```

### Example Algorithm (for the data above):
```
Step 1: Set best_total to 0, best_index to 0
Step 2: For each player i, loop through scores[i] to calculate their total
Step 3: If their total is greater than best_total, update best_total and best_index
Step 4: After all players, print players[best_index]
```

---

## Hints and Tips 💭

### Beginner Hints:
- Use `for i in range(len(players)):` for your outer loop
- Use `for j in range(len(scores[i])):` for your inner loop
- Access a single score with `scores[i][j]`
- Track `best_total` and `best_index` — update both whenever you find a new highest total

### Thinking Challenge:
- Can you print **all** players' totals neatly before declaring the winner?

### Efficiency Challenge:
- Right now you calculate totals and find the winner in the same loop. What if you needed the totals list for something else later — how would you store them?

---

## Testing Your Code 🧪

| Players | Scores | Expected Winner |
|---------|--------|-----------------|
| `["Alice","Bob","Charlie","Diana"]` | `[[72,88,65],[91,60,84],[78,78,78],[95,40,90]]` | `"Bob"` |
| `["Zara","Liam","Noah"]` | `[[50,60,70],[80,90,100],[30,30,30]]` | `"Liam"` |
| `["Sam","Jo"]` | `[[100,100,100],[99,100,100]]` | `"Sam"` |
| `["Ava"]` | `[[10,20,30]]` | `"Ava"` |

If these all match, your solution is working! ✅

---

## Pseudocode Template 📋

Here's a template to get you started:

```
SET best_total to 0
SET best_index to 0

FOR each player i from 0 to number of players - 1:
    SET player_total to 0
    FOR each round j from 0 to number of rounds - 1:
        ADD scores[i][j] to player_total
    IF player_total > best_total:
        SET best_total to player_total
        SET best_index to i

PRINT players[best_index]
```

---

## Questions to Reflect On 🌟

After you solve the problem, think about:

1. **What if two players tie for the highest total?** Which name does your program print, and why?
2. **What if a player has no scores** — an empty inner list like `[]`? What happens?
3. **What would change** if players had 5 rounds instead of 3?

---

## Bonus Challenges 🚀

- 🥈 **Silver:** Also print the **last place** player — the one with the lowest total
- 🥇 **Gold:** Print every player's name and total, neatly formatted, from highest to lowest — without using `.sort()` or `sorted()`

---

## Good Luck! 🚀

Remember: The journey is more important than the destination. Understanding WHY your solution works is more valuable than just getting the right answer!

**Have fun coding!** 🎉
