package intersectionoftwoarrays

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class IntersectionOfTwoArraysTest {
    @Test
    fun returnsEachCommonValueOnce() {
        assertArrayEquals(intArrayOf(2), Solution().intersection(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)))
    }

    @Test
    fun followsSecondSmallerInputOrder() {
        assertArrayEquals(intArrayOf(9, 4), Solution().intersection(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4)))
    }

    @Test
    fun handlesNegativeValuesAndDuplicates() {
        assertArrayEquals(intArrayOf(-2, 0), Solution().intersection(intArrayOf(-2, -2, 0, 3), intArrayOf(0, -2, -2)))
    }

    @Test
    fun handlesEmptyAndDisjointInputs() {
        assertArrayEquals(IntArray(0), Solution().intersection(IntArray(0), intArrayOf(1)))
        assertArrayEquals(IntArray(0), Solution().intersection(intArrayOf(1), intArrayOf(2)))
    }
}
