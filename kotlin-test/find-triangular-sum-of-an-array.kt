package findtriangularsumofanarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTriangularSumOfAnArrayTest {
    @Test
    fun exampleOne() {
        assertEquals(8, Solution().triangularSum(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun singleElement() {
        assertEquals(5, Solution().triangularSum(intArrayOf(5)))
    }

    @Test
    fun allZeros() {
        assertEquals(0, Solution().triangularSum(intArrayOf(0, 0, 0)))
    }

    @Test
    fun coefficientsContainFactorsOfTen() {
        assertEquals(2, Solution().triangularSum(intArrayOf(1, 2, 3, 4, 5, 6)))
    }
}
