package minimumnumberoffrogscroaking

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfFrogsCroakingTest {
    private val solution = Solution()

    @Test
    fun oneFrog() {
        assertEquals(1, solution.minNumberOfFrogs("croakcroak"))
    }

    @Test
    fun twoOverlappingFrogs() {
        assertEquals(2, solution.minNumberOfFrogs("crcoakroak"))
    }

    @Test
    fun invalidCharacterInCroak() {
        assertEquals(-1, solution.minNumberOfFrogs("croakcrook"))
    }

    @Test
    fun incompleteCroak() {
        assertEquals(-1, solution.minNumberOfFrogs("croakcroa"))
    }

    @Test
    fun singleCroak() {
        assertEquals(1, solution.minNumberOfFrogs("croak"))
    }
}
