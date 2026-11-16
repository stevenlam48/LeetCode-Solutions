package countgoodstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountGoodStringsTest {
    private val solution = Solution()

    @Test
    fun emptyStringHasNoGoodStrings() {
        assertEquals(0, solution.countGoodStrings(0))
    }

    @Test
    fun countsShortLengths() {
        assertEquals(2, solution.countGoodStrings(1))
        assertEquals(2, solution.countGoodStrings(2))
    }

    @Test
    fun followsRecurrenceForLongerLengths() {
        assertEquals(4, solution.countGoodStrings(3))
        assertEquals(6, solution.countGoodStrings(4))
        assertEquals(10, solution.countGoodStrings(5))
    }
}
