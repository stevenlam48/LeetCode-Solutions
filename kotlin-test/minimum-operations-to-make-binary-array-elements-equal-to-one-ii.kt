package minimumoperationstomakebinaryarrayelementsequaltooneii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeBinaryArrayElementsEqualToOneIiTest {
    @Test
    fun testAlternatingEffectiveValues() {
        assertEquals(3, Solution().minOperations(intArrayOf(0, 1, 1, 0)))
    }

    @Test
    fun testFlipAfterInitialOnes() {
        assertEquals(2, Solution().minOperations(intArrayOf(1, 0, 1)))
    }

    @Test
    fun testAllOnes() {
        assertEquals(0, Solution().minOperations(intArrayOf(1, 1, 1)))
    }

    @Test
    fun testConsecutiveZerosNeedOneSuffixFlip() {
        assertEquals(1, Solution().minOperations(intArrayOf(0, 0)))
    }
}
