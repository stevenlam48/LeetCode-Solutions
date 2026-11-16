package countpairswithxorinarange

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountPairsWithXorInARangeTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(6, solution.countPairs(intArrayOf(1, 4, 2, 7), 2, 6))
    }

    @Test
    fun testNarrowRange() {
        assertEquals(6, solution.countPairs(intArrayOf(1, 4, 2, 7), 3, 6))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0, solution.countPairs(intArrayOf(1), 1, 1))
    }

    @Test
    fun testTwoElements() {
        assertEquals(1, solution.countPairs(intArrayOf(1, 2), 1, 3))
        assertEquals(0, solution.countPairs(intArrayOf(1, 2), 1, 2))
        assertEquals(1, solution.countPairs(intArrayOf(1, 2), 3, 3))
    }

    @Test
    fun testNoPairs() {
        assertEquals(0, solution.countPairs(intArrayOf(1, 4, 2, 7), 1, 1))
    }
}
