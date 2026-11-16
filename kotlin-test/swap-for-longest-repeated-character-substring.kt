package swapforlongestrepeatedcharactersubstring

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SwapForLongestRepeatedCharacterSubstringTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(3, solution.maxRepOpt1("ababa"))
    }

    @Test
    fun testExample2() {
        assertEquals(6, solution.maxRepOpt1("aaabaaa"))
    }

    @Test
    fun testExample3() {
        assertEquals(7, solution.maxRepOpt1("aaabbbabbbb"))
    }

    @Test
    fun testAllSame() {
        assertEquals(5, solution.maxRepOpt1("aaaaa"))
    }

    @Test
    fun testAllDistinct() {
        assertEquals(1, solution.maxRepOpt1("abcdef"))
    }
}
