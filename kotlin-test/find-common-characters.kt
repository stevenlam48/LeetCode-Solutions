package findcommoncharacters

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindCommonCharactersTest {
    @Test
    fun standardExample() {
        assertEquals(listOf("e", "l", "l"), Solution().commonChars(arrayOf("bella", "label", "roller")))
    }

    @Test
    fun secondExample() {
        assertEquals(listOf("c", "o"), Solution().commonChars(arrayOf("cool", "lock", "cook")))
    }

    @Test
    fun singleWord() {
        assertEquals(listOf("a", "b", "c"), Solution().commonChars(arrayOf("abc")))
    }

    @Test
    fun noCommonCharacters() {
        assertEquals(emptyList<String>(), Solution().commonChars(arrayOf("a", "b")))
    }

    @Test
    fun repeatedCharacters() {
        assertEquals(listOf("a", "a"), Solution().commonChars(arrayOf("aa", "aaa")))
    }
}
