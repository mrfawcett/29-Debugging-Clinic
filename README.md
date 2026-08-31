# Debugging Clinic

**Unit 1 — Programming Fundamentals & Debugging** · Pairs with lecture 1.5 Debugging Practices & Hand-Tracing (and the traps from 1.4)

This assignment is backwards. Nothing is blank. Every method in `Clinic.java`
is already written, it all compiles, and **every method is wrong**. Six
methods, six bugs, exactly one bug per method. Some give the wrong answer on
some inputs. One crashes on every input. Your job is to fix them — not
rewrite them. In most cases the fix is one line; in several it is one
character.

Why this matters more than writing code from scratch: from here to May you
will spend more time finding out why your code is wrong than typing it in.
That is a skill, it has a method, and the method is what this clinic drills.

---

## The clinic format

1. **The tests are correct.** They were written against a working version.
   If a test fails, the method is wrong, not the test.
2. **Every method has exactly one bug.** When one fix turns the whole class
   green, you are done with that method. If you are changing three things,
   stop — you have not found it yet.
3. **The failing test is your clue.** Its name tells you the input and the
   expected answer. Its message tells you what came back instead. That pair —
   *expected vs actual* — is where every debugging session starts.
4. **The starter compiles.** So there are no compile errors to find. All six
   bugs are runtime errors (the program crashes) or logic errors (the program
   runs and is wrong). You met that split in 1.5; here is the field version.

## What you are given

| File | Status | Purpose |
|---|---|---|
| `src/main/java/Clinic.java` | **you fix this** | six methods, six bugs |
| `src/main/java/Main.java` | provided | a println-tracing driver — prints each method's answer next to the right answer, then crashes on purpose |
| `src/test/java/*Test.java` | provided | the autograder's tests — read them, they are the clues |
| `pom.xml`, `grading.json` | provided | build and grading setup — do not edit |

**Run `Main` first.** It prints five wrong answers side by side with the right
ones, then dies with a stack trace. That screen is the whole assignment in
miniature.

## What to fix

| Method | Points | What it should do |
|---|---|---|
| `double average(int[] scores)` | 15 | The average of the scores, decimals included. |
| `int countVowels(String s)` | 10 | How many characters of `s` are `a e i o u` (either case). |
| `boolean isLeapYear(int year)` | **20** | Divisible by 4 — except century years, which must be divisible by 400. |
| `int sumTo(int n)` | 15 | `1 + 2 + … + n`; `0` when `n` is `0`. |
| `boolean sameWord(String a, String b)` | 15 | `true` if the two Strings have the same characters, same case, same length. |
| `int maxOf(int[] values)` | **25** | The largest value in the array. |

Each method's Javadoc gives the exact rule and two or three examples. Those
examples are all the specification you get. The tests check the same rule
with more inputs.

---

## How to read a failing test

Run one class at a time:

```
mvn test -Dtest=SumToTest
```

Find the first `FAILED` line. It looks like this:

```
sumTo: 2 -> 3 (trace it: total should be 1 after the first pass and 3 after the second)
  expected: <3> but was: <2>
```

Three facts are sitting in that message:

| Fact | Where it is |
|---|---|
| the input | `sumTo(2)` — from the test name |
| what should come out | `expected: <3>` |
| what actually came out | `but was: <2>` |

Now you have a concrete case. Do **not** stare at the code hoping to see the
bug. Trace the code with that exact input (next section). The moment your
trace produces a value the test did not expect, you are standing on the bug.

Some tests **pass** on the broken code. That is deliberate and it is a clue
too: `sumTo(1)` passes and `sumTo(2)` fails. Ask what is different about the
second pass through the loop that is not true of the first.

## How to read a stack trace

One method throws instead of returning. When `Main` reaches it you see:

```
Exception in thread "main" java.lang.StringIndexOutOfBoundsException: Index 5 out of bounds for length 5
    at java.base/...
    at java.base/java.lang.String.charAt(String.java:...)
    at Clinic.countVowels(Clinic.java:56)
    at Main.main(Main.java:44)
```

Read it top to bottom, but skip everything that starts with `java.base` —
that is Java's own code and it is not broken. The first line that names
**your** file is the one you want: `Clinic.countVowels(Clinic.java:56)`.
Method, file, line number. Go to that line.

Then read the exception message like a sentence: *"Index 5 out of bounds for
length 5."* The String has 5 characters. Their indexes are 0, 1, 2, 3, 4.
Something asked for index 5. Now ask: what is the biggest value the loop
variable reaches?

## How to hand-trace

A trace table is a grid with one column per variable and one row per line of
code that changes something. You fill it in slowly, by hand, doing exactly
what Java does — no skipping, no "obviously". Here is `sumTo(2)` traced
against the **fixed** version:

```java
int total = 0;
for (int i = 1; i <= n; i++) {
    total += i;
}
return total;
```

| step | line | `n` | `i` | `total` | note |
|---|---|---|---|---|---|
| 1 | `int total = 0` | 2 | — | 0 | |
| 2 | `i = 1; 1 <= 2?` | 2 | 1 | 0 | true, enter loop |
| 3 | `total += i` | 2 | 1 | **1** | |
| 4 | `i++; 2 <= 2?` | 2 | 2 | 1 | true, enter loop |
| 5 | `total += i` | 2 | 2 | **3** | |
| 6 | `i++; 3 <= 2?` | 2 | 3 | 3 | false, exit |
| 7 | `return total` | | | 3 | matches the test |

Now do the same table for the **starter's** `sumTo(2)`. Add a row for every
line inside the loop, including the one the fixed version does not have. The
row where your `total` column disagrees with the one above is the bug.

Rules for a trace that actually finds things:

- **One line, one row.** The instant you write two lines in one row you have
  started guessing.
- **Write the value, not the expression.** In the `total` column write `3`,
  not `total + i`.
- **Evaluate conditions to `true` or `false` explicitly**, and write which
  way you went.
- **Be Java, not yourself.** `7 / 2` is `3`. `9 / 5` is `1`. `i <= 5` runs
  six times. `&&` is evaluated before `||`. If your gut disagrees with the
  language, the language wins — and that is precisely where bugs hide.
- **For booleans, trace each half separately.** For an `||` or `&&` write
  down the value of the left side, the value of the right side, and *only
  then* combine them the way Java groups them.

## The usual suspects

Every bug in this clinic is a classic from lectures 1.1–1.5. This checklist
is longer than six items on purpose — which method has which is for you to
find, and some items here are not used at all.

- `int / int` throws away the decimals, even if the answer is stored in a `double`
- `<=` where `<` was meant, or the other way round — the loop runs one time too many or too few
- `==` on Strings asks "same object?", not "same letters?"
- `&&` binds tighter than `||`, so `a || b && c` means `a || (b && c)`
- the accumulator is set back to its starting value where it should not be
- a "biggest so far" variable that starts at `0` is wrong when every value is below `0`
- `(int)` casts only the thing right next to it — `(int) x * 2` casts `x`, not the product
- `=` where `==` was meant
- a `+ 1` missing from a count of how many values are in a range

Do not go down this list trying each one. Trace first, then match what you
found to a name on the list. The list is for the write-up, not the hunt.

---

## Examples

Right answers, straight from the Javadoc. If your fixed method gives these,
it will pass.

```
average({90, 80})      ->  85.0          average({1, 2})      ->  1.5
countVowels("hello")   ->  2             countVowels("")      ->  0
isLeapYear(2024)       ->  true          isLeapYear(1900)     ->  false
isLeapYear(2000)       ->  true          isLeapYear(2023)     ->  false
sumTo(5)               ->  15            sumTo(0)             ->  0
sameWord("cat","cat")  ->  true          sameWord("cat","Cat")->  false
maxOf({3, 9, 2})       ->  9             maxOf({-5, -2, -9})  ->  -2
```

## Running the tests

`mvn test` runs everything; `mvn test -Dtest=MaxOfTest` runs one rubric line.

| Test class | Rubric line | Points |
|---|---|---|
| `AverageTest` | average fixed | 15 |
| `CountVowelsTest` | countVowels fixed | 10 |
| `IsLeapYearTest` | isLeapYear fixed | 20 |
| `SumToTest` | sumTo fixed | 15 |
| `SameWordTest` | sameWord fixed | 15 |
| `MaxOfTest` | maxOf fixed | 25 |

The autograder awards a rubric line only when **every** test in that class
passes. A fix that makes `maxOf({-5, -2, -9})` right but breaks
`maxOf({3, 9, 2})` earns 0 of 25 — after every fix, rerun the whole class,
not just the test that was red.

## Suggested order

1. **Run `Main`.** Read the six lines it prints, then read the stack trace.
   You now know which method crashes and roughly what is wrong with five
   others, before you have opened a test.
2. **`countVowels`** — the stack trace hands you the line number. Fix it, run
   `CountVowelsTest`, and `Main` will run to the end.
3. **`sumTo`** — do the trace table above for the starter. This is the one
   to do properly on paper; it is the shape of every accumulator bug you will
   ever write.
4. **`average`** — trace `{1, 2}`. Watch the types, not just the values.
5. **`maxOf`** — trace `{-5, -2, -9}`. Write down `max` *before* the loop.
6. **`sameWord`** — read `SameWordTest` carefully. Notice which tests pass and
   which fail, and where the two Strings in the failing tests came from.
7. **`isLeapYear`** — trace `2023`. Write the value of each of the three
   comparisons, then combine them the way Java does, not the way the comment
   reads.

## Rules of the road

- **Fix, do not rewrite.** Each method should end up one small edit away from
  where it started. If you find yourself replacing a whole method, back up;
  you are supposed to be finding the bug, not routing around it.
- AP Java subset only. You will not need anything that is not already in the
  file — no `StringBuilder`, no `Arrays`, no `String.split`.
- Do not change method headers. Do not add methods. Do not change the
  Javadoc rules.
- Do not touch `src/test`, `pom.xml`, `grading.json`, or `.github`. The
  autograder checks that they are byte-identical to the template before it
  runs a single test; if they differ it stops and awards nothing, and the
  change shows up in the roster.
- For each method, leave a one-line comment on the line you changed saying
  what the bug was, in your own words: `// was int division`. That is how
  you show your work in a clinic.
