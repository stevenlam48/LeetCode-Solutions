package maximumenemyfortsthatcanbecaptured

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumEnemyFortsThatCanBeCapturedTest {
    @Test
    fun example1() {
        assertEquals(4, Solution().captureForts(intArrayOf(1, 0, 0, -1, 0, 0, 0, 0, 1)))
    }

    @Test
    fun example2() {
        assertEquals(0, Solution().captureForts(intArrayOf(0, 0, 1, -1)))
    }

    @Test
    fun noForts() {
        assertEquals(0, Solution().captureForts(intArrayOf(0, 0, 0)))
    }

    @Test
    fun adjacentForts() {
        assertEquals(0, Solution().captureForts(intArrayOf(1, -1, 1, -1)))
    }

    @Test
    fun singleFort() {
        assertEquals(0, Solution().captureForts(intArrayOf(1)))
    }

    @Test
    fun multipleRuns() {
        assertEquals(3, Solution().captureForts(intArrayOf(1, 0, 0, 0, -1, 0, 0, 1)))
    }
}
