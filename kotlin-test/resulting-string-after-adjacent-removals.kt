package resultingstringafteradjacentremovals

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ResultingStringAfterAdjacentRemovalsTest {
    @Test
    fun example1() {
        assertEquals("c", Solution().resultingString("abc"))
    }

    @Test
    fun example2() {
        assertEquals("", Solution().resultingString("adcb"))
    }

    @Test
    fun example3() {
        assertEquals("db", Solution().resultingString("zadb"))
    }

    @Test
    fun singleChar() {
        assertEquals("a", Solution().resultingString("a"))
    }

    @Test
    fun wrapsAroundAlphabet() {
        assertEquals("", Solution().resultingString("az"))
    }

    @Test
    fun cascadingRemovals() {
        assertEquals("cz", Solution().resultingString("abcz"))
    }
}
