package sortarraybyincreasingfrequency

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SortArrayByIncreasingFrequencyTest {
    @Test
    fun example1() {
        assertArrayEquals(
            intArrayOf(3, 1, 1, 2, 2, 2),
            Solution().frequencySort(intArrayOf(1, 1, 2, 2, 2, 3))
        )
    }

    @Test
    fun example2() {
        assertArrayEquals(
            intArrayOf(1, 3, 3, 2, 2),
            Solution().frequencySort(intArrayOf(2, 3, 1, 3, 2))
        )
    }

    @Test
    fun negatives() {
        assertArrayEquals(
            intArrayOf(5, -1, 4, 4, -6, -6, 1, 1, 1),
            Solution().frequencySort(intArrayOf(-1, 1, -6, 4, 5, -6, 1, 4, 1))
        )
    }

    @Test
    fun allEqual() {
        assertArrayEquals(intArrayOf(7, 7, 7), Solution().frequencySort(intArrayOf(7, 7, 7)))
    }

    @Test
    fun singleElement() {
        assertArrayEquals(intArrayOf(1), Solution().frequencySort(intArrayOf(1)))
    }
}
