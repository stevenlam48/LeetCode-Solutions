package checkifall1sareatleastlengthkplacesaway

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CheckIfAll1sAreAtLeastLengthKPlacesAwayTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.kLengthApart(intArrayOf(1, 0, 0, 0, 1, 0, 0, 1), 2))
    }

    @Test
    fun testExample2() {
        assertFalse(solution.kLengthApart(intArrayOf(1, 0, 0, 1, 0, 1), 2))
    }

    @Test
    fun testAllZeros() {
        assertTrue(solution.kLengthApart(intArrayOf(0, 0, 0), 1))
    }

    @Test
    fun testSingleOne() {
        assertTrue(solution.kLengthApart(intArrayOf(1), 0))
    }

    @Test
    fun testAdjacentOnes() {
        assertFalse(solution.kLengthApart(intArrayOf(1, 1), 1))
        assertTrue(solution.kLengthApart(intArrayOf(1, 1), 0))
    }
}
