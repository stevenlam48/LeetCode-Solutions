package minimizethetotalpriceofthetrips

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimizeTheTotalPriceOfTheTripsTest {
    @Test
    fun example1() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(1, 3))
        val trips = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(1, 3))
        assertEquals(9, Solution().minimumTotalPrice(4, edges, intArrayOf(2, 2, 2, 2), trips))
    }

    @Test
    fun twoNodes() {
        val edges = arrayOf(intArrayOf(0, 1))
        val trips = arrayOf(intArrayOf(0, 1))
        assertEquals(3, Solution().minimumTotalPrice(2, edges, intArrayOf(2, 2), trips))
    }

    @Test
    fun singleNode() {
        val trips = arrayOf(intArrayOf(0, 0))
        assertEquals(2, Solution().minimumTotalPrice(1, arrayOf(), intArrayOf(5), trips))
    }

    @Test
    fun pathOfThree() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        val trips = arrayOf(intArrayOf(0, 2))
        assertEquals(3, Solution().minimumTotalPrice(3, edges, intArrayOf(1, 2, 3), trips))
    }

    @Test
    fun pathOfFour() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3))
        val trips = arrayOf(intArrayOf(0, 3))
        assertEquals(2, Solution().minimumTotalPrice(4, edges, intArrayOf(1, 1, 1, 1), trips))
    }
}
