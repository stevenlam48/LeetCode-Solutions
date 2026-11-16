package sortedgcdpairqueries

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SortedGcdPairQueriesTest {
    @Test
    fun exampleOne() {
        assertArrayEquals(
            intArrayOf(1, 2, 2),
            Solution().gcdValues(intArrayOf(2, 3, 4), longArrayOf(0, 2, 2))
        )
    }

    @Test
    fun exampleTwo() {
        assertArrayEquals(
            intArrayOf(4, 2, 1, 1),
            Solution().gcdValues(intArrayOf(4, 4, 2, 1), longArrayOf(5, 3, 1, 0))
        )
    }

    @Test
    fun duplicateValues() {
        assertArrayEquals(
            intArrayOf(2),
            Solution().gcdValues(intArrayOf(2, 2), longArrayOf(0))
        )
    }

    @Test
    fun allOnes() {
        assertArrayEquals(
            intArrayOf(1, 1, 1),
            Solution().gcdValues(intArrayOf(1, 1, 1), longArrayOf(0, 1, 2))
        )
    }
}
