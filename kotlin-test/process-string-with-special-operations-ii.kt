package processstringwithspecialoperationsii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ProcessStringWithSpecialOperationsIITest {
    private val solution = Solution()

    @Test
    fun validCase1_duplicate() {
        assertEquals('a', solution.processStr("abc#", 3))
        assertEquals('c', solution.processStr("abc#", 5))
    }

    @Test
    fun validCase2_delete() {
        assertEquals('b', solution.processStr("a#*b", 1))
    }

    @Test
    fun validCase3_mirror() {
        assertEquals('b', solution.processStr("ab%", 0))
        assertEquals('a', solution.processStr("ab%", 1))
    }

    @Test
    fun validCase4_deleteThenDuplicate() {
        assertEquals('a', solution.processStr("a#*#", 1))
    }

    @Test
    fun validCase5_duplicateMiddle() {
        assertEquals('c', solution.processStr("ab#c", 4))
    }

    @Test
    fun validCase6_indexOutsideResult() {
        assertEquals('.', solution.processStr("ab#", 4))
    }
}
