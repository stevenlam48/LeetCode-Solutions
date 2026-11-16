package checkifarraypairsaredivisiblebyk

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CheckIfArrayPairsAreDivisibleByKTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.canArrange(intArrayOf(1, 2, 3, 4, 5, 10, 6, 7, 8, 9), 5))
    }

    @Test
    fun testExample2() {
        assertTrue(solution.canArrange(intArrayOf(1, 2, 3, 4, 5, 6), 7))
    }

    @Test
    fun testExample3() {
        assertFalse(solution.canArrange(intArrayOf(1, 2, 3, 4, 5, 6), 10))
    }

    @Test
    fun testNegatives() {
        assertTrue(solution.canArrange(intArrayOf(-1, 1, -2, 2, -3, 3, -4, 4), 3))
    }

    @Test
    fun testOddZeroRemainder() {
        assertFalse(solution.canArrange(intArrayOf(1, 2, 3, 4, 5), 3))
    }
}
