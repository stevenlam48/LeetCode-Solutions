package minimumcosttoseparatesentenceintorows

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostToSeparateSentenceIntoRowsTest {
    @Test
    fun example1() {
        assertEquals(36, Solution().minimumCost("i love leetcode", 12))
    }

    @Test
    fun fitsOneLine() {
        assertEquals(0, Solution().minimumCost("i love leetcode", 20))
    }

    @Test
    fun eachWordOwnLine() {
        assertEquals(2, Solution().minimumCost("a b c", 2))
    }

    @Test
    fun twoWordsFit() {
        assertEquals(0, Solution().minimumCost("a b c", 3))
    }

    @Test
    fun singleWord() {
        assertEquals(0, Solution().minimumCost("abc", 5))
    }

    @Test
    fun twoWordsPerLine() {
        assertEquals(0, Solution().minimumCost("aa bb cc", 5))
    }
}
