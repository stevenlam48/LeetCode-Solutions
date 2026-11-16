package minimumnumberofoperationstomakearrayempty

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfOperationsToMakeArrayEmptyTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(
            4,
            solution.minOperations(intArrayOf(2, 3, 3, 2, 2, 4, 2, 3, 4))
        )
    }

    @Test
    fun elementWithSingleOccurrence() {
        assertEquals(-1, solution.minOperations(intArrayOf(2, 1, 2, 2, 3, 3)))
    }

    @Test
    fun pair() {
        assertEquals(1, solution.minOperations(intArrayOf(1, 1)))
    }

    @Test
    fun triple() {
        assertEquals(1, solution.minOperations(intArrayOf(2, 2, 2)))
    }

    @Test
    fun emptyArray() {
        assertEquals(0, solution.minOperations(intArrayOf()))
    }
}
