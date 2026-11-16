package maximumnumberofsubsequencesafteroneinserting

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumnumberofsubsequencesafteroneinsertingTest {
    @Test
    fun example() {
        assertEquals(2L, Solution().numOfSubsequences("LMCT"))
    }

    @Test
    fun oneInsertionCompletesTwo() {
        assertEquals(2L, Solution().numOfSubsequences("LCT"))
    }

    @Test
    fun singleCharactersCannotFormAny() {
        assertEquals(0L, Solution().numOfSubsequences("T"))
        assertEquals(0L, Solution().numOfSubsequences("L"))
    }

    @Test
    fun needsOneCharacter() {
        assertEquals(1L, Solution().numOfSubsequences("LC"))
    }

    @Test
    fun multipleSubsequences() {
        assertEquals(4L, Solution().numOfSubsequences("LCTT"))
        assertEquals(18L, Solution().numOfSubsequences("LLCCTTT"))
    }
}
