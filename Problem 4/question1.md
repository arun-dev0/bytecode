# Problem 2: The Class Report Card 📊

## The Challenge

A teacher has two lists — one with student names, and one with their test scores. Each name matches the score at the **same position**:

```
names  = ["Alice", "Bob", "Charlie", "Diana", "Eve"]
scores = [88,      72,    95,        60,       81   ]
```

- **Alice** scored **88**, **Bob** scored **72**, **Charlie** scored **95**, and so on.

From these two lists, you need to find:
- The **name** of the student with the highest score → `"Charlie"`
- The **names** of all students who scored **below average** → `["Bob", "Diana"]`

The average score is: (88 + 72 + 95 + 60 + 81) ÷ 5 = **79** *(rounded down)*

**Your Mission:** Write a program that takes a list of names and a list of scores, then prints the top student's name and a list of names of students who are below average.

---

## Understanding the Problem 🤔

### How do two lists work together?
When two lists are linked by position, they're called **parallel lists**. The item at index `i` in one list corresponds to the item at index `i` in the other.

```python
names  = ["Alice", "Bob", "Charlie"]
scores = [88,      72,    95       ]
#          ^                ^
#     names[0] = "Alice"    scores[0] = 88  → Alice scored 88
#     names[1] = "Bob"      scores[1] = 72  → Bob scored 72
```

So to find who got a particular score, you use the **same index** to look up the name!

### What's an average?
The average is the total of all scores divided by the number of scores. If the average is **79**, then anyone with a score **less than 79** is below average.

### Important Note!
You'll need to loop through the lists **more than once** — once to calculate the average, and again to find who's below it. Make sure you're using the same index `i` to access both lists at the same time.

---

## Your Task 📝

1. **Write a program** that works with two parallel lists: `names` and `scores`
2. **Find the name** of the student with the highest score
3. **Calculate the average** score (rounded down)
4. **Build a new list** of names of students who scored below the average
5. **Explain your algorithm** (see section below)

---

## Explaining Your Algorithm 💡

Before you start coding, think about HOW you'll solve this problem. An algorithm is just a step-by-step plan!

### Questions to Guide You:

1. **How do you find the top student's name, not just their score?**
   - Hint: When you find a new highest score, save its index — then use that index to look up the name...

2. **How do you collect names into a new list?**
   - Hint: Start with an empty list `[]` and use `.append()` to add names as you find them...

3. **Why do you need to loop through the lists twice?**
   - First loop: to calculate the average
   - Second loop: to compare each score against the average — but you need the average first!

### Write Your Algorithm Here:
```
Step 1: 
Step 2: 
Step 3: 
(Add more steps as needed!)
```

### Example Algorithm (for the names and scores above):
```
Step 1: Loop through scores to calculate the total → 396
Step 2: Divide by 5 to get the average → 79
Step 3: Loop through scores again using index i
Step 4: Track the index of the highest score → index 2 → "Charlie"
Step 5: If scores[i] < 79, add names[i] to the below_average list
Step 6: Print top student and below_average list
```

---

## Hints and Tips 💭

### Beginner Hints:
- Use `range(len(scores))` to loop with an index `i`, so you can access both `names[i]` and `scores[i]` at the same time
- Start with an empty list for below-average students: `below_average = []`
- Use `.append()` to add a name to your list: `below_average.append(names[i])`
- Remember: calculate the average **before** your second loop!

### Thinking Challenge:
- Can you do everything in a **single loop**? What's the problem with trying to check "below average" before you've finished calculating the average?

### Efficiency Challenge:
- What if there were 10,000 students? Your program loops through the list twice — is there any way to do it in one pass?

---

## Testing Your Code 🧪

| Names | Scores | Top Student | Below Average |
|-------|--------|-------------|---------------|
| `["Alice","Bob","Charlie","Diana","Eve"]` | `[88,72,95,60,81]` | `"Charlie"` | `["Bob","Diana"]` |
| `["Zara","Liam","Noah"]` | `[70,70,71]` | `"Noah"` | `["Zara","Liam"]` |
| `["Sam"]` | `[55]` | `"Sam"` | `[]` |
| `["Ava","Mia","Kai","Leo"]` | `[100,100,100,100]` | `"Ava"` | `[]` |

If these all match, your solution is working! ✅

---

## Pseudocode Template 📋

Here's a template to get you started:

```
SET total to 0
FOR i from 0 to length of scores - 1:
    ADD scores[i] to total
SET average to total // length of scores

SET top_index to 0
SET below_average to empty list

FOR i from 0 to length of scores - 1:
    IF scores[i] > scores[top_index]:
        SET top_index to i
    IF scores[i] < average:
        APPEND names[i] to below_average

PRINT names[top_index]
PRINT below_average
```

---

## Questions to Reflect On 🌟

After you solve the problem, think about:

1. **What happens if two students tie for the top score?** Which name does your program print, and why?
2. **What if the lists are different lengths?** How would your program behave, and how could you protect against it?
3. **What if ALL students score the same?** Would your below_average list be empty?
4. **Could you combine the names and scores into a single list of pairs?** How might that change your code?

---

## Bonus Challenges 🚀

- 🥈 **Silver:** Also find the name of the student with the **lowest** score
- 🥇 **Gold:** Print a neatly formatted report: each student's name, their score, and whether they are `"Above Average"`, `"Average"`, or `"Below Average"`
- 💎 **Diamond:** Sort both lists together so the students are displayed from **highest to lowest score** — without using `.sort()` or `sorted()`!

---

## Good Luck! 🚀

Remember: The journey is more important than the destination. Understanding WHY your solution works is more valuable than just getting the right answer!

**Have fun coding!** 🎉
