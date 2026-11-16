package averagewaitingtime

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AverageWaitingTimeTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(
            5.0,
            solution.averageWaitingTime(
                arrayOf(intArrayOf(1, 2), intArrayOf(2, 5), intArrayOf(4, 3))
            ),
            1e-9
        )
    }

    @Test
    fun testExample2() {
        assertEquals(
            3.25,
            solution.averageWaitingTime(
                arrayOf(
                    intArrayOf(5, 2),
                    intArrayOf(5, 4),
                    intArrayOf(10, 3),
                    intArrayOf(20, 1)
                )
            ),
            1e-9
        )
    }

    @Test
    fun testSingleCustomer() {
        assertEquals(
            3.0,
            solution.averageWaitingTime(arrayOf(intArrayOf(2, 3))),
            1e-9
        )
    }

    @Test
    fun testIdleGaps() {
        assertEquals(
            2.0,
            solution.averageWaitingTime(
                arrayOf(intArrayOf(1, 2), intArrayOf(10, 2))
            ),
            1e-9
        )
    }
}
