package minimumoperationstomakeeveryelementpalindromic

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeEveryElementPalindromicTest {
    @Test
    fun alreadyPalindromic() {
        assertEquals(0L, Solution().minOperations(intArrayOf(1, 2, 3)))
        assertEquals(0L, Solution().minOperations(intArrayOf(9999)))
    }

    @Test
    fun singleSmallNumber() {
        assertEquals(1L, Solution().minOperations(intArrayOf(13)))
        assertEquals(1L, Solution().minOperations(intArrayOf(123)))
    }

    @Test
    fun evenLengthNumber() {
        assertEquals(168L, Solution().minOperations(intArrayOf(1234)))
    }

    @Test
    fun multipleNumbers() {
        assertEquals(170L, Solution().minOperations(intArrayOf(13, 10, 1234)))
    }
}
