package minimumelementafterreplacementwithdigitsum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumElementAfterReplacementWithDigitSumTest {
    @Test
    fun example1() {
        assertEquals(1, Solution().minElement(intArrayOf(10, 12, 13, 14)))
    }

    @Test
    fun example2() {
        assertEquals(1, Solution().minElement(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun example3() {
        assertEquals(10, Solution().minElement(intArrayOf(999, 19, 199)))
    }

    @Test
    fun singleTwoDigitNumber() {
        assertEquals(18, Solution().minElement(intArrayOf(99)))
    }
}
