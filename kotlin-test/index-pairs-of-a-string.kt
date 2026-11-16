package indexpairsofastring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IndexPairsOfAStringTest {
    @Test
    fun example() {
        val expected = listOf(
            listOf(3, 7),
            listOf(9, 13),
            listOf(10, 17)
        )
        assertEquals(
            expected,
            Solution().indexPairs(
                "thestoryofleetcodeandme",
                listOf("story", "fleet", "leetcode")
            )
        )
    }

    @Test
    fun overlappingMatches() {
        val expected = listOf(
            listOf(0, 1),
            listOf(0, 2),
            listOf(2, 3),
            listOf(2, 4)
        )
        assertEquals(expected, Solution().indexPairs("ababa", listOf("aba", "ab")))
    }

    @Test
    fun repeatedMatches() {
        val expected = listOf(
            listOf(0, 1),
            listOf(1, 2)
        )
        assertEquals(expected, Solution().indexPairs("aaa", listOf("aa")))
    }

    @Test
    fun noMatches() {
        assertEquals(emptyList<List<Int>>(), Solution().indexPairs("abc", listOf("xyz")))
    }
}
