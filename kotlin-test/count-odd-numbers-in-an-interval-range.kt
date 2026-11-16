package countoddnumbersinanintervalrange

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountOddNumbersInAnIntervalRangeTest {
    private val solution = Solution()

    @Test
    fun oddEndpointsExample() {
        assertEquals(3, solution.countOdds(3, 7))
    }

    @Test
    fun evenEndpointsExample() {
        assertEquals(1, solution.countOdds(8, 10))
    }

    @Test
    fun singletonEvenAndOddRanges() {
        assertEquals(0, solution.countOdds(4, 4))
        assertEquals(1, solution.countOdds(5, 5))
    }

    @Test
    fun rangeBeginningAtZero() {
        assertEquals(0, solution.countOdds(0, 0))
        assertEquals(1, solution.countOdds(0, 1))
    }
}
