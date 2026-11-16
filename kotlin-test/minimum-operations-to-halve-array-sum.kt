package minimumoperationstohalvearraysum

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumOperationsToHalveArraySumTest {

    @Test
    fun testExample1() {
        assertEquals(3, Solution().halveArray(intArrayOf(5, 19, 8, 1)))
    }

    @Test
    fun testExample2() {
        assertEquals(3, Solution().halveArray(intArrayOf(3, 8, 20)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1, Solution().halveArray(intArrayOf(1)))
    }

    @Test
    fun testTwoEqualElements() {
        assertEquals(2, Solution().halveArray(intArrayOf(2, 2)))
    }

    @Test
    fun testLargeValues() {
        assertEquals(2, Solution().halveArray(intArrayOf(100000, 1)))
    }

    @Test
    fun testManySmallElements() {
        assertEquals(4, Solution().halveArray(intArrayOf(1, 1, 1, 1)))
    }
}
