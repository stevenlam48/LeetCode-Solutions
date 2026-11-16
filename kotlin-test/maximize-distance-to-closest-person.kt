package maximizedistancetoclosestperson

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeDistanceToClosestPersonTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2, solution.maxDistToClosest(intArrayOf(1, 0, 0, 0, 1, 0, 1)))
    }

    @Test
    fun testExample2() {
        assertEquals(3, solution.maxDistToClosest(intArrayOf(1, 0, 0, 0)))
    }

    @Test
    fun testLeftEdge() {
        assertEquals(1, solution.maxDistToClosest(intArrayOf(0, 1)))
    }

    @Test
    fun testLeftEdgeLonger() {
        assertEquals(2, solution.maxDistToClosest(intArrayOf(0, 0, 1)))
    }

    @Test
    fun testMiddleGap() {
        assertEquals(1, solution.maxDistToClosest(intArrayOf(1, 0, 1)))
    }
}
