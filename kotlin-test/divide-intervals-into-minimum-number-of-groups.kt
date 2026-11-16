package divideintervalsintominimumnumberofgroups

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DivideIntervalsIntoMinimumNumberOfGroupsTest {
    @Test
    fun example1() {
        val intervals = arrayOf(
            intArrayOf(5, 10),
            intArrayOf(6, 8),
            intArrayOf(1, 5),
            intArrayOf(2, 3),
            intArrayOf(1, 10)
        )
        assertEquals(3, Solution().minGroups(intervals))
    }

    @Test
    fun example2() {
        val intervals = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(5, 6),
            intArrayOf(8, 10),
            intArrayOf(11, 13)
        )
        assertEquals(1, Solution().minGroups(intervals))
    }

    @Test
    fun singleInterval() {
        assertEquals(1, Solution().minGroups(arrayOf(intArrayOf(1, 1))))
    }

    @Test
    fun touchingIntervalsShareGroup() {
        val intervals = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3))
        assertEquals(2, Solution().minGroups(intervals))
    }

    @Test
    fun allOverlapping() {
        val intervals = arrayOf(intArrayOf(1, 5), intArrayOf(1, 5), intArrayOf(1, 5))
        assertEquals(3, Solution().minGroups(intervals))
    }
}
