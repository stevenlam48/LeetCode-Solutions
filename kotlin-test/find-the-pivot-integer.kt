package findthepivotinteger

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindThePivotIntegerTest {
    private val solution = Solution()

    @Test
    fun singleElementIsItsOwnPivot() {
        assertEquals(1, solution.pivotInteger(1))
    }

    @Test
    fun findsPivotForEight() {
        assertEquals(6, solution.pivotInteger(8))
    }

    @Test
    fun returnsMinusOneWhenPivotDoesNotExist() {
        assertEquals(-1, solution.pivotInteger(4))
        assertEquals(-1, solution.pivotInteger(2))
    }

    @Test
    fun findsLargerPivot() {
        assertEquals(35, solution.pivotInteger(49))
    }
}
