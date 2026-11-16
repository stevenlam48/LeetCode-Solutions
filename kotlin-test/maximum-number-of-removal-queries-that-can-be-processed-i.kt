package maximumnumberofremovalqueriesthatcanbeprocessedi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumnumberofremovalqueriesthatcanbeprocessediTest {
    @Test
    fun singleMatch() {
        assertEquals(1, Solution().maximumProcessableQueries(intArrayOf(1), intArrayOf(1)))
    }

    @Test
    fun singleMismatch() {
        assertEquals(0, Solution().maximumProcessableQueries(intArrayOf(1), intArrayOf(2)))
    }

    @Test
    fun bothQueriesProcessed() {
        assertEquals(2, Solution().maximumProcessableQueries(intArrayOf(1, 2), intArrayOf(1, 1)))
    }

    @Test
    fun nothingProcessed() {
        assertEquals(0, Solution().maximumProcessableQueries(intArrayOf(1, 2), intArrayOf(3)))
    }

    @Test
    fun allProcessedDescending() {
        assertEquals(3, Solution().maximumProcessableQueries(intArrayOf(1, 2, 3), intArrayOf(3, 2, 1)))
    }

    @Test
    fun freeRemovalOfSmallElement() {
        assertEquals(2, Solution().maximumProcessableQueries(intArrayOf(1, 2, 3), intArrayOf(2, 3)))
    }
}
