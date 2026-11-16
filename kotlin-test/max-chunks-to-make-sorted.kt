package maxchunkstomakesorted

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxChunksToMakeSortedTest {
    private val solution = Solution()

    @Test
    fun computesFirstExample() {
        assertEquals(1, solution.maxChunksToSorted(intArrayOf(4, 3, 2, 1, 0)))
    }

    @Test
    fun computesSecondExample() {
        assertEquals(4, solution.maxChunksToSorted(intArrayOf(1, 0, 2, 3, 4)))
    }

    @Test
    fun sortedArraySplitsAtEveryElement() {
        assertEquals(5, solution.maxChunksToSorted(intArrayOf(0, 1, 2, 3, 4)))
    }

    @Test
    fun handlesSingleElement() {
        assertEquals(1, solution.maxChunksToSorted(intArrayOf(0)))
    }

    @Test
    fun handlesEmptyInput() {
        assertEquals(0, solution.maxChunksToSorted(intArrayOf()))
    }
}
