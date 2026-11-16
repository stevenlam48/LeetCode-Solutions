package minimumnumberofdaystoeatnoranges

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfDaysToEatNOrangesTest {
    private val solution = Solution()

    @Test
    fun tenOranges() {
        assertEquals(4, solution.minDays(10))
    }

    @Test
    fun sixOranges() {
        assertEquals(3, solution.minDays(6))
    }

    @Test
    fun oneOrange() {
        assertEquals(1, solution.minDays(1))
    }

    @Test
    fun noOranges() {
        assertEquals(0, solution.minDays(0))
    }

    @Test
    fun twelveOranges() {
        assertEquals(4, solution.minDays(12))
    }
}
