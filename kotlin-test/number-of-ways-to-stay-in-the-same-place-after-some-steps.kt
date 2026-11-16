package numberofwaystostayinthesameplaceaftersomesteps

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfWaysToStayInTheSamePlaceAfterSomeStepsTest {
    @Test
    fun firstExample() {
        assertEquals(4, Solution().numWays(3, 2))
    }

    @Test
    fun secondExample() {
        assertEquals(2, Solution().numWays(2, 4))
    }

    @Test
    fun thirdExample() {
        assertEquals(8, Solution().numWays(4, 2))
    }

    @Test
    fun noRoomToMove() {
        assertEquals(1, Solution().numWays(1, 1))
    }
}
