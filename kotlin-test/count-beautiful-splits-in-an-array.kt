package countbeautifulsplitsinanarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountBeautifulSplitsInAnArrayTest {
    @Test
    fun repeatedValues() {
        assertEquals(3, Solution().beautifulSplits(intArrayOf(2, 2, 2, 2)))
        assertEquals(2, Solution().beautifulSplits(intArrayOf(1, 1, 2, 1)))
    }

    @Test
    fun noBeautifulSplits() {
        assertEquals(0, Solution().beautifulSplits(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun tooShort() {
        assertEquals(0, Solution().beautifulSplits(intArrayOf()))
        assertEquals(0, Solution().beautifulSplits(intArrayOf(1, 1)))
    }
}
