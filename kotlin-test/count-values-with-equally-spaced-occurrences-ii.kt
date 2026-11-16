package countvalueswithequallyspacedoccurrencesii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountValuesWithEquallySpacedOccurrencesIITest {
    @Test
    fun example1() {
        assertEquals(2, Solution().countSpecialIntegers(intArrayOf(1, 8, 1, 5, 1, 5, 8, 5)))
    }

    @Test
    fun example2() {
        assertEquals(1, Solution().countSpecialIntegers(intArrayOf(8, 8, 8, 8)))
    }

    @Test
    fun example3() {
        assertEquals(0, Solution().countSpecialIntegers(intArrayOf(8, 6, 6, 8, 8)))
    }

    @Test
    fun threeInARow() {
        assertEquals(1, Solution().countSpecialIntegers(intArrayOf(1, 1, 1)))
    }

    @Test
    fun fourOccurrencesNotSpaced() {
        assertEquals(0, Solution().countSpecialIntegers(intArrayOf(1, 1, 2, 2, 1, 2)))
    }

    @Test
    fun fiveOccurrencesSpaced() {
        assertEquals(2, Solution().countSpecialIntegers(intArrayOf(3, 4, 3, 4, 3, 4, 3, 4, 3)))
    }
}
