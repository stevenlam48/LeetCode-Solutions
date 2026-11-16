package countvalidwordoccurrences

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class CountValidWordOccurrencesTest {
    @Test
    fun example1() {
        assertArrayEquals(
            intArrayOf(2, 1, 0),
            Solution().countWordOccurrences(
                listOf("hello wor", "ld hello"),
                listOf("hello", "world", "wor")
            )
        )
    }

    @Test
    fun example2() {
        assertArrayEquals(
            intArrayOf(2, 1, 1),
            Solution().countWordOccurrences(
                listOf("a-b a--b ", "a-", "b"),
                listOf("a-b", "a", "b")
            )
        )
    }

    @Test
    fun example3() {
        assertArrayEquals(
            intArrayOf(1, 1, 1, 0),
            Solution().countWordOccurrences(
                listOf("-cat dog- mouse"),
                listOf("cat", "dog", "mouse", "cat-dog")
            )
        )
    }

    @Test
    fun singleWord() {
        assertArrayEquals(
            intArrayOf(1, 0),
            Solution().countWordOccurrences(listOf("abc"), listOf("abc", "ab"))
        )
    }

    @Test
    fun hyphenAcrossChunks() {
        assertArrayEquals(
            intArrayOf(1),
            Solution().countWordOccurrences(listOf("ab-", "cd"), listOf("ab-cd"))
        )
    }
}
