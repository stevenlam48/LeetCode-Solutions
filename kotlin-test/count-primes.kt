package countprimes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountPrimesTest {
    private val solution = Solution()

    @Test
    fun example() {
        assertEquals(4, solution.countPrimes(10))
    }

    @Test
    fun zeroAndOne() {
        assertEquals(0, solution.countPrimes(0))
        assertEquals(0, solution.countPrimes(1))
    }

    @Test
    fun twoIsNotCounted() {
        assertEquals(0, solution.countPrimes(2))
        assertEquals(1, solution.countPrimes(3))
    }

    @Test
    fun oneHundred() {
        assertEquals(25, solution.countPrimes(100))
    }
}
