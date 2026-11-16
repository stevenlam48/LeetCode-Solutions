package minimumoperationstomakesubarrayelementsequal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeSubarrayElementsEqualTest {
    @Test
    fun oddWindow() {
        assertEquals(2L, Solution().minOperations(intArrayOf(1, 2, 3), 3))
    }

    @Test
    fun equalElements() {
        assertEquals(0L, Solution().minOperations(intArrayOf(1, 1, 1), 2))
    }

    @Test
    fun twoElements() {
        assertEquals(4L, Solution().minOperations(intArrayOf(1, 5), 2))
    }

    @Test
    fun bestWindowOfTwo() {
        assertEquals(1L, Solution().minOperations(intArrayOf(1, 2, 3, 4), 2))
    }
}
