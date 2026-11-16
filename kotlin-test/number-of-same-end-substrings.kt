package numberofsameendsubstrings

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NumberOfSameEndSubstringsTest {
    @Test
    fun testExample() {
        val queries = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 4),
            intArrayOf(2, 5),
            intArrayOf(0, 5)
        )
        assertArrayEquals(
            intArrayOf(1, 5, 5, 10),
            Solution().sameEndSubstringCount("abcaab", queries)
        )
    }

    @Test
    fun testDistinctCharacters() {
        assertArrayEquals(
            intArrayOf(4),
            Solution().sameEndSubstringCount("abcd", arrayOf(intArrayOf(0, 3)))
        )
    }

    @Test
    fun testSingleCharacter() {
        assertArrayEquals(
            intArrayOf(1, 6),
            Solution().sameEndSubstringCount(
                "aaa",
                arrayOf(intArrayOf(1, 1), intArrayOf(0, 2))
            )
        )
    }
}
