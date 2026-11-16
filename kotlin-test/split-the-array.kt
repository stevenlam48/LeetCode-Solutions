package splitthearray

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SplitTheArrayTest {
    private val solution = Solution()

    @Test
    fun `accepts values occurring at most twice`() {
        assertTrue(solution.isPossibleToSplit(intArrayOf(1, 1, 2, 2, 3, 4)))
    }

    @Test
    fun `rejects a value occurring more than twice`() {
        assertFalse(solution.isPossibleToSplit(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun `accepts negative values and zero with two occurrences each`() {
        assertTrue(solution.isPossibleToSplit(intArrayOf(-1, -1, 0, 0)))
    }

    @Test
    fun `accepts empty and single element arrays`() {
        assertTrue(solution.isPossibleToSplit(intArrayOf()))
        assertTrue(solution.isPossibleToSplit(intArrayOf(7)))
    }
}
