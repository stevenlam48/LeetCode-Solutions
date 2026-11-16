package minimumoperationstomakebinaryarrayelementsequaltoonei

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeBinaryArrayElementsEqualToOneITest {
    @Test
    fun testTwoFlipsMakeEveryElementOne() {
        assertEquals(2, Solution().minOperations(intArrayOf(0, 1, 1, 0, 1)))
    }

    @Test
    fun testImpossibleFinalPair() {
        assertEquals(-1, Solution().minOperations(intArrayOf(1, 0, 1, 1)))
    }

    @Test
    fun testAlreadyAllOnes() {
        assertEquals(0, Solution().minOperations(intArrayOf(1, 1, 1)))
    }

    @Test
    fun testAllZeros() {
        assertEquals(1, Solution().minOperations(intArrayOf(0, 0, 0)))
    }
}
