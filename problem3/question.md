# Project Euler Problem 5: Smallest Multiple 🔢

## The Challenge

**2520** is the smallest number that can be divided by each of the numbers from **1 to 10** without any remainder.

Let's verify this:
- 2520 ÷ 1 = 2520 ✓
- 2520 ÷ 2 = 1260 ✓
- 2520 ÷ 3 = 840 ✓
- 2520 ÷ 4 = 630 ✓
- 2520 ÷ 5 = 504 ✓
- 2520 ÷ 6 = 420 ✓
- 2520 ÷ 7 = 360 ✓
- 2520 ÷ 8 = 315 ✓
- 2520 ÷ 9 = 280 ✓
- 2520 ÷ 10 = 252 ✓

**Your Mission:** What is the smallest positive number that is evenly divisible by all of the numbers from **1 to 20**?

---

## Understanding the Problem 🤔

### What does "evenly divisible" mean?
A number is evenly divisible by another if there's no remainder when you divide them.
- 12 is evenly divisible by 3 (12 ÷ 3 = 4, remainder 0) ✓
- 13 is NOT evenly divisible by 3 (13 ÷ 3 = 4, remainder 1) ✗

### What are we looking for?
We need the **Least Common Multiple (LCM)** of all numbers from 1 to 20!

The LCM is the smallest number that ALL of these numbers divide into evenly.

### Important Insight 💡
You DON'T need to check every single number from 1 upward. There's a much smarter way!

---

## Your Task 📝

1. **Understand what LCM means**
2. **Think about which numbers actually matter**
3. **Write an algorithm** to find the LCM
4. **Optimize your approach** (brute force will take forever!)

---

## Explaining Your Algorithm 💡

### Questions to Guide You:

1. **The Brute Force Way** (not recommended!)
   - Start at 20 and check if it's divisible by all numbers 1-20
   - If not, try 21, 22, 23...
   - Why is this a bad idea? How long would it take?

2. **Which numbers can we ignore?**
   - Do we really need to check divisibility by 1?
   - If a number is divisible by 20, is it also divisible by 10? By 5? By 4?
   - Can we eliminate some numbers from our checks?

3. **What about prime factorization?**
   - Every number can be broken down into prime factors
   - Example: 12 = 2 × 2 × 3 (or 2² × 3)
   - How can this help us?

4. **What is LCM and how do we calculate it?**
   - LCM is related to GCD (Greatest Common Divisor)
   - Formula: LCM(a, b) = (a × b) / GCD(a, b)
   - How can we use this for multiple numbers?

### Write Your Algorithm Here:

```
Step 1: sets the lcm to 1

Step 2: sets the factor being checked to 2

Step 3: finds the next lcm by finding the lcm of the current lcm and the factor

Step 4: increase the factor by 1

Step 5: repeat steps 3 and 4 until the factor is 20 
```

---

## Hints and Tips 💭

### Beginner Approach: Eliminate Unnecessary Checks
Think about what numbers you actually need to test:
- If divisible by 20, automatically divisible by 10, 5, 4, 2, 1
- If divisible by 18, automatically divisible by 9, 6, 3
- If divisible by 16, automatically divisible by 8, 4, 2
- If divisible by 14, automatically divisible by 7, 2

**Challenge:** Can you figure out the minimal set of numbers to check?
11-20 is all we need to check, because the numbers from 1-10 are all factors of at least one number from 11-20

### Intermediate Approach: Use LCM
The LCM (Least Common Multiple) of multiple numbers can be calculated step by step:
- Start with LCM = 1
- For each number from 2 to 20:
  - Calculate: LCM = (LCM × number) / GCD(LCM, number)

You'll need to implement GCD (Greatest Common Divisor) first!

### Advanced Approach: Prime Factorization
This is the SMARTEST approach:

1. **Find all primes up to 20:** 2, 3, 5, 7, 11, 13, 17, 19

2. **For each prime, find the highest power needed:**
   - 2: What's the highest power of 2 in 1-20? It's 16 = 2⁴
   - 3: What's the highest power of 3 in 1-20? It's 9 = 3²
   - 5: What's the highest power of 5 in 1-20? It's 5¹
   - And so on...

3. **Multiply them all together:**
   - Answer = 2⁴ × 3² × 5¹ × 7¹ × 11¹ × 13¹ × 17¹ × 19¹

**This runs instantly!** ⚡

---

## Testing Your Code 🧪

Test with smaller ranges first:

| Range | Smallest Multiple | Your Result |
|-------|-------------------|-------------|
| 1 to 5 | 60 | 60 |
| 1 to 7 | 420 | 420 |
| 1 to 10 | 2520 | 2520 |
| 1 to 13 | 360360 | 360360 |
| 1 to 20 | ??? | 232792560 |

---

## Pseudocode Templates 📋

### Template 1: Brute Force (SLOW - for learning only!)
```
SET number = 20

WHILE true:
    SET divisible = true
    
    FOR each divisor from 1 to 20:
        IF number % divisor != 0:
            SET divisible = false
            BREAK
    
    IF divisible:
        RETURN number
    
    INCREMENT number by 1
```
⚠️ **Warning:** This will take a VERY long time for 1-20!

### Template 2: Using LCM (EFFICIENT)
```
FUNCTION gcd(a, b):
    WHILE b != 0:
        temp = b
        b = a % b
        a = temp
    RETURN a

FUNCTION lcm(a, b):
    RETURN (a * b) / gcd(a, b)

SET result = 1
FOR number from 2 to 20:
    result = lcm(result, number)

PRINT result
```

### Template 3: Prime Factorization (MOST EFFICIENT)
```
FIND all primes up to 20

FOR each prime:
    FIND highest power of prime that is <= 20
    MULTIPLY result by (prime ^ power)

PRINT result
```

---

## Mathematical Concepts 📚

### What is GCD (Greatest Common Divisor)?
The largest number that divides both numbers evenly.
- GCD(12, 8) = 4
- GCD(15, 10) = 5

**Euclid's Algorithm** calculates GCD efficiently:
```
GCD(a, b):
    while b ≠ 0:
        temp = b
        b = a mod b
        a = temp
    return a
```

### What is LCM (Least Common Multiple)?
The smallest number that both numbers divide into evenly.
- LCM(12, 8) = 24
- LCM(15, 10) = 30

**Formula:** LCM(a, b) = (a × b) / GCD(a, b)

### Prime Factorization
Every number can be expressed as a product of prime numbers:
- 12 = 2² × 3
- 18 = 2 × 3²
- 20 = 2² × 5

To find LCM using prime factorization:
- Take the HIGHEST power of each prime that appears
- LCM(12, 18, 20) = 2² × 3² × 5 = 180

---

## Performance Comparison 🚀

Let's see how different approaches perform:

| Method | Time for 1-20 | Time for 1-100 |
|--------|---------------|----------------|
| Brute Force | Hours? Days? | Impossible |
| Smart Brute Force | Seconds | Minutes |
| LCM Algorithm | Instant | Instant |
| Prime Factorization | Instant | Instant |

**Key Lesson:** Smart algorithms make HUGE differences!

---

## Challenge Questions 🎯

After you solve it, try these:

1. **What's the answer for numbers 1 to 30?**
5.493670133567616E19

2. **How many digits does the answer for 1-20 have?**
9

3. **Can you solve it by hand using prime factorization?** (Try it!)
I can

4. **What patterns do you notice in the answers?**
   - 1-5 = 60
   - 1-10 = 2520
   - 1-20 = ???

5. **Efficiency Challenge:** Make your program solve for 1-100 instantly!
It does, but it gets the wrong answer

---

## Interesting Facts 🌟

### About LCM:
- Used in music to find when different rhythms sync up
- Used in astronomy to calculate when planets align
- Used in scheduling to find common meeting times

### About This Problem:
- The answer for 1-20 has 9 digits
- There are only 8 primes between 1 and 20
- Using prime factorization, you can solve this by hand in under 2 minutes!

### Real-World Applications:
- **Music:** Finding when different beats align
- **Gears:** Calculating when gear teeth match up again
- **Schedules:** Finding common time slots
- **Fractions:** Finding common denominators

---

## Reflection Questions 🤔

1. **Why is brute force so slow for this problem?**
It checks every number from 21-232792560 for divisibility by numbers 1-20, and that is way too many calculations to do.

2. **How does understanding prime factorization help?**
It can really help optimizing the code.

3. **What's the relationship between GCD and LCM?**
lcm(a, b) = (a*b) / gcd(a, b)

4. **Could you explain LCM to someone who's never heard of it?**
Yes. It is not that complicated

5. **Which approach did you use? Why?**
I used the LCM method because it is the fasted timed that I knew how to do

---

## Optimization Goals 🏆

**Bronze:** Get the correct answer (any method)

**Silver:** Solve it in under 1 second

**Gold:** Solve it using prime factorization in under 0.01 seconds

**Platinum:** Explain why your solution works to someone else

---

## Good Luck! 🚀

This problem teaches you that sometimes the best solution is to **think smarter, not harder**. A good algorithm beats raw computing power every time!

**Remember:** The journey from brute force to elegant solution is where the real learning happens! 🎉