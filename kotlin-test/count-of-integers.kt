package countofintegers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountOfIntegersTest {
    private val solution = Solution()

    @Test
    fun exampleWithUpperDigitSumLimit() {
        assertEquals(11, solution.count("1", "12", 1, 8))
    }

    @Test
    fun smallRangeExample() {
        assertEquals(2, solution.count("1", "2", 1, 2))
    }

    @Test
    fun includesLowerBoundaryWhenItsDigitSumQualifies() {
        assertEquals(1, solution.count("12", "12", 3, 3))
    }

    @Test
    fun supportsLeadingZeros() {
        assertEquals(11, solution.count("001", "012", 1, 8))
    }

    @Test
    fun noNumberHasQualifyingDigitSum() {
        assertEquals(0, solution.count("7", "7", 8, 9))
    }
}
