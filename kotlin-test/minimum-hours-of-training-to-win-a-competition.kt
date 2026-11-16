package minimumhoursoftrainingtowinacompetition

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumHoursOfTrainingToWinACompetitionTest {
    @Test
    fun example1() {
        assertEquals(
            8,
            Solution().minNumberOfHours(5, 3, intArrayOf(1, 4, 3, 2), intArrayOf(2, 6, 3, 1))
        )
    }

    @Test
    fun example2() {
        assertEquals(
            0,
            Solution().minNumberOfHours(2, 4, intArrayOf(1), intArrayOf(3))
        )
    }

    @Test
    fun example3() {
        assertEquals(
            5,
            Solution().minNumberOfHours(1, 1, intArrayOf(1, 1, 1, 1), intArrayOf(1, 1, 1, 1))
        )
    }

    @Test
    fun alreadyStrongEnough() {
        assertEquals(
            0,
            Solution().minNumberOfHours(10, 10, intArrayOf(5), intArrayOf(5))
        )
    }
}
