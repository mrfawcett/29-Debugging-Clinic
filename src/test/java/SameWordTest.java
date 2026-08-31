import java.util.Scanner;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SameWordTest {
    @DisplayName("sameWord: two identical literals -> true (\"cat\", \"cat\")")
    @Test
    void sameWord_Test01() {
        assertTrue(Clinic.sameWord("cat", "cat"));
    }

    @DisplayName("sameWord: different words -> false (\"cat\", \"dog\")")
    @Test
    void sameWord_Test02() {
        assertFalse(Clinic.sameWord("cat", "dog"));
    }

    @DisplayName("sameWord: case matters (\"cat\", \"Cat\") -> false")
    @Test
    void sameWord_Test03() {
        assertFalse(Clinic.sameWord("cat", "Cat"), "same letters, different case - not the same word");
    }

    @DisplayName("sameWord: a word read by a Scanner equals the same word typed as a literal")
    @Test
    void sameWord_Test04() {
        String fromInput = new Scanner("cat dog").next();
        assertTrue(Clinic.sameWord("cat", fromInput),
            "\"cat\" and a \"cat\" that came from input hold the same letters - are you asking about the letters or about the object?");
    }

    @DisplayName("sameWord: a word built by concatenation equals the literal (\"c\" + \"at\" at run time)")
    @Test
    void sameWord_Test05() {
        String start = "c";
        String built = start + "at";
        assertTrue(Clinic.sameWord("cat", built),
            "built at run time, so it is a different object with the same letters");
    }

    @DisplayName("sameWord: works the other way round too (built word first, literal second)")
    @Test
    void sameWord_Test06() {
        String start = "do";
        String built = start + "g";
        assertTrue(Clinic.sameWord(built, "dog"));
    }

    @DisplayName("sameWord: two words read from the same Scanner that are spelled the same -> true")
    @Test
    void sameWord_Test07() {
        Scanner sc = new Scanner("echo echo");
        String first = sc.next();
        String second = sc.next();
        assertTrue(Clinic.sameWord(first, second));
    }

    @DisplayName("sameWord: a prefix is not the same word (\"cat\", \"cats\") -> false")
    @Test
    void sameWord_Test08() {
        assertFalse(Clinic.sameWord("cat", "cats"));
    }

    @DisplayName("sameWord: two empty Strings -> true")
    @Test
    void sameWord_Test09() {
        assertTrue(Clinic.sameWord("", ""));
    }

    @DisplayName("sameWord: a word with a trailing space is not the same word (\"cat\", \"cat \") -> false")
    @Test
    void sameWord_Test10() {
        assertFalse(Clinic.sameWord("cat", "cat "));
    }
}
