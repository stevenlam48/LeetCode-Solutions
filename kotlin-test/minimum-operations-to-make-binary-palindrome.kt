package minimumoperationstomakebinarypalindrome

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeBinaryPalindromeTest {
    @Test
    fun testSmallValuesAtOrBetweenPalindromes() {
        assertArrayEquals(
            intArrayOf(0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0),
            Solution().minOperations(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15))
        )
    }

    @Test
    fun testFiveBitPalindrome() {
        assertArrayEquals(intArrayOf(0), Solution().minOperations(intArrayOf(17)))
    }

    @Test
    fun testLargerPalindrome() {
        assertArrayEquals(intArrayOf(0), Solution().minOperations(intArrayOf(31)))
    }

    @Test
    fun testQueryOrderAndRepetitionArePreserved() {
        assertArrayEquals(
            intArrayOf(0, 0, 0, 1),
            Solution().minOperations(intArrayOf(21, 17, 9, 6))
        )
    }
}
