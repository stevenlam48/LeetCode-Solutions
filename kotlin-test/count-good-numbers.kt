package countgoodnumbers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountGoodNumbersTest {
    private val solution = Solution()

    @Test
    fun countsSingleDigitNumbers() {
        assertEquals(5, solution.countGoodNumbers(1))
    }

    @Test
    fun countsEvenAndOddLengths() {
        assertEquals(400, solution.countGoodNumbers(4))
        assertEquals(2000, solution.countGoodNumbers(5))
    }

    @Test
    fun appliesModuloForLargeInput() {
        assertEquals(564908303, solution.countGoodNumbers(50))
    }
}
