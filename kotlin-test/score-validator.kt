package scorevalidator

// Time:  O(n)
// Space: O(1)

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ScoreValidatorTest {
    @Test
    fun mixedScoringEvents() {
        assertArrayEquals(
            intArrayOf(13, 1),
            Solution().scoreValidator(listOf("1", "W", "4", "WD", "NB", "6"))
        )
    }

    @Test
    fun stopsAtTenthWicket() {
        val events = MutableList(9) { "W" } + listOf("4", "W", "6", "WD")
        assertArrayEquals(intArrayOf(4, 10), Solution().scoreValidator(events))
    }

    @Test
    fun onlyWickets() {
        assertArrayEquals(intArrayOf(0, 3), Solution().scoreValidator(listOf("W", "W", "W")))
    }

    @Test
    fun emptyInnings() {
        assertArrayEquals(intArrayOf(0, 0), Solution().scoreValidator(emptyList()))
    }
}
