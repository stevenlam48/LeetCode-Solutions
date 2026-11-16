package generateschedule

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class GenerateScheduleTest {
    @Test
    fun smallTeamsReturnEmptySchedule() {
        for (n in 1..4) {
            assertTrue(Solution().generateSchedule(n).isEmpty())
        }
    }

    @Test
    fun everyOrderedPairAppearsExactlyOnce() {
        for (n in 5..10) {
            val schedule = Solution().generateSchedule(n)
            assertEquals(n * (n - 1), schedule.size)
            val seen = HashSet<Pair<Int, Int>>()
            for (game in schedule) {
                assertEquals(2, game.size)
                val a = game[0]
                val b = game[1]
                assertTrue(a in 0 until n)
                assertTrue(b in 0 until n)
                assertNotEquals(a, b)
                assertTrue(seen.add(a to b), "duplicate game ($a, $b) for n = $n")
            }
            assertEquals(n * (n - 1), seen.size)
        }
    }

    @Test
    fun everyUnorderedPairIsPlayedTwice() {
        for (n in 5..10) {
            val schedule = Solution().generateSchedule(n)
            val seen = HashSet<Pair<Int, Int>>()
            for (game in schedule) {
                seen.add(game[0] to game[1])
            }
            for (a in 0 until n) {
                for (b in a + 1 until n) {
                    assertTrue((a to b) in seen, "missing ($a, $b) for n = $n")
                    assertTrue((b to a) in seen, "missing ($b, $a) for n = $n")
                }
            }
        }
    }

    @Test
    fun evenNumberOfTeams() {
        assertEquals(30, Solution().generateSchedule(6).size)
    }

    @Test
    fun oddNumberOfTeams() {
        assertEquals(20, Solution().generateSchedule(5).size)
    }
}
