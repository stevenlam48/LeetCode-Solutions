package majorityelementii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MajorityElementIiTest {
    private val solution = Solution()

    @Test
    fun findsSingleValueAppearingMoreThanOneThird() {
        assertSortedEquals(intArrayOf(3), solution.majorityElement(intArrayOf(3, 2, 3)))
    }

    @Test
    fun findsBothMajorityCandidates() {
        assertSortedEquals(
            intArrayOf(1, 2),
            solution.majorityElement(intArrayOf(1, 1, 1, 3, 3, 2, 2, 2))
        )
    }

    @Test
    fun includesBothValuesWhenThresholdIsZero() {
        assertSortedEquals(intArrayOf(1, 2), solution.majorityElement(intArrayOf(1, 2)))
    }

    @Test
    fun excludesValuesAppearingExactlyOneThird() {
        assertSortedEquals(intArrayOf(), solution.majorityElement(intArrayOf(1, 2, 3)))
    }

    @Test
    fun handlesEmptyInput() {
        assertSortedEquals(intArrayOf(), solution.majorityElement(intArrayOf()))
    }

    private fun assertSortedEquals(expected: IntArray, actual: IntArray) {
        assertArrayEquals(expected.sortedArray(), actual.sortedArray())
    }
}
