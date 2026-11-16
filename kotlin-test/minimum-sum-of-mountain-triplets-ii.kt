package minimumsumofmountaintripletsii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumSumOfMountainTripletsIiTest {
    @Test
    fun example1() {
        assertEquals(9, Solution().minimumSum(intArrayOf(8, 6, 1, 5, 3)))
    }

    @Test
    fun example2() {
        assertEquals(13, Solution().minimumSum(intArrayOf(5, 4, 8, 7, 10, 2)))
    }

    @Test
    fun example3() {
        assertEquals(-1, Solution().minimumSum(intArrayOf(6, 5, 4, 3, 4, 5)))
    }

    @Test
    fun repeatedPeakValues() {
        assertEquals(4, Solution().minimumSum(intArrayOf(1, 2, 2, 1)))
    }

    @Test
    fun strictlyIncreasing() {
        assertEquals(-1, Solution().minimumSum(intArrayOf(1, 2, 3, 4)))
    }
}
