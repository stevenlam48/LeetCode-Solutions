package sumofdigitdifferencesofallpairs

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SumOfDigitDifferencesOfAllPairsTest {
    @Test
    fun exampleWithTwoDigits() {
        assertEquals(4L, Solution().sumDigitDifferences(intArrayOf(13, 23, 12)))
    }

    @Test
    fun identicalNumbers() {
        assertEquals(0L, Solution().sumDigitDifferences(intArrayOf(10, 10, 10, 10)))
    }

    @Test
    fun singleDigits() {
        assertEquals(3L, Solution().sumDigitDifferences(intArrayOf(1, 2, 3)))
    }

    @Test
    fun singleElement() {
        assertEquals(0L, Solution().sumDigitDifferences(intArrayOf(5)))
    }
}
