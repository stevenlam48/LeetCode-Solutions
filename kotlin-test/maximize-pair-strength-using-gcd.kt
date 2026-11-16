package maximizepairstrengthusinggcd

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizePairStrengthUsingGcdTest {
    @Test
    fun divisorPairsReduceStrength() {
        assertEquals(4L, Solution().maxPairStrength(intArrayOf(2, 4, 8)))
    }

    @Test
    fun coprimePairUsesFullProduct() {
        assertEquals(35L, Solution().maxPairStrength(intArrayOf(5, 7)))
    }

    @Test
    fun mixedPairsFindMaximum() {
        assertEquals(15L, Solution().maxPairStrength(intArrayOf(6, 10, 15)))
    }

    @Test
    fun duplicateValuesReturnOne() {
        assertEquals(1L, Solution().maxPairStrength(intArrayOf(12, 12, 12)))
    }

    @Test
    fun singleElementHasNoPair() {
        assertEquals(0L, Solution().maxPairStrength(intArrayOf(42)))
    }
}
