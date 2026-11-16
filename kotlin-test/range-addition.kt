package rangeaddition

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RangeAdditionTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val updates = arrayOf(
            intArrayOf(1, 3, 2), intArrayOf(2, 4, 3), intArrayOf(0, 2, -2)
        )
        assertArrayEquals(intArrayOf(-2, 0, 3, 5, 3), solution.getModifiedArray(5, updates))
    }

    @Test
    fun testNoUpdates() {
        assertArrayEquals(intArrayOf(0, 0, 0), solution.getModifiedArray(3, arrayOf()))
    }

    @Test
    fun testFullRange() {
        val updates = arrayOf(intArrayOf(0, 2, 5))
        assertArrayEquals(intArrayOf(5, 5, 5), solution.getModifiedArray(3, updates))
    }

    @Test
    fun testSingleElement() {
        val updates = arrayOf(intArrayOf(0, 0, 7))
        assertArrayEquals(intArrayOf(7), solution.getModifiedArray(1, updates))
    }
}
