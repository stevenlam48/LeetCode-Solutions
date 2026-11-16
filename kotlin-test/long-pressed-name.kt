package longpressedname

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LongPressedNameTest {
    @Test
    fun standardLongPress() {
        assertTrue(Solution().isLongPressedName("alex", "aaleex"))
    }

    @Test
    fun missingPresses() {
        assertFalse(Solution().isLongPressedName("saeed", "ssaaedd"))
    }

    @Test
    fun repeatedCharacters() {
        assertTrue(Solution().isLongPressedName("leelee", "lleeelee"))
    }

    @Test
    fun extraCharacterAtEnd() {
        assertFalse(Solution().isLongPressedName("alex", "aaleexa"))
    }

    @Test
    fun singleCharacter() {
        assertTrue(Solution().isLongPressedName("a", "a"))
        assertTrue(Solution().isLongPressedName("a", "aaa"))
        assertFalse(Solution().isLongPressedName("a", "b"))
    }

    @Test
    fun typedShorterOrDifferentOrder() {
        assertFalse(Solution().isLongPressedName("pyplrz", "ppyypllr"))
        assertFalse(Solution().isLongPressedName("abc", "ab"))
    }
}
