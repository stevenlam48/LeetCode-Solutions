package sumofvaluesatindiceswithksetbits

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SumOfValuesAtIndicesWithKSetBitsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(13, solution.sumIndicesWithKSetBits(intArrayOf(5, 10, 1, 5, 2), 1))
    }

    @Test
    fun testExample2() {
        assertEquals(1, solution.sumIndicesWithKSetBits(intArrayOf(4, 3, 2, 1), 2))
    }

    @Test
    fun testZeroSetBits() {
        assertEquals(1, solution.sumIndicesWithKSetBits(intArrayOf(1, 2, 3), 0))
    }

    @Test
    fun testAllBitsSet() {
        assertEquals(9, solution.sumIndicesWithKSetBits(intArrayOf(1, 2, 3, 4, 5, 6, 7, 9), 3))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0, solution.sumIndicesWithKSetBits(intArrayOf(0), 1))
    }
}
