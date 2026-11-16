package leftandrightsumdifferences

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class LeftAndRightSumDifferencesTest {
    private val solution = Solution()

    @Test
    fun computesLeetCodeExample() {
        assertArrayEquals(
            intArrayOf(15, 1, 11, 22),
            solution.leftRightDifference(intArrayOf(10, 4, 8, 3))
        )
    }

    @Test
    fun handlesSingleElement() {
        assertArrayEquals(intArrayOf(0), solution.leftRightDifference(intArrayOf(1)))
    }

    @Test
    fun handlesAllZeros() {
        assertArrayEquals(intArrayOf(0, 0, 0), solution.leftRightDifference(intArrayOf(0, 0, 0)))
    }

    @Test
    fun computesBothPrefixDifferences() {
        assertArrayEquals(intArrayOf(10, 4, 6), solution.leftRightDifference(intArrayOf(2, 4, 6)))
    }

    @Test
    fun handlesNegativeValues() {
        assertArrayEquals(intArrayOf(1, 2, 1), solution.leftRightDifference(intArrayOf(-1, 2, -3)))
    }
}
