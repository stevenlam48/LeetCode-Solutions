package contiguousarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ContiguousArrayTest {
    @Test
    fun twoElementBalancedArray() {
        assertEquals(2, Solution().findMaxLength(intArrayOf(0, 1)))
    }

    @Test
    fun balancedPrefixOfThreeElements() {
        assertEquals(2, Solution().findMaxLength(intArrayOf(0, 1, 0)))
    }

    @Test
    fun entireArrayIsBalanced() {
        assertEquals(8, Solution().findMaxLength(intArrayOf(0, 1, 1, 0, 1, 1, 0, 0)))
    }

    @Test
    fun unbalancedAndEmptyInputs() {
        assertEquals(2, Solution().findMaxLength(intArrayOf(0, 0, 1, 0, 0)))
        assertEquals(0, Solution().findMaxLength(intArrayOf()))
    }
}
