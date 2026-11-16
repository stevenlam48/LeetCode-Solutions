package getmaximumingeneratedarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GetMaximumInGeneratedArrayTest {
    @Test
    fun `standard examples`() {
        val solution = Solution()
        assertEquals(3, solution.getMaximumGenerated(7))
        assertEquals(1, solution.getMaximumGenerated(2))
        assertEquals(2, solution.getMaximumGenerated(3))
        assertEquals(4, solution.getMaximumGenerated(9))
    }

    @Test
    fun `zero and one`() {
        val solution = Solution()
        assertEquals(0, solution.getMaximumGenerated(0))
        assertEquals(1, solution.getMaximumGenerated(1))
    }

    @Test
    fun `cached values work across instances and decreasing queries`() {
        assertEquals(2, Solution().getMaximumGenerated(4))
        assertEquals(1, Solution().getMaximumGenerated(2))
        assertEquals(0, Solution().getMaximumGenerated(0))
    }
}
