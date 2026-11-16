package kdiffpairsinanarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KDiffPairsInAnArrayTest {
    @Test
    fun `counts two unique pairs`() {
        assertEquals(2, Solution().findPairs(intArrayOf(3, 1, 4, 1, 5), 2))
    }

    @Test
    fun `counts each consecutive pair once`() {
        assertEquals(4, Solution().findPairs(intArrayOf(1, 2, 3, 4, 5), 1))
    }

    @Test
    fun `zero difference counts duplicated values`() {
        assertEquals(1, Solution().findPairs(intArrayOf(1, 3, 1, 5, 4), 0))
    }

    @Test
    fun `negative difference has no pairs`() {
        assertEquals(0, Solution().findPairs(intArrayOf(1, 2, 3), -1))
    }

    @Test
    fun `duplicate pair values are deduplicated`() {
        assertEquals(1, Solution().findPairs(intArrayOf(1, 1, 1, 2, 2), 1))
    }
}
