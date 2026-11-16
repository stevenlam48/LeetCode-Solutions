package countpairsofequalsubstringswithminimumdifference

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountPairsOfEqualSubstringsWithMinimumDifferenceTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(1, solution.countQuadruples("abcd", "bccda"))
    }

    @Test
    fun testExample2() {
        assertEquals(0, solution.countQuadruples("ab", "cd"))
    }

    @Test
    fun testExample3() {
        assertEquals(1, solution.countQuadruples("a", "a"))
    }

    @Test
    fun testMultipleMinimum() {
        assertEquals(3, solution.countQuadruples("abc", "abc"))
    }

    @Test
    fun testEmpty() {
        assertEquals(0, solution.countQuadruples("", ""))
    }
}
