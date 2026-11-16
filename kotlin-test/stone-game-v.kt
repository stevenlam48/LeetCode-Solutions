package stonegamev

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class StoneGameVTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(18, solution.stoneGameV(intArrayOf(6, 2, 3, 4, 5, 5)))
    }

    @Test
    fun testExample2() {
        assertEquals(28, solution.stoneGameV(intArrayOf(7, 7, 7, 7, 7, 7, 7)))
    }

    @Test
    fun testSingleStone() {
        assertEquals(0, solution.stoneGameV(intArrayOf(5)))
    }

    @Test
    fun testTwoStones() {
        assertEquals(2, solution.stoneGameV(intArrayOf(2, 3)))
    }

    @Test
    fun testUnequalHalves() {
        assertEquals(1, solution.stoneGameV(intArrayOf(1, 2)))
    }
}
