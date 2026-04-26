# Problem: Anagram Checker 🔤

## The Challenge

An **anagram** is a word or phrase made by rearranging all the letters of another word or phrase.

For example:
- `"listen"` and `"silent"` are anagrams ✓
- `"triangle"` and `"integral"` are anagrams ✓
- `"hello"` and `"world"` are **not** anagrams ✗

Some fun anagrams:
| Word | Anagram |
|------|---------|
| `astronomer` | `moon starer` |
| `conversation` | `voices rant on` |
| `the classroom` | `schoolmaster` |

**Your Mission:** Write a Java program that checks whether two words (or phrases) are anagrams of each other.

---

## Understanding the Problem 💡

### What Makes Two Words Anagrams?

Two words are anagrams if they contain **exactly the same letters, the same number of times** — just in a different order.

**Example:** `"listen"` vs `"silent"`

```
l-i-s-t-e-n  →  sorted: e-i-l-n-s-t
s-i-l-e-n-t  →  sorted: e-i-l-n-s-t

Same! → ANAGRAM ✓
```

**Non-example:** `"hello"` vs `"world"`

```
h-e-l-l-o  →  sorted: e-h-l-l-o
w-o-r-l-d  →  sorted: d-l-o-r-w

Different! → NOT AN ANAGRAM ✗
```

### Two Ways to Think About It

**Approach 1 — Sort and Compare:**
Sort both words alphabetically. If the sorted versions are equal, they're anagrams!

**Approach 2 — Count and Compare:**
Count how many times each letter appears in both words. If all counts match, they're anagrams!

| | Approach 1: Sort | Approach 2: Count |
|--|--|--|
| Idea | Sort both, compare | Count letters in each |
| Good for | Simplicity | Efficiency |
| Key skill | Arrays, sorting | Arrays as maps |

---

## Your Task 📝

1. **Write a method** `isAnagram(String a, String b)` that returns `true` or `false`
2. **Ignore case** — `"Listen"` and `"Silent"` should still be anagrams
3. **Ignore spaces** — `"moon starer"` and `"astronomer"` should be anagrams
4. **Test your method** on at least 5 pairs

Expected output:
```
"listen" and "silent"     → ANAGRAM ✓
"triangle" and "integral" → ANAGRAM ✓
"hello" and "world"       → NOT AN ANAGRAM ✗
"Astronomer" and "Moon starer" → ANAGRAM ✓
"abc" and "ab"            → NOT AN ANAGRAM ✗
```

---

## Understanding the Tools 💡

### Working with Strings in Java

```java
String word = "Hello World";

// Convert to lowercase
String lower = word.toLowerCase();         // "hello world"

// Remove spaces
String noSpaces = word.replace(" ", "");   // "HelloWorld"

// Get length
int len = word.length();                   // 11

// Get character at position i
char c = word.charAt(0);                   // 'H'

// Convert to array of characters
char[] letters = word.toCharArray();       // ['H','e','l','l','o',' ','W','o','r','l','d']
```

### Sorting a Character Array

```java
import java.util.Arrays;

char[] letters = {'h', 'e', 'l', 'l', 'o'};
Arrays.sort(letters);
// letters is now: ['e', 'h', 'l', 'l', 'o']
```

### Converting a char[] Back to a String

```java
char[] sorted = {'e', 'i', 'l', 'n', 's', 't'};
String sortedString = new String(sorted);   // "eilnst"
```

### Counting with an Array

The alphabet has 26 letters. You can use an **array of 26 integers** to count each letter:

```java
int[] counts = new int[26];   // [0, 0, 0, ..., 0]  (26 zeros)

char c = 'e';
int index = c - 'a';          // 'e' - 'a' = 4  (e is the 4th letter, 0-indexed)
counts[index]++;               // counts[4] is now 1

// counts[0] = count of 'a'
// counts[1] = count of 'b'
// ...
// counts[25] = count of 'z'
```

---

## Questions to Guide You

1. **Before comparing, what "cleaning" do you need to do to both strings?**
   - Hint: think about case and spaces

2. **If you sort both strings, how do you compare them?**
   - Hint: you can't use `==` to compare Strings in Java! Use `.equals()`

3. **If you use counting, how do you know the counts match?**
   - Hint: you could count up for one word and count *down* for the other — then check if all counts are zero

4. **What edge cases should you handle?**
   - What if both strings are empty?
   - What if one is longer than the other?

### Write Your Algorithm Here:

```
Step 1: 

Step 2: 

Step 3: 

Step 4:

(Add more steps as needed!)
```

---

## Hints and Tips 💭

### Why Can't You Use `==` for Strings in Java?

```java
String a = "hello";
String b = "hello";

a == b         // might be false! (compares memory addresses)
a.equals(b)    // always true! (compares actual content)
```

This is a classic Java gotcha. **Always use `.equals()` to compare Strings.**

### Cleaning the Input

Before doing any comparison, normalize both strings:

```java
String clean = word.toLowerCase().replace(" ", "");
```

### The Index Trick

To map any lowercase letter to an array index 0–25:

```java
int index = letter - 'a';
// 'a' - 'a' = 0
// 'b' - 'a' = 1
// 'z' - 'a' = 25
```

This works because characters are numbers — and subtracting `'a'` gives you the position!

---

## Testing Your Code 🧪

Use this table to verify your results:

| Word A | Word B | Anagram? | Why |
|--------|--------|----------|-----|
| `"listen"` | `"silent"` | ✅ Yes | Same letters, rearranged |
| `"hello"` | `"world"` | ❌ No | Different letters |
| `"abc"` | `"ab"` | ❌ No | Different lengths |
| `"aab"` | `"abb"` | ❌ No | Different counts |
| `"Listen"` | `"Silent"` | ✅ Yes | Ignore case |
| `"Astronomer"` | `"Moon starer"` | ✅ Yes | Ignore spaces + case |
| `""` | `""` | ✅ Yes | Both empty |

---

## Pseudocode Templates 📋

### Template 1: Sort and Compare (Beginner)

```
FUNCTION isAnagram(wordA, wordB):
    SET a = wordA in lowercase, with spaces removed
    SET b = wordB in lowercase, with spaces removed
    
    IF length of a ≠ length of b:
        RETURN false
    
    SORT the characters of a
    SORT the characters of b
    
    RETURN (sorted a EQUALS sorted b)
```

### Template 2: Count Letters (Intermediate)

```
FUNCTION isAnagram(wordA, wordB):
    SET a = wordA in lowercase, with spaces removed
    SET b = wordB in lowercase, with spaces removed
    
    IF length of a ≠ length of b:
        RETURN false
    
    SET counts = array of 26 zeros
    
    FOR each character c in a:
        ADD 1 to counts[c - 'a']
    
    FOR each character c in b:
        SUBTRACT 1 from counts[c - 'a']
    
    FOR each value in counts:
        IF value ≠ 0: RETURN false
    
    RETURN true
```

### Template 3: Detailed Letter Report (Advanced)

```
FUNCTION anagramReport(wordA, wordB):
    IF isAnagram(wordA, wordB):
        PRINT wordA + " and " + wordB + " ARE anagrams!"
        PRINT "Letters used: " + sorted unique letters
    ELSE:
        SET missingFromB = letters in A not in B
        SET extraInB = letters in B not in A
        PRINT "Not anagrams."
        PRINT "Missing from second word: " + missingFromB
        PRINT "Extra in second word: " + extraInB
```

---

## Interesting Facts 🌟

### About Anagrams:
- The word "anagram" itself comes from Greek: *ana* (back, again) + *gramma* (letter)
- Some famous anagram examples: `"Clint Eastwood"` → `"Old West action"`, `"Elvis"` → `"Lives"`
- Competitive Scrabble players use anagram skills to spot high-scoring words!

### About This Problem:
- Anagram checking is a classic CS interview question
- The counting approach (Template 2) is faster than sorting for long strings
- A sorted character array comparison is `O(n log n)`, while counting is `O(n)` — see if you can find out what that means!

### About Character Arrays in Java:
- In Java, `String` objects are **immutable** — you can't change them in place
- That's why you convert to `char[]` to sort, then convert back
- This is different from Python, where `sorted("hello")` works directly on the string

---

## Challenge Questions 🎯

After you solve it, try these:

1. **Can a word be an anagram of itself?** Test it. Does your code handle it correctly?
2. **What is the anagram of `"Dormitory"`?** (Hint: think of a place to sleep, messily)
3. **Can two different numbers, written as words, be anagrams?** For example, is `"one"` an anagram of anything common?
4. **How many anagrams does `"abc"` have?** List them all.
5. **What is the longest common English word that is an anagram of another common word?**

---

## Optimization Challenge 🚀

### Basic Solution:
- Sort both strings and compare

### Intermediate Solution:
- Use a 26-element count array — O(n) time, no sorting needed

### Advanced Solution:
- **Early exit**: if string lengths differ, return `false` immediately
- **Single-pass counting**: count up for word A and down for word B in a single loop over the longer one — no second loop needed
- **Ignore non-letters too**: extend your cleaner to strip punctuation, not just spaces

---

## Visualize It! 🎨

Here's the count array approach for `"listen"` vs `"silent"`:

```
Letter: a  b  c  d  e  f  g  h  i  j  k  l  m  n  o  p  q  r  s  t  u  v  w  x  y  z
        [0][0][0][0][1][0][0][0][1][0][0][1][0][1][0][0][0][0][1][1][0][0][0][0][0][0]

After "listen":  e=1, i=1, l=1, n=1, s=1, t=1
After "silent":  e=0, i=0, l=0, n=0, s=0, t=0  ← all zeros!

All zeros → ANAGRAM ✓
```

Can you trace through `"hello"` vs `"world"` the same way? Which slots won't end up at zero?

---

## Reflection Questions 🤔

1. **Why does cleaning (lowercasing + removing spaces) need to happen *before* comparing?**
2. **The counting approach uses an array of size 26. Why 26 specifically?**
3. **In your own words, explain why all counts being zero proves the words are anagrams.**
4. **You used `letter - 'a'` to get an array index. How is this similar to how the Caesar Cipher worked?**
5. **If you wanted to check anagrams for any language (not just English), how would you change your approach?**

---

## Bonus: Anagram Finder 🔍

Can you extend your program to find anagrams in a list of words?

```java
String[] dictionary = {"listen", "silent", "enlist", "hello", "world", "inlets"};
```

Given the word `"listen"`, your program should find and print all words in the list that are anagrams of it.

Expected output:
```
Anagrams of "listen": silent, enlist, inlets
```

---

## Good Luck! 🌟

Notice how the same trick from Caesar Cipher appears again: `letter - 'a'` converts a character into a useful number. **This is a pattern worth remembering** — characters are numbers, and that makes all kinds of clever shortcuts possible.

**Happy unscrambling!** 🔤✨
