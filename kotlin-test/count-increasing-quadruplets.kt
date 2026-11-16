package countincreasingquadruplets

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountIncreasingQuadrupletsTest {
    private val solution = Solution()

    @Test
    fun countsFirstExample() {
        assertEquals(2L, solution.countQuadruplets(intArrayOf(1, 3, 2, 4, 5)))
    }

    @Test
    fun strictlyIncreasingArrayHasNoPattern() {
        assertEquals(0L, solution.countQuadruplets(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun ignoresIndicesWithEqualValues() {
        assertEquals(0L, solution.countQuadruplets(intArrayOf(1, 1, 1, 1)))
    }
}
