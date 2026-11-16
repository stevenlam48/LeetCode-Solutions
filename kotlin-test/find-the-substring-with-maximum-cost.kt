package findthesubstringwithmaximumcost

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindTheSubstringWithMaximumCostTest {

    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2, solution.maximumCostSubstring("adaa", "d", intArrayOf(-1000)))
    }

    @Test
    fun testExample2() {
        assertEquals(0, solution.maximumCostSubstring("abc", "abc", intArrayOf(-1, -1, -1)))
    }

    @Test
    fun testDefaultLetterValues() {
        assertEquals(7, solution.maximumCostSubstring("cdb", "ab", intArrayOf(-1, -1)))
    }

    @Test
    fun testSingleCharacter() {
        assertEquals(1, solution.maximumCostSubstring("a", "a", intArrayOf(1)))
        assertEquals(0, solution.maximumCostSubstring("a", "a", intArrayOf(-1)))
    }

    @Test
    fun testAllPositive() {
        assertEquals(27, solution.maximumCostSubstring("az", "", intArrayOf()))
    }
}
