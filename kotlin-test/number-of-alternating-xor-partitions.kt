package numberofalternatingxorpartitions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfAlternatingXorPartitionsTest {
    @Test
    fun twoEqualElements() {
        assertEquals(1, Solution().alternatingXOR(intArrayOf(1, 1), 1, 1))
    }

    @Test
    fun twoDistinctTargets() {
        assertEquals(1, Solution().alternatingXOR(intArrayOf(1, 2), 1, 2))
    }

    @Test
    fun threeEqualElements() {
        assertEquals(2, Solution().alternatingXOR(intArrayOf(1, 1, 1), 1, 1))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().alternatingXOR(intArrayOf(5), 5, 7))
    }

    @Test
    fun noValidPartition() {
        assertEquals(0, Solution().alternatingXOR(intArrayOf(1, 2), 5, 7))
    }
}
