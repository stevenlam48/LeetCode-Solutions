package alternatingdigitsum

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AlternatingDigitSumTest {
    @Test
    fun testExample1() {
        assertEquals(4, Solution().alternateDigitSum(521))
    }

    @Test
    fun testExample2() {
        assertEquals(1, Solution().alternateDigitSum(111))
    }

    @Test
    fun testExample3() {
        assertEquals(0, Solution().alternateDigitSum(886996))
    }

    @Test
    fun testTwoDigits() {
        assertEquals(1, Solution().alternateDigitSum(10))
        assertEquals(1, Solution().alternateDigitSum(21))
    }
}
