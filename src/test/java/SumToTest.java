import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SumToTest {
    @DisplayName("sumTo: 1 -> 1")
    @Test
    void sumTo_Test01() {
        assertEquals(1, Clinic.sumTo(1));
    }

    @DisplayName("sumTo: 0 -> 0 (the loop never runs)")
    @Test
    void sumTo_Test02() {
        assertEquals(0, Clinic.sumTo(0));
    }

    @DisplayName("sumTo: 2 -> 3 (trace it: total should be 1 after the first pass and 3 after the second)")
    @Test
    void sumTo_Test03() {
        assertEquals(3, Clinic.sumTo(2),
            "if you get 2, total is forgetting the 1 - watch what happens to it at the top of each pass");
    }

    @DisplayName("sumTo: 5 -> 15")
    @Test
    void sumTo_Test04() {
        assertEquals(15, Clinic.sumTo(5), "1 + 2 + 3 + 4 + 5");
    }

    @DisplayName("sumTo: 10 -> 55")
    @Test
    void sumTo_Test05() {
        assertEquals(55, Clinic.sumTo(10));
    }

    @DisplayName("sumTo: 100 -> 5050")
    @Test
    void sumTo_Test06() {
        assertEquals(5050, Clinic.sumTo(100));
    }

    @DisplayName("sumTo: 3 -> 6")
    @Test
    void sumTo_Test07() {
        assertEquals(6, Clinic.sumTo(3));
    }

    @DisplayName("sumTo: 1000 -> 500500")
    @Test
    void sumTo_Test08() {
        assertEquals(500500, Clinic.sumTo(1000));
    }
}
