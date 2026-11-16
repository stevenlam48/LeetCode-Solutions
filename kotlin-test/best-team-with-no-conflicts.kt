package bestteamwithnoconflicts

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BestTeamWithNoConflictsTest {
    @Test
    fun example1() {
        assertEquals(
            34,
            Solution().bestTeamScore(intArrayOf(1, 3, 5, 10, 15), intArrayOf(1, 2, 3, 4, 5)),
        )
    }

    @Test
    fun example2() {
        assertEquals(
            16,
            Solution().bestTeamScore(intArrayOf(4, 5, 6, 5), intArrayOf(2, 1, 2, 1)),
        )
    }

    @Test
    fun example3() {
        assertEquals(
            6,
            Solution().bestTeamScore(intArrayOf(1, 2, 3, 5), intArrayOf(8, 9, 10, 1)),
        )
    }

    @Test
    fun singlePlayer() {
        assertEquals(7, Solution().bestTeamScore(intArrayOf(7), intArrayOf(3)))
    }

    @Test
    fun duplicates() {
        assertEquals(
            15,
            Solution().bestTeamScore(intArrayOf(5, 5, 5), intArrayOf(1, 2, 3)),
        )
    }
}
