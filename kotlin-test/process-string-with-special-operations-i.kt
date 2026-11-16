package processstringwithspecialoperationsi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ProcessStringWithSpecialOperationsITest {
    private val solution = Solution()

    @Test
    fun validCase1_plainLetters() {
        assertEquals("abc", solution.processStr("abc"))
    }

    @Test
    fun validCase2_duplicateThenReverse() {
        assertEquals("baa", solution.processStr("a#b%"))
    }

    @Test
    fun validCase3_deleteAndEmptyDelete() {
        assertEquals("b", solution.processStr("*a*b"))
    }

    @Test
    fun validCase4_deleteAfterReverse() {
        assertEquals("ba", solution.processStr("a#b%*"))
    }

    @Test
    fun validCase5_duplicateAndReverse() {
        assertEquals("baba", solution.processStr("ab#%"))
    }

    @Test
    fun validCase6_duplicateWhileReversed() {
        assertEquals("abab", solution.processStr("a%b#"))
    }
}
