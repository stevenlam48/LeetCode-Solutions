package minimumoperationstocollectelements

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumOperationsToCollectElementsTest {

    @Test
    fun testExample1() {
        assertEquals(3, Solution().minOperations(intArrayOf(3, 1, 2, 3, 2, 1), 3))
    }

    @Test
    fun testExample2() {
        assertEquals(2, Solution().minOperations(intArrayOf(2, 1, 2, 1, 2), 2))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1, Solution().minOperations(intArrayOf(1), 1))
    }

    @Test
    fun testAllElementsNeeded() {
        assertEquals(3, Solution().minOperations(intArrayOf(1, 2, 3), 3))
    }

    @Test
    fun testDuplicatesAtEnd() {
        assertEquals(1, Solution().minOperations(intArrayOf(1, 1, 1), 1))
    }

    @Test
    fun testValuesAboveK() {
        assertEquals(3, Solution().minOperations(intArrayOf(2, 1, 2, 3), 2))
    }
}
