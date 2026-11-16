package findthenumberofpossiblewaysforanevent

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheNumberOfPossibleWaysForAnEventTest {
    @Test
    fun oneParticipantAndOneStage() {
        assertEquals(2, Solution().numberOfWays(1, 1, 2))
    }

    @Test
    fun participantsCanShareASingleStage() {
        assertEquals(12, Solution().numberOfWays(2, 2, 2))
    }

    @Test
    fun everyUsedStageHasOneChoice() {
        assertEquals(8, Solution().numberOfWays(3, 2, 1))
    }

    @Test
    fun moreStagesThanParticipants() {
        assertEquals(9, Solution().numberOfWays(2, 3, 1))
    }

    @Test
    fun allThreeStagesCanBeUsed() {
        assertEquals(126, Solution().numberOfWays(3, 3, 2))
    }
}
