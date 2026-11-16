package smalleststableindexi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestStableIndexITest {
    private val solution = Solution()

    @Test
    fun firstIndexSatisfiesThreshold() {
        assertEquals(0, solution.firstStableIndex(intArrayOf(3, 1, 2), 2))
        assertEquals(0, solution.firstStableIndex(intArrayOf(5, 4, 3), 10))
    }

    @Test
    fun negativeValuesCanRequireLaterIndex() {
        assertEquals(1, solution.firstStableIndex(intArrayOf(-5, 0, -1), 1))
    }

    @Test
    fun noStableIndex() {
        assertEquals(-1, solution.firstStableIndex(intArrayOf(-5, -1, -3), 0))
        assertEquals(-1, solution.firstStableIndex(intArrayOf(1, 2), -1))
    }
}
