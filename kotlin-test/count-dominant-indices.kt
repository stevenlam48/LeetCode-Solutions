package countdominantindices

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountDominantIndicesTest {
    @Test
    fun increasingArray() {
        assertEquals(0, Solution().dominantIndices(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun largeFirstElement() {
        assertEquals(1, Solution().dominantIndices(intArrayOf(5, 1, 1, 1)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().dominantIndices(intArrayOf(1)))
    }

    @Test
    fun zeros() {
        assertEquals(1, Solution().dominantIndices(intArrayOf(2, 0, 0)))
    }

    @Test
    fun allOnes() {
        assertEquals(0, Solution().dominantIndices(intArrayOf(1, 1, 1, 1, 1)))
    }
}
