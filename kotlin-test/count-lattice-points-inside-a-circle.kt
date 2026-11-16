package countlatticepointsinsideacircle

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountLatticePointsInsideACircleTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(5, solution.countLatticePoints(arrayOf(intArrayOf(2, 2, 1))))
    }

    @Test
    fun testExample2() {
        assertEquals(
            16,
            solution.countLatticePoints(
                arrayOf(intArrayOf(2, 2, 2), intArrayOf(3, 4, 1))
            )
        )
    }

    @Test
    fun testSingleCircle() {
        assertEquals(13, solution.countLatticePoints(arrayOf(intArrayOf(1, 1, 2))))
    }
}
