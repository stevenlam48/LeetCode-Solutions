package maximumlengthofpairchain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumLengthOfPairChainTest {
    private val solution = Solution()

    @Test
    fun `finds a chain among overlapping pairs`() {
        val pairs = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4))
        assertEquals(2, solution.findLongestChain(pairs))
    }

    @Test
    fun `chains nonoverlapping pairs`() {
        val pairs = arrayOf(intArrayOf(1, 2), intArrayOf(7, 8), intArrayOf(4, 5))
        assertEquals(3, solution.findLongestChain(pairs))
    }

    @Test
    fun `handles negative endpoints`() {
        val pairs = arrayOf(intArrayOf(-6, 9), intArrayOf(1, 6), intArrayOf(8, 10), intArrayOf(-5, 8))
        assertEquals(2, solution.findLongestChain(pairs))
    }

    @Test
    fun `handles no pairs`() {
        assertEquals(0, solution.findLongestChain(arrayOf()))
    }
}
