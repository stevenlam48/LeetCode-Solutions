package countalmostequalpairsi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountAlmostEqualPairsITest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        assertEquals(2, solution.countPairs(intArrayOf(3, 12, 30, 17, 21)))
    }

    @Test
    fun testAllEqual() {
        assertEquals(10, solution.countPairs(intArrayOf(1, 1, 1, 1, 1)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0, solution.countPairs(intArrayOf(7)))
    }
}
