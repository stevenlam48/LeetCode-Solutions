package arithmeticsubarrays

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ArithmeticSubarraysTest {
    private val solution = Solution()

    @Test
    fun testExample() {
        assertArrayEquals(
            booleanArrayOf(true, false, true),
            solution.checkArithmeticSubarrays(
                intArrayOf(4, 6, 5, 9, 3, 7),
                intArrayOf(0, 0, 2),
                intArrayOf(2, 3, 5)
            )
        )
    }

    @Test
    fun testSingleElement() {
        assertArrayEquals(
            booleanArrayOf(true, true),
            solution.checkArithmeticSubarrays(intArrayOf(1), intArrayOf(0, 0), intArrayOf(0, 0))
        )
    }

    @Test
    fun testDuplicates() {
        assertArrayEquals(
            booleanArrayOf(true),
            solution.checkArithmeticSubarrays(intArrayOf(2, 2, 2), intArrayOf(0), intArrayOf(2))
        )
    }

    @Test
    fun testNegatives() {
        assertArrayEquals(
            booleanArrayOf(true, false),
            solution.checkArithmeticSubarrays(
                intArrayOf(-12, -9, -6, -3, -5),
                intArrayOf(0, 1),
                intArrayOf(3, 4)
            )
        )
    }
}
