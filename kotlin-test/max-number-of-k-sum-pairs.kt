package maxnumberofksumpairs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxNumberOfKSumPairsTest {
    private val solution = Solution()

    @Test
    fun computesFirstExample() {
        assertEquals(2, solution.maxOperations(intArrayOf(1, 2, 3, 4), 5))
    }

    @Test
    fun computesSecondExample() {
        assertEquals(1, solution.maxOperations(intArrayOf(3, 1, 3, 4, 3), 6))
    }

    @Test
    fun handlesDuplicateComplements() {
        assertEquals(3, solution.maxOperations(intArrayOf(2, 2, 2, 3, 3, 3), 5))
    }

    @Test
    fun pairsSameNumberOnlyWithCorrectMultiplicity() {
        assertEquals(1, solution.maxOperations(intArrayOf(4, 4, 4), 8))
    }

    @Test
    fun returnsZeroWhenNoPairExists() {
        assertEquals(0, solution.maxOperations(intArrayOf(-2, 0, 8), 10))
    }

    @Test
    fun handlesEmptyInput() {
        assertEquals(0, solution.maxOperations(intArrayOf(), 5))
    }
}
