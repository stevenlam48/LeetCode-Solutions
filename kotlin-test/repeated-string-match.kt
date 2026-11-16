package repeatedstringmatch

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RepeatedStringMatchTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals(3, solution.repeatedStringMatch("abcd", "cdabcdab"))
    }

    @Test
    fun twoCopiesAreNeeded() {
        assertEquals(2, solution.repeatedStringMatch("a", "aa"))
    }

    @Test
    fun oneCopyCanMatch() {
        assertEquals(1, solution.repeatedStringMatch("abc", "abc"))
    }

    @Test
    fun matchMayRequireOneExtraCopy() {
        assertEquals(4, solution.repeatedStringMatch("abc", "cabcabca"))
    }

    @Test
    fun unrelatedStringsCannotMatch() {
        assertEquals(-1, solution.repeatedStringMatch("abc", "wxyz"))
    }
}
