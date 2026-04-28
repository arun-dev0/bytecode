# Problem: The Birthday Club 🎂

## The Challenge

Your class is planning birthday parties — but instead of throwing **one party per student**, the teacher wants to throw **one party per month** and invite everyone born in that month together!

You're given two lists: the **names** of students and the **month** each one was born in:

```
names  = ["Alice", "Bob", "Charlie", "Diana", "Eve", "Frank", "Grace"]
months = ["March", "July", "March", "December", "July", "March", "April"]
```

Alice is born in March, Bob in July, Charlie in March, and so on.

**Your Mission:** Build a program that **groups students by birth month**, and for each month prints the list of students born that month.

### Expected Output

```
March: Alice, Charlie, Frank
July: Bob, Eve
December: Diana
April: Grace

The busiest month is March with 3 students.
```

---

## Understanding the Problem 🤔

### This feels familiar... but different

Remember the **Word Frequency Counter**? You used a `HashMap<String, Integer>` to count how many times each word appeared. Something like:

```
"the"  → 4
"cat"  → 1
```

This problem is similar — you're grouping things by a key (the month) — but instead of storing a **count**, you need to store a **list of names** for each month:

```
"March"  → [Alice, Charlie, Frank]
"July"   → [Bob, Eve]
```

The value isn't a number anymore. It's a whole **list**! 🤯

### Why we can't just use counting

If you tried a `HashMap<String, Integer>`, you'd only know **how many** students are in each month — not **who** they are. We need to remember the actual names, not just a count.

So we need a HashMap where the **value is itself a list**.

---

## Meet the HashMap-of-Lists 💡

### The Type Signature

Here's how you declare it in Java:

```java
import java.util.HashMap;
import java.util.ArrayList;

HashMap<String, ArrayList<String>> club = new HashMap<>();
```

Read this as: **"a HashMap where keys are Strings and values are lists of Strings"**.

### What's an ArrayList?

An `ArrayList` is like an array that can **grow**. You don't have to know its size in advance.

```java
ArrayList<String> list = new ArrayList<>();
list.add("Alice");           // list is now: [Alice]
list.add("Charlie");         // list is now: [Alice, Charlie]
list.add("Frank");           // list is now: [Alice, Charlie, Frank]

int n = list.size();         // n = 3
String first = list.get(0);  // "Alice"
```

Think of `ArrayList` as a **stretchy array**. You've been using fixed arrays like `int[26]` — this is the next step up.

### The Grouping Pattern

Here's the key pattern for this problem. It's worth reading **slowly**:

```java
String month = "March";
String name  = "Alice";

// Does "March" already have a list? If not, create an empty one.
if (!club.containsKey(month)) {
    club.put(month, new ArrayList<>());
}

// Now grab the list for "March" and add Alice to it.
club.get(month).add(name);
```

After processing `("Alice", "March")`:
```
club = {March: [Alice]}
```

After processing `("Charlie", "March")`:
```
club = {March: [Alice, Charlie]}    ← Charlie joined the existing list!
```

### The One-Line Shortcut

Remember `getOrDefault(word, 0) + 1` from the Word Frequency problem? There's a similar shortcut here, called `computeIfAbsent`:

```java
club.computeIfAbsent(month, k -> new ArrayList<>()).add(name);
```

In plain English: "If this month doesn't have a list yet, create one. Then add the name to that list."

One line. Handles new months AND existing months. ✨

(Don't worry if the `k -> new ArrayList<>()` looks weird — it's called a **lambda**, and you'll see tons of them in real Java code. For now, just memorize the pattern.)

---

## Your Task 📝

1. **Loop through** the parallel lists `names` and `months` using an index `i`
2. **Group students into a HashMap** where each key is a month and the value is a list of names
3. **Print each month** with its list of students
4. **Find the month** with the most students and print it

---

## Questions to Guide You

1. **How do you connect a name and a month that are in separate lists?**
   - Hint: same index `i` in both — just like the Class Report Card problem!

2. **When you see a new month for the first time, what needs to happen?**
   - Hint: you can't add a name to a list that doesn't exist yet — you need to **create an empty list first**

3. **When you see a month that's already been seen, what do you do?**
   - Hint: grab the existing list and just add the new name to it

4. **How do you find the month with the most students?**
   - Hint: loop through the HashMap, check the `.size()` of each list, track the biggest — same "track the max" trick you've used before!

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

### Printing a List Nicely

ArrayLists print with square brackets by default:

```java
System.out.println(list);       // prints: [Alice, Charlie, Frank]
```

To print names separated by commas without the brackets:

```java
ArrayList<String> list = club.get("March");
for (int i = 0; i < list.size(); i++) {
    System.out.print(list.get(i));
    if (i < list.size() - 1) {
        System.out.print(", ");
    }
}
System.out.println();
```

Or use Java's built-in `String.join()`:

```java
System.out.println(String.join(", ", list));   // prints: Alice, Charlie, Frank
```

### Looping Through the HashMap

```java
for (String month : club.keySet()) {
    ArrayList<String> students = club.get(month);
    System.out.println(month + ": " + String.join(", ", students));
}
```

### Finding the Busiest Month

This is just "find the max" again — but now you're comparing `.size()` of each list:

```java
String busiest = "";
int maxCount = 0;

for (String month : club.keySet()) {
    int count = club.get(month).size();
    if (count > maxCount) {
        maxCount = count;
        busiest = month;
    }
}
```

Does this look familiar? It's the **exact same pattern** as finding the top student (Report Card), the top scorer (Tournament Bracket), and the most frequent word (Word Frequency Counter). One pattern, used everywhere! 🏆

---

## Testing Your Code 🧪

| Input | Groups | Busiest Month |
|-------|--------|---------------|
| names=`["Alice","Bob"]`, months=`["Jan","Feb"]` | Jan: [Alice]<br>Feb: [Bob] | Tie (or first one) |
| names=`["Alice","Bob","Charlie"]`, months=`["Jan","Jan","Jan"]` | Jan: [Alice,Bob,Charlie] | Jan |
| names=`["Sam"]`, months=`["July"]` | July: [Sam] | July |
| Empty lists | (nothing) | None |

---

## Pseudocode Templates 📋

### Template 1: The Clear Way (Beginner)

```
SET club = empty HashMap<String, ArrayList<String>>

FOR i FROM 0 TO length of names - 1:
    SET name = names[i]
    SET month = months[i]
    
    IF club does NOT contain the key month:
        ADD a new empty ArrayList at key month
    
    GET the list at key month
    ADD name to that list

FOR each month in club:
    PRINT month + ": " + the list at month

FIND the key whose list has the largest size
PRINT "The busiest month is " + that key
```

### Template 2: Using computeIfAbsent (Intermediate)

```
SET club = empty HashMap<String, ArrayList<String>>

FOR i FROM 0 TO length of names - 1:
    club.computeIfAbsent(months[i], k -> new empty list).add(names[i])

FOR each month in club:
    PRINT month + ": " + joined list at month

FIND busiest month and print it
```

### Template 3: Sorted Output (Advanced)

```
// Sort each month's list of names alphabetically before printing
FOR each month in club:
    SORT club.get(month) alphabetically
    PRINT month + ": " + joined list

// Print months in calendar order (Jan, Feb, Mar, ...) instead of random order
// Hint: create a String[] with months in order, loop through that
```

---

## Interesting Facts 🌟

### About Grouping:

- **Grouping by a key** is one of the most common operations in programming — databases, spreadsheets, and analytics tools all do this constantly
- In SQL (a database language), this exact operation is called `GROUP BY`
- Python has a tool called `defaultdict(list)` that does the same thing; Java's `computeIfAbsent` is the equivalent

### About Birthdays:

- In any group of **23 people**, there's a **>50% chance** that two people share the same birthday! This is called the **Birthday Paradox**.
- The most common birth month in the U.S. is **September** — count back 9 months and you'll see why 😉
- Only about 1 in 1,461 people are born on **February 29th** (leap day)

### About Nested Data Structures:

- A `HashMap<String, ArrayList<String>>` is a **nested** structure — a collection inside a collection
- You can go deeper: `HashMap<String, HashMap<String, Integer>>` — a map of maps!
- Real-world data is almost always nested. A school has classes, a class has students, a student has grades...

---

## Challenge Questions 🎯

After you solve it, try these:

1. **What happens if the same name appears twice with the same month?** (e.g., two students named "Alex" both born in May.) Does your code add both? Should it?
2. **What happens if the names and months lists have different lengths?** Does your code crash? How could you protect against that?
3. **Can you sort the names within each month alphabetically?**
4. **Can you print the months in calendar order** (January, February, ...) rather than the random HashMap order?
5. **What if you wanted to group by birth YEAR instead of month?** How much of your code would change?

---

## Optimization Challenge 🚀

### Basic Solution:
- Use `if (!map.containsKey(...)) map.put(...)` before adding to the list

### Intermediate Solution:
- Use `computeIfAbsent` to handle new-key and existing-key cases in one line

### Advanced Solution:
- Print months in **calendar order**, not HashMap order
- Within each month, print names **alphabetically**
- Handle ties for the busiest month (what if March and July both have 3 students?)

---

## Visualize It! 🎨

Watch the HashMap grow as we process each student:

```
Start:                {}
("Alice",  "March"):  {March: [Alice]}
("Bob",    "July"):   {March: [Alice], July: [Bob]}
("Charlie","March"):  {March: [Alice, Charlie], July: [Bob]}       ← joined existing list!
("Diana",  "Dec"):    {March: [Alice, Charlie], July: [Bob], Dec: [Diana]}
("Eve",    "July"):   {March: [Alice, Charlie], July: [Bob, Eve], Dec: [Diana]}
("Frank",  "March"):  {March: [Alice, Charlie, Frank], July: [Bob, Eve], Dec: [Diana]}
("Grace",  "April"):  {March: [Alice, Charlie, Frank], July: [Bob, Eve], Dec: [Diana], April: [Grace]}
```

Two things are happening at once:
- **New months** cause the HashMap to grow sideways
- **Existing months** cause their lists to grow downward

Compare this to Word Frequency, where the counts just went up by 1 each time. Here, each "count" is a whole list that's collecting real data! 📈

---

## Reflection Questions 🤔

1. **Why does this problem need `HashMap<String, ArrayList<String>>` instead of `HashMap<String, Integer>`?**
2. **In the Word Frequency problem, each "update" was just adding 1. What's the "update" step in this problem?**
3. **What's the difference between counting things and grouping things?** Can you think of examples of each from everyday life?
4. **The Tournament Bracket problem used 2D arrays — lists inside a list. This problem uses lists inside a HashMap. What's the advantage of using a HashMap instead of a 2D array here?**
5. **Where in real life do you see grouping?** (Think: email folders, music playlists, contact lists by category, phone call history...)

---

## Bonus: Class Yearbook 📖

Extend your program so that for each month, it prints a fancy "yearbook page":

```
═══════════════════════════════
         MARCH BIRTHDAYS
═══════════════════════════════
  🎂 Alice
  🎂 Charlie
  🎂 Frank
───────────────────────────────
  Total: 3 students
═══════════════════════════════
```

Can you loop through each month and print a page like this? Add fun decorations!

---

## Good Luck! 🌟

You just leveled up your HashMap skills! Going from `HashMap<String, Integer>` (counting) to `HashMap<String, ArrayList<String>>` (grouping) is a huge conceptual jump — and it's the same jump professional programmers make when they graduate from "how many?" questions to "which ones?" questions.

**This pattern shows up everywhere.** Grouping students by grade. Grouping emails by sender. Grouping songs by artist. Grouping orders by customer. Once you see it, you'll see it *everywhere*.

**Happy grouping!** 🎂✨
