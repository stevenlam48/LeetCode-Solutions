package checkingexistenceofedgelengthlimitedpathsii

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CheckingExistenceOfEdgeLengthLimitedPathsIITest {
    @Test
    fun testChainQueries() {
        val edges = arrayOf(
            intArrayOf(0, 1, 10),
            intArrayOf(1, 2, 5),
            intArrayOf(2, 3, 8),
            intArrayOf(3, 4, 3)
        )
        val solution = DistanceLimitedPathsExist(6, edges)
        assertTrue(solution.query(0, 4, 50))
        assertFalse(solution.query(0, 4, 10))
        assertTrue(solution.query(0, 4, 11))
        assertFalse(solution.query(0, 2, 6))
        assertTrue(solution.query(2, 4, 9))
        assertTrue(solution.query(1, 3, 9))
    }

    @Test
    fun testDisconnectedNodes() {
        val solution = DistanceLimitedPathsExist(6, arrayOf(intArrayOf(0, 1, 1)))
        assertFalse(solution.query(0, 5, 100))
        assertTrue(solution.query(0, 1, 2))
    }

    @Test
    fun testSameNode() {
        val solution = DistanceLimitedPathsExist(3, emptyArray())
        assertTrue(solution.query(1, 1, 1))
        assertFalse(solution.query(1, 2, 1000))
    }

    @Test
    fun testMultipleComponents() {
        val edges = arrayOf(
            intArrayOf(0, 1, 4),
            intArrayOf(2, 3, 7)
        )
        val solution = DistanceLimitedPathsExist(4, edges)
        assertTrue(solution.query(0, 1, 5))
        assertTrue(solution.query(2, 3, 8))
        assertFalse(solution.query(2, 3, 7))
        assertFalse(solution.query(0, 2, 100))
    }
}
