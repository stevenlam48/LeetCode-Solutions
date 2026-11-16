package minimumoperationstoequalizearray

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumOperationsToEqualizeArrayTest {

    @Test
    fun testAlreadyEqual() {
        assertEquals(0, Solution().minOperations(intArrayOf(1, 1, 1)))
    }

    @Test
    fun testExampleDifferent() {
        assertEquals(1, Solution().minOperations(intArrayOf(1, 2, 3)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0, Solution().minOperations(intArrayOf(7)))
    }

    @Test
    fun testTwoEqualElements() {
        assertEquals(0, Solution().minOperations(intArrayOf(2, 2)))
    }

    @Test
    fun testTwoDifferentElements() {
        assertEquals(1, Solution().minOperations(intArrayOf(2, 3)))
    }

    @Test
    fun testNegativesAndDuplicates() {
        assertEquals(1, Solution().minOperations(intArrayOf(-1, -1, 0)))
    }
}
