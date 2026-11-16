package minimumlevelstogainmorepoints

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumLevelsToGainMorePointsTest {

    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(1, solution.minimumLevels(intArrayOf(1, 0, 1, 0)))
    }

    @Test
    fun testExample2() {
        assertEquals(3, solution.minimumLevels(intArrayOf(1, 1, 1, 1, 1)))
    }

    @Test
    fun testImpossible() {
        assertEquals(-1, solution.minimumLevels(intArrayOf(0, 0)))
    }

    @Test
    fun testSingleWin() {
        assertEquals(1, solution.minimumLevels(intArrayOf(1, 0)))
    }

    @Test
    fun testSingleLoss() {
        assertEquals(-1, solution.minimumLevels(intArrayOf(0, 1)))
    }

    @Test
    fun testLateTurnaround() {
        assertEquals(4, solution.minimumLevels(intArrayOf(1, 1, 1, 1, 1, 1, 1, 0)))
    }
}
