package stonegameii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class StoneGameIITest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(10, solution.stoneGameII(intArrayOf(2, 7, 9, 4, 4)))
    }

    @Test
    fun testExample2() {
        assertEquals(104, solution.stoneGameII(intArrayOf(1, 2, 3, 4, 5, 100)))
    }

    @Test
    fun testSinglePile() {
        assertEquals(5, solution.stoneGameII(intArrayOf(5)))
    }

    @Test
    fun testTwoPiles() {
        assertEquals(3, solution.stoneGameII(intArrayOf(1, 2)))
    }

    @Test
    fun testAllOnes() {
        assertEquals(4, solution.stoneGameII(intArrayOf(1, 1, 1, 1, 1, 1, 1, 1)))
    }
}
