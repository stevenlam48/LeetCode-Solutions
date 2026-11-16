package digitcountinrange

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DigitCountInRangeTest {
    @Test
    fun testExample1() {
        assertEquals(6, Solution().digitsCount(1, 1, 13))
    }

    @Test
    fun testExample2() {
        assertEquals(0, Solution().digitsCount(3, 1, 2))
    }

    @Test
    fun testZero() {
        assertEquals(0, Solution().digitsCount(0, 0, 0))
        assertEquals(0, Solution().digitsCount(0, 1, 9))
        assertEquals(1, Solution().digitsCount(0, 1, 10))
    }

    @Test
    fun testSingleRange() {
        assertEquals(1, Solution().digitsCount(5, 5, 5))
        assertEquals(0, Solution().digitsCount(5, 1, 4))
    }

    @Test
    fun testLargerRange() {
        assertEquals(21, Solution().digitsCount(1, 1, 100))
    }
}
