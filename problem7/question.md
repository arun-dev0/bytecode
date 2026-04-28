# Problem: Word Frequency Counter 📚

## The Challenge

Every time you read a book, watch a YouTube video, or scroll through text messages, you're seeing words — and some words appear **WAY more often** than others. In English, `"the"` is the most common word. It shows up about **once every 14 words** you read!

**Your Mission:** Given a sentence or paragraph, count how many times each word appears, then find the **most frequent word**.

For example, given this sentence:

```
"the cat sat on the mat and the dog sat on the floor"
```

Your program should figure out:

| Word | Count |
|------|-------|
| the  | 4     |
| sat  | 2     |
| on   | 2     |
| cat  | 1     |
| mat  | 1     |
| and  | 1     |
| dog  | 1     |
| floor| 1     |

And tell you: **The most frequent word is `"the"` (appears 4 times)**.

---

## Understanding the Problem 🤔

### Why is this tricky with what you already know?

Remember the **Anagram Checker**? You used an **array of 26 integers** to count how many times each letter appeared. That worked great because there are only **26 letters** — you knew exactly how big to make the array.

But what about **words**? How many different words are there? **Hundreds of thousands!** 😱

You can't make an array big enough — and even if you could, how would you know which slot belongs to `"cat"` and which to `"dog"`?

### What we need: a smarter data structure

We need something that can:
- Store any word as a **key**
- Remember a **count** for each word
- Let us **look up** a word's count instantly
- **Grow** as we discover new words

That magical tool is called a **HashMap**! 🗺️

---

## Meet the HashMap 💡

### What is a HashMap?

A HashMap stores **key → value** pairs. Think of it like a dictionary:

```
"the"   →  4
"cat"   →  1
"dog"   →  1
"sat"   →  2
```

You look up a word (the **key**) and get its count (the **value**).

### Arrays vs HashMaps

| | Array | HashMap |
|--|--|--|
| Index by | Number (0, 1, 2...) | Anything (String, Integer...) |
| Size | Fixed | Grows as needed |
| Good for | Counting letters (A-Z) | Counting words (unlimited!) |

### HashMap in Java

```java
import java.util.HashMap;

HashMap<String, Integer> counts = new HashMap<>();
```

The `<String, Integer>` part says: **keys are Strings, values are Integers**. So the key is the word, and the value is the count.

### Basic HashMap Operations

```java
HashMap<String, Integer> counts = new HashMap<>();

// Add or update a value
counts.put("the", 4);
counts.put("cat", 1);

// Look up a value
int c = counts.get("the");        // c = 4

// Check if a key exists
boolean hasIt = counts.containsKey("dog");   // false

// How many keys are stored?
int size = counts.size();          // 2

// Loop through every key
for (String word : counts.keySet()) {
    System.out.println(word + " → " + counts.get(word));
}
```

### The Classic Counting Pattern

Here's the magic line of code you'll use over and over:

```java
counts.put(word, counts.getOrDefault(word, 0) + 1);
```

What does this do? It reads: "store `word` with value (its current count, or 0 if new) + 1".

- If `"the"` is already there with count 3 → becomes 4
- If `"cat"` is brand new → becomes 1

One line, any word, handled perfectly. ✨

---

## Your Task 📝

1. **Take a sentence** (a String like `"the cat sat on the mat"`)
2. **Split it into words** (break it apart at spaces)
3. **Count each word** using a HashMap
4. **Print every word** with its count
5. **Find and print the most frequent word**

### Expected Output

```
Input: "the cat sat on the mat and the dog sat on the floor"

Word counts:
  the → 4
  cat → 1
  sat → 2
  on → 2
  mat → 1
  and → 1
  dog → 1
  floor → 1

Most frequent word: "the" (4 times)
```

---

## Understanding the Tools 💡

### Splitting a String into Words

Java's `String.split()` method breaks a string apart:

```java
String sentence = "the cat sat on the mat";
String[] words = sentence.split(" ");

// words is now: ["the", "cat", "sat", "on", "the", "mat"]
```

The `" "` means "split wherever you see a space".

### Cleaning the Input

Real sentences have punctuation and mixed case! `"The"` and `"the"` should probably count as the same word.

```java
String clean = sentence.toLowerCase();              // lowercase everything
String noPunc = clean.replace(",", "").replace(".", "");   // remove punctuation
```

For more complete cleaning:
```java
String cleaned = sentence.toLowerCase().replaceAll("[^a-z ]", "");
```

(That `[^a-z ]` pattern means "anything that isn't a lowercase letter or space" — remove those!)

### Finding the Maximum in a HashMap

To find the key with the highest value, loop through and track the max:

```java
String topWord = "";
int topCount = 0;

for (String word : counts.keySet()) {
    if (counts.get(word) > topCount) {
        topCount = counts.get(word);
        topWord = word;
    }
}
```

Does this pattern look familiar? It's the **same "track the highest" trick** from the Tournament Bracket problem! Just now the "scores" are word counts and the "players" are words. 🏆

---

## Questions to Guide You

1. **How do you split a sentence into words?**
   - Hint: `.split(" ")` returns a `String[]`

2. **How do you update a word's count if it's already in the map?**
   - Hint: use `getOrDefault(word, 0) + 1` to handle both cases (new word AND existing word) in one line

3. **How do you loop through every word in the HashMap?**
   - Hint: `for (String word : map.keySet())`

4. **How do you find the most common word?**
   - Hint: this is just "find the max" — same pattern as finding the top scorer in a tournament!

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

### The Three-Line Counting Loop

This is the heart of your solution:

```java
for (String word : words) {
    counts.put(word, counts.getOrDefault(word, 0) + 1);
}
```

Three lines. Counts anything. Works for any number of unique words. This pattern is used in **real software everywhere** — search engines, analytics, spam filters, language translators.

### Watch Out For Empty Words

If your sentence has **two spaces in a row** (`"hello  world"`), splitting on a space gives you an empty string in the middle:

```java
"hello  world".split(" ")  →  ["hello", "", "world"]
```

To skip empty words:

```java
for (String word : words) {
    if (word.isEmpty()) continue;   // skip and move on
    counts.put(word, counts.getOrDefault(word, 0) + 1);
}
```

### Printing a HashMap Nicely

```java
for (String word : counts.keySet()) {
    System.out.println("  " + word + " → " + counts.get(word));
}
```

⚠️ **Note:** HashMaps don't guarantee any particular order! Don't be surprised if the words come out in a weird order. (If you want alphabetical order, use a `TreeMap` instead — same methods, sorted keys!)

---

## Testing Your Code 🧪

| Input | Top Word | Top Count |
|-------|----------|-----------|
| `"the cat sat on the mat"` | `"the"` | 2 |
| `"hello hello hello world"` | `"hello"` | 3 |
| `"one"` | `"one"` | 1 |
| `"a a a b b c"` | `"a"` | 3 |
| `"The THE the"` (after cleaning) | `"the"` | 3 |

---

## Pseudocode Templates 📋

### Template 1: Basic Counter (Beginner)

```
READ sentence
SET words = sentence split by spaces
SET counts = empty HashMap<String, Integer>

FOR each word in words:
    SET counts[word] = counts.getOrDefault(word, 0) + 1

FOR each word in counts.keys():
    PRINT word + " → " + counts[word]
```

### Template 2: Clean + Count + Find Max (Intermediate)

```
READ sentence
SET cleaned = sentence.toLowerCase() with punctuation removed
SET words = cleaned split by spaces
SET counts = empty HashMap<String, Integer>

FOR each word in words:
    IF word is not empty:
        SET counts[word] = counts.getOrDefault(word, 0) + 1

SET topWord = ""
SET topCount = 0
FOR each word in counts.keys():
    IF counts[word] > topCount:
        SET topCount = counts[word]
        SET topWord = word

PRINT all counts
PRINT "Most frequent: " + topWord + " (" + topCount + " times)"
```

### Template 3: Top N Words (Advanced)

```
// After counting, find the TOP 3 most common words
FOR i FROM 1 TO 3:
    find the word with the highest count
    print it
    REMOVE it from the HashMap (so it won't be found next time)
```

---

## Interesting Facts 🌟

### About Word Frequency in English:

- The **top 100 most common words** make up about **50%** of all English text!
- The word `"the"` alone makes up about **7%** of English
- The next most common words are: `"of"`, `"and"`, `"to"`, `"a"`, `"in"`, `"is"`, `"it"`, `"you"`, `"that"`
- This pattern is called **Zipf's Law**: the 2nd most common word appears about half as often as the 1st, the 3rd appears a third as often, and so on!

### About HashMaps:

- The "Hash" in HashMap comes from a **hash function** — a mathematical trick that turns a word into a number really fast, so the computer can find it instantly
- HashMaps are one of the most-used data structures in all of programming
- Python calls them `dict` (dictionary), JavaScript calls them `Object` or `Map`, but they all work the same way!

### About This Problem:

- Search engines like Google use word counting (on a MUCH bigger scale) to figure out what a webpage is about
- Spam filters count word frequencies to detect junk email
- Language learning apps use frequency lists to teach you the **most useful words first**

---

## Challenge Questions 🎯

After you solve it, try these:

1. **In the sentence `"the the the"`, what's the count of `"the"`?** Does your program handle this correctly?
2. **What if a word appears with different capitalization?** Should `"Hello"` and `"hello"` count as the same word? How does your code handle it?
3. **What's the count of a word that doesn't appear at all?** Trick question — does it even show up in your HashMap? Why not?
4. **Can your program handle punctuation?** Try `"Hello, world! Hello."` — does it count `"hello"` correctly?
5. **What happens with an empty sentence `""`?** Your program shouldn't crash — what should it print?

---

## Optimization Challenge 🚀

### Basic Solution:
- Split the sentence, loop through words, count each one in a HashMap

### Intermediate Solution:
- Clean the input (lowercase, remove punctuation) so `"The"`, `"the"`, and `"the,"` all count as the same word
- Find the most frequent word

### Advanced Solution:
- Print the **top 3 most frequent words** in order
- **Two-pass bonus:** Find the most frequent word **that appears more than once** (ignore words that only appear once)
- **Real-world bonus:** Ignore common "stop words" like `"the"`, `"and"`, `"of"` — only count the interesting words!

---

## Visualize It! 🎨

Watch a HashMap grow as you process each word of `"the cat sat on the mat"`:

```
Start:           {}
After "the":     {the: 1}
After "cat":     {the: 1, cat: 1}
After "sat":     {the: 1, cat: 1, sat: 1}
After "on":      {the: 1, cat: 1, sat: 1, on: 1}
After "the":     {the: 2, cat: 1, sat: 1, on: 1}   ← "the" was already there!
After "mat":     {the: 2, cat: 1, sat: 1, on: 1, mat: 1}
```

Notice how the HashMap **grew** when it saw a new word, but just **updated the count** when it saw a repeat. That's the superpower arrays don't have!

---

## Reflection Questions 🤔

1. **Why wouldn't an array of 26 integers work for this problem?** (Like you used in the Anagram Checker?)
2. **In your own words, explain what a HashMap is and why it's useful here.**
3. **The line `counts.put(word, counts.getOrDefault(word, 0) + 1)` handles two different cases in one line — what are they?**
4. **How is finding the most frequent word similar to finding the winner in the Tournament Bracket problem?**
5. **Where in real life do you see word counting in action?** (Think: Google searches, Twitter trends, YouTube captions, autocomplete...)

---

## Bonus: Word Cloud Generator 🎨

A **word cloud** is a picture where the most common words appear the biggest. Can you make a text version?

```
Input: "the cat sat on the mat and the dog sat on the floor"

Output:
  THE THE THE THE
  sat sat
  on on
  cat
  mat
  and
  dog
  floor
```

Each word is printed as many times as it appears, with the most common ones first. Can you do it?

---

## Good Luck! 🌟

You've just unlocked one of the most powerful tools in all of programming: **the HashMap**. Once you see it, you'll spot opportunities to use it everywhere — counting, grouping, looking things up, caching results.

The trick that counted letters in the Anagram Checker (using an array of 26) just got a **massive upgrade**. Now you can count **anything**, not just letters. 🚀

**Happy counting!** 📚✨
