package stonegameviii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class StoneGameVIIITest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(5, solution.stoneGameVIII(intArrayOf(-1, -2, -3, -4, -5)))
    }

    @Test
    fun testExample2() {
        assertEquals(13, solution.stoneGameVIII(intArrayOf(7, -6, 5, 10, 5, -2, -6)))
    }

    @Test
    fun testSingleStone() {
        assertEquals(4, solution.stoneGameVIII(intArrayOf(4)))
    }

    @Test
    fun testTwoStones() {
        assertEquals(3, solution.stoneGameVIII(intArrayOf(1, 2)))
    }

    @Test
    fun testPositive() {
        assertEquals(3, solution.stoneGameVIII(intArrayOf(1, 1, 1)))
    }
}
