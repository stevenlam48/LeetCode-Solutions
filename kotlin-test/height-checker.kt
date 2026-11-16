package heightchecker

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HeightCheckerTest {
    private val solution = Solution()

    @Test
    fun examples() {
        assertEquals(3, solution.heightChecker(intArrayOf(1, 1, 4, 2, 1, 3)))
        assertEquals(5, solution.heightChecker(intArrayOf(5, 1, 2, 3, 4)))
        assertEquals(0, solution.heightChecker(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun duplicateHeights() {
        assertEquals(4, solution.heightChecker(intArrayOf(2, 1, 2, 1, 1, 2)))
    }

    @Test
    fun singleStudentAndInputPreservation() {
        val heights = intArrayOf(4)
        assertEquals(0, solution.heightChecker(heights))
        assertArrayEquals(intArrayOf(4), heights)
    }
}
