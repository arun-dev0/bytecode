# Project Euler Problem 1: Multiples of 3 or 5 🎯

## The Challenge

If we list all the natural numbers below **10** that are multiples of 3 or 5, we get:
- **3**, **5**, **6**, **9**

The sum of these multiples is: 3 + 5 + 6 + 9 = **23**

**Your Mission:** Find the sum of all the multiples of 3 or 5 below **1000**.

---

## Understanding the Problem 🤔

### What's a multiple?
A multiple of a number is what you get when you multiply that number by any whole number.

**Multiples of 3:** 3, 6, 9, 12, 15, 18, 21, 24, 27, 30...
**Multiples of 5:** 5, 10, 15, 20, 25, 30, 35, 40...

### Important Note!
Notice that **15** appears in both lists! Make sure you don't count numbers like this twice. If a number is a multiple of BOTH 3 and 5, only count it once.

---

## Your Task 📝

1. **Write a program** that finds all multiples of 3 or 5 below 1000
2. **Calculate the sum** of all these numbers
3. **Explain your algorithm** (see section below)

---

## Explaining Your Algorithm 💡

Before you start coding, think about HOW you'll solve this problem. An algorithm is just a step-by-step plan!

### Questions to Guide You:

1. **How will you check if a number is a multiple of 3 or 5?**
   - Hint: Think about division and remainders...

2. **How will you avoid counting numbers twice?**
   - Example: 15 is a multiple of both 3 and 5

3. **What loop will you use to check all numbers?**
   - What's your starting number?
   - What's your ending number?
   - How will you step through them?

### Write Your Algorithm Here:

```
Step 1: 

Step 2: 

Step 3: 

(Add more steps as needed!)
```

### Example Algorithm (for numbers below 10):
```
Step 1: Start with a sum of 0
Step 2: Check each number from 1 to 9
Step 3: If the number is divisible by 3 OR divisible by 5, add it to the sum
Step 4: Return the final sum
```

---

## Hints and Tips 💭

### Beginner Hints:
- Use the **modulo operator (%)** to check if a number divides evenly
- If `number % 3 == 0`, then the number is divisible by 3
- Use a **for loop** to check each number from 1 to 999

### Thinking Challenge:
- Can you solve this WITHOUT checking every single number?
- What patterns do you notice in the multiples?

### Efficiency Challenge:
- There's a mathematical formula that can solve this instantly! Can you figure it out?
- Hint: Think about arithmetic sequences...

---

## Testing Your Code 🧪

Before running your program on 1000, test it with smaller numbers:

| Range | Expected Sum | Your Result |
|-------|--------------|-------------|
| Below 10 | 23 | ? |
| Below 20 | 78 | ? |
| Below 100 | 2318 | ? |

If these work, try 1000!

---

## Pseudocode Template 📋

Here's a template to get you started:

```
SET sum to 0

FOR each number from 1 to 999:
    IF number is divisible by 3 OR divisible by 5:
        ADD number to sum

PRINT sum
```

---

## Questions to Reflect On 🌟

After you solve the problem, think about:

1. **How long does your program take to run?**
2. **Could you make it faster?**
3. **What would change if we asked for multiples of 3 or 7 instead?**
4. **Can you solve it with math instead of programming?**

---

## Good Luck! 🚀

Remember: The journey is more important than the destination. Understanding WHY your solution works is more valuable than just getting the right answer!

**Have fun coding!** 🎉