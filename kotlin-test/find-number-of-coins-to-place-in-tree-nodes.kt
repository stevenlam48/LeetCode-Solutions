package findnumberofcoinstoplaceintreenodes

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindNumberOfCoinsToPlaceInTreeNodesTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3))
        assertArrayEquals(longArrayOf(24, 1, 1, 1), solution.placedCoins(edges, intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun exampleTwo() {
        val edges = arrayOf(
            intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 3), intArrayOf(1, 4),
            intArrayOf(1, 5), intArrayOf(2, 6), intArrayOf(2, 7), intArrayOf(2, 8)
        )
        val cost = intArrayOf(1, 4, 2, 3, 5, 7, 8, -4, 2)
        assertArrayEquals(longArrayOf(280, 140, 32, 1, 1, 1, 1, 1, 1), solution.placedCoins(edges, cost))
    }

    @Test
    fun twoNegativeCostsGivePositiveProduct() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3))
        assertArrayEquals(longArrayOf(24, 1, 1, 1), solution.placedCoins(edges, intArrayOf(-1, -2, -3, 4)))
    }

    @Test
    fun singleNode() {
        assertArrayEquals(longArrayOf(1), solution.placedCoins(arrayOf(), intArrayOf(5)))
    }
}
