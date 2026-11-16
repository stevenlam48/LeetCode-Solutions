package numberofwaystoearnpoints

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfWaysToEarnPointsTest {
    @Test
    fun example1() {
        val types = arrayOf(intArrayOf(6, 1), intArrayOf(3, 2), intArrayOf(2, 3))
        assertEquals(7, Solution().waysToReachTarget(6, types))
    }

    @Test
    fun example2() {
        val types = arrayOf(intArrayOf(50, 1), intArrayOf(50, 2), intArrayOf(50, 5))
        assertEquals(4, Solution().waysToReachTarget(5, types))
    }

    @Test
    fun twoTypes() {
        val types = arrayOf(intArrayOf(1, 2), intArrayOf(1, 2))
        assertEquals(2, Solution().waysToReachTarget(2, types))
    }

    @Test
    fun singleType() {
        assertEquals(1, Solution().waysToReachTarget(1, arrayOf(intArrayOf(1, 1))))
    }

    @Test
    fun zeroTarget() {
        assertEquals(1, Solution().waysToReachTarget(0, arrayOf(intArrayOf(1, 1))))
    }
}
