package primenumberofsetbitsinbinaryrepresentation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PrimeNumberOfSetBitsInBinaryRepresentationTest {
    @Test
    fun exampleOne() {
        assertEquals(4, Solution().countPrimeSetBits(6, 10))
    }

    @Test
    fun exampleTwo() {
        assertEquals(5, Solution().countPrimeSetBits(10, 15))
    }

    @Test
    fun singleNonPrime() {
        assertEquals(0, Solution().countPrimeSetBits(1, 1))
    }

    @Test
    fun singlePrime() {
        assertEquals(1, Solution().countPrimeSetBits(3, 3))
    }

    @Test
    fun wideRange() {
        assertEquals(1, Solution().countPrimeSetBits(1, 3))
    }
}
