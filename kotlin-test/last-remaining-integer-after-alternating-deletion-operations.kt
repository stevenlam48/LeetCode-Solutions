package lastremainingintegerafteralternatingdeletionoperations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LastRemainingIntegerAfterAlternatingDeletionOperationsTest {
    private val solution = Solution()

    @Test
    fun handlesOneAndTwo() {
        assertEquals(1L, solution.lastInteger(1L))
        assertEquals(1L, solution.lastInteger(2L))
    }

    @Test
    fun handlesSmallOddInputs() {
        assertEquals(3L, solution.lastInteger(3L))
        assertEquals(1L, solution.lastInteger(5L))
        assertEquals(3L, solution.lastInteger(7L))
        assertEquals(9L, solution.lastInteger(9L))
    }

    @Test
    fun handlesSmallEvenInputs() {
        assertEquals(3L, solution.lastInteger(4L))
        assertEquals(1L, solution.lastInteger(6L))
        assertEquals(3L, solution.lastInteger(8L))
        assertEquals(9L, solution.lastInteger(10L))
    }

    @Test
    fun handlesLargerInput() {
        assertEquals(11L, solution.lastInteger(16L))
    }
}
