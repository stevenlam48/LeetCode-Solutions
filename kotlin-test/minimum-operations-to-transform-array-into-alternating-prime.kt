package minimumoperationstotransformarrayintoalternatingprime

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToTransformArrayIntoAlternatingPrimeTest {
    @Test
    fun alreadyAlternatingArrayNeedsNoOperations() {
        assertEquals(0, Solution().minOperations(intArrayOf(2, 4, 3, 9)))
    }

    @Test
    fun primeAndCompositeRequirementsAlternateByIndex() {
        assertEquals(6, Solution().minOperations(intArrayOf(4, 2, 9, 3)))
    }

    @Test
    fun oneAdvancesToTheSmallestPrime() {
        assertEquals(1, Solution().minOperations(intArrayOf(1)))
    }

    @Test
    fun nextPrimeGapsAndOddPrimeAreCounted() {
        assertEquals(5, Solution().minOperations(intArrayOf(12, 7, 14)))
    }

    @Test
    fun duplicateValuesDependOnTheirPositions() {
        assertEquals(6, Solution().minOperations(intArrayOf(8, 8, 8, 8)))
    }
}
