package minimumoperationstomakenumbersnonpositive

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeNumbersNonPositiveTest {
    @Test
    fun example() {
        assertEquals(3, Solution().minOperations(intArrayOf(3, 4, 5), 2, 1))
    }

    @Test
    fun alreadyNonPositiveAfterOne() {
        assertEquals(1, Solution().minOperations(intArrayOf(1, 1), 2, 1))
    }

    @Test
    fun singleLargeNumber() {
        assertEquals(2, Solution().minOperations(intArrayOf(10), 5, 1))
        assertEquals(4, Solution().minOperations(intArrayOf(10), 3, 1))
    }

    @Test
    fun mixedValues() {
        assertEquals(2, Solution().minOperations(intArrayOf(1, 2, 3), 3, 1))
    }
}
