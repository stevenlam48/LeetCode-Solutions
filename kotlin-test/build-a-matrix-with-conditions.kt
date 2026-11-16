package buildamatrixwithconditions

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BuildAMatrixWithConditionsTest {
    @Test
    fun example1() {
        val rowConditions = arrayOf(intArrayOf(1, 2), intArrayOf(3, 2))
        val colConditions = arrayOf(intArrayOf(2, 1), intArrayOf(3, 2))
        val expected = arrayOf(
            intArrayOf(0, 0, 1),
            intArrayOf(3, 0, 0),
            intArrayOf(0, 2, 0)
        )
        assertMatrixEquals(expected, Solution().buildMatrix(3, rowConditions, colConditions))
    }

    @Test
    fun singleElement() {
        val expected = arrayOf(intArrayOf(1))
        assertMatrixEquals(expected, Solution().buildMatrix(1, emptyArray(), emptyArray()))
    }

    @Test
    fun simpleOrder() {
        val rowConditions = arrayOf(intArrayOf(1, 2))
        val colConditions = arrayOf(intArrayOf(1, 2))
        val expected = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(0, 2)
        )
        assertMatrixEquals(expected, Solution().buildMatrix(2, rowConditions, colConditions))
    }

    @Test
    fun cycleReturnsEmpty() {
        val rowConditions = arrayOf(intArrayOf(1, 2), intArrayOf(2, 1))
        val result = Solution().buildMatrix(2, rowConditions, emptyArray())
        assertEquals(0, result.size)
    }

    private fun assertMatrixEquals(expected: Array<IntArray>, actual: Array<IntArray>) {
        assertEquals(expected.size, actual.size)
        for (i in expected.indices) {
            assertArrayEquals(expected[i], actual[i])
        }
    }
}
