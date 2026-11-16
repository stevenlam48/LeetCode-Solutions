package concatenateddivisibility

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ConcatenatedDivisibilityTest {
    @Test
    fun findsLexicographicallySmallestSuccessfulOrder() {
        assertArrayEquals(intArrayOf(3, 12, 45), Solution().concatenatedDivisibility(intArrayOf(12, 45, 3), 5))
    }

    @Test
    fun returnsEmptyArrayWhenNoPermutationWorks() {
        assertArrayEquals(intArrayOf(), Solution().concatenatedDivisibility(intArrayOf(1, 2, 3), 5))
        assertArrayEquals(intArrayOf(), Solution().concatenatedDivisibility(intArrayOf(6, 11), 7))
    }

    @Test
    fun accountsForMultiDigitLengthsDuringReconstruction() {
        assertArrayEquals(intArrayOf(3, 12), Solution().concatenatedDivisibility(intArrayOf(12, 3), 4))
    }

    @Test
    fun returnsSortedValuesWhenEveryConcatenationIsDivisible() {
        assertArrayEquals(intArrayOf(2, 5, 10), Solution().concatenatedDivisibility(intArrayOf(10, 2, 5), 5))
        assertArrayEquals(intArrayOf(1, 1), Solution().concatenatedDivisibility(intArrayOf(1, 1), 11))
    }
}
