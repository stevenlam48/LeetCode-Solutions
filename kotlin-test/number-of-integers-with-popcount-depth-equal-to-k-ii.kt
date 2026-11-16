package numberofintegerswithpopcountdepthequaltokii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class NumberOfIntegersWithPopcountDepthEqualToKIITest {
    @Test
    fun testMixedQueries() {
        val nums = longArrayOf(2, 3, 4, 7)
        val queries = arrayOf(
            longArrayOf(1, 0, 3, 1),
            longArrayOf(1, 0, 3, 2),
            longArrayOf(1, 0, 3, 3),
            longArrayOf(2, 0, 7),
            longArrayOf(1, 0, 3, 1),
            longArrayOf(1, 0, 3, 3),
            longArrayOf(1, 1, 2, 2)
        )
        assertArrayEquals(intArrayOf(2, 1, 1, 1, 2, 1), Solution().popcountDepth(nums, queries))
    }

    @Test
    fun testUpdates() {
        val nums = longArrayOf(1, 2)
        val queries = arrayOf(
            longArrayOf(1, 0, 1, 0),
            longArrayOf(2, 1, 3),
            longArrayOf(1, 0, 1, 2),
            longArrayOf(1, 0, 1, 0)
        )
        assertArrayEquals(intArrayOf(1, 1, 1), Solution().popcountDepth(nums, queries))
    }

    @Test
    fun testEmptyDepth() {
        val nums = longArrayOf(2)
        val queries = arrayOf(longArrayOf(1, 0, 0, 5))
        assertArrayEquals(intArrayOf(0), Solution().popcountDepth(nums, queries))
    }
}
