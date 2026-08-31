import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MaxOfTest {
    @DisplayName("maxOf: {3, 9, 2} -> 9")
    @Test
    void maxOf_Test01() {
        assertEquals(9, Clinic.maxOf(new int[]{3, 9, 2}));
    }

    @DisplayName("maxOf: {7} -> 7")
    @Test
    void maxOf_Test02() {
        assertEquals(7, Clinic.maxOf(new int[]{7}));
    }

    @DisplayName("maxOf: largest value last ({1, 2, 3}) -> 3")
    @Test
    void maxOf_Test03() {
        assertEquals(3, Clinic.maxOf(new int[]{1, 2, 3}));
    }

    @DisplayName("maxOf: largest value first ({50, 10, 20}) -> 50")
    @Test
    void maxOf_Test04() {
        assertEquals(50, Clinic.maxOf(new int[]{50, 10, 20}));
    }

    @DisplayName("maxOf: all negative ({-5, -2, -9}) -> -2 (trace it: where does the answer 0 come from?)")
    @Test
    void maxOf_Test05() {
        assertEquals(-2, Clinic.maxOf(new int[]{-5, -2, -9}),
            "0 is not in this array, so it cannot be the answer - what is max before the loop starts?");
    }

    @DisplayName("maxOf: a single negative value ({-1}) -> -1")
    @Test
    void maxOf_Test06() {
        assertEquals(-1, Clinic.maxOf(new int[]{-1}));
    }

    @DisplayName("maxOf: {-100, -50, -75} -> -50")
    @Test
    void maxOf_Test07() {
        assertEquals(-50, Clinic.maxOf(new int[]{-100, -50, -75}));
    }

    @DisplayName("maxOf: mixed signs ({5, -3, 8, -10}) -> 8")
    @Test
    void maxOf_Test08() {
        assertEquals(8, Clinic.maxOf(new int[]{5, -3, 8, -10}));
    }

    @DisplayName("maxOf: {0, 0} -> 0")
    @Test
    void maxOf_Test09() {
        assertEquals(0, Clinic.maxOf(new int[]{0, 0}));
    }

    @DisplayName("maxOf: duplicates of the max are fine ({4, 4, 1}) -> 4")
    @Test
    void maxOf_Test10() {
        assertEquals(4, Clinic.maxOf(new int[]{4, 4, 1}));
    }

    @DisplayName("maxOf: does not modify the array")
    @Test
    void maxOf_Test11() {
        int[] values = {-3, -1, -2};
        Clinic.maxOf(values);
        assertArrayEquals(new int[]{-3, -1, -2}, values, "maxOf should only read the array");
    }
}
