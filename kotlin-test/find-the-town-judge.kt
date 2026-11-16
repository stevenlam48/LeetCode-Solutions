package findthetownjudge

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindTheTownJudgeTest {

    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2, solution.findJudge(2, arrayOf(intArrayOf(1, 2))))
    }

    @Test
    fun testExample2() {
        assertEquals(3, solution.findJudge(3, arrayOf(intArrayOf(1, 3), intArrayOf(2, 3))))
    }

    @Test
    fun testExample3() {
        assertEquals(
            -1,
            solution.findJudge(3, arrayOf(intArrayOf(1, 3), intArrayOf(2, 3), intArrayOf(3, 1)))
        )
    }

    @Test
    fun testNoTrust() {
        assertEquals(1, solution.findJudge(1, arrayOf()))
        assertEquals(-1, solution.findJudge(3, arrayOf()))
    }

    @Test
    fun testChainNotJudge() {
        assertEquals(-1, solution.findJudge(3, arrayOf(intArrayOf(1, 2), intArrayOf(2, 3))))
    }
}
