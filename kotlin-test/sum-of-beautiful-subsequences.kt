package sumofbeautifulsubsequences

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SumOfBeautifulSubsequencesTest {
    @Test
    fun distinctSmallValues() {
        assertEquals(10, Solution().totalBeauty(intArrayOf(1, 2, 3)))
    }

    @Test
    fun repeatedValues() {
        assertEquals(6, Solution().totalBeauty(intArrayOf(2, 2, 2)))
    }

    @Test
    fun multipleDivisors() {
        assertEquals(12, Solution().totalBeauty(intArrayOf(4, 6)))
    }

    @Test
    fun powersOfTwo() {
        assertEquals(24, Solution().totalBeauty(intArrayOf(2, 4, 8)))
    }
}
