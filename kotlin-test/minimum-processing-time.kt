package minimumprocessingtime

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumProcessingTimeTest {
    private val solution = Solution()

    @Test
    fun `first example pairs earliest processors with longest tasks`() {
        assertEquals(
            16,
            solution.minProcessingTime(
                intArrayOf(8, 10),
                intArrayOf(2, 2, 3, 1, 8, 7, 4, 5)
            )
        )
    }

    @Test
    fun `second example has later processor determining finish`() {
        assertEquals(
            23,
            solution.minProcessingTime(
                intArrayOf(10, 20),
                intArrayOf(2, 3, 1, 2, 5, 8, 4, 3)
            )
        )
    }

    @Test
    fun `single processor receives four longest tasks`() {
        assertEquals(9, solution.minProcessingTime(intArrayOf(5), intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun `zero processor times and tasks finish immediately`() {
        assertEquals(
            0,
            solution.minProcessingTime(intArrayOf(0, 0), IntArray(8))
        )
    }
}
