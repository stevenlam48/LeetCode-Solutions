package minimumdegreeofaconnectedtrioinagraph

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumDegreeOfAConnectedTrioInAGraphTest {
    @Test
    fun example1() {
        val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(3, 2),
            intArrayOf(4, 1),
            intArrayOf(5, 2),
            intArrayOf(3, 6)
        )
        assertEquals(3, Solution().minTrioDegree(6, edges))
    }

    @Test
    fun triangleOnly() {
        val edges = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(1, 3))
        assertEquals(0, Solution().minTrioDegree(3, edges))
    }

    @Test
    fun noTriangle() {
        val edges = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3))
        assertEquals(-1, Solution().minTrioDegree(4, edges))
    }

    @Test
    fun twoTriangles() {
        val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(1, 3),
            intArrayOf(3, 4),
            intArrayOf(4, 5),
            intArrayOf(3, 5)
        )
        assertEquals(2, Solution().minTrioDegree(5, edges))
    }
}
