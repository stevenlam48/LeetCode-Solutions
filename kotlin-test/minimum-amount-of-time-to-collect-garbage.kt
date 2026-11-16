package minimumamountoftimetocollectgarbage

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumAmountOfTimeToCollectGarbageTest {
    @Test
    fun standardExample() = assertEquals(21, Solution().garbageCollection(arrayOf("G", "P", "GP", "GG"), intArrayOf(2, 4, 3)))

    @Test
    fun repeatedGarbage() = assertEquals(37, Solution().garbageCollection(arrayOf("MMM", "PGM", "GP"), intArrayOf(3, 10)))

    @Test
    fun allGarbageTypes() = assertEquals(23, Solution().garbageCollection(arrayOf("MM", "PP", "GG"), intArrayOf(5, 7)))

    @Test
    fun noGarbage() = assertEquals(0, Solution().garbageCollection(arrayOf(""), intArrayOf()))
}
