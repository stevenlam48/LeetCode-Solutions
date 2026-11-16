package smallestklengthsubsequencewithoccurrencesofaletter

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SmallestKLengthSubsequenceWithOccurrencesOfALetterTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals("eet", solution.smallestSubsequence("leet", 3, 'e', 1))
    }

    @Test
    fun testExample2() {
        assertEquals("ecde", solution.smallestSubsequence("leetcode", 4, 'e', 2))
    }

    @Test
    fun testExample3() {
        assertEquals("bb", solution.smallestSubsequence("bb", 2, 'b', 2))
    }

    @Test
    fun testExample4() {
        assertEquals("abb", solution.smallestSubsequence("aaabbbcccddd", 3, 'b', 2))
    }

    @Test
    fun testWholeString() {
        assertEquals("abc", solution.smallestSubsequence("abc", 3, 'a', 1))
    }
}
