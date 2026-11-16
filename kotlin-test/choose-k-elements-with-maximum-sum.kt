package choosekelementswithmaximumsum

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ChooseKElementsWithMaximumSumTest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        val result = solution.findMaxSum(
            intArrayOf(1, 3, 3, 2),
            intArrayOf(2, 1, 3, 4),
            3
        )
        assertArrayEquals(longArrayOf(0, 6, 6, 2), result)
    }

    @Test
    fun testExampleTwo() {
        val result = solution.findMaxSum(
            intArrayOf(4, 2, 1, 5, 3),
            intArrayOf(10, 20, 30, 40, 50),
            2
        )
        assertArrayEquals(longArrayOf(80, 30, 0, 80, 50), result)
    }

    @Test
    fun testAllEqual() {
        val result = solution.findMaxSum(
            intArrayOf(1, 1, 1),
            intArrayOf(5, 6, 7),
            2
        )
        assertArrayEquals(longArrayOf(0, 0, 0), result)
    }

    @Test
    fun testSingleElement() {
        val result = solution.findMaxSum(intArrayOf(5), intArrayOf(100), 1)
        assertArrayEquals(longArrayOf(0), result)
    }

    @Test
    fun testKOne() {
        val result = solution.findMaxSum(
            intArrayOf(1, 2, 3),
            intArrayOf(3, 2, 1),
            1
        )
        assertArrayEquals(longArrayOf(0, 3, 3), result)
    }
}
