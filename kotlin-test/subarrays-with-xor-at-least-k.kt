package subarrayswithxoratleastk

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SubarraysWithXorAtLeastKTest {
    @Test
    fun testExample1() {
        assertEquals(3L, Solution().countXorSubarrays(intArrayOf(1, 2, 3), 2))
    }

    @Test
    fun testKEqualsZero() {
        assertEquals(6L, Solution().countXorSubarrays(intArrayOf(1, 2, 3), 0))
    }

    @Test
    fun testMixed() {
        assertEquals(7L, Solution().countXorSubarrays(intArrayOf(2, 3, 1, 6, 7), 3))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1L, Solution().countXorSubarrays(intArrayOf(1), 1))
        assertEquals(0L, Solution().countXorSubarrays(intArrayOf(1), 2))
    }

    @Test
    fun testDuplicates() {
        assertEquals(4L, Solution().countXorSubarrays(intArrayOf(5, 5, 5), 5))
    }
}
