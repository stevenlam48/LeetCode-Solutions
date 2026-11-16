package findsubarraywithbitwiseorclosesttok

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindSubarrayWithBitwiseOrClosestToKTest {
    @Test
    fun testExample1() {
        assertEquals(0, Solution().minimumDifference(intArrayOf(1, 2, 4, 5), 3))
    }

    @Test
    fun testExample2() {
        assertEquals(1, Solution().minimumDifference(intArrayOf(1, 3, 1, 3), 2))
    }

    @Test
    fun testExactMatch() {
        assertEquals(0, Solution().minimumDifference(intArrayOf(7, 7, 7), 7))
    }

    @Test
    fun testSingleElement() {
        assertEquals(9, Solution().minimumDifference(intArrayOf(1), 10))
    }

    @Test
    fun testZero() {
        assertEquals(0, Solution().minimumDifference(intArrayOf(0, 0), 0))
    }
}
