package sumofflooredpairs

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SumOfFlooredPairsTest {
    @Test
    fun exampleOne() {
        assertEquals(10, Solution().sumOfFlooredPairs(intArrayOf(2, 5, 9)))
    }

    @Test
    fun allEqual() {
        assertEquals(49, Solution().sumOfFlooredPairs(intArrayOf(7, 7, 7, 7, 7, 7, 7)))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().sumOfFlooredPairs(intArrayOf(1)))
    }
}
