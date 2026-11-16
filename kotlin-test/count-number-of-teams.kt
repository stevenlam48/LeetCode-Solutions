package countnumberofteams

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountNumberOfTeamsTest {
    @Test
    fun exampleOne() {
        assertEquals(3, Solution().numTeams(intArrayOf(2, 5, 3, 4, 1)))
    }

    @Test
    fun exampleTwo() {
        assertEquals(0, Solution().numTeams(intArrayOf(2, 1, 3)))
    }

    @Test
    fun exampleThree() {
        assertEquals(4, Solution().numTeams(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun duplicatesAndTooFewSoldiers() {
        assertEquals(0, Solution().numTeams(intArrayOf(2, 2, 2, 2)))
        assertEquals(0, Solution().numTeams(intArrayOf(1, 2)))
        assertEquals(0, Solution().numTeams(intArrayOf()))
    }
}
