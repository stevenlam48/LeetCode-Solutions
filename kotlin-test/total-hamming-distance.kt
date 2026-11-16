package totalhammingdistance

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TotalHammingDistanceTest {
    @Test
    fun example() {
        assertEquals(6, Solution().totalHammingDistance(intArrayOf(4, 14, 2)))
    }

    @Test
    fun duplicateValues() {
        assertEquals(4, Solution().totalHammingDistance(intArrayOf(4, 14, 4)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().totalHammingDistance(intArrayOf(0)))
    }

    @Test
    fun allZeros() {
        assertEquals(0, Solution().totalHammingDistance(intArrayOf(0, 0, 0)))
    }

    @Test
    fun consecutiveValues() {
        assertEquals(4, Solution().totalHammingDistance(intArrayOf(1, 2, 3)))
    }
}
