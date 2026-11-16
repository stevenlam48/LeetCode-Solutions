package minimummovestomakearraycomplementary

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumMovesToMakeArrayComplementaryTest {

    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(1, solution.minMoves(intArrayOf(1, 2, 4, 3), 4))
    }

    @Test
    fun testExample2() {
        assertEquals(2, solution.minMoves(intArrayOf(1, 2, 2, 1), 2))
    }

    @Test
    fun testAlreadyComplementary() {
        assertEquals(0, solution.minMoves(intArrayOf(1, 2), 3))
    }

    @Test
    fun testEqualPair() {
        assertEquals(0, solution.minMoves(intArrayOf(1, 1), 2))
    }

    @Test
    fun testAllOnes() {
        assertEquals(0, solution.minMoves(intArrayOf(1, 1, 1, 1), 1))
    }

    @Test
    fun testTwoPairsSameSum() {
        assertEquals(0, solution.minMoves(intArrayOf(1, 2, 3, 4), 4))
    }
}
