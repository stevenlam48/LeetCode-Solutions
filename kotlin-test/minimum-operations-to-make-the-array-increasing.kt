package minimumoperationstomakethearrayincreasing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeTheArrayIncreasingTest {
    @Test
    fun alreadyIncreasing() {
        assertEquals(0, Solution().minOperations(intArrayOf(1, 2, 3)))
    }

    @Test
    fun allEqual() {
        assertEquals(3, Solution().minOperations(intArrayOf(1, 1, 1)))
    }

    @Test
    fun decreasing() {
        assertEquals(6, Solution().minOperations(intArrayOf(5, 4, 3)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().minOperations(intArrayOf(1)))
    }
}
