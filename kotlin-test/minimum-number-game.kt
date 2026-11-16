package minimumnumbergame

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumNumberGameTest {
    @Test
    fun exampleWithFourNumbers() {
        val nums = intArrayOf(5, 4, 2, 3)
        assertArrayEquals(intArrayOf(3, 2, 5, 4), Solution().numberGame(nums))
    }

    @Test
    fun exampleWithTwoNumbers() {
        assertArrayEquals(intArrayOf(5, 2), Solution().numberGame(intArrayOf(2, 5)))
    }

    @Test
    fun duplicatesRemainPairedAfterSorting() {
        assertArrayEquals(intArrayOf(1, 1, 2, 2), Solution().numberGame(intArrayOf(2, 1, 2, 1)))
    }

    @Test
    fun returnsTheSortedInputAfterSwappingPairs() {
        val nums = intArrayOf(6, 1, 4, 3, 2, 5)
        val result = Solution().numberGame(nums)
        assertSame(nums, result)
        assertArrayEquals(intArrayOf(2, 1, 4, 3, 6, 5), result)
    }
}
