package stonegamevii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class StoneGameVIITest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(6, solution.stoneGameVII(intArrayOf(5, 3, 1, 4, 2)))
    }

    @Test
    fun testExample2() {
        assertEquals(122, solution.stoneGameVII(intArrayOf(7, 90, 5, 1, 100, 10, 10, 2)))
    }

    @Test
    fun testTwoStones() {
        assertEquals(1, solution.stoneGameVII(intArrayOf(1, 1)))
    }

    @Test
    fun testSingleStone() {
        assertEquals(0, solution.stoneGameVII(intArrayOf(42)))
    }

    @Test
    fun testIncreasing() {
        assertEquals(2, solution.stoneGameVII(intArrayOf(1, 2, 3)))
    }
}
