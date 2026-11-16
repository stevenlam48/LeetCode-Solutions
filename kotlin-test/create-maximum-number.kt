package createmaximumnumber

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class CreateMaximumNumberTest {
    @Test
    fun `merges the best subsequences from both arrays`() {
        val result = Solution().maxNumber(
            intArrayOf(3, 4, 6, 5), intArrayOf(9, 1, 2, 5, 8, 3), 5
        )
        assertArrayEquals(intArrayOf(9, 8, 6, 5, 3), result)
    }

    @Test
    fun `uses all five values`() {
        val result = Solution().maxNumber(intArrayOf(6, 7), intArrayOf(6, 0, 4), 5)
        assertArrayEquals(intArrayOf(6, 7, 6, 0, 4), result)
    }

    @Test
    fun `breaks ties using the remaining suffixes`() {
        val result = Solution().maxNumber(intArrayOf(3, 9), intArrayOf(8, 9), 3)
        assertArrayEquals(intArrayOf(9, 8, 9), result)
    }

    @Test
    fun `handles an empty source array`() {
        assertArrayEquals(intArrayOf(2, 1), Solution().maxNumber(intArrayOf(2, 1), intArrayOf(), 2))
    }

    @Test
    fun `handles leading and repeated zeroes`() {
        assertArrayEquals(intArrayOf(0, 0), Solution().maxNumber(intArrayOf(0, 0), intArrayOf(0), 2))
    }
}
