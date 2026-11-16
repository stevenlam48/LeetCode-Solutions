package sumofgcdofformedpairs

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SumOfGcdOfFormedPairsTest {
    @Test
    fun exampleOne() {
        assertEquals(2L, Solution().gcdSum(intArrayOf(2, 6, 4)))
    }

    @Test
    fun equalValues() {
        assertEquals(5L, Solution().gcdSum(intArrayOf(5, 5)))
    }

    @Test
    fun unsortedInput() {
        assertEquals(5L, Solution().gcdSum(intArrayOf(3, 6, 2, 8)))
    }

    @Test
    fun singleElement() {
        assertEquals(0L, Solution().gcdSum(intArrayOf(1)))
    }
}
