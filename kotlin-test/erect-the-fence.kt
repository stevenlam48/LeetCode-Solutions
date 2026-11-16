package erectthefence

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ErectTheFenceTest {
    private val solution = Solution()

    private fun asSet(points: Array<IntArray>): Set<Pair<Int, Int>> =
        points.map { it[0] to it[1] }.toSet()

    @Test
    fun testExample1() {
        val result = solution.outerTrees(
            arrayOf(
                intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(2, 0),
                intArrayOf(2, 4), intArrayOf(3, 3), intArrayOf(4, 2)
            )
        )
        assertEquals(
            setOf(1 to 1, 2 to 0, 4 to 2, 3 to 3, 2 to 4),
            asSet(result)
        )
    }

    @Test
    fun testCollinear() {
        val result = solution.outerTrees(
            arrayOf(intArrayOf(1, 2), intArrayOf(2, 2), intArrayOf(4, 2))
        )
        assertEquals(setOf(1 to 2, 2 to 2, 4 to 2), asSet(result))
    }

    @Test
    fun testSinglePoint() {
        val result = solution.outerTrees(arrayOf(intArrayOf(0, 0)))
        assertEquals(setOf(0 to 0), asSet(result))
    }

    @Test
    fun testTwoPoints() {
        val result = solution.outerTrees(arrayOf(intArrayOf(0, 0), intArrayOf(1, 1)))
        assertEquals(setOf(0 to 0, 1 to 1), asSet(result))
    }

    @Test
    fun testSquareWithInteriorPoint() {
        val result = solution.outerTrees(
            arrayOf(
                intArrayOf(0, 0), intArrayOf(0, 2), intArrayOf(2, 0),
                intArrayOf(2, 2), intArrayOf(1, 1)
            )
        )
        assertEquals(setOf(0 to 0, 0 to 2, 2 to 0, 2 to 2), asSet(result))
    }
}
