package balancedkfactordecomposition

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class BalancedKFactorDecompositionTest {
    private val solution = Solution()

    @Test
    fun squareCanUseEqualFactors() {
        assertArrayEquals(intArrayOf(10, 10), solution.minDifference(100, 2))
    }

    @Test
    fun repeatedSmallFactorsMinimizeRange() {
        assertArrayEquals(intArrayOf(2, 2, 11), solution.minDifference(44, 3))
    }

    @Test
    fun nearestCubeRootFactors() {
        assertArrayEquals(intArrayOf(3, 3, 4), solution.minDifference(36, 3))
    }

    @Test
    fun singleFactorIsOriginalNumber() {
        assertArrayEquals(intArrayOf(17), solution.minDifference(17, 1))
    }

    @Test
    fun onesAreUsedWhenMoreFactorsThanPrimeFactors() {
        assertArrayEquals(intArrayOf(1, 2, 2, 3), solution.minDifference(12, 4))
        assertArrayEquals(intArrayOf(1, 1, 2), solution.minDifference(2, 3))
    }
}
