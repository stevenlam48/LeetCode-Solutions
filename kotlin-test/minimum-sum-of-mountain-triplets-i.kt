package minimumsumofmountaintripletsi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumSumOfMountainTripletsITest {
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
    fun choosesMinimumAmongMultiplePeaks() {
        assertEquals(6, Solution().minimumSum(intArrayOf(2, 4, 3, 1)))
    }

    @Test
    fun tooShort() {
        assertEquals(-1, Solution().minimumSum(intArrayOf(1, 2)))
    }
}
