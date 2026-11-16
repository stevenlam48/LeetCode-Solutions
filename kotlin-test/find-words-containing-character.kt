package findwordscontainingcharacter

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindWordsContainingCharacterTest {
    @Test
    fun exampleOne() {
        assertEquals(listOf(0, 1), Solution().findWordsContaining(listOf("leet", "code"), 'e'))
    }

    @Test
    fun exampleTwo() {
        assertEquals(listOf(0, 2), Solution().findWordsContaining(listOf("abc", "bcd", "aaaa", "cbc"), 'a'))
    }

    @Test
    fun exampleThree() {
        assertEquals(emptyList<Int>(), Solution().findWordsContaining(listOf("abc", "bcd", "aaaa", "cbc"), 'z'))
    }

    @Test
    fun emptyWords() {
        assertEquals(emptyList<Int>(), Solution().findWordsContaining(emptyList(), 'a'))
    }
}
