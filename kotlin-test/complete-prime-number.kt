package completeprimenumber

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CompletePrimeNumberTest {
    @Test
    fun acceptsSingleDigitPrimes() {
        val solution = Solution()
        for (n in intArrayOf(2, 3, 5, 7)) {
            assertTrue(solution.completePrime(n))
        }
        for (n in intArrayOf(1, 4, 6, 8, 9)) {
            assertFalse(solution.completePrime(n))
        }
    }

    @Test
    fun acceptsNumbersWhosePrefixesAndSuffixesArePrime() {
        val solution = Solution()
        for (n in intArrayOf(23, 37, 53, 73, 313)) {
            assertTrue(solution.completePrime(n))
        }
    }

    @Test
    fun rejectsCompositePrefixesSuffixesOrWholeNumbers() {
        val solution = Solution()
        for (n in intArrayOf(11, 13, 39, 59, 101)) {
            assertFalse(solution.completePrime(n))
        }
    }
}
