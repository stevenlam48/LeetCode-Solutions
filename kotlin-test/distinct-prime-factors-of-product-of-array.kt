package distinctprimefactorsofproductofarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DistinctPrimeFactorsOfProductOfArrayTest {
    private val solution = Solution()

    @Test
    fun mixedPrimeFactors() {
        assertEquals(4, solution.distinctPrimeFactors(intArrayOf(2, 4, 3, 7, 10, 6)))
    }

    @Test
    fun powersOfOnePrime() {
        assertEquals(1, solution.distinctPrimeFactors(intArrayOf(2, 4, 8, 16)))
    }

    @Test
    fun onesHaveNoPrimeFactors() {
        assertEquals(0, solution.distinctPrimeFactors(intArrayOf(1)))
    }

    @Test
    fun largePrimeFactorsRemainAfterTrialDivision() {
        assertEquals(4, solution.distinctPrimeFactors(intArrayOf(30, 42, 70)))
    }
}
