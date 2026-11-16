package checkifarrayisgood

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CheckIfArrayIsGoodTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertFalse(solution.isGood(intArrayOf(2, 1, 3)))
    }

    @Test
    fun testExample2() {
        assertTrue(solution.isGood(intArrayOf(1, 3, 3, 2)))
    }

    @Test
    fun testExample3() {
        assertTrue(solution.isGood(intArrayOf(1, 1)))
    }

    @Test
    fun testInvalidPair() {
        assertFalse(solution.isGood(intArrayOf(2, 2)))
    }

    @Test
    fun testSortedGood() {
        assertTrue(solution.isGood(intArrayOf(1, 2, 3, 3)))
    }

    @Test
    fun testOutOfRange() {
        assertFalse(solution.isGood(intArrayOf(3, 4, 2, 1)))
    }
}
