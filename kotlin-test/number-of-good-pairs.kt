package numberofgoodpairs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfGoodPairsTest {
    @Test
    fun testExample1() {
        assertEquals(4, Solution().numIdenticalPairs(intArrayOf(1, 2, 3, 1, 1, 3)))
    }

    @Test
    fun testAllEqual() {
        assertEquals(6, Solution().numIdenticalPairs(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun testAllDistinct() {
        assertEquals(0, Solution().numIdenticalPairs(intArrayOf(1, 2, 3)))
    }
}
