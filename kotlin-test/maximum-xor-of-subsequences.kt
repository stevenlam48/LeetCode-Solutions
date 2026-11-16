package maximumxorofsubsequences

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumXorOfSubsequencesTest {
    private val solution = Solution()

    @Test
    fun consecutiveValues() {
        assertEquals(3, solution.maxXorSubsequences(intArrayOf(1, 2, 3)))
    }

    @Test
    fun threeValues() {
        assertEquals(7, solution.maxXorSubsequences(intArrayOf(2, 3, 5)))
    }

    @Test
    fun singleZero() {
        assertEquals(0, solution.maxXorSubsequences(intArrayOf(0)))
    }

    @Test
    fun duplicateValues() {
        assertEquals(1, solution.maxXorSubsequences(intArrayOf(1, 1)))
    }

    @Test
    fun fourBitBasis() {
        assertEquals(15, solution.maxXorSubsequences(intArrayOf(8, 1, 2, 12)))
    }
}
