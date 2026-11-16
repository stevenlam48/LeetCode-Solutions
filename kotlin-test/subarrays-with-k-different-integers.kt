package subarrayswithkdifferentintegers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SubarraysWithKDifferentIntegersTest {
    @Test
    fun testExample1() {
        assertEquals(7, Solution().subarraysWithKDistinct(intArrayOf(1, 2, 1, 2, 3), 2))
    }

    @Test
    fun testExample2() {
        assertEquals(3, Solution().subarraysWithKDistinct(intArrayOf(1, 2, 1, 3, 4), 3))
    }

    @Test
    fun testKEqualsOne() {
        assertEquals(5, Solution().subarraysWithKDistinct(intArrayOf(1, 2, 1, 2, 3), 1))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1, Solution().subarraysWithKDistinct(intArrayOf(7), 1))
        assertEquals(0, Solution().subarraysWithKDistinct(intArrayOf(7), 2))
    }

    @Test
    fun testAllSame() {
        assertEquals(6, Solution().subarraysWithKDistinct(intArrayOf(1, 1, 1), 1))
    }
}
