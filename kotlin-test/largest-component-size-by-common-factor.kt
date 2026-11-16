package largestcomponentsizebycommonfactor

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LargestComponentSizeByCommonFactorTest {
    @Test
    fun exampleInput() {
        assertEquals(4, Solution().largestComponentSize(intArrayOf(4, 6, 15, 35)))
    }

    @Test
    fun connectedThroughIntermediateNumbers() {
        assertEquals(2, Solution().largestComponentSize(intArrayOf(20, 50, 9, 63)))
        assertEquals(8, Solution().largestComponentSize(intArrayOf(2, 3, 6, 7, 4, 12, 21, 39)))
    }

    @Test
    fun coprimeSingletonsAndOne() {
        assertEquals(1, Solution().largestComponentSize(intArrayOf(1, 2, 3, 5, 7)))
    }

    @Test
    fun allSharePrimeFactor() {
        assertEquals(4, Solution().largestComponentSize(intArrayOf(6, 12, 18, 30)))
    }
}
