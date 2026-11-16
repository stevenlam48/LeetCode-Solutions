package finddiameterendpointsofatree

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindDiameterEndpointsOfATreeTest {
    @Test
    fun pathOfThree() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertEquals("101", Solution().findSpecialNodes(3, edges))
    }

    @Test
    fun pathOfFive() {
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4)
        )
        assertEquals("10001", Solution().findSpecialNodes(5, edges))
    }

    @Test
    fun star() {
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(0, 3)
        )
        assertEquals("0111", Solution().findSpecialNodes(4, edges))
    }

    @Test
    fun singleEdge() {
        val edges = arrayOf(intArrayOf(0, 1))
        assertEquals("11", Solution().findSpecialNodes(2, edges))
    }
}
