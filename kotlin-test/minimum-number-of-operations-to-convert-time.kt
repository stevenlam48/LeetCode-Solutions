package minimumnumberofoperationstoconverttime

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfOperationsToConvertTimeTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(3, solution.convertTime("02:30", "04:35"))
    }

    @Test
    fun oneMinuteDifference() {
        assertEquals(1, solution.convertTime("11:00", "11:01"))
    }

    @Test
    fun sameTime() {
        assertEquals(0, solution.convertTime("01:00", "01:00"))
    }

    @Test
    fun almostFullDay() {
        assertEquals(32, solution.convertTime("00:00", "23:59"))
    }
}
