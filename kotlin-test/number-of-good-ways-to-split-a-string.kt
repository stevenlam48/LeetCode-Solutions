package numberofgoodwaystosplitastring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfGoodWaysToSplitAStringTest {
    @Test
    fun testExample1() {
        assertEquals(2, Solution().numSplits("aacaba"))
    }

    @Test
    fun testAllDistinct() {
        assertEquals(1, Solution().numSplits("abcd"))
    }

    @Test
    fun testAllSame() {
        assertEquals(4, Solution().numSplits("aaaaa"))
    }

    @Test
    fun testSingleCharacter() {
        assertEquals(0, Solution().numSplits("a"))
    }
}
