package findthestudentthatwillreplacethechalk

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindTheStudentThatWillReplaceTheChalkTest {

    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(0, solution.chalkReplacer(intArrayOf(5, 1, 5), 22))
    }

    @Test
    fun testExample2() {
        assertEquals(1, solution.chalkReplacer(intArrayOf(3, 4, 1, 2), 25))
    }

    @Test
    fun testZeroChalk() {
        assertEquals(0, solution.chalkReplacer(intArrayOf(1, 1, 1), 0))
    }

    @Test
    fun testExactBoundary() {
        assertEquals(1, solution.chalkReplacer(intArrayOf(2, 3, 4), 2))
        assertEquals(2, solution.chalkReplacer(intArrayOf(2, 3, 4), 5))
    }

    @Test
    fun testLargeK() {
        assertEquals(2, solution.chalkReplacer(intArrayOf(1, 2, 3), 1000000000))
    }
}
