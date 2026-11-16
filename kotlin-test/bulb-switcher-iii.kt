package bulbswitcheriii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BulbSwitcherIiiTest {
    @Test
    fun leetCodeExample() {
        assertEquals(3, Solution().numTimesAllBlue(intArrayOf(2, 1, 3, 5, 4)))
    }

    @Test
    fun onlyFinallyAllBlue() {
        assertEquals(1, Solution().numTimesAllBlue(intArrayOf(4, 1, 2, 3)))
    }

    @Test
    fun reverseOrderIsBlueAtEveryMoment() {
        assertEquals(4, Solution().numTimesAllBlue(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun singleLight() {
        assertEquals(1, Solution().numTimesAllBlue(intArrayOf(1)))
    }
}
