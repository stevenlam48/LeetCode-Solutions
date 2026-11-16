package numberofbeautifulpairs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfBeautifulPairsTest {
    @Test
    fun example1() {
        assertEquals(5, Solution().countBeautifulPairs(intArrayOf(2, 5, 1, 4)))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().countBeautifulPairs(intArrayOf(11, 21, 12)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().countBeautifulPairs(intArrayOf(1)))
    }

    @Test
    fun allCoprime() {
        assertEquals(3, Solution().countBeautifulPairs(intArrayOf(1, 2, 3)))
    }

    @Test
    fun sharedFactor() {
        assertEquals(0, Solution().countBeautifulPairs(intArrayOf(2, 2)))
    }

    @Test
    fun multiDigitFirstElement() {
        assertEquals(1, Solution().countBeautifulPairs(intArrayOf(12, 8)))
    }
}
