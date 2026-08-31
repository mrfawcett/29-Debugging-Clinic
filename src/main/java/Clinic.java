/** READ FIRST
 * This assignment is different. Nothing here is blank. Every method is
 * already written, and every method is WRONG.
 *
 * Six methods, six bugs, exactly one bug per method. The code compiles.
 * Some methods give a wrong answer on some inputs; at least one crashes.
 * Your job is to FIX them, not rewrite them. In most cases the fix is one
 * line, and in several it is a single character.
 *
 * The tests are correct and they are your clue. Run them. Each failing test
 * tells you the input, the answer it expected, and the answer it got (or the
 * exception it hit). Take that input and trace the method BY HAND, one line
 * at a time, writing down every variable after every step. The line where
 * your trace and the expected answer part ways is where the bug lives.
 *
 * Every bug in this file is one you have seen on a slide in 1.1 through 1.5:
 * a value that is not what you think it is, a loop that runs one time too
 * many or too few, an operator that binds tighter than you expected, a
 * variable that forgets, a comparison that asks the wrong question, a
 * starting value that is not safe. That list is longer than six on purpose.
 *
 * Main.java prints each method's answer for a sample input. Run it and read
 * the stack trace when it crashes - the line number points at a method.
 *
 * Rules: fix the bug inside each method. Do not change any method header.
 * Do not add new methods. AP Java subset only - you will not need anything
 * that is not already in this file.
 */
public class Clinic {

    /** FIX THIS METHOD - one bug
     * Precondition: scores.length >= 1
     * Returns the average of the scores as a double.
     *     average({90, 80})  ->  85.0
     *     average({1, 2})    ->  1.5
     */
    public static double average(int[] scores) {
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        return sum / scores.length;
    }

    /** FIX THIS METHOD - one bug
     * Precondition: s is not null
     * Returns how many characters of s are vowels (a, e, i, o, u, either case).
     *     countVowels("hello")  ->  2
     *     countVowels("rhythm") ->  0
     *     countVowels("")       ->  0
     */
    public static int countVowels(String s) {
        String vowels = "aeiouAEIOU";
        int count = 0;
        for (int i = 0; i <= s.length(); i++) {
            char c = s.charAt(i);
            if (vowels.indexOf(c) >= 0) {
                count++;
            }
        }
        return count;
    }

    /** FIX THIS METHOD - one bug
     * Precondition: year > 0
     * Returns true if year is a leap year. A year is a leap year when it is
     * divisible by 4, EXCEPT that a century year (divisible by 100) is a
     * leap year only when it is also divisible by 400.
     *     isLeapYear(2024) -> true      isLeapYear(2023) -> false
     *     isLeapYear(2000) -> true      isLeapYear(1900) -> false
     */
    public static boolean isLeapYear(int year) {
        // not a century year, or a 400-year - and in every case a multiple of 4
        return year % 100 != 0 || year % 400 == 0 && year % 4 == 0;
    }

    /** FIX THIS METHOD - one bug
     * Precondition: n >= 0
     * Returns 1 + 2 + ... + n. Returns 0 when n is 0.
     *     sumTo(5)  ->  15
     *     sumTo(1)  ->  1
     */
    public static int sumTo(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total = 0;
            total += i;
        }
        return total;
    }

    /** FIX THIS METHOD - one bug
     * Precondition: a and b are not null
     * Returns true if a and b are the same word: same letters, same case,
     * same length. Where the two Strings came from must not matter.
     *     sameWord("cat", "cat")  ->  true
     *     sameWord("cat", "Cat")  ->  false
     *     sameWord("cat", "dog")  ->  false
     */
    public static boolean sameWord(String a, String b) {
        return a == b;
    }

    /** FIX THIS METHOD - one bug
     * Precondition: values.length >= 1
     * Returns the largest value in the array.
     *     maxOf({3, 9, 2})    ->  9
     *     maxOf({-5, -2, -9}) ->  -2
     */
    public static int maxOf(int[] values) {
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }
        return max;
    }
}
