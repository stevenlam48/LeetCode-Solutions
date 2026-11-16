package countthenumberofgoodsubsequences

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountTheNumberOfGoodSubsequencesTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(11, solution.countGoodSubsequences("aabb"))
    }

    @Test
    fun testExample2() {
        assertEquals(7, solution.countGoodSubsequences("abc"))
    }

    @Test
    fun testExample3() {
        assertEquals(3, solution.countGoodSubsequences("dd"))
    }

    @Test
    fun testSingleChar() {
        assertEquals(1, solution.countGoodSubsequences("a"))
    }

    @Test
    fun testAllSame() {
        assertEquals(7, solution.countGoodSubsequences("aaa"))
    }
}
