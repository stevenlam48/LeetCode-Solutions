package findthemaximumsequencevalueofarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheMaximumSequenceValueOfArrayTest {
    @Test
    fun example1() {
        assertEquals(5, Solution().maxValue(intArrayOf(2, 6, 7), 1))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().maxValue(intArrayOf(4, 2, 5, 6, 7), 2))
    }

    @Test
    fun allEqual() {
        assertEquals(0, Solution().maxValue(intArrayOf(1, 1, 1), 1))
    }
}
