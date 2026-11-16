package firstlettertoappeartwice

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FirstLetterToAppearTwiceTest {
    @Test
    fun example() {
        assertEquals('c', Solution().repeatedCharacter("abccbaacz"))
    }

    @Test
    fun adjacentDuplicate() {
        assertEquals('d', Solution().repeatedCharacter("abcdd"))
    }

    @Test
    fun immediateRepeat() {
        assertEquals('a', Solution().repeatedCharacter("aa"))
    }

    @Test
    fun laterRepeat() {
        assertEquals('b', Solution().repeatedCharacter("abba"))
    }
}
