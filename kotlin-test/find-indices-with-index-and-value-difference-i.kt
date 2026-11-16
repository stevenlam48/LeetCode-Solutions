package findindiceswithindexandvaluedifferencei

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindIndicesWithIndexAndValueDifferenceITest {
    @Test
    fun findsPairSeparatedByRequiredIndexAndValueDifferences() {
        assertArrayEquals(
            intArrayOf(0, 2),
            Solution().findIndices(intArrayOf(5, 1, 2, 10), 2, 3)
        )
    }

    @Test
    fun findsPairWhereSecondValueIsLarger() {
        assertArrayEquals(
            intArrayOf(0, 2),
            Solution().findIndices(intArrayOf(1, 2, 3, 4), 2, 2)
        )
    }

    @Test
    fun returnsMinusOneWhenNoPairQualifies() {
        assertArrayEquals(
            intArrayOf(-1, -1),
            Solution().findIndices(intArrayOf(2, 1), 1, 3)
        )
    }

    @Test
    fun acceptsIdenticalValuesWhenDifferencesAreZero() {
        assertArrayEquals(
            intArrayOf(0, 0),
            Solution().findIndices(intArrayOf(7), 0, 0)
        )
    }
}
