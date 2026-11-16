package countintegerswithevendigitsum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountIntegersWithEvenDigitSumTest {
    private val solution = Solution()

    @Test
    fun countsFirstExample() {
        assertEquals(4, solution.countEven(8))
    }

    @Test
    fun countsSecondExample() {
        assertEquals(14, solution.countEven(30))
    }

    @Test
    fun smallestPositiveIntegerHasOddDigitSum() {
        assertEquals(0, solution.countEven(1))
    }
}
