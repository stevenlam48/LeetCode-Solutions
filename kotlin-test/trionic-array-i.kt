package trionicarrayi

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TrionicArrayITest {
    @Test
    fun standardExamples() {
        assertTrue(Solution().isTrionic(intArrayOf(1, 3, 5, 4, 2, 6)))
        assertFalse(Solution().isTrionic(intArrayOf(2, 1, 3)))
        assertFalse(Solution().isTrionic(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun allowsSingleElementSegments() {
        assertTrue(Solution().isTrionic(intArrayOf(1, 2, 1, 2)))
        assertTrue(Solution().isTrionic(intArrayOf(-3, -2, -1, -4, -3)))
    }

    @Test
    fun rejectsEqualAdjacentValuesAndMissingSegments() {
        assertFalse(Solution().isTrionic(intArrayOf(1, 2, 2, 1, 2)))
        assertFalse(Solution().isTrionic(intArrayOf(1, 3, 2)))
        assertFalse(Solution().isTrionic(IntArray(0)))
    }
}
