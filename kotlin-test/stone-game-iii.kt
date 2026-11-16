package stonegameiii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class StoneGameIIITest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals("Bob", solution.stoneGameIII(intArrayOf(1, 2, 3, 7)))
    }

    @Test
    fun testExample2() {
        assertEquals("Alice", solution.stoneGameIII(intArrayOf(1, 2, 3, -9)))
    }

    @Test
    fun testExample3() {
        assertEquals("Alice", solution.stoneGameIII(intArrayOf(1, 2, 3, -1, -2, -3, 7)))
    }

    @Test
    fun testTie() {
        assertEquals("Tie", solution.stoneGameIII(intArrayOf(1, 2, 3, 6)))
    }

    @Test
    fun testSingleStone() {
        assertEquals("Alice", solution.stoneGameIII(intArrayOf(5)))
    }
}
