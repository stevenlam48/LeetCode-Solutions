package stonegame

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class StoneGameTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.stoneGame(intArrayOf(5, 3, 4, 5)))
    }

    @Test
    fun testExample2() {
        assertTrue(solution.stoneGame(intArrayOf(3, 7, 2, 3)))
    }

    @Test
    fun testSinglePile() {
        assertTrue(solution.stoneGame(intArrayOf(1)))
    }

    @Test
    fun testOddLengthLosing() {
        assertFalse(solution.stoneGame(intArrayOf(3, 7, 2)))
    }

    @Test
    fun testOddLengthWinning() {
        assertTrue(solution.stoneGame(intArrayOf(3, 2, 10)))
    }
}
