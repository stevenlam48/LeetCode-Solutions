package minimumdeletionstomakearraybeautiful
// Time:  O(n)
// Space: O(1)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumDeletionsToMakeArrayBeautifulTest {
    private val solution = Solution()

    @Test
    fun leetCodeExamples() {
        assertEquals(1, solution.minDeletion(intArrayOf(1, 1, 2, 3, 5)))
        assertEquals(2, solution.minDeletion(intArrayOf(1, 1, 2, 2, 3, 3)))
    }

    @Test
    fun oddLengthNeedsFinalDeletion() {
        assertEquals(1, solution.minDeletion(intArrayOf(10)))
        assertEquals(1, solution.minDeletion(intArrayOf(1, 2, 3)))
    }

    @Test
    fun emptyAndAlreadyBeautifulArrays() {
        assertEquals(0, solution.minDeletion(intArrayOf()))
        assertEquals(0, solution.minDeletion(intArrayOf(1, 2, 1, 2)))
    }
}
