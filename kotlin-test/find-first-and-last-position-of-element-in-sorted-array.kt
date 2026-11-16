package findfirstandlastpositionofelementinsortedarray

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindFirstAndLastPositionOfElementInSortedArrayTest {
    @Test
    fun standardExample() {
        assertArrayEquals(
            intArrayOf(3, 4),
            Solution().searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8)
        )
    }

    @Test
    fun targetMissing() {
        assertArrayEquals(
            intArrayOf(-1, -1),
            Solution().searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 6)
        )
    }

    @Test
    fun emptyArray() {
        assertArrayEquals(intArrayOf(-1, -1), Solution().searchRange(intArrayOf(), 0))
    }

    @Test
    fun singleElementFound() {
        assertArrayEquals(intArrayOf(0, 0), Solution().searchRange(intArrayOf(1), 1))
    }

    @Test
    fun allElementsMatch() {
        assertArrayEquals(intArrayOf(0, 1), Solution().searchRange(intArrayOf(2, 2), 2))
    }

    @Test
    fun targetAtStart() {
        assertArrayEquals(
            intArrayOf(0, 0),
            Solution().searchRange(intArrayOf(1, 2, 3), 1)
        )
    }
}
