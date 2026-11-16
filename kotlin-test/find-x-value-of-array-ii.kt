package findxvalueofarrayii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindXValueOfArrayIiTest {
    @Test
    fun appliesPersistentUpdatesBeforeEachSuffixQuery() {
        val queries = arrayOf(
            intArrayOf(1, 3, 0, 2),
            intArrayOf(0, 2, 1, 4),
            intArrayOf(3, 5, 2, 0)
        )

        assertArrayEquals(intArrayOf(0, 1, 1), Solution().resultArray(intArrayOf(1, 2, 3, 4), 5, queries))
    }

    @Test
    fun countsEveryPrefixWhenKIsOne() {
        val queries = arrayOf(intArrayOf(0, 7, 0, 0), intArrayOf(1, 9, 1, 0))

        assertArrayEquals(intArrayOf(2, 1), Solution().resultArray(intArrayOf(2, 4), 1, queries))
    }

    @Test
    fun handlesASingleElementArray() {
        val queries = arrayOf(
            intArrayOf(0, 2, 0, 2),
            intArrayOf(0, 5, 0, 2),
            intArrayOf(0, 7, 0, 2)
        )

        assertArrayEquals(intArrayOf(1, 0, 1), Solution().resultArray(intArrayOf(6), 5, queries))
    }

    @Test
    fun countsProductsSpanningSegmentTreeBoundaries() {
        val queries = arrayOf(intArrayOf(4, 1, 0, 6), intArrayOf(1, 2, 2, 4))

        assertArrayEquals(intArrayOf(1, 1), Solution().resultArray(intArrayOf(2, 3, 4, 5, 6), 7, queries))
    }
}
