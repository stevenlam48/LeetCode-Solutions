package countalmostequalpairsii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountAlmostEqualPairsIITest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        assertEquals(4, solution.countPairs(intArrayOf(1023, 2310, 2130, 213)))
    }

    @Test
    fun testAllEqual() {
        assertEquals(6, solution.countPairs(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0, solution.countPairs(intArrayOf(9)))
    }
}
