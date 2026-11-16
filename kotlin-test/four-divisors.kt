package fourdivisors

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FourDivisorsTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(32, solution.sumFourDivisors(intArrayOf(21, 4, 7)))
    }

    @Test
    fun repeatedQualifyingNumber() {
        assertEquals(64, solution.sumFourDivisors(intArrayOf(21, 21)))
    }

    @Test
    fun primeCubesAndProductsOfTwoPrimes() {
        assertEquals(91, solution.sumFourDivisors(intArrayOf(6, 8, 15, 27)))
    }

    @Test
    fun rejectsNumbersWithOtherDivisorCounts() {
        assertEquals(0, solution.sumFourDivisors(intArrayOf(1, 2, 4, 7, 9, 12, 16, 36)))
    }

    @Test
    fun emptyInput() {
        assertEquals(0, solution.sumFourDivisors(intArrayOf()))
    }
}
