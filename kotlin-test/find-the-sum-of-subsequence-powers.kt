package findthesumofsubsequencepowers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindTheSumOfSubsequencePowersTest {

    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(10, solution.sumOfPowers(intArrayOf(1, 2, 3, 4), 2))
    }

    @Test
    fun testExample2() {
        assertEquals(0, solution.sumOfPowers(intArrayOf(2, 2), 2))
    }

    @Test
    fun testExample3() {
        assertEquals(6, solution.sumOfPowers(intArrayOf(4, 3, 1), 2))
    }

    @Test
    fun testAllEqual() {
        assertEquals(0, solution.sumOfPowers(intArrayOf(1, 1, 1, 1), 2))
    }

    @Test
    fun testLengthThreeSubsequences() {
        assertEquals(1, solution.sumOfPowers(intArrayOf(1, 2, 3), 3))
        assertEquals(4, solution.sumOfPowers(intArrayOf(1, 2, 3, 4), 3))
    }

    @Test
    fun testNegativeValues() {
        assertEquals(10, solution.sumOfPowers(intArrayOf(-1, 0, 1, 2), 2))
    }
}
