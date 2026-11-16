package maximumgapbetweenstations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumGapBetweenStationsTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().maximumGap("aa", "aaaa"))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().maximumGap("xyz", "xyzz"))
    }

    @Test
    fun example3() {
        assertEquals(4, Solution().maximumGap("cbc", "cbcdbc"))
    }

    @Test
    fun singleWorker() {
        assertEquals(0, Solution().maximumGap("a", "a"))
    }

    @Test
    fun exactMatch() {
        assertEquals(1, Solution().maximumGap("abc", "abc"))
    }
}
