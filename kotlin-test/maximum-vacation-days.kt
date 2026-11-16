package maximumvacationdays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumVacationDaysTest {
    @Test
    fun examples() {
        assertEquals(
            12,
            Solution().maxVacationDays(
                arrayOf(intArrayOf(0, 1, 1), intArrayOf(1, 0, 1), intArrayOf(1, 1, 0)),
                arrayOf(intArrayOf(1, 3, 1), intArrayOf(6, 0, 3), intArrayOf(3, 3, 3))
            )
        )
        assertEquals(
            3,
            Solution().maxVacationDays(
                arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 0), intArrayOf(0, 0, 0)),
                arrayOf(intArrayOf(1, 1, 1), intArrayOf(7, 7, 7), intArrayOf(7, 7, 7))
            )
        )
    }

    @Test
    fun flyThenStay() {
        assertEquals(
            6,
            Solution().maxVacationDays(
                arrayOf(intArrayOf(0, 1), intArrayOf(0, 0)),
                arrayOf(intArrayOf(1, 2), intArrayOf(5, 1))
            )
        )
    }

    @Test
    fun emptyOrSingleCity() {
        assertEquals(0, Solution().maxVacationDays(arrayOf(), arrayOf()))
        assertEquals(10, Solution().maxVacationDays(arrayOf(intArrayOf(0)), arrayOf(intArrayOf(4, 6))))
    }
}
