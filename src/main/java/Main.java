import java.util.Scanner;

/**
 * PROVIDED - a println-tracing driver. Run this before you read a single test.
 * It calls every Clinic method with one input, prints what came back, and
 * prints what SHOULD have come back next to it. The autograder never runs it.
 *
 * It will not reach the last line. When it crashes, do not close the window:
 * read the stack trace. The first line that mentions Clinic.java names the
 * method and the exact line number where the exception happened. That is
 * lesson 1.5 in one screen.
 *
 * Change the inputs. Add more lines. This file is yours.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Debugging Clinic - sample inputs ===");
        System.out.println();

        int[] scores = {1, 2};
        System.out.println("average({1, 2})          got " + Clinic.average(scores)
                + "    expected 1.5");

        System.out.println("isLeapYear(2023)         got " + Clinic.isLeapYear(2023)
                + "   expected false");
        System.out.println("isLeapYear(2000)         got " + Clinic.isLeapYear(2000)
                + "    expected true");

        System.out.println("sumTo(5)                 got " + Clinic.sumTo(5)
                + "      expected 15");

        // A word that came from input, exactly like Scanner on System.in would give you.
        String typed = new Scanner("cat dog").next();
        System.out.println("sameWord(\"cat\", typed)   got " + Clinic.sameWord("cat", typed)
                + "  expected true");

        int[] negatives = {-5, -2, -9};
        System.out.println("maxOf({-5, -2, -9})      got " + Clinic.maxOf(negatives)
                + "      expected -2");

        System.out.println();
        System.out.println("Now the one that crashes. Read the stack trace below this line.");
        System.out.println("countVowels(\"hello\")     got " + Clinic.countVowels("hello")
                + "      expected 2");

        System.out.println();
        System.out.println("If you can read this line, countVowels no longer crashes.");
    }
}
