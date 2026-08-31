import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CountVowelsTest {
    @DisplayName("countVowels: must not throw on \"hello\" (read the exception - which index did it ask for?)")
    @Test
    void countVowels_Test01() {
        assertDoesNotThrow(() -> Clinic.countVowels("hello"),
            "a String of length 5 has indexes 0 through 4 - the loop is asking for one more");
    }

    @DisplayName("countVowels: \"hello\" -> 2")
    @Test
    void countVowels_Test02() {
        assertEquals(2, Clinic.countVowels("hello"));
    }

    @DisplayName("countVowels: \"rhythm\" -> 0")
    @Test
    void countVowels_Test03() {
        assertEquals(0, Clinic.countVowels("rhythm"));
    }

    @DisplayName("countVowels: empty String -> 0")
    @Test
    void countVowels_Test04() {
        assertEquals(0, Clinic.countVowels(""), "an empty String has no index 0 to look at");
    }

    @DisplayName("countVowels: \"a\" -> 1")
    @Test
    void countVowels_Test05() {
        assertEquals(1, Clinic.countVowels("a"));
    }

    @DisplayName("countVowels: uppercase vowels count (\"AEIOU\" -> 5)")
    @Test
    void countVowels_Test06() {
        assertEquals(5, Clinic.countVowels("AEIOU"));
    }

    @DisplayName("countVowels: \"queue\" -> 4")
    @Test
    void countVowels_Test07() {
        assertEquals(4, Clinic.countVowels("queue"));
    }

    @DisplayName("countVowels: \"Programming\" -> 3")
    @Test
    void countVowels_Test08() {
        assertEquals(3, Clinic.countVowels("Programming"));
    }

    @DisplayName("countVowels: y is not a vowel here (\"sky\" -> 0)")
    @Test
    void countVowels_Test09() {
        assertEquals(0, Clinic.countVowels("sky"));
    }
}
