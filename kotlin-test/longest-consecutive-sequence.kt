package longestconsecutivesequence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestConsecutiveSequenceTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(4, solution.longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)))
    }

    @Test
    fun longerExample() {
        assertEquals(9, solution.longestConsecutive(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)))
    }

    @Test
    fun emptyInput() {
        assertEquals(0, solution.longestConsecutive(intArrayOf()))
    }

    @Test
    fun negativesAndDuplicates() {
        assertEquals(6, solution.longestConsecutive(intArrayOf(-2, -1, 0, 1, 2, 3, 1, 0)))
    }

    @Test
    fun noConsecutivePair() {
        assertEquals(1, solution.longestConsecutive(intArrayOf(10, 30, 20)))
    }
}
