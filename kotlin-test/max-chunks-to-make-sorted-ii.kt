package maxchunkstomakesortedii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxChunksToMakeSortedIiTest {
    private val solution = Solution()

    @Test
    fun computesFirstExample() {
        assertEquals(1, solution.maxChunksToSorted(intArrayOf(5, 4, 3, 2, 1)))
    }

    @Test
    fun computesSecondExample() {
        assertEquals(4, solution.maxChunksToSorted(intArrayOf(2, 1, 3, 4, 4)))
    }

    @Test
    fun preservesDuplicateBoundaries() {
        assertEquals(3, solution.maxChunksToSorted(intArrayOf(1, 1, 0, 2, 2)))
    }

    @Test
    fun sortedDuplicatesCanEachFormAChunk() {
        assertEquals(4, solution.maxChunksToSorted(intArrayOf(1, 1, 2, 2)))
    }

    @Test
    fun handlesSingleElement() {
        assertEquals(1, solution.maxChunksToSorted(intArrayOf(-3)))
    }

    @Test
    fun handlesEmptyInput() {
        assertEquals(0, solution.maxChunksToSorted(intArrayOf()))
    }
}
