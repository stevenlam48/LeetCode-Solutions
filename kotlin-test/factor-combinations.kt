package factorcombinations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FactorCombinationsTest {
    private val solution = Solution()

    @Test
    fun `returns no factors for one and primes`() {
        assertEquals(emptyList<List<Int>>(), solution.getFactors(1))
        assertEquals(emptyList<List<Int>>(), solution.getFactors(7))
    }

    @Test
    fun `includes a repeated factor pair`() {
        assertEquals(listOf(listOf(2, 2)), solution.getFactors(4))
    }

    @Test
    fun `generates progressively longer combinations`() {
        assertEquals(listOf(listOf(2, 4), listOf(2, 2, 2)), solution.getFactors(8))
    }

    @Test
    fun `keeps factors in nondecreasing order`() {
        assertEquals(
            listOf(listOf(2, 6), listOf(2, 2, 3), listOf(3, 4)),
            solution.getFactors(12)
        )
    }

    @Test
    fun `explores all combinations for a power of two`() {
        assertEquals(
            listOf(
                listOf(2, 8),
                listOf(2, 2, 4),
                listOf(2, 2, 2, 2),
                listOf(4, 4)
            ),
            solution.getFactors(16)
        )
    }
}
