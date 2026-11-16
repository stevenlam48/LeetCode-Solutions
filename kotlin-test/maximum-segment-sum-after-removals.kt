package maximumsegmentsumafterremovals

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MaximumSegmentSumAfterRemovalsTest {
    @Test
    fun example1() {
        assertArrayEquals(
            longArrayOf(14, 7, 2, 2, 0),
            Solution().maximumSegmentSum(intArrayOf(1, 2, 5, 6, 1), intArrayOf(0, 3, 2, 4, 1))
        )
    }

    @Test
    fun descendingRemovals() {
        assertArrayEquals(
            longArrayOf(6, 3, 1, 0),
            Solution().maximumSegmentSum(intArrayOf(1, 2, 3, 4), intArrayOf(3, 2, 1, 0))
        )
    }

    @Test
    fun singleElement() {
        assertArrayEquals(longArrayOf(0), Solution().maximumSegmentSum(intArrayOf(5), intArrayOf(0)))
    }

    @Test
    fun middleFirst() {
        assertArrayEquals(
            longArrayOf(1, 1, 0),
            Solution().maximumSegmentSum(intArrayOf(1, 1, 1), intArrayOf(1, 0, 2))
        )
    }

    @Test
    fun largeValues() {
        assertArrayEquals(
            longArrayOf(2_000_000_000L, 1_000_000_000L, 0L),
            Solution().maximumSegmentSum(
                intArrayOf(1_000_000_000, 1_000_000_000, 1_000_000_000),
                intArrayOf(2, 0, 1)
            )
        )
    }
}
