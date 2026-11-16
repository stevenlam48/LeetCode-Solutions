package maximumnumberofvisiblepoints

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumnumberofvisiblepointsTest {
    @Test
    fun example1() {
        val points = arrayOf(intArrayOf(2, 1), intArrayOf(2, 2), intArrayOf(3, 3))
        assertEquals(3, Solution().visiblePoints(points, 90, intArrayOf(1, 1)))
    }

    @Test
    fun example2() {
        val points = arrayOf(intArrayOf(2, 1), intArrayOf(2, 2), intArrayOf(3, 4), intArrayOf(1, 1))
        assertEquals(4, Solution().visiblePoints(points, 90, intArrayOf(1, 1)))
    }

    @Test
    fun onlyObserversOwnLocation() {
        val points = arrayOf(intArrayOf(1, 1))
        assertEquals(1, Solution().visiblePoints(points, 10, intArrayOf(1, 1)))
    }

    @Test
    fun pointPlusOwnLocation() {
        val points = arrayOf(intArrayOf(0, 0), intArrayOf(1, 0))
        assertEquals(2, Solution().visiblePoints(points, 45, intArrayOf(0, 0)))
    }
}
