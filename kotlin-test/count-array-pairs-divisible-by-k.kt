package countarraypairsdivisiblebyk

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountArrayPairsDivisibleByKTest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        assertEquals(7L, solution.countPairs(intArrayOf(1, 2, 3, 4, 5), 2))
    }

    @Test
    fun testNoPairs() {
        assertEquals(0L, solution.countPairs(intArrayOf(1, 2, 3, 4), 5))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0L, solution.countPairs(intArrayOf(10), 5))
    }
}
