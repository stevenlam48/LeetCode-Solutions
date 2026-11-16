package maximumsubarraywithequalproducts
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSubarrayWithEqualProductsTest {
    private val solution = Solution()

    @Test
    fun distinctPrimeFactors() {
        assertEquals(4, solution.maxLength(intArrayOf(2, 3, 5, 7)))
    }

    @Test
    fun repeatedPrimeFactorsLimitWindow() {
        assertEquals(4, solution.maxLength(intArrayOf(2, 3, 4, 5, 7, 10)))
    }

    @Test
    fun compositeNumbers() {
        assertEquals(2, solution.maxLength(intArrayOf(6, 10, 9, 4)))
    }

    @Test
    fun onesHaveNoPrimeDivisors() {
        assertEquals(3, solution.maxLength(intArrayOf(1, 1, 1)))
    }

    @Test
    fun identicalPrimeNumbers() {
        assertEquals(2, solution.maxLength(intArrayOf(2, 2, 2)))
    }
}
