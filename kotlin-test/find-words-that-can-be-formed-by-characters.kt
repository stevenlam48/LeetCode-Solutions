package findwordsthatcanbeformedbycharacters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindWordsThatCanBeFormedByCharactersTest {
    @Test
    fun exampleOne() {
        assertEquals(6, Solution().countCharacters(listOf("cat", "bt", "hat", "tree"), "atach"))
    }

    @Test
    fun exampleTwo() {
        assertEquals(10, Solution().countCharacters(listOf("hello", "world", "leetcode"), "welldonehoneyr"))
    }

    @Test
    fun repeatedCharacterExceedsSupply() {
        assertEquals(1, Solution().countCharacters(listOf("a", "aa"), "a"))
    }

    @Test
    fun emptyWords() {
        assertEquals(0, Solution().countCharacters(emptyList(), "abc"))
    }
}
