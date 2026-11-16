package minimumoperationstomakearrayelementszero

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeArrayElementsZeroTest {
    @Test
    fun testRangeCrossesTwoCostLevels() {
        assertEquals(3L, Solution().minOperations(arrayOf(intArrayOf(1, 4))))
    }

    @Test
    fun testTwoUnitCostValuesShareOperation() {
        assertEquals(1L, Solution().minOperations(arrayOf(intArrayOf(1, 2))))
    }

    @Test
    fun testSeparateQueriesAreAdded() {
        assertEquals(
            3L,
            Solution().minOperations(
                arrayOf(intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(4, 4))
            )
        )
    }

    @Test
    fun testRangeEntirelyAtSecondCostLevel() {
        assertEquals(3L, Solution().minOperations(arrayOf(intArrayOf(5, 7))))
    }
}
