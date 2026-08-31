import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AverageTest {
    @DisplayName("average: {2, 4} -> 3.0")
    @Test
    void average_Test01() {
        assertEquals(3.0, Clinic.average(new int[]{2, 4}), 1e-9);
    }

    @DisplayName("average: {10} -> 10.0")
    @Test
    void average_Test02() {
        assertEquals(10.0, Clinic.average(new int[]{10}), 1e-9);
    }

    @DisplayName("average: {1, 2} -> 1.5 (trace it: sum is 3, length is 2, 3 / 2 should be 1.5)")
    @Test
    void average_Test03() {
        assertEquals(1.5, Clinic.average(new int[]{1, 2}), 1e-9,
            "the .5 is being thrown away somewhere - trace the last line by hand");
    }

    @DisplayName("average: {90, 85} -> 87.5")
    @Test
    void average_Test04() {
        assertEquals(87.5, Clinic.average(new int[]{90, 85}), 1e-9);
    }

    @DisplayName("average: {7, 8, 8} -> 7.666...")
    @Test
    void average_Test05() {
        assertEquals(7.6666666667, Clinic.average(new int[]{7, 8, 8}), 1e-6,
            "23 / 3 should keep its decimals");
    }

    @DisplayName("average: {0, 0, 0} -> 0.0")
    @Test
    void average_Test06() {
        assertEquals(0.0, Clinic.average(new int[]{0, 0, 0}), 1e-9);
    }

    @DisplayName("average: {-3, -4} -> -3.5")
    @Test
    void average_Test07() {
        assertEquals(-3.5, Clinic.average(new int[]{-3, -4}), 1e-9);
    }

    @DisplayName("average: {1, 1, 1, 2} -> 1.25")
    @Test
    void average_Test08() {
        assertEquals(1.25, Clinic.average(new int[]{1, 1, 1, 2}), 1e-9);
    }
}
