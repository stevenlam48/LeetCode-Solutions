package findthekthcharacterinstringgameii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheKThCharacterInStringGameIITest {
    @Test
    fun example1() {
        assertEquals('a', Solution().kthCharacter(5L, intArrayOf(0, 0, 0)))
    }

    @Test
    fun example2() {
        assertEquals('b', Solution().kthCharacter(10L, intArrayOf(0, 1, 0, 1)))
    }

    @Test
    fun firstCharacter() {
        assertEquals('a', Solution().kthCharacter(1L, intArrayOf(0)))
    }

    @Test
    fun secondCharacter() {
        assertEquals('b', Solution().kthCharacter(2L, intArrayOf(1)))
    }
}
