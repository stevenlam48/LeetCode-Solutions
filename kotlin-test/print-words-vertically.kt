package printwordsvertically

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PrintWordsVerticallyTest {
    private val solution = Solution()

    @Test
    fun validCase1() {
        val actual = solution.printVertically("HOW ARE YOU")
        assertEquals(listOf("HAY", "ORO", "WEU"), actual)
    }

    @Test
    fun validCase2() {
        val actual = solution.printVertically("TO BE OR NOT TO BE")
        assertEquals(listOf("TBONTB", "OEROOE", "   T"), actual)
    }

    @Test
    fun validCase3() {
        val actual = solution.printVertically("CONTEST IS COMING")
        assertEquals(listOf("CIC", "OSO", "N M", "T I", "E N", "S G", "T"), actual)
    }

    @Test
    fun validCase4_singleWord() {
        val actual = solution.printVertically("HELLO")
        assertEquals(listOf("H", "E", "L", "L", "O"), actual)
    }

    @Test
    fun validCase5_punctuation() {
        val actual = solution.printVertically("HI, WORLD! OK")
        assertEquals(listOf("HWO", "IOK", ",R", " L", " D", " !"), actual)
    }

    @Test
    fun validCase6_singleLetters() {
        val actual = solution.printVertically("A B C D")
        assertEquals(listOf("ABCD"), actual)
    }
}
