package sumofprimesbetweennumberanditsreverse

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SumOfPrimesBetweenNumberAndItsReverseTest {
    private val solution = Solution()

    @Test
    fun palindromicCompositeHasNoPrimeAtEndpoint() {
        assertEquals(0, solution.sumOfPrimesInRange(22))
    }

    @Test
    fun reversedRangeIsInclusive() {
        assertEquals(132, solution.sumOfPrimesInRange(31))
    }

    @Test
    fun trailingZeroDisappearsOnReversal() {
        assertEquals(17, solution.sumOfPrimesInRange(10))
    }

    @Test
    fun oneHasNoPrimeInRange() {
        assertEquals(0, solution.sumOfPrimesInRange(1))
    }

    @Test
    fun sumThroughOneHundred() {
        assertEquals(1060, solution.sumOfPrimesInRange(100))
    }
}
