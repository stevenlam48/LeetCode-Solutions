package robotcollisions

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class RobotCollisionsTest {
    @Test
    fun facingPairsDestroyEachOther() {
        val result = Solution().survivedRobotsHealths(
            intArrayOf(5, 4, 2, 7, 1),
            intArrayOf(2, 2, 1, 5, 3),
            "RRRLL"
        )
        assertArrayEquals(intArrayOf(2, 3), result)
    }

    @Test
    fun survivorKeepsReducedHealth() {
        val result = Solution().survivedRobotsHealths(
            intArrayOf(3, 5, 2, 6),
            intArrayOf(10, 10, 5, 40),
            "RLRL"
        )
        assertArrayEquals(intArrayOf(39), result)
    }

    @Test
    fun equalHealthsDestroyBoth() {
        val result = Solution().survivedRobotsHealths(
            intArrayOf(1, 2),
            intArrayOf(5, 5),
            "RL"
        )
        assertArrayEquals(intArrayOf(), result)
    }

    @Test
    fun strongerRobotSurvives() {
        val result = Solution().survivedRobotsHealths(
            intArrayOf(1, 2),
            intArrayOf(5, 3),
            "RL"
        )
        assertArrayEquals(intArrayOf(4), result)
    }

    @Test
    fun sameDirectionNeverCollides() {
        val result = Solution().survivedRobotsHealths(
            intArrayOf(1, 2, 3),
            intArrayOf(7, 8, 9),
            "RRR"
        )
        assertArrayEquals(intArrayOf(7, 8, 9), result)
    }

    @Test
    fun movingApartNeverCollides() {
        val result = Solution().survivedRobotsHealths(
            intArrayOf(2, 1),
            intArrayOf(4, 6),
            "RL"
        )
        assertArrayEquals(intArrayOf(4, 6), result)
    }
}
