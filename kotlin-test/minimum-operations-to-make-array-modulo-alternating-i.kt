package minimumoperationstomakearraymoduloalternatingi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeArrayModuloAlternatingITest {
    @Test
    fun testSameResidueNeedsOneChange() {
        assertEquals(1L, Solution().minOperations(intArrayOf(0, 0), 2))
    }

    @Test
    fun testAlreadyModuloAlternating() {
        assertEquals(0L, Solution().minOperations(intArrayOf(0, 1), 2))
    }

    @Test
    fun testFourElements() {
        assertEquals(2L, Solution().minOperations(intArrayOf(0, 0, 1, 1), 2))
    }

    @Test
    fun testOddModulus() {
        assertEquals(1L, Solution().minOperations(intArrayOf(0, 0), 3))
    }
}
