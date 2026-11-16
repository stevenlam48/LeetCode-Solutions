package thetimewhenthenetworkbecomesidle

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TheTimeWhenTheNetworkBecomesIdleTest {

    @Test
    fun testExample1() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertEquals(8, Solution().networkBecomesIdle(edges, intArrayOf(0, 2, 1)))
    }

    @Test
    fun testExample2() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 2))
        assertEquals(3, Solution().networkBecomesIdle(edges, intArrayOf(0, 10, 10)))
    }

    @Test
    fun testSingleEdge() {
        val edges = arrayOf(intArrayOf(0, 1))
        assertEquals(4, Solution().networkBecomesIdle(edges, intArrayOf(0, 1)))
    }

    @Test
    fun testLargePatience() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3))
        assertEquals(7, Solution().networkBecomesIdle(edges, intArrayOf(0, 100, 100, 100)))
    }
}
