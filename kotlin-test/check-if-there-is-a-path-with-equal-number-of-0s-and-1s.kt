package checkifthereisapathwithequalnumberof0sand1s

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CheckIfThereIsAPathWithEqualNumberOf0sAnd1sTest {
    private val solution = Solution()

    @Test
    fun testEqualCountsReachable() {
        assertTrue(solution.isThereAPath(arrayOf(intArrayOf(1, 0, 1), intArrayOf(0, 1, 0))))
    }

    @Test
    fun testNotEnoughOnes() {
        assertFalse(solution.isThereAPath(arrayOf(intArrayOf(0, 1, 0), intArrayOf(0, 0, 0))))
    }

    @Test
    fun testSingleCell() {
        assertFalse(solution.isThereAPath(arrayOf(intArrayOf(0))))
    }

    @Test
    fun testOddPathLength() {
        assertFalse(solution.isThereAPath(arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))))
    }

    @Test
    fun testSingleRowTrue() {
        assertTrue(solution.isThereAPath(arrayOf(intArrayOf(0, 1, 1, 0))))
    }

    @Test
    fun testSingleRowAllOnes() {
        assertFalse(solution.isThereAPath(arrayOf(intArrayOf(1, 1, 1, 1))))
    }
}
