package maximumrunningtimeofncomputers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumRunningTimeOfNComputersTest {
    private val solution = Solution()

    @Test
    fun equalBatteriesSupportFourMinutes() {
        assertEquals(4L, solution.maxRunTime(2, intArrayOf(3, 3, 3)))
    }

    @Test
    fun extraSmallBatteriesExtendRuntime() {
        assertEquals(2L, solution.maxRunTime(2, intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun reservesOversizedBatteries() {
        assertEquals(8L, solution.maxRunTime(3, intArrayOf(10, 10, 3, 5)))
    }

    @Test
    fun oneComputerUsesEveryBattery() {
        assertEquals(18L, solution.maxRunTime(1, intArrayOf(7, 2, 9)))
    }

    @Test
    fun totalUsesLongArithmetic() {
        assertEquals(
            Int.MAX_VALUE.toLong(),
            solution.maxRunTime(2, intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE))
        )
    }
}
