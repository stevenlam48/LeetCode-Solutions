package maximumsquareareabyremovingfencesfromafield

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSquareAreaByRemovingFencesFromAFieldTest {
    @Test
    fun example1() {
        assertEquals(4, Solution().maximizeSquareArea(4, 3, intArrayOf(2, 3), intArrayOf(2)))
    }

    @Test
    fun noCommonDistance() {
        assertEquals(-1, Solution().maximizeSquareArea(6, 7, intArrayOf(2), intArrayOf(4)))
    }

    @Test
    fun noFences() {
        assertEquals(1, Solution().maximizeSquareArea(2, 2, intArrayOf(), intArrayOf()))
    }

    @Test
    fun sameFence() {
        assertEquals(9, Solution().maximizeSquareArea(4, 4, intArrayOf(2), intArrayOf(2)))
    }

    @Test
    fun fullField() {
        assertEquals(16, Solution().maximizeSquareArea(5, 5, intArrayOf(2, 3, 4), intArrayOf(2, 3, 4)))
    }
}
