package checkingexistenceofedgelengthlimitedpaths

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CheckingExistenceOfEdgeLengthLimitedPathsTest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        val n = 3
        val edgeList = arrayOf(
            intArrayOf(0, 1, 2),
            intArrayOf(1, 2, 4),
            intArrayOf(2, 0, 8),
            intArrayOf(1, 0, 16)
        )
        val queries = arrayOf(
            intArrayOf(0, 1, 2),
            intArrayOf(0, 2, 5)
        )
        assertArrayEquals(booleanArrayOf(false, true), solution.distanceLimitedPathsExist(n, edgeList, queries))
    }

    @Test
    fun testExampleTwo() {
        val n = 5
        val edgeList = arrayOf(
            intArrayOf(0, 1, 10),
            intArrayOf(1, 2, 5),
            intArrayOf(2, 3, 9),
            intArrayOf(3, 4, 13)
        )
        val queries = arrayOf(
            intArrayOf(0, 4, 14),
            intArrayOf(1, 4, 13)
        )
        assertArrayEquals(booleanArrayOf(true, false), solution.distanceLimitedPathsExist(n, edgeList, queries))
    }

    @Test
    fun testSameNode() {
        assertArrayEquals(
            booleanArrayOf(true, true),
            solution.distanceLimitedPathsExist(1, emptyArray(), arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 5)))
        )
    }

    @Test
    fun testDisconnected() {
        val n = 4
        val edgeList = arrayOf(intArrayOf(0, 1, 3))
        val queries = arrayOf(
            intArrayOf(0, 2, 100),
            intArrayOf(0, 1, 4)
        )
        assertArrayEquals(booleanArrayOf(false, true), solution.distanceLimitedPathsExist(n, edgeList, queries))
    }

    @Test
    fun testEmptyQueries() {
        assertArrayEquals(booleanArrayOf(), solution.distanceLimitedPathsExist(2, emptyArray(), emptyArray()))
    }
}
