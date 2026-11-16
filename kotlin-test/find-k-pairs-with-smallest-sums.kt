package findkpairswithsmallestsums

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindKPairsWithSmallestSumsTest {
    private fun assertPairs(expected: Array<IntArray>, actual: List<IntArray>) {
        assertEquals(expected.size, actual.size)
        for (i in expected.indices) {
            assertArrayEquals(expected[i], actual[i])
        }
    }

    @Test
    fun returnsPairsInNondecreasingSumOrder() {
        assertPairs(
            arrayOf(intArrayOf(1, 2), intArrayOf(1, 4), intArrayOf(1, 6)),
            Solution().kSmallestPairs(intArrayOf(1, 7, 11), intArrayOf(2, 4, 6), 3)
        )
    }

    @Test
    fun handlesDuplicateValuesAndRequestsMorePairsThanExist() {
        assertPairs(
            arrayOf(intArrayOf(1, 1), intArrayOf(1, 1)),
            Solution().kSmallestPairs(intArrayOf(1, 1, 2), intArrayOf(1, 2, 3), 2)
        )
        assertPairs(
            arrayOf(intArrayOf(1, 4), intArrayOf(1, 5), intArrayOf(2, 4), intArrayOf(2, 5)),
            Solution().kSmallestPairs(intArrayOf(1, 2), intArrayOf(4, 5), 5)
        )
    }

    @Test
    fun swapsInputsWithoutChangingPairOrientation() {
        assertPairs(
            arrayOf(intArrayOf(1, 4), intArrayOf(2, 4), intArrayOf(3, 4)),
            Solution().kSmallestPairs(intArrayOf(1, 2, 3, 4, 5), intArrayOf(4), 3)
        )
    }

    @Test
    fun handlesEmptyInput() {
        assertPairs(
            arrayOf(),
            Solution().kSmallestPairs(intArrayOf(), intArrayOf(1, 2), 3)
        )
    }
}
