package stonegameix

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class StoneGameIXTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.stoneGameIX(intArrayOf(2, 1)))
    }

    @Test
    fun testExample2() {
        assertFalse(solution.stoneGameIX(intArrayOf(2)))
    }

    @Test
    fun testExample3() {
        assertFalse(solution.stoneGameIX(intArrayOf(5, 1, 2, 4, 3)))
    }

    @Test
    fun testAllOnes() {
        assertFalse(solution.stoneGameIX(intArrayOf(1, 1, 1)))
    }

    @Test
    fun testOddZerosLargeDifference() {
        assertTrue(solution.stoneGameIX(intArrayOf(1, 1, 1, 1, 2, 0)))
    }

    @Test
    fun testEvenZerosBothNonZero() {
        assertTrue(solution.stoneGameIX(intArrayOf(1, 2)))
    }
}
