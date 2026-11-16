package countvalidsequences

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountValidSequencesTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().countValidSequences(5, 3))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().countValidSequences(3, 2))
    }

    @Test
    fun example3() {
        assertEquals(0, Solution().countValidSequences(5, 5))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().countValidSequences(1, 1))
        assertEquals(1, Solution().countValidSequences(2, 1))
    }

    @Test
    fun twoElements() {
        assertEquals(1, Solution().countValidSequences(4, 2))
        assertEquals(2, Solution().countValidSequences(6, 2))
    }

    @Test
    fun threeElements() {
        assertEquals(10, Solution().countValidSequences(6, 3))
    }
}
