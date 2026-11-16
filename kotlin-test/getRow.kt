package getRow

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class GetRowTest {
    @Test
    fun `first two rows`() {
        val solution = Solution()
        assertArrayEquals(intArrayOf(1), solution.getRow(0))
        assertArrayEquals(intArrayOf(1, 1), solution.getRow(1))
    }

    @Test
    fun `standard examples`() {
        val solution = Solution()
        assertArrayEquals(intArrayOf(1, 3, 3, 1), solution.getRow(3))
        assertArrayEquals(intArrayOf(1, 4, 6, 4, 1), solution.getRow(4))
    }

    @Test
    fun `row five`() {
        assertArrayEquals(intArrayOf(1, 5, 10, 10, 5, 1), Solution().getRow(5))
    }
}
