package numberofcommonfactors

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NumberOfCommonFactorsTest {
    private val solution = Solution()

    @Test
    fun `counts all factors of six`() {
        assertEquals(4, solution.commonFactors(12, 6))
    }

    @Test
    fun `counts factors of a prime gcd`() {
        assertEquals(2, solution.commonFactors(25, 30))
    }

    @Test
    fun `coprime numbers share only one`() {
        assertEquals(1, solution.commonFactors(7, 11))
    }

    @Test
    fun `counts an odd number of divisors for a square gcd`() {
        assertEquals(9, solution.commonFactors(36, 36))
    }

    @Test
    fun `one shares only the factor one`() {
        assertEquals(1, solution.commonFactors(1, 1000))
    }
}
