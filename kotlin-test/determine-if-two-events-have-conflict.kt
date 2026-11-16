package determineiftwoeventshaveconflict

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DetermineIfTwoEventsHaveConflictTest {
    private val solution = Solution()

    @Test
    fun partiallyOverlappingEventsConflict() {
        assertTrue(
            solution.haveConflict(
                listOf("01:15", "02:00"),
                listOf("02:00", "03:00")
            )
        )
    }

    @Test
    fun containedEventConflicts() {
        assertTrue(
            solution.haveConflict(
                listOf("01:00", "02:00"),
                listOf("01:20", "03:00")
            )
        )
    }

    @Test
    fun disjointEventsDoNotConflict() {
        assertFalse(
            solution.haveConflict(
                listOf("10:00", "11:00"),
                listOf("14:00", "15:00")
            )
        )
    }

    @Test
    fun sameEventConflicts() {
        val event = listOf("05:30", "06:45")
        assertTrue(solution.haveConflict(event, event))
    }
}
