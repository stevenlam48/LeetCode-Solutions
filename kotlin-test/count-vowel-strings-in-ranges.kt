package countvowelstringsinranges

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class CountVowelStringsInRangesTest {
    @Test
    fun example1() {
        assertArrayEquals(
            intArrayOf(2, 3, 0),
            Solution().vowelStrings(
                listOf("aba", "bcb", "ece", "aa", "e"),
                arrayOf(intArrayOf(0, 2), intArrayOf(1, 4), intArrayOf(1, 1))
            )
        )
    }

    @Test
    fun example2() {
        assertArrayEquals(
            intArrayOf(3, 2, 1),
            Solution().vowelStrings(
                listOf("a", "e", "i"),
                arrayOf(intArrayOf(0, 2), intArrayOf(0, 1), intArrayOf(2, 2))
            )
        )
    }

    @Test
    fun noVowelWords() {
        assertArrayEquals(
            intArrayOf(0),
            Solution().vowelStrings(
                listOf("abc", "bcd"),
                arrayOf(intArrayOf(0, 1))
            )
        )
    }

    @Test
    fun singleWord() {
        assertArrayEquals(
            intArrayOf(1),
            Solution().vowelStrings(listOf("aa"), arrayOf(intArrayOf(0, 0)))
        )
    }
}
