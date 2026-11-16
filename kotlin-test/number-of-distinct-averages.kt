package numberofdistinctaverages

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfDistinctAveragesTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().distinctAverages(intArrayOf(4, 1, 4, 0, 3, 5)))
    }

    @Test
    fun example2() {
        assertEquals(1, Solution().distinctAverages(intArrayOf(1, 100)))
    }

    @Test
    fun allValuesEqual() {
        assertEquals(1, Solution().distinctAverages(intArrayOf(4, 4, 4, 4)))
    }

    @Test
    fun allPairSumsDiffer() {
        assertEquals(2, Solution().distinctAverages(intArrayOf(1, 2, 3, 100)))
    }

    @Test
    fun repeatedPairSumsCollapse() {
        assertEquals(2, Solution().distinctAverages(intArrayOf(1, 1, 2, 4, 4, 5)))
    }
}
