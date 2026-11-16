package countcommonwordswithoneoccurrence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountCommonWordsWithOneOccurrenceTest {
    @Test
    fun example() {
        assertEquals(
            2,
            Solution().countWords(
                listOf("leetcode", "is", "amazing", "as", "is"),
                listOf("amazing", "leetcode", "is")
            )
        )
    }

    @Test
    fun disjointWords() {
        assertEquals(0, Solution().countWords(listOf("b", "bb", "bbb"), listOf("a", "aa", "aaa")))
    }

    @Test
    fun repeatedOccurrencesAreExcluded() {
        assertEquals(0, Solution().countWords(listOf("a"), listOf("a", "a")))
        assertEquals(0, Solution().countWords(listOf("a", "a"), listOf("a")))
    }

    @Test
    fun emptyLists() {
        assertEquals(0, Solution().countWords(emptyList(), emptyList()))
        assertEquals(0, Solution().countWords(listOf("a"), emptyList()))
    }
}
