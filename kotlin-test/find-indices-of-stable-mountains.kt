package findindicesofstablemountains

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindIndicesOfStableMountainsTest {
    @Test
    fun findsMountainsAfterStablePredecessors() {
        assertArrayEquals(
            intArrayOf(3, 4),
            Solution().stableMountains(intArrayOf(1, 2, 3, 4, 5), 2)
        )
    }

    @Test
    fun usesStrictThreshold() {
        assertArrayEquals(
            intArrayOf(1, 3),
            Solution().stableMountains(intArrayOf(10, 1, 10, 1, 10), 1)
        )
        assertArrayEquals(
            intArrayOf(),
            Solution().stableMountains(intArrayOf(2, 2, 2), 2)
        )
    }

    @Test
    fun handlesEmptyAndSingleElementArrays() {
        assertArrayEquals(intArrayOf(), Solution().stableMountains(intArrayOf(), 0))
        assertArrayEquals(intArrayOf(), Solution().stableMountains(intArrayOf(5), 0))
    }
}
