package collectcoinsinatree

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CollectCoinsInATreeTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val edges = arrayOf(
            intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3),
            intArrayOf(3, 4), intArrayOf(4, 5)
        )
        assertEquals(2, solution.collectTheCoins(intArrayOf(1, 0, 0, 0, 0, 1), edges))
    }

    @Test
    fun testCoinsAdjacent() {
        val edges = arrayOf(
            intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4)
        )
        assertEquals(0, solution.collectTheCoins(intArrayOf(0, 0, 0, 1, 1), edges))
    }

    @Test
    fun testSingleNode() {
        assertEquals(0, solution.collectTheCoins(intArrayOf(1), emptyArray()))
        assertEquals(0, solution.collectTheCoins(intArrayOf(0), emptyArray()))
    }

    @Test
    fun testTwoNodes() {
        assertEquals(0, solution.collectTheCoins(intArrayOf(1, 1), arrayOf(intArrayOf(0, 1))))
    }

    @Test
    fun testCoinsAtLeaf() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertEquals(0, solution.collectTheCoins(intArrayOf(0, 0, 1), edges))
    }
}
