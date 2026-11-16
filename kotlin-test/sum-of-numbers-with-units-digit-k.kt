package sumofnumberswithunitsdigitk

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SumOfNumbersWithUnitsDigitKTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals(2, solution.minimumNumbers(58, 9))
    }

    @Test
    fun secondExample() {
        assertEquals(-1, solution.minimumNumbers(37, 2))
    }

    @Test
    fun zeroSumNeedsNoNumbers() {
        assertEquals(0, solution.minimumNumbers(0, 0))
    }

    @Test
    fun unitsDigitZero() {
        assertEquals(1, solution.minimumNumbers(30, 0))
    }

    @Test
    fun exactSingleNumber() {
        assertEquals(1, solution.minimumNumbers(5, 5))
    }
}
