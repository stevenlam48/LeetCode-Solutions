package minimumoperationstomakearraysumdivisiblebyk

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeArraySumDivisibleByKTest {
    @Test
    fun testAlreadyDivisible() {
        assertEquals(0, Solution().minOperations(intArrayOf(1, 2, 3), 3))
    }

    @Test
    fun testPositiveRemainder() {
        assertEquals(3, Solution().minOperations(intArrayOf(1, 2), 4))
    }

    @Test
    fun testSingleValueMultipleOfK() {
        assertEquals(0, Solution().minOperations(intArrayOf(5), 5))
    }

    @Test
    fun testNegativeRemainderMatchesSourceArithmetic() {
        assertEquals(-1, Solution().minOperations(intArrayOf(-1), 3))
    }
}
