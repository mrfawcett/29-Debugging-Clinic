import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class IsLeapYearTest {
    @DisplayName("isLeapYear: 2024 -> true (ordinary leap year)")
    @Test
    void isLeapYear_Test01() {
        assertTrue(Clinic.isLeapYear(2024));
    }

    @DisplayName("isLeapYear: 2000 -> true (century year divisible by 400)")
    @Test
    void isLeapYear_Test02() {
        assertTrue(Clinic.isLeapYear(2000));
    }

    @DisplayName("isLeapYear: 1900 -> false (century year NOT divisible by 400)")
    @Test
    void isLeapYear_Test03() {
        assertFalse(Clinic.isLeapYear(1900));
    }

    @DisplayName("isLeapYear: 2023 -> false (not divisible by 4 - trace which half of the || is true)")
    @Test
    void isLeapYear_Test04() {
        assertFalse(Clinic.isLeapYear(2023),
            "2023 % 4 is 3, so the answer must be false - write down all three comparisons, then check how Java groups them");
    }

    @DisplayName("isLeapYear: 2022 -> false")
    @Test
    void isLeapYear_Test05() {
        assertFalse(Clinic.isLeapYear(2022));
    }

    @DisplayName("isLeapYear: 2100 -> false (the next century year that is not a leap year)")
    @Test
    void isLeapYear_Test06() {
        assertFalse(Clinic.isLeapYear(2100));
    }

    @DisplayName("isLeapYear: 1600 -> true")
    @Test
    void isLeapYear_Test07() {
        assertTrue(Clinic.isLeapYear(1600));
    }

    @DisplayName("isLeapYear: 1999 -> false")
    @Test
    void isLeapYear_Test08() {
        assertFalse(Clinic.isLeapYear(1999));
    }

    @DisplayName("isLeapYear: 2004 -> true")
    @Test
    void isLeapYear_Test09() {
        assertTrue(Clinic.isLeapYear(2004));
    }

    @DisplayName("isLeapYear: 1 -> false")
    @Test
    void isLeapYear_Test10() {
        assertFalse(Clinic.isLeapYear(1));
    }
}
