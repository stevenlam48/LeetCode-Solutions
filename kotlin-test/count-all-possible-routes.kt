package countallpossibleroutes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountAllPossibleRoutesTest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        assertEquals(4, solution.countRoutes(intArrayOf(2, 3, 6, 8, 4), 1, 3, 5))
    }

    @Test
    fun testExampleTwo() {
        assertEquals(5, solution.countRoutes(intArrayOf(4, 3, 1), 1, 0, 6))
    }

    @Test
    fun testExampleThree() {
        assertEquals(0, solution.countRoutes(intArrayOf(5, 2, 1), 0, 2, 3))
    }

    @Test
    fun testStartEqualsFinish() {
        assertEquals(1, solution.countRoutes(intArrayOf(1, 2), 0, 0, 0))
    }
}
