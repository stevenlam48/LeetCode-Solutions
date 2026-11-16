package minimumadjacentswapstopartitionarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumAdjacentSwapsToPartitionArrayTest {
    @Test
    fun reversedGroups() = assertEquals(5, Solution().minAdjacentSwaps(intArrayOf(4, 3, 2, 1), 2, 3))

    @Test
    fun interleavedGroups() = assertEquals(3, Solution().minAdjacentSwaps(intArrayOf(5, 1, 4, 2), 2, 3))

    @Test
    fun allMiddleValues() = assertEquals(0, Solution().minAdjacentSwaps(intArrayOf(2, 3, 2, 3), 2, 3))

    @Test
    fun emptyArray() = assertEquals(0, Solution().minAdjacentSwaps(intArrayOf(), 2, 3))
}
