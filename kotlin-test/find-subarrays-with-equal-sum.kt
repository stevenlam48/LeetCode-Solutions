package findsubarrayswithequalsum

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class FindSubarraysWithEqualSumTest {
    @Test
    fun testExample1() {
        assertTrue(Solution().findSubarrays(intArrayOf(4, 2, 4)))
    }

    @Test
    fun testExample2() {
        assertFalse(Solution().findSubarrays(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun testZeros() {
        assertTrue(Solution().findSubarrays(intArrayOf(0, 0, 0)))
    }

    @Test
    fun testTooShort() {
        assertFalse(Solution().findSubarrays(intArrayOf(1)))
    }

    @Test
    fun testNegatives() {
        assertTrue(Solution().findSubarrays(intArrayOf(-1, 1, 0, 0)))
    }
}
