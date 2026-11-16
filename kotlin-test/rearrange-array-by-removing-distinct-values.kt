package rearrangearraybyremovingdistinctvalues
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class RearrangeArrayByRemovingDistinctValuesTest {
    @Test
    fun emitsEachRemainingDistinctValueInSortedRounds() {
        assertArrayEquals(
            intArrayOf(1, 2, 3, 4, 1, 2),
            Solution().rearrangeArray(intArrayOf(1, 3, 1, 2, 2, 4))
        )
        assertArrayEquals(
            intArrayOf(-1, 0, 2, -1, 0, -1),
            Solution().rearrangeArray(intArrayOf(-1, 0, -1, 2, 0, -1))
        )
    }

    @Test
    fun preservesInputTotalAndDuplicateCount() {
        assertArrayEquals(intArrayOf(2, 2, 2), Solution().rearrangeArray(intArrayOf(2, 2, 2)))
        assertArrayEquals(intArrayOf(7), Solution().rearrangeArray(intArrayOf(7)))
    }

    @Test
    fun emptyInput() {
        assertArrayEquals(intArrayOf(), Solution().rearrangeArray(intArrayOf()))
    }
}
