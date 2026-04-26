# Problem: Caesar Cipher 🔐

## The Challenge

Every letter you type is secretly a number inside a computer! The letter `'A'` is stored as **65**, `'B'` as **66**, and so on. This system is called **ASCII** (American Standard Code for Information Interchange).

A **Caesar Cipher** is one of the oldest secret codes in history — Julius Caesar used it to send military messages! The idea: **shift every letter forward by N positions** in the alphabet.

For example, with a shift of **3**:
- `A → D`
- `B → E`
- `Z → C` ← wraps around!

| Original | A | B | C | ... | X | Y | Z |
|----------|---|---|---|-----|---|---|---|
| Shifted +3 | D | E | F | ... | A | B | C |

**Your Mission:** Write a Java program that encodes a message using a Caesar Cipher, then decodes it back.

---

## Understanding ASCII 💡

### Characters Are Numbers

In Java, a `char` is really just a number under the hood. You can do math on characters!

```java
char letter = 'A';
int code = (int) letter;      // code = 65
System.out.println(code);     // prints: 65

char back = (char) 65;        // back = 'A'
System.out.println(back);     // prints: A
```

### The Alphabet in ASCII

```
'A' = 65    'B' = 66    'C' = 67   ...   'Z' = 90
'a' = 97    'b' = 98    'c' = 99   ...   'z' = 122
```

Notice that uppercase letters go from 65–90, and lowercase from 97–122.

### Shifting a Letter

To shift `'H'` forward by 3:

```
Step 1: Find position in alphabet → 'H' - 'A' = 7   (H is the 7th letter, 0-indexed)
Step 2: Add the shift             → 7 + 3 = 10
Step 3: Wrap around with % 26     → 10 % 26 = 10     (still 10, no wrap needed)
Step 4: Convert back to a letter  → (char)('A' + 10) = 'K'

H → K ✓
```

What about wrapping? Shift `'Z'` by 3:

```
Step 1: 'Z' - 'A' = 25
Step 2: 25 + 3 = 28
Step 3: 28 % 26 = 2      ← modulo wraps it back!
Step 4: (char)('A' + 2) = 'C'

Z → C ✓
```

---

## Your Task 📝

1. **Encode** the message `"HELLO WORLD"` with a shift of 3
2. **Decode** the encoded message back to the original
3. **Handle both** uppercase and lowercase letters
4. **Leave non-letters** (spaces, punctuation) unchanged

Expected output:
```
Original:  HELLO WORLD
Encoded:   KHOOR ZRUOG
Decoded:   HELLO WORLD
```

---

## Understanding the Algorithm 💡

### Questions to Guide You:

1. **How do you shift a single uppercase letter?**
   - Hint: subtract `'A'`, add the shift, use `% 26`, add `'A'` back

2. **How do you handle lowercase letters differently from uppercase?**
   - Hint: lowercase `'a'` starts at 97, not 65 — which letter do you subtract?

3. **How do you loop through every character in a String?**
   - Hint: in Java, use `.toCharArray()` or `.charAt(i)` in a for loop

4. **How do you decode?** (Hint: it's the same operation — what shift undoes a shift of 3?)

### Write Your Algorithm Here:

```
Step 1: 

Step 2: 

Step 3: 

Step 4:

(Add more steps as needed!)
```

### Example Algorithm Structure:

```
FUNCTION encode(message, shift):
    SET result = ""
    FOR each character c in message:
        IF c is an uppercase letter:
            shift it using uppercase math
            add shifted char to result
        ELSE IF c is a lowercase letter:
            shift it using lowercase math
            add shifted char to result
        ELSE:
            add c unchanged to result
    RETURN result

FUNCTION decode(message, shift):
    use encode with a shift of (26 - shift) instead
```

---

## Hints and Tips 💭

### Java-Specific Hints:

- Check if a character is uppercase: `Character.isUpperCase(c)`
- Check if a character is a letter: `Character.isLetter(c)`
- Cast char to int: `(int) c`
- Cast int back to char: `(char) someInt`
- Loop through a String's characters:
  ```java
  for (char c : message.toCharArray()) {
      // do something with c
  }
  ```
- Build a String character by character:
  ```java
  String result = "";
  result += someChar;   // appends the character
  ```

### The Key Formula:

```java
// For uppercase letters:
char encoded = (char) ('A' + (c - 'A' + shift) % 26);

// For lowercase letters:
char encoded = (char) ('a' + (c - 'a' + shift) % 26);
```

### Why Does Decoding Work?

Encoding with shift 3 and then encoding again with shift 23 gets you back to the start — because 3 + 23 = 26, a full loop of the alphabet!

So to decode: `decodeShift = 26 - encodeShift`

---

## Testing Your Code 🧪

Test your encoder character by character before running the full message:

| Input | Shift | Expected Output | Reason |
|-------|-------|-----------------|--------|
| `'A'` | 3 | `'D'` | 0 + 3 = 3 |
| `'Z'` | 3 | `'C'` | 25 + 3 = 28, 28 % 26 = 2 |
| `'a'` | 3 | `'d'` | lowercase version |
| `' '` | 3 | `' '` | spaces unchanged |
| `'H'` | 13 | `'U'` | ROT13 — encodes and decodes with same shift! |

**Special case:** A shift of 13 is called **ROT13** — it's special because applying it twice returns the original message. Can you see why?

---

## Pseudocode Templates 📋

### Template 1: Basic Encoder (Beginner)

```
FUNCTION encode(message, shift):
    SET result = ""
    FOR each character c in message:
        IF c is between 'A' and 'Z':
            SET pos = c - 'A'
            SET newPos = (pos + shift) % 26
            SET newChar = 'A' + newPos
            ADD newChar to result
        ELSE:
            ADD c unchanged to result
    RETURN result
```

### Template 2: Handle Both Cases (Intermediate)

```
FUNCTION shiftChar(c, shift):
    IF c is uppercase:
        RETURN (char)('A' + (c - 'A' + shift) % 26)
    ELSE IF c is lowercase:
        RETURN (char)('a' + (c - 'a' + shift) % 26)
    ELSE:
        RETURN c unchanged

FUNCTION encode(message, shift):
    SET result = ""
    FOR each character c in message:
        ADD shiftChar(c, shift) to result
    RETURN result

FUNCTION decode(message, shift):
    RETURN encode(message, 26 - shift)
```

### Template 3: Crack an Unknown Cipher (Advanced)

```
FUNCTION bruteForce(encodedMessage):
    FOR shift FROM 1 TO 25:
        SET attempt = decode(encodedMessage, shift)
        PRINT "Shift " + shift + ": " + attempt
    // Which one looks like real English?
```

---

## Interesting Facts 🌟

### About ASCII:
- ASCII was invented in 1963 and is still used today!
- Every character on your keyboard has an ASCII code
- Emojis use a newer, larger system called **Unicode** — `'😀'` is code 128512

### About Caesar Cipher:
- Julius Caesar reportedly used a shift of 3 for his military messages
- It's called a **substitution cipher** — one of the oldest forms of encryption
- Modern encryption (like HTTPS websites use) is millions of times more complex
- A Caesar cipher can be cracked in at most 25 guesses — not very secure!

### About This Problem:
- The `%` operator (modulo) is the hero of this problem — it handles wrapping automatically
- This same wrapping trick appears in clocks, calendars, and game design!

---

## Challenge Questions 🎯

After you solve it, try these:

1. **What shift decodes the message `"KHOOR"`?** Work it out by hand first, then verify with code.
2. **ROT13 challenge:** Encode `"Hello"` with shift 13. Now encode *that result* with shift 13 again. What do you get?
3. **Is a shift of 0 valid?** What does it produce?
4. **What happens with a shift of 26?** How about 27?
5. **Can you crack this encoded message?** (Shift is unknown)
   ```
   GUVF VF SHA
   ```

---

## Optimization Challenge 🚀

### Basic Solution:
- Separate `if/else` blocks for uppercase and lowercase

### Intermediate Solution:
- Single `shiftChar()` helper method reused by both `encode()` and `decode()`

### Advanced Solution:
- **Brute force cracker**: try all 25 possible shifts and print them all
- **Frequency analysis**: in English, `'E'` is the most common letter (~13% of text). Can you find the shift by looking for the most frequent character in the encoded message?

---

## Visualize It! 🎨

Here's the alphabet as a wheel — the Caesar cipher just rotates the inner ring:

```
Outer (original): A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
Inner (shift +3): D E F G H I J K L M N O P Q R S T U V W X Y Z A B C
```

With shift 3: `A→D`, `B→E`, ... `Z→C`

Can you draw this as an actual circle? 🔄

---

## Reflection Questions 🤔

1. **Why does `% 26` solve the wrap-around problem?** Explain it in your own words.
2. **Why do we subtract `'A'` before shifting, and add it back after?**
3. **In Java, `char` and `int` can be converted back and forth. Why is that useful here?**
4. **If you wanted to cipher *numbers* too (0–9), how would you change your code?**
5. **Why is the Caesar cipher not safe for real secrets today?**

---

## Bonus: ASCII Art Decoder 🎨

Here's a message encoded with an unknown shift. Can you crack it?

```
Encoded: WKH TXLFN EURZQ IRA
```

Hint: it's a well-known English phrase. Try a few shifts!

---

## Good Luck! 🌟

Remember: the same modulo trick that wraps binary remainders around (from the last problem) wraps the alphabet around here too. **Math patterns show up everywhere in code!**

**Happy encoding — and decoding!** 🔐✨
