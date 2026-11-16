package topkfrequentelements

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class TopKFrequentElementsTest {
    @Test
    fun example() {
        assertArrayEquals(intArrayOf(1, 2), Solution().topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2))
    }

    @Test
    fun singleElement() {
        assertArrayEquals(intArrayOf(1), Solution().topKFrequent(intArrayOf(1), 1))
    }

    @Test
    fun allDistinctCounts() {
        assertArrayEquals(
            intArrayOf(1, 2, 3),
            Solution().topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 3),
        )
    }

    @Test
    fun negatives() {
        assertArrayEquals(intArrayOf(-1, 2), Solution().topKFrequent(intArrayOf(-1, -1, -1, 2, 2, 3), 2))
    }
}
