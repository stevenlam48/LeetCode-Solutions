package mostfrequentevenelement

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MostFrequentEvenElementTest {
    private val solution = Solution()

    @Test
    fun choosesSmallestAmongEqualHighestFrequencies() {
        assertEquals(2, solution.mostFrequentEven(intArrayOf(0, 1, 2, 2, 4, 4, 1)))
    }

    @Test
    fun choosesMostFrequentEvenValue() {
        assertEquals(4, solution.mostFrequentEven(intArrayOf(4, 4, 4, 9, 2, 4)))
    }

    @Test
    fun returnsMinusOneWithoutEvenValues() {
        assertEquals(-1, solution.mostFrequentEven(intArrayOf(1, 3, 5)))
        assertEquals(-1, solution.mostFrequentEven(intArrayOf()))
    }

    @Test
    fun includesZeroAsEven() {
        assertEquals(0, solution.mostFrequentEven(intArrayOf(2, 2, 0, 0)))
    }
}
