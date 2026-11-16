package amountofnewareapaintedeachday

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AmountOfNewAreaPaintedEachDayTest {
    @Test
    fun testExample1() {
        val paint = arrayOf(intArrayOf(1, 4), intArrayOf(4, 7), intArrayOf(5, 8))
        assertArrayEquals(intArrayOf(3, 3, 1), Solution().amountPainted(paint))
    }

    @Test
    fun testExample2() {
        val paint = arrayOf(intArrayOf(1, 4), intArrayOf(5, 8), intArrayOf(4, 7))
        assertArrayEquals(intArrayOf(3, 3, 1), Solution().amountPainted(paint))
    }

    @Test
    fun testFullyCovered() {
        val paint = arrayOf(intArrayOf(1, 5), intArrayOf(2, 4))
        assertArrayEquals(intArrayOf(4, 0), Solution().amountPainted(paint))
    }

    @Test
    fun testSingleDay() {
        val paint = arrayOf(intArrayOf(0, 10))
        assertArrayEquals(intArrayOf(10), Solution().amountPainted(paint))
    }

    @Test
    fun testDisjoint() {
        val paint = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3))
        assertArrayEquals(intArrayOf(1, 1, 1), Solution().amountPainted(paint))
    }
}
