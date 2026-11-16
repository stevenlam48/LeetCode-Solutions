package decodewaysii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DecodeWaysIiTest {
    @Test
    fun singleStar() {
        assertEquals(9, Solution().numDecodings("*"))
    }

    @Test
    fun oneStar() {
        assertEquals(18, Solution().numDecodings("1*"))
    }

    @Test
    fun twoStar() {
        assertEquals(15, Solution().numDecodings("2*"))
    }

    @Test
    fun twoStars() {
        assertEquals(96, Solution().numDecodings("**"))
    }

    @Test
    fun threeStars() {
        assertEquals(999, Solution().numDecodings("***"))
    }

    @Test
    fun digitsWithZero() {
        assertEquals(1, Solution().numDecodings("1"))
        assertEquals(0, Solution().numDecodings("0"))
        assertEquals(0, Solution().numDecodings("06"))
    }
}
