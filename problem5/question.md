# Problem: Cracking the Binary Code 🤖

## The Challenge

Computers don't think in the numbers **0–9** like we do. They only understand two things: **ON** and **OFF** — which we write as **1** and **0**. This system is called **binary** (base-2).

Here is how the first eight positive integers look in binary:

| Decimal | Binary |
| ------- | ------ |
| 1       | 1      |
| 2       | 10     |
| 3       | 11     |
| 4       | 100    |
| 5       | 101    |
| 6       | 110    |
| 7       | 111    |
| 8       | 1000   |

**Your Mission:** Write a program that reads a positive integer **N** (up to 255), converts it to binary, and then counts how many **1s** appear in that binary representation. This count is called the number's **"popcount"** (population count) — a real term used by computer engineers!

---

## Understanding Binary Numbers 💡

### What Is a Number System?

The number system you use every day is called **base-10** (decimal). It uses ten digits: 0 through 9. Each position is worth **10 times** more than the position to its right.

For example, **342** means:
- 3 × 100 = 300
- 4 × 10  =  40
- 2 × 1   =   2
- **Total = 342** ✓

### Binary Is Base-2

Binary works the same way, but each position is worth **2 times** more than the one to its right — and you can only use **0** or **1**.

Let's decode the binary number **1011**:

```
Position value:   8    4    2    1
Binary digits:    1    0    1    1

= (1 × 8) + (0 × 4) + (1 × 2) + (1 × 1)
= 8 + 0 + 2 + 1
= 11  ✓
```

So **1011** in binary = **11** in decimal. Cool, right? 🎉

### The Position Values

| Position (right to left) | Power of 2 | Value |
| ------------------------ | ---------- | ----- |
| 1st (rightmost)          | 2⁰         | 1     |
| 2nd                      | 2¹         | 2     |
| 3rd                      | 2²         | 4     |
| 4th                      | 2³         | 8     |
| 5th                      | 2⁴         | 16    |
| 6th                      | 2⁵         | 32    |
| 7th                      | 2⁶         | 64    |
| 8th                      | 2⁷         | 128   |

A number that uses 8 binary digits is called a **byte** — the same "byte" you see in kilobytes and gigabytes!

---

## How to Convert Decimal → Binary 🔄

Here's the classic method: **keep dividing by 2 and collect the remainders**.

### Example: Convert 13 to binary

| Step | Number | ÷ 2 | Quotient | Remainder |
| ---- | ------ | --- | -------- | --------- |
| 1    | 13     | ÷ 2 | 6        | **1**     |
| 2    | 6      | ÷ 2 | 3        | **0**     |
| 3    | 3      | ÷ 2 | 1        | **1**     |
| 4    | 1      | ÷ 2 | 0        | **1**     |

Now read the remainders **bottom to top**: **1101**

Check: (1×8) + (1×4) + (0×2) + (1×1) = 8 + 4 + 0 + 1 = **13** ✓

### The Popcount of 13

Binary of 13 = **1101** → it has three **1**s → **popcount = 3**

---

## Your Task 📝

1. **Accept a positive integer N** (between 1 and 255)
2. **Convert N to binary** using the repeated-division method
3. **Count the number of 1s** in the binary representation (the popcount)
4. **Print both the binary form and the popcount**
5. **Explain your algorithm** step by step (see section below)

### Example Output

```
Input:  13
Binary: 1101
Popcount (number of 1s): 3
```

```
Input:  255
Binary: 11111111
Popcount (number of 1s): 8
```

---

## Explaining Your Algorithm 💬

### Questions to Guide You:

1. **How will you convert the number to binary?**
   - What operation finds the rightmost binary digit?
   - What operation moves you to the next digit?
   - When do you stop?

2. **How will you count the 1s?**
   - Do you count them as you build the binary string, or after?

3. **How will you display the binary digits in the correct order?**
   - Think carefully: the division method produces digits from *right to left*. How will you reverse them?

### Write Your Algorithm Here:

```
Step 1: Take a number

Step 2: Find binary

Step 3: Add 1 to popcount for every 1 in the number 

Step 4: Print binary and popcount

(Add more steps as needed!)
```

### Example Algorithm Structure:

```
Step 1: Read the input number N
Step 2: Create an empty list to store binary digits
Step 3: While N is greater than 0:
    a) Compute the remainder when N is divided by 2
    b) Add that remainder to the front of your list
    c) Replace N with N divided by 2 (integer division)
Step 4: Count how many 1s are in the list
Step 5: Print the binary number and the popcount
```

---

## Hints and Tips 💭

### Beginner Hints:

- The **modulo operator (%)** gives the remainder: `13 % 2 = 1`
- **Integer division (//)** discards the decimal part: `13 // 2 = 6`
- Build your binary digits in a list and then reverse the list at the end — or add each new digit to the *beginning* of a string

### Intermediate Hint:

- You can combine conversion and counting in one loop! Every time you find a remainder of **1**, you know that digit is a 1 — increment your counter right there.

### Efficiency Hint:

- There's a famous bit-manipulation trick called **Brian Kernighan's algorithm** that counts 1s without ever building the binary string. It uses the operation `N = N & (N - 1)` to remove the lowest set bit each time. Can you figure out why this works?

---

## Pseudocode Templates 📋

### Template 1: Build the String, Then Count

```
READ N
SET binary_string = ""
SET count = 0

WHILE N > 0:
    SET digit = N % 2
    SET binary_string = digit + binary_string   ← prepend digit
    SET N = N // 2

FOR each character in binary_string:
    IF character == "1":
        ADD 1 to count

PRINT binary_string
PRINT count
```

### Template 2: Count While Converting (Intermediate)

```
READ N
SET binary_string = ""
SET count = 0

WHILE N > 0:
    SET digit = N % 2
    SET binary_string = digit + binary_string
    IF digit == 1:
        ADD 1 to count
    SET N = N // 2

PRINT binary_string
PRINT count
```

### Template 3: Bit Trick (Advanced)

```
READ N
SET original = N
SET count = 0

WHILE N > 0:
    SET N = N AND (N - 1)   ← clears the lowest 1-bit
    ADD 1 to count

PRINT count
// Can you also print the binary string for original?
```

---

## Testing Your Code 🧪

Use these cases to check that your program is correct:

| Input (Decimal) | Expected Binary | Expected Popcount | Your Result |
| --------------- | --------------- | ----------------- | ----------- |
| 1               | 1               | 1                 | 1           |
| 5               | 101             | 2                 | 2           |
| 13              | 1101            | 3                 | 3           |
| 42              | 101010          | 3                 | 3           |
| 100             | 1100100         | 3                 | 4           |
| 127             | 1111111         | 7                 | 7           |
| 255             | 11111111        | 8                 | 8           |

> 💡 **Notice anything about 255?** It fills a whole byte with 1s. That's why 255 is such a magic number in computing — colors, IP addresses, and more!

---

## Interesting Facts 🌟

### About Binary:

- The word *binary* comes from the Latin *binarius*, meaning "consisting of two"
- All digital images, videos, music, and text you've ever seen are stored as binary 0s and 1s
- A single binary digit is called a **bit**. Eight bits make a **byte**
- The world's fastest computers perform billions of binary operations every second

### About Popcount:

- Popcount (also called Hamming weight) is used in error-correcting codes — the technology that lets your Wi-Fi work even when the signal is weak
- Modern CPUs have a *single hardware instruction* (`POPCNT`) that can count the 1s in a number in one step — no loop needed!
- Popcount is used in cryptography, databases, and even chess-playing engines

---

## Challenge Questions 🎯

After you solve it, think about these:

1. **Which numbers from 1–15 have the highest popcount?** Is there a pattern?
15. It is always a power of 2 minus one
2. **Powers of 2 (1, 2, 4, 8, 16...) always have a popcount of ___. Why?**
1, because the entire value fits into one digit
3. **What is the popcount of a number N plus the popcount of N+1? Does a pattern emerge?**

4. **Can you modify your program to go the other way** — convert a binary string *back* to decimal?
Yes, but it might take a bit more effort
5. **Why is 255 the maximum value of a single byte?** What's the minimum? What's the range?
255 is the maximum because 8 digits are each a power of 2, so the highest is 256. However, 0 also counts, so the highest is 255.

---

## Optimization Challenge 🚀

### Basic Solution:

- Convert to binary using repeated division
- Scan the resulting string and count the 1s

### Intermediate Solution:

- Count 1s *during* conversion, skipping the string-scan step

### Advanced Solution:

- Use Brian Kernighan's bit trick to count 1s without ever building the binary string
- Compare the number of loop iterations between the basic and advanced approaches for a large number like **255**. Which is faster, and by how much?

---

## Reflection Questions 🤔

1. **Before this problem, did you know computers only use 0 and 1? Does that surprise you?**
Yes, I did know. At first, it was kind of surprising
2. **What was the trickiest part of the conversion — and how did you solve it?**
The trickiest part was getting the program to read the number backwards. I solved it by using
3. **Could you explain binary numbers to a friend using only a light switch as an analogy?**
Yes. An off light switch would be considered 0, and on would be 1. There is no in-between, like how a light cannot be half-way on
4. **Where else in real life do you see "on/off" or "yes/no" systems that are secretly binary?**
If a device is on or off, or if a robot is moving or not.

---

## Good Luck! 🌟

Every app, game, and website you've ever used runs on exactly this idea — billions of 0s and 1s working together at lightning speed.

**Now you know the secret language of computers. Use it well!** 💻🎉
