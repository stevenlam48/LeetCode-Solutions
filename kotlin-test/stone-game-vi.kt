package stonegamevi

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class StoneGameVITest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(1, solution.stoneGameVI(intArrayOf(1, 3), intArrayOf(2, 1)))
    }

    @Test
    fun testExample2() {
        assertEquals(0, solution.stoneGameVI(intArrayOf(1, 2), intArrayOf(3, 1)))
    }

    @Test
    fun testExample3() {
        assertEquals(-1, solution.stoneGameVI(intArrayOf(2, 4, 3), intArrayOf(1, 6, 7)))
    }

    @Test
    fun testSingleStone() {
        assertEquals(1, solution.stoneGameVI(intArrayOf(5), intArrayOf(3)))
    }

    @Test
    fun testTie() {
        assertEquals(0, solution.stoneGameVI(intArrayOf(1, 1), intArrayOf(1, 1)))
    }
}
