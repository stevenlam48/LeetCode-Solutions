package minimumnumberofprimestosumtotarget

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfPrimesToSumToTargetTest {
    private val solution = Solution()

    @Test
    fun usesTwoSmallestPrimes() {
        assertEquals(4, solution.minNumberOfPrimes(10, 2))
        assertEquals(5, solution.minNumberOfPrimes(15, 2))
    }

    @Test
    fun usesLargerPrimesWhenTheyReduceTheCount() {
        assertEquals(3, solution.minNumberOfPrimes(24, 5))
    }

    @Test
    fun returnsMinusOneWhenTargetCannotBeFormed() {
        assertEquals(-1, solution.minNumberOfPrimes(7, 1))
        assertEquals(-1, solution.minNumberOfPrimes(3, 1))
    }

    @Test
    fun reusesTheSamePrime() {
        assertEquals(4, solution.minNumberOfPrimes(8, 1))
        assertEquals(1, solution.minNumberOfPrimes(3, 2))
    }

    @Test
    fun handlesZeroTarget() {
        assertEquals(0, solution.minNumberOfPrimes(0, 1))
    }
}
