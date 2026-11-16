package primearrangements

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PrimeArrangementsTest {
    @Test
    fun exampleOne() {
        assertEquals(12, Solution().numPrimeArrangements(5))
    }

    @Test
    fun exampleTwo() {
        assertEquals(682289015, Solution().numPrimeArrangements(100))
    }

    @Test
    fun one() {
        assertEquals(1, Solution().numPrimeArrangements(1))
    }

    @Test
    fun two() {
        assertEquals(1, Solution().numPrimeArrangements(2))
    }

    @Test
    fun three() {
        assertEquals(2, Solution().numPrimeArrangements(3))
    }
}
