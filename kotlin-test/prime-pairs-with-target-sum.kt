package primepairswithtargetsum

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PrimePairsWithTargetSumTest {
    @Test
    fun exampleOne() {
        val expected = arrayOf(intArrayOf(3, 7), intArrayOf(5, 5))
        assertTrue(expected.contentDeepEquals(Solution().findPrimePairs(10)))
    }

    @Test
    fun exampleTwo() {
        val expected = arrayOf(intArrayOf(3, 17), intArrayOf(7, 13))
        assertTrue(expected.contentDeepEquals(Solution().findPrimePairs(20)))
    }

    @Test
    fun two() {
        assertTrue(arrayOf<IntArray>().contentDeepEquals(Solution().findPrimePairs(2)))
    }

    @Test
    fun three() {
        assertTrue(arrayOf<IntArray>().contentDeepEquals(Solution().findPrimePairs(3)))
    }

    @Test
    fun four() {
        val expected = arrayOf(intArrayOf(2, 2))
        assertTrue(expected.contentDeepEquals(Solution().findPrimePairs(4)))
    }
}
