package unique3digitevennumbers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Unique3DigitEvenNumbersTest {
    @Test
    fun example1() {
        assertEquals(12, Solution().totalNumbers(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().totalNumbers(intArrayOf(0, 2, 2)))
    }

    @Test
    fun example3() {
        assertEquals(1, Solution().totalNumbers(intArrayOf(6, 6, 6)))
    }

    @Test
    fun noEvenDigits() {
        assertEquals(0, Solution().totalNumbers(intArrayOf(1, 3, 5)))
    }

    @Test
    fun zeroHeavy() {
        assertEquals(3, Solution().totalNumbers(intArrayOf(0, 0, 2, 2)))
    }
}
