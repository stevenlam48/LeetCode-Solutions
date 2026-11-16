package minimumpossiblemaximumwaitingtime

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumPossibleMaximumWaitingTimeTest {
    private val solution = Solution()

    @Test
    fun `single servable car has no waiting time`() {
        assertEquals(0, solution.minMaxWaitingTime(intArrayOf(5), intArrayOf(5, 0)))
    }

    @Test
    fun `returns minus one when first car cannot be served`() {
        assertEquals(-1, solution.minMaxWaitingTime(intArrayOf(5), intArrayOf(3, 4)))
    }

    @Test
    fun `third equal car must wait for a dispenser`() {
        assertEquals(2, solution.minMaxWaitingTime(intArrayOf(2, 2, 2), intArrayOf(10, 10)))
    }

    @Test
    fun `fuel capacities restrict dispenser assignments`() {
        assertEquals(3, solution.minMaxWaitingTime(intArrayOf(3, 3, 3), intArrayOf(6, 3)))
    }

    @Test
    fun `uneven demands preserve the optimal maximum wait`() {
        assertEquals(4, solution.minMaxWaitingTime(intArrayOf(4, 4, 1, 1), intArrayOf(20, 20)))
    }
}
