package stringsdifferbyonecharacter

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class StringsDifferByOneCharacterTest {
    @Test
    fun `standard pair differs in one position`() {
        assertTrue(Solution().differByOne(listOf("abcd", "acbd", "aacd")))
    }

    @Test
    fun `no pair differs in exactly one position`() {
        assertFalse(Solution().differByOne(listOf("ab", "cd", "yz")))
    }

    @Test
    fun `pair with multiple nonmatching words`() {
        assertTrue(Solution().differByOne(listOf("abcde", "abxde", "abxdf")))
    }

    @Test
    fun `single word cannot form a pair`() {
        assertFalse(Solution().differByOne(listOf("abc")))
    }
}
