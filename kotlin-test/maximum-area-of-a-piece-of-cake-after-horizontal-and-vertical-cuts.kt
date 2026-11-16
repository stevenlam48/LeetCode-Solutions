package maximumareaofapieceofcakeafterhorizontalandverticalcuts

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCutsTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals(4, solution.maxArea(5, 4, intArrayOf(1, 2, 4), intArrayOf(1, 3)))
    }

    @Test
    fun secondExample() {
        assertEquals(6, solution.maxArea(5, 4, intArrayOf(3, 1), intArrayOf(1)))
    }

    @Test
    fun thirdExample() {
        assertEquals(9, solution.maxArea(5, 4, intArrayOf(3), intArrayOf(3)))
    }

    @Test
    fun unsortedCutsAndLargestEdgePieces() {
        assertEquals(9, solution.maxArea(10, 8, intArrayOf(7, 2, 4), intArrayOf(2, 5)))
    }

    @Test
    fun largeDimensionsUseLongProduct() {
        assertEquals(64, solution.maxArea(1_000_000_000, 1_000_000_000, intArrayOf(1), intArrayOf(1)))
    }
}
