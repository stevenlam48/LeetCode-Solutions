package minimumoperationstomakearrayequaliii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeArrayEqualIiiTest {
    @Test
    fun testAllOnes() {
        assertEquals(0L, Solution().minOperations(intArrayOf(1, 1)))
    }

    @Test
    fun testFrequentValueIsCandidate() {
        assertEquals(1L, Solution().minOperations(intArrayOf(2, 2, 4)))
    }

    @Test
    fun testCandidateAcrossBitLengths() {
        assertEquals(2L, Solution().minOperations(intArrayOf(2, 2, 4, 8)))
    }

    @Test
    fun testNoMajorityCandidate() {
        assertEquals(3L, Solution().minOperations(intArrayOf(3, 5, 6)))
    }
}
