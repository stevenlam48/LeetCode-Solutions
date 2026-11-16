package transformarraytoallequalelements

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TransformArrayToAllEqualElementsTest {
    @Test
    fun canMakeAllPositive() {
        assertTrue(Solution().canMakeEqual(intArrayOf(-1, 1, -1, 1, -1), 2))
    }

    @Test
    fun canMakeAllNegativeByPairOperations() {
        assertTrue(Solution().canMakeEqual(intArrayOf(1, -1, 1, -1, 1), 2))
    }

    @Test
    fun rejectsInsufficientOperationsOrLastMismatch() {
        assertFalse(Solution().canMakeEqual(intArrayOf(-1, -1, -1, 1), 0))
        assertFalse(Solution().canMakeEqual(intArrayOf(-1, 1, -1, 1, -1), 1))
        assertFalse(Solution().canMakeEqual(intArrayOf(1, -1, 1), 1))
    }
}
