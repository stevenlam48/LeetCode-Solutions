package maximizesumofatmostkdistinctelements

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MaximizeSumOfAtMostKDistinctElementsTest {
    private val solution = Solution()

    @Test
    fun returnsTopTwoDistinctValuesDescending() {
        assertArrayEquals(intArrayOf(5, 4), solution.maxKDistinct(intArrayOf(1, 2, 3, 4, 5), 2))
    }

    @Test
    fun ignoresDuplicatesBeforeSelectingTopValues() {
        assertArrayEquals(intArrayOf(100, 93, 84), solution.maxKDistinct(intArrayOf(84, 93, 100, 77, 93), 3))
    }

    @Test
    fun returnsAllValuesWhenKExceedsDistinctCount() {
        assertArrayEquals(intArrayOf(2, 1), solution.maxKDistinct(intArrayOf(2, 2, 1), 5))
    }

    @Test
    fun returnsEmptyArrayForZeroK() {
        assertArrayEquals(intArrayOf(), solution.maxKDistinct(intArrayOf(1, 2), 0))
    }

    @Test
    fun handlesNegativeValues() {
        assertArrayEquals(intArrayOf(-1, -3), solution.maxKDistinct(intArrayOf(-5, -1, -3, -1), 2))
    }
}
