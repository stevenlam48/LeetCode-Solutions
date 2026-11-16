package minimumnumberofoperationstohavedistinctelements

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfOperationsToHaveDistinctElementsTest {
    private val solution = Solution()

    @Test
    fun duplicateNearEnd() {
        assertEquals(
            2,
            solution.minOperations(intArrayOf(1, 2, 3, 4, 2, 3, 3, 5, 7))
        )
    }

    @Test
    fun duplicateAtStart() {
        assertEquals(1, solution.minOperations(intArrayOf(4, 1, 4)))
    }

    @Test
    fun allDistinct() {
        assertEquals(0, solution.minOperations(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun twoEqualElements() {
        assertEquals(1, solution.minOperations(intArrayOf(1, 1)))
    }
}
