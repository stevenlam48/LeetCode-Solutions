package findthekthcharacterinstringgamei

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheKThCharacterInStringGameITest {
    @Test
    fun example1() {
        assertEquals('b', Solution().kthCharacter(5))
    }

    @Test
    fun firstCharacter() {
        assertEquals('a', Solution().kthCharacter(1))
    }

    @Test
    fun tenthCharacter() {
        assertEquals('c', Solution().kthCharacter(10))
    }

    @Test
    fun twentySixthCharacter() {
        assertEquals('d', Solution().kthCharacter(26))
    }
}
