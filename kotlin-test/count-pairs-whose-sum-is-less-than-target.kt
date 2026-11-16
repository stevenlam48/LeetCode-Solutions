package countpairswhosesumislessthantarget

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountPairsWhoseSumIsLessThanTargetTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(3, solution.countPairs(intArrayOf(-1, 1, 2, 3, 1), 2))
    }

    @Test
    fun testExample2() {
        assertEquals(10, solution.countPairs(intArrayOf(-6, 2, 5, -2, -7, -1, 3), -2))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0, solution.countPairs(intArrayOf(1), 5))
    }

    @Test
    fun testEmpty() {
        assertEquals(0, solution.countPairs(intArrayOf(), 5))
    }

    @Test
    fun testAllPairs() {
        assertEquals(3, solution.countPairs(intArrayOf(1, 1, 1), 3))
    }
}
