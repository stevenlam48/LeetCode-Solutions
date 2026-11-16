package computealternatingsum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ComputeAlternatingSumTest {
    @Test
    fun alternatesBeginningWithAddition() {
        assertEquals(-4, Solution().alternatingSum(intArrayOf(1, 3, 5, 7)))
        assertEquals(2, Solution().alternatingSum(intArrayOf(1, 2, 3)))
    }

    @Test
    fun handlesEmptyAndSingleElementInputs() {
        assertEquals(0, Solution().alternatingSum(intArrayOf()))
        assertEquals(100, Solution().alternatingSum(intArrayOf(100)))
    }

    @Test
    fun handlesNegativeValues() {
        assertEquals(-12, Solution().alternatingSum(intArrayOf(-2, 4, -6)))
    }
}
