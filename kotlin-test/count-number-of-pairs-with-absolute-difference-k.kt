package countnumberofpairswithabsolutedifferencek

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountNumberOfPairsWithAbsoluteDifferenceKTest {
    @Test
    fun exampleOne() {
        assertEquals(4, Solution().countKDifference(intArrayOf(1, 2, 2, 1), 1))
    }

    @Test
    fun exampleTwoAndThree() {
        assertEquals(0, Solution().countKDifference(intArrayOf(1, 3), 3))
        assertEquals(3, Solution().countKDifference(intArrayOf(3, 2, 1, 5, 4), 2))
    }

    @Test
    fun zeroDifferenceWithDuplicates() {
        assertEquals(6, Solution().countKDifference(intArrayOf(1, 1, 1), 0))
    }

    @Test
    fun negativeValuesAndEmptyInput() {
        assertEquals(2, Solution().countKDifference(intArrayOf(-1, 1, -1), 2))
        assertEquals(0, Solution().countKDifference(intArrayOf(), 1))
    }
}
